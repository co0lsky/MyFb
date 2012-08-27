package com.just4sky.myfb.models;

import org.json.JSONObject;

import com.just4sky.myfb.vos.Action;
import com.just4sky.myfb.vos.Application;
import com.just4sky.myfb.vos.Connection;
import com.just4sky.myfb.vos.Post;
import com.just4sky.myfb.vos.Properties;
import com.just4sky.myfb.vos.Tag;
import com.just4sky.myfb.vos.User;

public class Photo extends Post {
	
	private String story;
	private Tag storyTags;
	private User to;
	private String message;
	private Tag messageTags;
	private String picture;
	private String link;
	private String name;
	private String caption;
	private String description;
	private Properties properties;
	private String icon;
	private Action actions;
	private Connection shares;
	private Connection likes;
	private String objectId;
	private Application application;
	private Connection comments;
	
	public Photo(JSONObject obj) {
		super(obj);
		this.story = obj.optString("story");
		this.storyTags = new Tag(obj.optJSONObject("story_tags"));
		this.to = new User(obj.optJSONObject("to"));
		this.message = obj.optString("message");
		this.messageTags = new Tag(obj.optJSONObject("message_tags"));
		this.picture = obj.optString("picture");
		this.link = obj.optString("link");
		this.name = obj.optString("name");
		this.caption = obj.optString("caption");
		this.description = obj.optString("description");
		this.properties = new Properties(obj.optJSONObject("properties"));
		this.icon = obj.optString("icon");
		this.actions = new Action(obj.optJSONObject("actions"));
		this.shares = new Connection(obj.optJSONObject("shares"));
		this.likes = new Connection(obj.optJSONObject("likes"));
		this.objectId = obj.optString("object_id");
		this.application = new Application(obj.optJSONObject("application"));
		this.comments = new Connection(obj.optJSONObject("comments"));
	}

	public String getStory() {
		return story;
	}

	public Tag getStoryTags() {
		return storyTags;
	}

	public User getTo() {
		return to;
	}

	public String getMessage() {
		return message;
	}

	public Tag getMessageTags() {
		return messageTags;
	}

	public String getPicture() {
		return picture;
	}

	public String getLink() {
		return link;
	}

	public String getName() {
		return name;
	}

	public String getCaption() {
		return caption;
	}

	public String getDescription() {
		return description;
	}

	public Properties getProperties() {
		return properties;
	}

	public String getIcon() {
		return icon;
	}

	public Action getActions() {
		return actions;
	}

	public Connection getShares() {
		return shares;
	}

	public Connection getLikes() {
		return likes;
	}

	public String getObjectId() {
		return objectId;
	}

	public Application getApplication() {
		return application;
	}

	public Connection getComments() {
		return comments;
	}

}
