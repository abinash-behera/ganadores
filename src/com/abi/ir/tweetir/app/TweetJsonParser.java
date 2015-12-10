/**
 * 
 */
package com.abi.ir.tweetir.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

import com.abi.ir.tweetir.inputbeans.Tweet;
import com.abi.ir.tweetir.inputbeans.TwitterEntityUrl;
import com.abi.ir.tweetir.inputbeans.TwitterHashTags;
import com.abi.ir.tweetir.solrBeans.SolrIngestTweet;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Abinash
 *
 */
public class TweetJsonParser {

	// private static DateFormat format = new SimpleDateFormat("YYYY-MM-DD",
	// Locale.ENGLISH);
	private static DateFormat format = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws ParseException
	 */
	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, FileNotFoundException, IOException, ParseException {

		List<Tweet> inputTweets = new ArrayList<Tweet>();
		List<SolrIngestTweet> injestTweets = new ArrayList<SolrIngestTweet>();
		// DateFormat format = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ssZ",
		// Locale.ENGLISH);
		long englishTweets = 0;
		long germanTweets = 0;
		long russianTweets = 0;

		File outputFile = new File("FinalTweetSet/IngestMe.json");
		TypeReference<List<Tweet>> typeReference = new TypeReference<List<Tweet>>() {
		};
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
		// mapper.setDateFormat(format);
		// disable the Jackson data bind unrecognized property exception
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		// specifying the parent folder
		File parentFolder = new File("SolrInput");
		if (parentFolder.isDirectory()) {
			File[] inputJsonFiles = parentFolder.listFiles();
			for (File inputJsonFile : inputJsonFiles) {
				inputTweets.addAll(mapper.readValue(new FileInputStream(inputJsonFile), typeReference));
			}
		}

		// we need to maintain atleast 25% for all the three languages.
		// I would try to remove the escaped newlines and substitute the
		// unicode characters for the escaped unicode entities. Other than
		// that, looks good.
		// change the date format as well for all

		if (inputTweets != null && inputTweets.size() > 0) {
			System.out.println(inputTweets.size());

			for (Tweet tweet : inputTweets) {
				SolrIngestTweet ingestTweet = new SolrIngestTweet();
				boolean NoRTFlag = true;
				boolean otherLangFlag = false;
				// TODO have commented the RT check
				// StringBuilder rwtweetCharSeq = new StringBuilder("RT @");
				// // checking if there is a re-tweet in engish
				// if (tweet.getText().contains(rwtweetCharSeq)) {
				// NoRTFlag = false;
				// }
				if (NoRTFlag) {

					// checking the langauge count
					switch (tweet.getLang()) {
					case "en":
						englishTweets++;
						ingestTweet.setText_en(tweet.getText());
						break;
					case "de":
						germanTweets++;
						ingestTweet.setText_de(tweet.getText());
						break;
					case "ru":
						russianTweets++;
						ingestTweet.setText_ru(tweet.getText());
						break;
					default:
						otherLangFlag = true;
						break;

					}
					if (otherLangFlag) {
						// TODO commented this line to handle all language
						// tweets
						// continue;
					}
					ingestTweet.setText(tweet.getText());
					if (StringUtils.isNumeric(tweet.getCreated_at())) {
						System.out.println(tweet.getId());
						ingestTweet.setCreated_at(new Date(Long.valueOf(tweet.getCreated_at()) * 1000L));
						System.out.println(ingestTweet.getCreated_at());
					} else {
						ingestTweet.setCreated_at(new TweetJsonParser().dateStringCleaner((tweet.getCreated_at())));
						// System.out.println(ingestTweet.getCreated_at());
					}
					ingestTweet.setLang(tweet.getLang());
					ingestTweet.setId(tweet.getId());
					if (tweet.getEntities() != null) {
						if (tweet.getEntities().getHashtags() != null
								&& tweet.getEntities().getHashtags().length != 0) {
							String[] hashTagsHolder = new String[tweet.getEntities().getHashtags().length];
							int i = 0;
							for (TwitterHashTags twitterHashTags : tweet.getEntities().getHashtags()) {
								hashTagsHolder[i] = twitterHashTags.getText();
								i++;
							}
							ingestTweet.setTweet_hashtags(hashTagsHolder);
							ingestTweet.setHashtagsFacet(hashTagsHolder);
						}
						if (tweet.getEntities().getUrls() != null && tweet.getEntities().getUrls().length != 0) {
							String[] urlHolder = new String[tweet.getEntities().getUrls().length];
							int i = 0;
							for (TwitterEntityUrl twitterEntityUrl : tweet.getEntities().getUrls()) {
								urlHolder[i] = twitterEntityUrl.getExpanded_url();
								i++;
							}
							ingestTweet.setTweet_urls(urlHolder);// fetch
							// the
							// expanded
							// URLs
						}
					}
					// tweet.getEntities().getMedia();
					// tweet.getEntities().getSymbols();
					// tweet.getEntities().getTrends();
					// Part C additions
					if (tweet.getUser() != null) {
						ingestTweet.setDescription(tweet.getUser().getDescription());
						ingestTweet.setUserLocation(tweet.getUser().getLocation());
						ingestTweet.setName(tweet.getUser().getName());
						ingestTweet.setScreen_name(tweet.getUser().getScreen_name());
						ingestTweet.setVerified(tweet.getUser().isVerified());
						if (StringUtils.isNotEmpty(tweet.getUser().getProfile_image_url())) {
							ingestTweet.setProfImageURL(tweet.getUser().getProfile_image_url());
						} else if (StringUtils.isNotEmpty(tweet.getUser().getProfile_image_url_https())) {
							ingestTweet.setProfImageURL(tweet.getUser().getProfile_image_url_https());
						}

					}
					injestTweets.add(ingestTweet);
				}
			}
			// creating a json from the tweet and writing it to the master file
			mapper.writeValue(outputFile, injestTweets);
			System.out.println("English - " + englishTweets);
			System.out.println("German - " + germanTweets);
			System.out.println("Russian - " + russianTweets);
			System.out.println("Total - " + injestTweets.size());
		}
	}

	private Date dateStringCleaner(String dateString) throws ParseException {

		// TODO Need to make this better
		// Wed Sep 09 01:08:29 +0000 2015
		String month = dateString.substring(4, 7);
		String year = dateString.substring(26, 30);
		String day = dateString.substring(8, 10);
		String time = dateString.substring(11, 19);
		String newDateString = day + "-" + month + "-" + year + " " + time;
		// String reverseDateString = new
		// StringBuilder(dateString).reverse().toString();
		// Print the dates for verification
		// format.setTimeZone(TimeZone.getTimeZone("UTC"));
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		Date dateHolder = format.parse(newDateString);
		// a parse call can reset the time zone
		// format.setTimeZone(TimeZone.getTimeZone("UTC"));
		// dateHolder= format.format(dateHolder);
		// System.out.println("Old : " + dateString + " New : " +
		// dateHolder.toString() + " Formatte Date : "
		// + format.format(dateHolder) + " Tmezone : " + format.getTimeZone());
		// if (year.equals("2013")) {
		// System.out
		// .println("Old : " + dateString + " New : " + dateHolder.toString() +
		// " Date : " + dateHolder);
		// }
		// return "2015-23-05";
		return dateHolder;
	}
}
