/**
 * 
 */
package com.abi.ir.tweetir.solrBeans;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

/**
 * this class is used to ingest the tweets into Solr and also to create
 * corresponding jsons for the tweets ingested for reference
 * 
 * @author Abinash
 *
 */
public class SolrIngestTweet {

	@Field
	private String[] tweet_urls;
	@Field
	private String[] tweet_hashtags;
	@Field
	private Date created_at;
	@Field
	private String text;
	@Field
	private String lang;
	@Field
	private String text_ru;
	@Field
	private String text_de;
	@Field
	private String text_en;
	@Field
	private long id;
	@Field
	private String name;
	@Field
	private String screen_name;
	// The user location
	@Field
	private String userLocation;
	@Field
	private String description;
	@Field
	private boolean verified;
	@Field
	private String[] namesFacet;
	// will be used as a filter query
	@Field
	private String[] peopleNames;
	// will be used as a filter query
	@Field
	private String[] location;
	@Field
	private String[] locationFacet;
	@Field
	private String[] hashtagsFacet;
	@Field
	private String profImageURL;

	/**
	 * @return the tweet_urls
	 */
	public String[] getTweet_urls() {
		return tweet_urls;
	}

	/**
	 * @param tweet_urls
	 *            the tweet_urls to set
	 */
	public void setTweet_urls(String[] tweet_urls) {
		this.tweet_urls = tweet_urls;
	}

	/**
	 * @return the tweet_hashtags
	 */
	public String[] getTweet_hashtags() {
		return tweet_hashtags;
	}

	/**
	 * @param tweet_hashtags
	 *            the tweet_hashtags to set
	 */
	public void setTweet_hashtags(String[] tweet_hashtags) {
		this.tweet_hashtags = tweet_hashtags;
	}

	/**
	 * @return the created_at
	 */
	public Date getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at
	 *            the created_at to set
	 */
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * @param lang
	 *            the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * @return the text_ru
	 */
	public String getText_ru() {
		return text_ru;
	}

	/**
	 * @param text_ru
	 *            the text_ru to set
	 */
	public void setText_ru(String text_ru) {
		this.text_ru = text_ru;
	}

	/**
	 * @return the text_de
	 */
	public String getText_de() {
		return text_de;
	}

	/**
	 * @param text_de
	 *            the text_de to set
	 */
	public void setText_de(String text_de) {
		this.text_de = text_de;
	}

	/**
	 * @return the text_en
	 */
	public String getText_en() {
		return text_en;
	}

	/**
	 * @param text_en
	 *            the text_en to set
	 */
	public void setText_en(String text_en) {
		this.text_en = text_en;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the screen_name
	 */
	public String getScreen_name() {
		return screen_name;
	}

	/**
	 * @param screen_name
	 *            the screen_name to set
	 */
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	/**
	 * @return the userLocation
	 */
	public String getUserLocation() {
		return userLocation;
	}

	/**
	 * @param userLocation
	 *            the userLocation to set
	 */
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the verified
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * @param verified
	 *            the verified to set
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	/**
	 * @return the namesFacet
	 */
	public String[] getNamesFacet() {
		return namesFacet;
	}

	/**
	 * @param namesFacet
	 *            the namesFacet to set
	 */
	public void setNamesFacet(String[] namesFacet) {
		this.namesFacet = namesFacet;
	}

	/**
	 * @return the peopleNames
	 */
	public String[] getPeopleNames() {
		return peopleNames;
	}

	/**
	 * @param peopleNames
	 *            the peopleNames to set
	 */
	public void setPeopleNames(String[] peopleNames) {
		this.peopleNames = peopleNames;
	}

	/**
	 * @return the location
	 */
	public String[] getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String[] location) {
		this.location = location;
	}

	/**
	 * @return the locationFacet
	 */
	public String[] getLocationFacet() {
		return locationFacet;
	}

	/**
	 * @param locationFacet
	 *            the locationFacet to set
	 */
	public void setLocationFacet(String[] locationFacet) {
		this.locationFacet = locationFacet;
	}

	/**
	 * @return the hashtagsFacet
	 */
	public String[] getHashtagsFacet() {
		return hashtagsFacet;
	}

	/**
	 * @param hashtagsFacet
	 *            the hashtagsFacet to set
	 */
	public void setHashtagsFacet(String[] hashtagsFacet) {
		this.hashtagsFacet = hashtagsFacet;
	}

	/**
	 * @return the profImageURL
	 */
	public String getProfImageURL() {
		return profImageURL;
	}

	/**
	 * @param profImageURL
	 *            the profImageURL to set
	 */
	public void setProfImageURL(String profImageURL) {
		this.profImageURL = profImageURL;
	}

}
