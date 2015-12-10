/**
 * 
 */
package com.abi.ir.tweetir.solrBeans;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author Abinash
 *
 */
public class SolrTweet {

	@Field
	private String created_at;
	@Field
	private long id;
	@Field
	private String id_str;
	@Field
	private String text;
	@Field
	private String source;
	@Field
	private boolean truncated;
	@Field
	private long in_reply_to_status_id;
	@Field
	private String in_reply_to_status_id_str;
	@Field
	private long in_reply_to_user_id;
	@Field
	private String in_reply_to_user_id_str;
	@Field
	private String in_reply_to_screen_name;
	@Field
	private SolrTwitterUser user;
	@Field
	private String geo;
	@Field
	private int[] coordinates; // list of arrays with integers
	@Field
	private String place;
	@Field
	private String contributors;
	@Field
	private int retweet_count;
	@Field
	private int favorite_count;
	@Field
	private SolrTwitterEntity entities;
	@Field
	private SolrTwitterEntity extended_entities;
	@Field
	private boolean favorited;
	@Field
	private boolean retweeted;
	@Field
	private boolean possibly_sensitive;
	@Field
	private String filter_level;
	@Field
	private String lang;
	@Field
	private String timestamp_ms;

	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at
	 *            the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
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
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the truncated
	 */
	public boolean isTruncated() {
		return truncated;
	}

	/**
	 * @param truncated
	 *            the truncated to set
	 */
	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}

	/**
	 * @return the in_reply_to_status_id
	 */
	public long getIn_reply_to_status_id() {
		return in_reply_to_status_id;
	}

	/**
	 * @param in_reply_to_status_id
	 *            the in_reply_to_status_id to set
	 */
	public void setIn_reply_to_status_id(long in_reply_to_status_id) {
		this.in_reply_to_status_id = in_reply_to_status_id;
	}

	/**
	 * @return the in_reply_to_status_id_str
	 */
	public String getIn_reply_to_status_id_str() {
		return in_reply_to_status_id_str;
	}

	/**
	 * @param in_reply_to_status_id_str
	 *            the in_reply_to_status_id_str to set
	 */
	public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
		this.in_reply_to_status_id_str = in_reply_to_status_id_str;
	}

	/**
	 * @return the in_reply_to_user_id
	 */
	public long getIn_reply_to_user_id() {
		return in_reply_to_user_id;
	}

	/**
	 * @param in_reply_to_user_id
	 *            the in_reply_to_user_id to set
	 */
	public void setIn_reply_to_user_id(long in_reply_to_user_id) {
		this.in_reply_to_user_id = in_reply_to_user_id;
	}

	/**
	 * @return the in_reply_to_user_id_str
	 */
	public String getIn_reply_to_user_id_str() {
		return in_reply_to_user_id_str;
	}

	/**
	 * @param in_reply_to_user_id_str
	 *            the in_reply_to_user_id_str to set
	 */
	public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
		this.in_reply_to_user_id_str = in_reply_to_user_id_str;
	}

	/**
	 * @return the in_reply_to_screen_name
	 */
	public String getIn_reply_to_screen_name() {
		return in_reply_to_screen_name;
	}

	/**
	 * @param in_reply_to_screen_name
	 *            the in_reply_to_screen_name to set
	 */
	public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
		this.in_reply_to_screen_name = in_reply_to_screen_name;
	}

	/**
	 * @return the user
	 */
	public SolrTwitterUser getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(SolrTwitterUser user) {
		this.user = user;
	}

	/**
	 * @return the geo
	 */
	public String getGeo() {
		return geo;
	}

	/**
	 * @param geo
	 *            the geo to set
	 */
	public void setGeo(String geo) {
		this.geo = geo;
	}

	/**
	 * @return the coordinates
	 */
	public int[] getCoordinates() {
		return coordinates;
	}

	/**
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setCoordinates(int[] coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the contributors
	 */
	public String getContributors() {
		return contributors;
	}

	/**
	 * @param contributors
	 *            the contributors to set
	 */
	public void setContributors(String contributors) {
		this.contributors = contributors;
	}

	/**
	 * @return the retweet_count
	 */
	public int getRetweet_count() {
		return retweet_count;
	}

	/**
	 * @param retweet_count
	 *            the retweet_count to set
	 */
	public void setRetweet_count(int retweet_count) {
		this.retweet_count = retweet_count;
	}

	/**
	 * @return the favorite_count
	 */
	public int getFavorite_count() {
		return favorite_count;
	}

	/**
	 * @param favorite_count
	 *            the favorite_count to set
	 */
	public void setFavorite_count(int favorite_count) {
		this.favorite_count = favorite_count;
	}

	/**
	 * @return the entities
	 */
	public SolrTwitterEntity getEntities() {
		return entities;
	}

	/**
	 * @param entities
	 *            the entities to set
	 */
	public void setEntities(SolrTwitterEntity entities) {
		this.entities = entities;
	}

	/**
	 * @return the extended_entities
	 */
	public SolrTwitterEntity getExtended_entities() {
		return extended_entities;
	}

	/**
	 * @param extended_entities
	 *            the extended_entities to set
	 */
	public void setExtended_entities(SolrTwitterEntity extended_entities) {
		this.extended_entities = extended_entities;
	}

	/**
	 * @return the favorited
	 */
	public boolean isFavorited() {
		return favorited;
	}

	/**
	 * @param favorited
	 *            the favorited to set
	 */
	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}

	/**
	 * @return the retweeted
	 */
	public boolean isRetweeted() {
		return retweeted;
	}

	/**
	 * @param retweeted
	 *            the retweeted to set
	 */
	public void setRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
	}

	/**
	 * @return the possibly_sensitive
	 */
	public boolean isPossibly_sensitive() {
		return possibly_sensitive;
	}

	/**
	 * @param possibly_sensitive
	 *            the possibly_sensitive to set
	 */
	public void setPossibly_sensitive(boolean possibly_sensitive) {
		this.possibly_sensitive = possibly_sensitive;
	}

	/**
	 * @return the filter_level
	 */
	public String getFilter_level() {
		return filter_level;
	}

	/**
	 * @param filter_level
	 *            the filter_level to set
	 */
	public void setFilter_level(String filter_level) {
		this.filter_level = filter_level;
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
	 * @return the timestamp_ms
	 */
	public String getTimestamp_ms() {
		return timestamp_ms;
	}

	/**
	 * @param timestamp_ms
	 *            the timestamp_ms to set
	 */
	public void setTimestamp_ms(String timestamp_ms) {
		this.timestamp_ms = timestamp_ms;
	}

}
