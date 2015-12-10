/**
 * 
 */
package com.abi.ir.tweetir.solrBeans;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author Abinash
 *
 */
public class SolrTwitterEntity {

	@Field
	private SolrTwitterHashTags[] hashtags;
	@Field
	private String[] trends;
	@Field
	private SolrTwitterEntityUrl[] urls;
	@Field
	private SolrTwitterUserMentions[] user_mentions;
	@Field
	private String[] symbols;
	@Field
	private SolrTwitterMedia[] media;

	/**
	 * @return the hashtags
	 */
	public SolrTwitterHashTags[] getHashtags() {
		return hashtags;
	}

	/**
	 * @param hashtags
	 *            the hashtags to set
	 */
	public void setHashtags(SolrTwitterHashTags[] hashtags) {
		this.hashtags = hashtags;
	}

	/**
	 * @return the trends
	 */
	public String[] getTrends() {
		return trends;
	}

	/**
	 * @param trends
	 *            the trends to set
	 */
	public void setTrends(String[] trends) {
		this.trends = trends;
	}

	/**
	 * @return the urls
	 */
	public SolrTwitterEntityUrl[] getUrls() {
		return urls;
	}

	/**
	 * @param urls
	 *            the urls to set
	 */
	public void setUrls(SolrTwitterEntityUrl[] urls) {
		this.urls = urls;
	}

	/**
	 * @return the user_mentions
	 */
	public SolrTwitterUserMentions[] getUser_mentions() {
		return user_mentions;
	}

	/**
	 * @param user_mentions
	 *            the user_mentions to set
	 */
	public void setUser_mentions(SolrTwitterUserMentions[] user_mentions) {
		this.user_mentions = user_mentions;
	}

	/**
	 * @return the symbols
	 */
	public String[] getSymbols() {
		return symbols;
	}

	/**
	 * @param symbols
	 *            the symbols to set
	 */
	public void setSymbols(String[] symbols) {
		this.symbols = symbols;
	}

	/**
	 * @return the media
	 */
	public SolrTwitterMedia[] getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMedia(SolrTwitterMedia[] media) {
		this.media = media;
	}

}
