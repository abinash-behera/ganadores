/**
 * 
 */
package com.abi.ir.tweetir.inputbeans;

/**
 * @author Abinash
 *
 */
public class TwitterHashTags {
	private String text;
	private int[] indices;

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
