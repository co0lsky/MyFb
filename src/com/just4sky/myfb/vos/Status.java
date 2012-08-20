package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class Status extends Post{
	private String story;
	private Tag storyTags;
	private String message;
	private Action actions;
	private Connection likes;
	private Application application;
	private Connection comments;
	
	public Status(JSONObject obj){
		super(obj);
		this.story = obj.optString("story");
		this.storyTags = new Tag(obj.optJSONObject("story_tags"));
		this.message = obj.optString("message");
		this.actions = new Action(obj.optJSONObject("actions"));
		this.likes = new Connection(obj.optJSONObject("likes"));
		this.application = new Application(obj.optJSONObject("application"));
		this.comments = new Connection(obj.optJSONObject("comments"));
	}

	public String getStory() {
		return story;
	}
	public Tag getStoryTags() {
		return storyTags;
	}
	public String getMessage() {
		return message;
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
