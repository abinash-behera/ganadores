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

public class QuerySolrWithComments {

	private static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws SolrServerException, IOException {

		// String urlString = "http://localhost:8983/solr/BM25Default";
		// String urlString1 = "http://localhost:8983/solr/BM25Tweak";
		// String urlString2 = "http://localhost:8983/solr/VSMTweak";
		// String urlString = "http://localhost:8983/solr/projectB";
		// String urlString = "http://localhost:8983/solr/";
		QuerySolrWithComments querySolr = new QuerySolrWithComments();
		// TODO reads this always
		/**
		 * A SolrClient implementation that talks directly to a Solr server via
		 * HTTP There are two ways to use an HttpSolrClient: 1) Pass a URL to
		 * the constructor that points directly at a particular core SolrClient
		 * client = new HttpSolrClient("http://my-solr-server:8983/solr/core1");
		 * QueryResponse resp = client.query(new SolrQuery("*:*"));
		 * 
		 * In this case, you can query the given core directly, but you cannot
		 * query any other cores or issue CoreAdmin requests with this client.
		 * 2) Pass the base URL of the node to the constructor SolrClient client
		 * = new HttpSolrClient("http://my-solr-server:8983/solr");
		 * QueryResponse resp = client.query("core1", new SolrQuery("*:*"));
		 * 
		 * In this case, you must pass the name of the required core for all
		 * queries and updates, but you may use the same client for all cores,
		 * and for CoreAdmin requests.
		 */
		// SolrClient solrClient = new HttpSolrClient(urlString);

		// querySolr.queryAndDisplay(solrClient,
		// "projectB","text_en:Russia's
		// intervention in Syria");

		// fetching the queries
		BufferedReader fis = new BufferedReader(new FileReader("partb_data/queries.txt"));
		Map<String, String> query = new HashMap<>();
		while (fis.ready()) {
			String queryStringWithNumber = fis.readLine().toString();
			query.put(queryStringWithNumber.split(" ")[0], queryStringWithNumber
					.substring(queryStringWithNumber.indexOf(" ") + 1, queryStringWithNumber.length()));
		}

		// fetching the docIDs and score for every query
		// String requestURLpart1VSMDefault =
		// "http://localhost:8983/solr/projectB/select?q=";
		// String requestURLpart1VSMTweak =
		// "http://localhost:8983/solr/VSMTweak/select?q=";
		String requestURLpart1BM25Default = "http://localhost:8983/solr/BM25Default/select?q=";
		// String requestURLpart1BM25Tweak =
		// "http://localhost:8983/solr/BM25Tweak/select?q=";

		String modelNameBm25 = "bm25";
		// String modelNameDefault = "default"; // set the model name - default
		// corresponds to VSM
		String requestURLpart2 = "&fl=id%2Cscore&wt=json&indent=true&rows=10000";
		URL reqURL = null;

		// creating the output file
		// for each query - the response is fed into the querySolrResponse.txt
		// file and then this file is used to write the id and scores to the
		// master output file
		// FileWriter masterFileWriterBM25 = new
		// FileWriter("partb_data/BM25DefaultQuerySolrResponse.txt");
		// FileWriter masterFileWriterVSM = new
		// FileWriter("partb_data/VSMDefaultQuerySolrResponse.txt");
		FileWriter masterFileWriterBM25 = new FileWriter(
				"partb_data/solrResponseFiles/BM25DefaultQuerySolrResponse.txt");
		for (String queryNumber : query.keySet()) {

			// Declaring the file to store the queries
			// FileWriter responseFileWriter = new
			// FileWriter("partb_data/querySolrResponse.txt");
			String queryStringValue = query.get(queryNumber);
			queryStringValue = "text_en:" + queryStringValue + " OR text_de:" + queryStringValue + " OR text_ru:"
					+ queryStringValue;
			reqURL = new URL(
					requestURLpart1BM25Default + URLEncoder.encode(queryStringValue, "UTF-8") + requestURLpart2);
			URLConnection connection = reqURL.openConnection();
			// int resposenBit = -1;
			// do {
			// resposenBit = connection.getInputStream().read();
			// responseFileWriter.write(resposenBit);
			// } while (resposenBit != -1);

			// Now parsing the queries from the response file
			// querySolr.writeOutput(masterfileWriter, new
			// FileReader("partb_data/querySolrResponse.txt"), queryNumber);
			querySolr.writeOutput(masterFileWriterBM25, connection.getInputStream(), queryNumber, modelNameBm25);
			// responseFileWriter.close();
		}
		// solrClient.close();
		masterFileWriterBM25.close();
		// masterFileWriterVSM.close();
		fis.close();
		System.out.println("Success");
	}

	private void writeOutput(FileWriter masterfileWriter, InputStream inputStream, String queryNumber, String modelName)
			throws JsonProcessingException, IOException {
		ObjectReader objectReader = mapper.reader();
		JsonNode outerJsonNode = objectReader.readTree(inputStream);
		// since the first element is the responseHeader and the second element
		// is the response, so moving the iterator by two places
		Iterator<JsonNode> iterator = outerJsonNode.elements();
		iterator.next();
		JsonNode responseBody = iterator.next();
		// now the response body itself has many children. The fourth one has
		// the docs array
		iterator = responseBody.elements();
		iterator.next();
		iterator.next();
		iterator.next();
		JsonNode docs = iterator.next();
		int rankCounter = 0;
		iterator = docs.elements();
		while (iterator.hasNext()) {
			JsonNode document = iterator.next();
			// the id is of the form "xxxxx" , so using substring to remove the
			// quotes
			masterfileWriter.write(queryNumber + " Q0 "
					+ document.findValue("id").toString().substring(1, document.findValue("id").toString().length() - 1)
					+ " " + rankCounter + " " + document.findValue("score") + " " + modelName + "\n");
			rankCounter++;
		}
	}

	@SuppressWarnings("unused")
	private void queryAndDisplay(SolrClient solrClient, String coreName, String queryString)
			throws SolrServerException, IOException {

		// SolrQuery extends ModifiableSolrParams which in turn extends
		// SolrParams
		SolrQuery query = new SolrQuery();
		query.setQuery(queryString);
		QueryResponse queryResponse = solrClient.query(query);
		System.out.println(queryResponse.getResponse().get("response"));

		// When you don't define the amount of rows (documents) to fetch, Solr
		// defaults to fetching 10 documents, as explained in the docs. SO
		// changed the solrconfig.xml file as per -
		// http://stackoverflow.com/questions/4697347/why-i-can-read-only-10-documents-out-of-665-results-into-beans-in-solr
		SolrDocumentList response = queryResponse.getResults();

		for (int i = 0; i < response.size(); i++) {
			System.out.println("Tweet " + i + " - " + response.get(i).getFieldValue("text_en"));
		}
	}
}
