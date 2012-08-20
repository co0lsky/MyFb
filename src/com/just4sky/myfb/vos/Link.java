package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class Link extends Post {
	
	private User to;
	private String message;
	private Tag messageTags;
	private String picture;
	private String link;
	private String name;
	private String caption;
	private String description;
	private String icon;
	private Action actions;
	private Connection likes;
	private Application application;
	private Connection comments;
	
	public Link(JSONObject obj) {
		super(obj);
		this.to = new User(obj.optJSONObject("to"));
		this.message = obj.optString("message");
		this.messageTags = new Tag(obj.optJSONObject("message_tags"));
		this.picture = obj.optString("picture");
		this.link = obj.optString("link");
		this.name = obj.optString("name");
		this.caption = obj.optString("caption");
		this.description = obj.optString("description");
		this.icon = obj.optString("icon");
		this.actions = new Action(obj.optJSONObject("actions"));
		this.likes = new Connection(obj.optJSONObject("likes"));
		this.application = new Application(obj.optJSONObject("application"));
		this.comments = new Connection(obj.optJSONObject("comments"));
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

	public String getIcon() {
		return icon;
	}

	public Action getActions() {
		return actions;
	}

	public Connection getLikes() {
		return likes;
	}

	public Application getApplication() {
		return application;
	}

	public Connection getComments() {
		return comments;
	}

}
