/**
 * 
 */
package com.abi.ir.tweetir.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import com.abi.ir.tweetir.solrBeans.SolrIngestTweet;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.util.Triple;

/**
 * @author Abinash
 *
 */
public class TweeterIngester {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, FileNotFoundException,
			IOException, SolrServerException, ClassCastException, ClassNotFoundException {

		// TODO find the best way to do this
		TweeterIngester tweeterIngester = new TweeterIngester();
		// TODO remove TODOs and sysouts from everywhere
		ObjectMapper mapper = new ObjectMapper();
		int counter = 0;
		mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		TypeReference<List<SolrIngestTweet>> typeReference = new TypeReference<List<SolrIngestTweet>>() {
		};
		// FileInputStream fis = new
		// FileInputStream("SolrIngestTweetMasterDataV2-RT.txt");
		FileInputStream fis = new FileInputStream("FinalTweetSet/IngestMe.json");

		List<SolrIngestTweet> inputTweets = mapper.readValue(fis, typeReference);

		if (inputTweets != null && inputTweets.size() > 0) {

			String baseUrlString = "http://localhost:8983/solr";
			SolrClient solr = new HttpSolrClient(baseUrlString);

			// clearing each solr core
			solr.deleteByQuery("partC_BM25", "*:*");
			solr.commit("partC_BM25");
			System.out.println("partC_BM25 done");
			// solr.deleteByQuery("VSMDefault", "*:*");
			// solr.commit("VSMDefault");
			Triple<List<String>, List<String>, List<String>> triple;
			// Declaring the classifier once
			String serializedClassifier = "classifiers/english.conll.4class.distsim.crf.ser.gz";
			AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(serializedClassifier);
			// use individual for loops, clubbing multiple cores slows the code
			// Indexing the BM25Default core
			for (SolrIngestTweet solrIngestTweet : inputTweets) {

				// populating the fields- namesFacet; peopleNames; location;
				// locationFacet;

				// Facets only for English language tweets
				if (StringUtils.isNotEmpty(solrIngestTweet.getText_en())) {
					// add the NER part - TODO don't know if this is the fastest
					// way
					triple = tweeterIngester.nerProcessor(solrIngestTweet.getText_en(),
							solrIngestTweet.getTweet_hashtags(), classifier);
					solrIngestTweet.setPeopleNames(triple.first.toArray(new String[0]));
					solrIngestTweet.setNamesFacet(triple.first.toArray(new String[0]));
					solrIngestTweet.setLocationFacet(triple.second.toArray(new String[0]));
					solrIngestTweet.setLocation(triple.second.toArray(new String[0]));
					// System.out.println(Arrays.toString(solrIngestTweet.getNamesFacet()));
					// System.out.println(Arrays.toString(solrIngestTweet.getLocationFacet()));
					// TODO see if we can include organization as well
					// triple.third
				}

				// insert into SOLR
				solr.addBean("partC_BM25", solrIngestTweet);
				// counter++;
				// System.out.println(counter + " tweets collected ---" +
				// (counter * 100 / inputTweets.size()) + "% done ");
			}
			solr.commit("partC_BM25");
			System.out.println("partC_BM25 done");

			System.out.println("Success");
			solr.close();
		}

	}

	// ENUM for NER output
	public enum NEROutput {
		PERSON, MISC, ORGANIZATION, LOCATION
	}

	private Triple<List<String>, List<String>, List<String>> nerProcessor(String tweetText, String[] hashtags,
			AbstractSequenceClassifier<CoreLabel> classifier)
					throws ClassCastException, ClassNotFoundException, IOException {
		// selecting the classifier

		List<String> availablePersons = new ArrayList<>();
		List<String> availableLocations = new ArrayList<>();
		List<String> availableOrganizations = new ArrayList<>();

		// This gets out entities with character offsets
		// NERing the tweet text - for extracting the person names, organization
		// and locations
		List<Triple<String, Integer, Integer>> triples = classifier.classifyToCharacterOffsets(tweetText);
		// the triples list has at the max four types of elements (since we are
		// using a
		// class 4 classifier) with trip.first() values - PERSON, ORGANIZATION,
		// LOCATION (run the NERDemo.java)
		for (Triple<String, Integer, Integer> trip : triples) {
			if (StringUtils.equalsIgnoreCase(trip.first, NEROutput.PERSON.name())) {
				availablePersons.add(tweetText.substring(trip.second(), trip.third));
			} else if (StringUtils.equalsIgnoreCase(trip.first, NEROutput.LOCATION.name())) {
				availableLocations.add(tweetText.substring(trip.second(), trip.third));
			} else if (StringUtils.equalsIgnoreCase(trip.first, NEROutput.ORGANIZATION.name())) {
				availableOrganizations.add(tweetText.substring(trip.second(), trip.third));
			}
		}
		// NERing the hashtags
		if (hashtags != null && hashtags.length > 0) {
			for (String hashtag : hashtags) {
				triples = classifier.classifyToCharacterOffsets(hashtag);
				for (Triple<String, Integer, Integer> trip : triples) {
					if (StringUtils.equalsIgnoreCase(trip.first, NEROutput.PERSON.name())) {
						availablePersons.add(hashtag.substring(trip.second(), trip.third));
					} else if (StringUtils.equalsIgnoreCase(trip.first, NEROutput.LOCATION.name())) {
						availableLocations.add(hashtag.substring(trip.second(), trip.third));
					} else if (StringUtils.equalsIgnoreCase(trip.first, NEROutput.ORGANIZATION.name())) {
						availableOrganizations.add(hashtag.substring(trip.second(), trip.third));
					}
				}
			}
		}
		return new Triple<List<String>, List<String>, List<String>>(availablePersons, availableLocations,
				availableOrganizations);
	}
}
