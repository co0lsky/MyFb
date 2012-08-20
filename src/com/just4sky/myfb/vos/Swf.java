package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class Swf extends Post {
	
	private String message;
	private Tag messageTags;
	private String picture;
	private String link;
	private String name;
	private String caption;
	private int height;
	private int weight;
	private int expanded_height;
	private int expanded_weight;
	private String icon;
	private Action actions;
	private Connection shares;
	private Connection likes;
	private Application application;
	private Connection comments;
		
	public Swf(JSONObject obj) {
		super(obj);
		this.message = obj.optString("message");
		this.messageTags = new Tag(obj.optJSONObject("message_tags"));
		this.picture = obj.optString("picture");
		this.link = obj.optString("link");
		this.name = obj.optString("name");
		this.caption = obj.optString("caption");
		this.height = obj.optInt("height");
		this.weight = obj.optInt("weight");
		this.expanded_height = obj.optInt("expanded_height");
		this.expanded_weight = obj.optInt("expanded_weight");
		this.icon = obj.optString("icon");
		this.actions = new Action(obj.optJSONObject("actions"));
		this.shares = new Connection(obj.optJSONObject("shares"));
		this.likes = new Connection(obj.optJSONObject("likes"));
		this.application = new Application(obj.optJSONObject("application"));
		this.comments = new Connection(obj.optJSONObject("comments"));
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

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public int getExpanded_height() {
		return expanded_height;
	}

	public int getExpanded_weight() {
		return expanded_weight;
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

	public Application getApplication() {
		return application;
	}

	public Connection getComments() {
		return comments;
	}
}
