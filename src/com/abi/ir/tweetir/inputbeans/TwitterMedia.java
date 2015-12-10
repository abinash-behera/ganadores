/**
 * 
 */
package com.abi.ir.tweetir.inputbeans;

/**
 * @author Abinash
 *
 */
public class TwitterMedia {
	private long id;
	private String id_str;
	private int[] indices;
	private String media_url;
	private String media_url_https;
	private String url;
	private String display_url;
	private String expanded_url;
	private String type;
	private TwitterMediaSizes sizes;

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
	 * @return the id_str
	 */
	public String getId_str() {
		return id_str;
	}

	/**
	 * @param id_str
	 *            the id_str to set
	 */
	public void setId_str(String id_str) {
		this.id_str = id_str;
	}

	/**
	 * @return the indices
	 */
	public int[] getIndices() {
		return indices;
	}

	/**
	 * @param indices
	 *            the indices to set
	 */
	public void setIndices(int[] indices) {
		this.indices = indices;
	}

	/**
	 * @return the media_url
	 */
	public String getMedia_url() {
		return media_url;
	}

	/**
	 * @param media_url
	 *            the media_url to set
	 */
	public void setMedia_url(String media_url) {
		this.media_url = media_url;
	}

	/**
	 * @return the media_url_https
	 */
	public String getMedia_url_https() {
		return media_url_https;
	}

	/**
	 * @param media_url_https
	 *            the media_url_https to set
	 */
	public void setMedia_url_https(String media_url_https) {
		this.media_url_https = media_url_https;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the display_url
	 */
	public String getDisplay_url() {
		return display_url;
	}

	/**
	 * @param display_url
	 *            the display_url to set
	 */
	public void setDisplay_url(String display_url) {
		this.display_url = display_url;
	}

	/**
	 * @return the expanded_url
	 */
	public String getExpanded_url() {
		return expanded_url;
	}

	/**
	 * @param expanded_url
	 *            the expanded_url to set
	 */
	public void setExpanded_url(String expanded_url) {
		this.expanded_url = expanded_url;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the sizes
	 */
	public TwitterMediaSizes getSizes() {
		return sizes;
	}

	/**
	 * @param sizes
	 *            the sizes to set
	 */
	public void setSizes(TwitterMediaSizes sizes) {
		this.sizes = sizes;
	}

}