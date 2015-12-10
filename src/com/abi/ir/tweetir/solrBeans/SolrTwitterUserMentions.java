/**
 * 
 */
package com.abi.ir.tweetir.solrBeans;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author Abinash
 *
 */
public class SolrTwitterUserMentions {

	@Field
	private String screen_name;
	@Field
	private String name;
	@Field
	private long id;
	@Field
	private String id_st;
	@Field
	private int[] indices;

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
	 * @return the id_st
	 */
	public String getId_st() {
		return id_st;
	}

	/**
	 * @param id_st
	 *            the id_st to set
	 */
	public void setId_st(String id_st) {
		this.id_st = id_st;
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
