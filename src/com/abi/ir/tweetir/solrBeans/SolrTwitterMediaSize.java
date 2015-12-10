/**
 * 
 */
package com.abi.ir.tweetir.solrBeans;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author Abinash
 *
 */
public class SolrTwitterMediaSize {
	@Field
	private long w;
	@Field
	private long h;
	@Field
	private String resize;

	/**
	 * @return the w
	 */
	public long getW() {
		return w;
	}

	/**
	 * @param w
	 *            the w to set
	 */
	public void setW(long w) {
		this.w = w;
	}

	/**
	 * @return the h
	 */
	public long getH() {
		return h;
	}

	/**
	 * @param h
	 *            the h to set
	 */
	public void setH(long h) {
		this.h = h;
	}

	/**
	 * @return the resize
	 */
	public String getResize() {
		return resize;
	}

	/**
	 * @param resize
	 *            the resize to set
	 */
	public void setResize(String resize) {
		this.resize = resize;
	}
}
