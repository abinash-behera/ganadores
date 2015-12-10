/**
 * 
 */
package com.abi.ir.tweetir.inputbeans;

/**
 * @author Abinash
 *
 */
public class TwitterEntity {
	private TwitterHashTags[] hashtags;
	private String[] trends;
	private TwitterEntityUrl[] urls;
	private TwitterUserMentions[] user_mentions;
	private String[] Repalcesymbols; // TODO - refer line line: 13190, column:
										// 2108
	private TwitterMedia[] media;

	/**
	 * @return the hashtags
	 */
	public TwitterHashTags[] getHashtags() {
		return hashtags;
	}

	/**
	 * @param hashtags
	 *            the hashtags to set
	 */
	public void setHashtags(TwitterHashTags[] hashtags) {
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
	public TwitterEntityUrl[] getUrls() {
		return urls;
	}

	/**
	 * @param urls
	 *            the urls to set
	 */
	public void setUrls(TwitterEntityUrl[] urls) {
		this.urls = urls;
	}

	/**
	 * @return the user_mentions
	 */
	public TwitterUserMentions[] getUser_mentions() {
		return user_mentions;
	}

	/**
	 * @param user_mentions
	 *            the user_mentions to set
	 */
	public void setUser_mentions(TwitterUserMentions[] user_mentions) {
		this.user_mentions = user_mentions;
	}

	/**
	 * @return the symbols
	 */
	public String[] getRepalcesymbols() {
		return Repalcesymbols;
	}

	/**
	 * @param symbols
	 *            the symbols to set
	 */
	public void setRepalceSymbols(String[] symbols) {
		this.Repalcesymbols = symbols;
	}

	/**
	 * @return the media
	 */
	public TwitterMedia[] getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMedia(TwitterMedia[] media) {
		this.media = media;
	}
}
