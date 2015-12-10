package com.abi.ir.tweetir.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.abi.ir.tweetir.inputbeans.Tweet;
import com.abi.ir.tweetir.solrBeans.SolrTweet;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Abinash
 *
 */
public class App {
	private static Mapper mapper = new DozerBeanMapper();

	public static void main(String[] args) throws JsonProcessingException, IOException, SolrServerException {

		// System.out.println( "Hello World!" );
		List<Tweet> inputTweets = new ArrayList<Tweet>();
		TypeReference<List<Tweet>> typeReference = new TypeReference<List<Tweet>>() {
		};
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);

		// disable the Jackson data bind unrecognized property exception
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// inputTweets = mapper.readValue(new
		// FileInputStream("solrTestDocs/tester.txt"), typeReference);
		// inputTweets = mapper.readValue(new
		// FileInputStream("solrTestDocs/tweets10SeptSuicideRu"),
		// typeReference);
		inputTweets = mapper.readValue(new FileInputStream("B:/IR project/Consolidated.txt"), typeReference);
		// alternate way - inputTweets = mapper.readValue(new
		// File("solrTestDocs/tester.txt"), typeReference);

		if (inputTweets != null && inputTweets.size() > 0) {
			/* Configuring the Solr Client - start */
			// SolrClient is abstract, so to connect to a remote Solr instance,
			// you'll actually create an instance of either HttpSolrClient, or
			// CloudSolrClient .
			// for more info access
			// https://cwiki.apache.org/confluence/display/solr/Using+SolrJ

			String urlString = "http://localhost:8983/solr/tweetTesterWindows";
			SolrClient solr = new HttpSolrClient(urlString);
			/* Configuring the Solr Client - end */

			App app = new App();
			app.ingestDocs(solr, inputTweets);
			// app.ingestDocsExample(solr);
			// app.deleteDocs(solr);

			// this is to indicate that all the queries have been processed
			System.out.println(inputTweets.size());
		}
	}

	public void ingestDocsExample(SolrClient solr) throws SolrServerException, IOException {

		// code for adding new documents
		for (int i = 0; i < 1000; ++i) {
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("cat", "book");
			doc.addField("id", "book-" + i);
			doc.addField("name", "The Legend of the Hobbit part" + i);
			solr.add(doc);
			if (i % 100 == 0)
				solr.commit(); // periodically flush
		}
		solr.commit();

	}

	public void ingestDocs(SolrClient solr, List<Tweet> tweets) throws SolrServerException, IOException {

		if (tweets != null && tweets.size() > 0) {
			// alternate code for adding new documents - but has problems with
			// array fields
			// List<SolrTweet> solrTweets = new ArrayList<SolrTweet>();
			// mapper.map(tweets, solrTweets);
			// solr.addBean(solrTweets);
			// solr.commit();

			long i = 0;
			for (Tweet tweet : tweets) {
				SolrTweet solrTweet = new SolrTweet();
				mapper.map(tweet, solrTweet);
				solr.addBean(solrTweet);
				if (i % 100 == 0)
					solr.commit(); // periodically flush i++; }
			}

		}
	}

	public void deleteDocs(SolrClient solr) throws SolrServerException, IOException {
		// code for deleting all the documents
		solr.deleteByQuery("*:*");
		solr.commit();
	}

}
