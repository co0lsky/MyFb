package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class Comment {
	private String id;
	private User from;
	private String message;
	private String createdTime;
	
	public Comment(JSONObject comment){
		if(comment != null){
			this.id = comment.optString("name");
			this.from = new User(comment.optJSONObject("from"));
			this.message = comment.optString("message");
			this.createdTime = comment.optString("created_time");
		}
	}

	public String getId() {
		return id;
	}

	public User getFrom() {
		return from;
	}

	public String getMessage() {
		return message;
	}

	public String getCreatedTime() {
		return createdTime;
	}
	
}
