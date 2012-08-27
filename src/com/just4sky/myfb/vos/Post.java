package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class Post {
	private String id;
	private User whoPostIt;
	private User postToWho;
	private String message;
	private Tag messageTags[];
	private String picture;
	private String linkAttached;
	private String linkName;
	private String linkCaption;
	private String linkDesc;
	private String videoSource;
	private Properties videoProp;
	private String icon;
	private Action whatCanDo;
	//private Privacy privacy; TODO implement later
	private String type;
	private Connection likes; //TODO change connection to other better name
	private Place place;
	private String story;
	private Tag storyTags[];
	private Tag withWho[];
	private Connection comments;
	private int objectId;
	private Application viaApp;
	private String createdTime;
	private String updatedTime;
	
	public Post(JSONObject thisObj){
		this.id = thisObj.optString("id");
	}

	public String getId() {
		return id;
	}

	public User getWhoPostIt() {
		return whoPostIt;
	}

	public User getPostToWho() {
		return postToWho;
	}

	public String getMessage() {
		return message;
	}

	public Tag[] getMessageTags() {
		return messageTags;
	}

	public String getPicture() {
		return picture;
	}

	public String getLinkAttached() {
		return linkAttached;
	}

	public String getLinkName() {
		return linkName;
	}

	public String getLinkCaption() {
		return linkCaption;
	}

	public String getLinkDesc() {
		return linkDesc;
	}

	public String getVideoSource() {
		return videoSource;
	}

	public Properties getVideoProp() {
		return videoProp;
	}

	public String getIcon() {
		return icon;
	}

	public Action getWhatCanDo() {
		return whatCanDo;
	}

	public String getType() {
		return type;
	}

	public Connection getLikes() {
		return likes;
	}

	public Place getPlace() {
		return place;
	}

	public String getStory() {
		return story;
	}

	public Tag[] getStoryTags() {
		return storyTags;
	}

	public Tag[] getWithWho() {
		return withWho;
	}

	public Connection getComments() {
		return comments;
	}

	public int getObjectId() {
		return objectId;
	}

	public Application getViaApp() {
		return viaApp;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}
}
