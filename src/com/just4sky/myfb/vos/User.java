package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class User {
	private String id;
	private String name;
	
	public User(JSONObject user){
		if(user != null){
			this.name = user.optString("name");
			this.id = user.optString("id");
		}
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
