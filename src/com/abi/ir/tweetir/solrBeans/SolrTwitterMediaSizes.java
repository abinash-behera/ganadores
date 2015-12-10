/**
 * 
 */
package com.abi.ir.tweetir.solrBeans;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author Abinash
 *
 */
public class SolrTwitterMediaSizes {

	@Field
	private SolrTwitterMediaSize large;
	@Field
	private SolrTwitterMediaSize small;
	@Field
	private SolrTwitterMediaSize thumb;
	@Field
	private SolrTwitterMediaSize medium;

	/**
	 * @return the large
	 */
	public SolrTwitterMediaSize getLarge() {
		return large;
	}

	/**
	 * @param large
	 *            the large to set
	 */
	public void setLarge(SolrTwitterMediaSize large) {
		this.large = large;
	}

	/**
	 * @return the small
	 */
	public SolrTwitterMediaSize getSmall() {
		return small;
	}

	/**
	 * @param small
	 *            the small to set
	 */
	public void setSmall(SolrTwitterMediaSize small) {
		this.small = small;
	}

	/**
	 * @return the thumb
	 */
	public SolrTwitterMediaSize getThumb() {
		return thumb;
	}

	/**
	 * @param thumb
	 *            the thumb to set
	 */
	public void setThumb(SolrTwitterMediaSize thumb) {
		this.thumb = thumb;
	}

	/**
	 * @return the medium
	 */
	public SolrTwitterMediaSize getMedium() {
		return medium;
	}

	/**
	 * @param medium
	 *            the medium to set
	 */
	public void setMedium(SolrTwitterMediaSize medium) {
		this.medium = medium;
	}
}
