/**
 * 
 */
package com.abi.ir.tweetir.inputbeans;

/**
 * @author Abinash
 *
 */
public class TwitterUser {
	private long id;
	private String id_str;
	private String name;
	private String screen_name;
	private String location;
	private String url;
	private String description;
	private boolean protectedUser;// Maps to protected
	private boolean verified;
	private int followers_count;
	private int friends_count;
	private int listed_count;
	private int favourites_count;
	private int statuses_count;
	private String created_at;
	private long utc_offset;
	private String time_zone;
	private boolean geo_enabled;
	private String lang;
	private boolean contributors_enabled;
	private boolean is_translator;
	private String profile_background_color;
	private String profile_background_image_url;
	private String profile_background_image_url_https;
	private boolean profile_background_tile;
	private String profile_link_color;
	private String profile_sidebar_border_color;
	private String profile_sidebar_fill_color;
	private String profile_text_color;
	private boolean profile_use_background_image;
	private String profile_image_url;
	private String profile_image_url_https;;
	private String profile_banner_url;
	private boolean default_profile;
	private boolean default_profile_image;
	private boolean following; // need to check
	private boolean follow_request_sent;// need to check
	private String notifications;

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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * @return the protectedUser
	 */
	public boolean isProtectedUser() {
		return protectedUser;
	}

	/**
	 * @param protectedUser
	 *            the protectedUser to set
	 */
	public void setProtectedUser(boolean protectedUser) {
		this.protectedUser = protectedUser;
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
	 * @return the followers_count
	 */
	public int getFollowers_count() {
		return followers_count;
	}

	/**
	 * @param followers_count
	 *            the followers_count to set
	 */
	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}

	/**
	 * @return the friends_count
	 */
	public int getFriends_count() {
		return friends_count;
	}

	/**
	 * @param friends_count
	 *            the friends_count to set
	 */
	public void setFriends_count(int friends_count) {
		this.friends_count = friends_count;
	}

	/**
	 * @return the listed_count
	 */
	public int getListed_count() {
		return listed_count;
	}

	/**
	 * @param listed_count
	 *            the listed_count to set
	 */
	public void setListed_count(int listed_count) {
		this.listed_count = listed_count;
	}

	/**
	 * @return the favourites_count
	 */
	public int getFavourites_count() {
		return favourites_count;
	}

	/**
	 * @param favourites_count
	 *            the favourites_count to set
	 */
	public void setFavourites_count(int favourites_count) {
		this.favourites_count = favourites_count;
	}

	/**
	 * @return the statuses_count
	 */
	public int getStatuses_count() {
		return statuses_count;
	}

	/**
	 * @param statuses_count
	 *            the statuses_count to set
	 */
	public void setStatuses_count(int statuses_count) {
		this.statuses_count = statuses_count;
	}

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
	 * @return the utc_offset
	 */
	public long getUtc_offset() {
		return utc_offset;
	}

	/**
	 * @param utc_offset
	 *            the utc_offset to set
	 */
	public void setUtc_offset(long utc_offset) {
		this.utc_offset = utc_offset;
	}

	/**
	 * @return the time_zone
	 */
	public String getTime_zone() {
		return time_zone;
	}

	/**
	 * @param time_zone
	 *            the time_zone to set
	 */
	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

	/**
	 * @return the geo_enabled
	 */
	public boolean isGeo_enabled() {
		return geo_enabled;
	}

	/**
	 * @param geo_enabled
	 *            the geo_enabled to set
	 */
	public void setGeo_enabled(boolean geo_enabled) {
		this.geo_enabled = geo_enabled;
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
	 * @return the contributors_enabled
	 */
	public boolean isContributors_enabled() {
		return contributors_enabled;
	}

	/**
	 * @param contributors_enabled
	 *            the contributors_enabled to set
	 */
	public void setContributors_enabled(boolean contributors_enabled) {
		this.contributors_enabled = contributors_enabled;
	}

	/**
	 * @return the is_translator
	 */
	public boolean isIs_translator() {
		return is_translator;
	}

	/**
	 * @param is_translator
	 *            the is_translator to set
	 */
	public void setIs_translator(boolean is_translator) {
		this.is_translator = is_translator;
	}

	/**
	 * @return the profile_background_color
	 */
	public String getProfile_background_color() {
		return profile_background_color;
	}

	/**
	 * @param profile_background_color
	 *            the profile_background_color to set
	 */
	public void setProfile_background_color(String profile_background_color) {
		this.profile_background_color = profile_background_color;
	}

	/**
	 * @return the profile_background_image_url
	 */
	public String getProfile_background_image_url() {
		return profile_background_image_url;
	}

	/**
	 * @param profile_background_image_url
	 *            the profile_background_image_url to set
	 */
	public void setProfile_background_image_url(String profile_background_image_url) {
		this.profile_background_image_url = profile_background_image_url;
	}

	/**
	 * @return the profile_background_image_url_https
	 */
	public String getProfile_background_image_url_https() {
		return profile_background_image_url_https;
	}

	/**
	 * @param profile_background_image_url_https
	 *            the profile_background_image_url_https to set
	 */
	public void setProfile_background_image_url_https(String profile_background_image_url_https) {
		this.profile_background_image_url_https = profile_background_image_url_https;
	}

	/**
	 * @return the profile_background_tile
	 */
	public boolean isProfile_background_tile() {
		return profile_background_tile;
	}

	/**
	 * @param profile_background_tile
	 *            the profile_background_tile to set
	 */
	public void setProfile_background_tile(boolean profile_background_tile) {
		this.profile_background_tile = profile_background_tile;
	}

	/**
	 * @return the profile_link_color
	 */
	public String getProfile_link_color() {
		return profile_link_color;
	}

	/**
	 * @param profile_link_color
	 *            the profile_link_color to set
	 */
	public void setProfile_link_color(String profile_link_color) {
		this.profile_link_color = profile_link_color;
	}

	/**
	 * @return the profile_sidebar_border_color
	 */
	public String getProfile_sidebar_border_color() {
		return profile_sidebar_border_color;
	}

	/**
	 * @param profile_sidebar_border_color
	 *            the profile_sidebar_border_color to set
	 */
	public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
		this.profile_sidebar_border_color = profile_sidebar_border_color;
	}

	/**
	 * @return the profile_sidebar_fill_color
	 */
	public String getProfile_sidebar_fill_color() {
		return profile_sidebar_fill_color;
	}

	/**
	 * @param profile_sidebar_fill_color
	 *            the profile_sidebar_fill_color to set
	 */
	public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
		this.profile_sidebar_fill_color = profile_sidebar_fill_color;
	}

	/**
	 * @return the profile_text_color
	 */
	public String getProfile_text_color() {
		return profile_text_color;
	}

	/**
	 * @param profile_text_color
	 *            the profile_text_color to set
	 */
	public void setProfile_text_color(String profile_text_color) {
		this.profile_text_color = profile_text_color;
	}

	/**
	 * @return the profile_use_background_image
	 */
	public boolean isProfile_use_background_image() {
		return profile_use_background_image;
	}

	/**
	 * @param profile_use_background_image
	 *            the profile_use_background_image to set
	 */
	public void setProfile_use_background_image(boolean profile_use_background_image) {
		this.profile_use_background_image = profile_use_background_image;
	}

	/**
	 * @return the profile_image_url
	 */
	public String getProfile_image_url() {
		return profile_image_url;
	}

	/**
	 * @param profile_image_url
	 *            the profile_image_url to set
	 */
	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	/**
	 * @return the profile_image_url_https
	 */
	public String getProfile_image_url_https() {
		return profile_image_url_https;
	}

	/**
	 * @param profile_image_url_https
	 *            the profile_image_url_https to set
	 */
	public void setProfile_image_url_https(String profile_image_url_https) {
		this.profile_image_url_https = profile_image_url_https;
	}

	/**
	 * @return the profile_banner_url
	 */
	public String getProfile_banner_url() {
		return profile_banner_url;
	}

	/**
	 * @param profile_banner_url
	 *            the profile_banner_url to set
	 */
	public void setProfile_banner_url(String profile_banner_url) {
		this.profile_banner_url = profile_banner_url;
	}

	/**
	 * @return the default_profile
	 */
	public boolean isDefault_profile() {
		return default_profile;
	}

	/**
	 * @param default_profile
	 *            the default_profile to set
	 */
	public void setDefault_profile(boolean default_profile) {
		this.default_profile = default_profile;
	}

	/**
	 * @return the default_profile_image
	 */
	public boolean isDefault_profile_image() {
		return default_profile_image;
	}

	/**
	 * @param default_profile_image
	 *            the default_profile_image to set
	 */
	public void setDefault_profile_image(boolean default_profile_image) {
		this.default_profile_image = default_profile_image;
	}

	/**
	 * @return the following
	 */
	public boolean isFollowing() {
		return following;
	}

	/**
	 * @param following
	 *            the following to set
	 */
	public void setFollowing(boolean following) {
		this.following = following;
	}

	/**
	 * @return the follow_request_sent
	 */
	public boolean isFollow_request_sent() {
		return follow_request_sent;
	}

	/**
	 * @param follow_request_sent
	 *            the follow_request_sent to set
	 */
	public void setFollow_request_sent(boolean follow_request_sent) {
		this.follow_request_sent = follow_request_sent;
	}

	/**
	 * @return the notifications
	 */
	public String getNotifications() {
		return notifications;
	}

	/**
	 * @param notifications
	 *            the notifications to set
	 */
	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}

}
