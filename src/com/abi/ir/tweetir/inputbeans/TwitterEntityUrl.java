/**
 * 
 */
package com.abi.ir.tweetir.inputbeans;

/**
 * @author Abinash
 *
 */
public class TwitterEntityUrl {
	private String url;
	private String expanded_url;
	private String display_url;
	private int[] indices;

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
}
