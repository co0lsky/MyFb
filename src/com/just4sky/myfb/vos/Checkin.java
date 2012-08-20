package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class Checkin extends Post {
	
	private String message;
	private String picture;
	private String link;
	private String name;
	private String caption;
	private String icon;
	private Action actions;
	private Place place;
	private Connection likes;
	private Application application;
	private Connection comments;
	
	public Checkin(JSONObject obj) {
		super(obj);
		this.message = obj.optString("message");
		this.picture = obj.optString("picture");
		this.link = obj.optString("link");
		this.name = obj.optString("name");
		this.caption = obj.optString("caption");
		this.icon = obj.optString("icon");
		this.actions = new Action(obj.optJSONObject("actions"));
		this.place = new Place(obj.optJSONObject("place"));
		this.likes = new Connection(obj.optJSONObject("likes"));
		this.application = new Application(obj.optJSONObject("application"));
		this.comments = new Connection(obj.optJSONObject("comments"));
	}

	public String getMessage() {
		return message;
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

	public String getIcon() {
		return icon;
	}

	public Action getActions() {
		return actions;
	}

	public Place getPlace() {
		return place;
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
