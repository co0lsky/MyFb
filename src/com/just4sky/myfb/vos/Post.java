package com.just4sky.myfb.vos;

import org.json.JSONException;
import org.json.JSONObject;

public class Post {
	private String id;
	private User from;
	private String type;
	private String createdTime;
	private String updatedTime;
	private boolean isPublished;
	
	public Post(JSONObject obj){
		try {
			this.id = obj.getString("id");
			this.from = new User(obj.getJSONObject("from"));			
			this.type = obj.getString("type");
			this.createdTime = obj.getString("created_time");
			this.updatedTime = obj.getString("updated_time");
			this.isPublished = obj.getBoolean("is_published");			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}
	public User getFrom() {
		return from;
	}
	public String getType() {
		return type;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public boolean isPublished() {
		return isPublished;
	}
}
