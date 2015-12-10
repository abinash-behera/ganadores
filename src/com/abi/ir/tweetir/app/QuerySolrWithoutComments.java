package com.abi.ir.tweetir.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class QuerySolrWithoutComments {

	private static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws SolrServerException, IOException {

		QuerySolrWithoutComments querySolr = new QuerySolrWithoutComments();

		BufferedReader fis = new BufferedReader(new FileReader("partb_data/test_queries.txt"));
		Map<String, String> query = new HashMap<>();
		while (fis.ready()) {
			String queryStringWithNumber = fis.readLine().toString();
			query.put(queryStringWithNumber.split(" ")[0], queryStringWithNumber
					.substring(queryStringWithNumber.indexOf(" ") + 1, queryStringWithNumber.length()));
		}
		// TODO - Step 1 change the URL
		String requestURLpart1 = "http://localhost:8983/solr/BM25Tweak_0.0_0.75/select?q=";
		// TODO - Step 2 change the model name - default, bm25
		String modelName = "bm25";

		String requestURLpart2 = "&wt=json&indent=true&defType=edismax&qf=text_en^3.0+AND+text_de^1.5+AND+text_ru^1.5+AND+tweet_hashtags^2.0&stopwords=true&lowercaseOperators=true&fl=id%2Cscore&wt=json&indent=true&rows=10000";
		URL reqURL = null;

		// TODO - Step 3 give the appropriate file name
		int counter = 1;
		for (String queryNumber : query.keySet()) {
			FileWriter masterFileWriter = new FileWriter("partb_data/solrResponseFiles/" + counter + ".txt");
			String queryStringValue = query.get(queryNumber);
			queryStringValue = "text_en:" + queryStringValue + "OR text_de:" + queryStringValue + " OR text_ru:"
					+ queryStringValue + " OR tweet_hashtags:" + queryStringValue;
			reqURL = new URL(requestURLpart1 + URLEncoder.encode(queryStringValue, "UTF-8") + requestURLpart2);
			URLConnection connection = reqURL.openConnection();
			querySolr.writeOutput(masterFileWriter, connection.getInputStream(), queryNumber, modelName);
			masterFileWriter.close();
			counter++;
		}

		// String URL =
		// "http://localhost:8983/solr/DefaultFielded/select?q=text_en%3ARussia%27s+intervention+in+Syria+OR+tweet_hashtags%3ARussia%27s+intervention+in+Syria&wt=json&indent=true&defType=edismax&qf=text_en^100+AND+tweet_hashtags^3&stopwords=true&lowercaseOperators=true&fl=id%2Cscore&wt=json&indent=true&rows=10000";
		// URLConnection connection = new URL(URL).openConnection();
		// querySolr.writeOutput(masterFileWriter, connection.getInputStream(),
		// "001", modelName);

		fis.close();
		System.out.println("Success");
	}

	private void writeOutput(FileWriter masterfileWriter, InputStream inputStream, String queryNumber, String modelName)
			throws JsonProcessingException, IOException {
		ObjectReader objectReader = mapper.reader();
		JsonNode outerJsonNode = objectReader.readTree(inputStream);
		Iterator<JsonNode> iterator = outerJsonNode.elements();
		iterator.next();
		JsonNode responseBody = iterator.next();
		iterator = responseBody.elements();
		iterator.next();
		iterator.next();
		iterator.next();
		JsonNode docs = iterator.next();
		int rankCounter = 0;
		iterator = docs.elements();
		while (iterator.hasNext()) {
			JsonNode document = iterator.next();
			masterfileWriter.write(queryNumber + " Q0 "
					+ document.findValue("id").toString().substring(1, document.findValue("id").toString().length() - 1)
					+ " " + rankCounter + " " + document.findValue("score") + " " + modelName + "\n");
			rankCounter++;
		}
	}

	@SuppressWarnings("unused")
	private void queryAndDisplay(SolrClient solrClient, String coreName, String queryString)
			throws SolrServerException, IOException {

		SolrQuery query = new SolrQuery();
		query.setQuery(queryString);
		QueryResponse queryResponse = solrClient.query(query);
		System.out.println(queryResponse.getResponse().get("response"));

		SolrDocumentList response = queryResponse.getResults();

		for (int i = 0; i < response.size(); i++) {
			System.out.println("Tweet " + i + " - " + response.get(i).getFieldValue("text_en"));
		}
	}
}
