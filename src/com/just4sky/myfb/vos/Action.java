package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class Action {	
	
	private String name;
	private String link;
	
	public Action(JSONObject action){
		if(action != null){
			this.name = action.optString("name");
			this.link = action.optString("link");
		}
	}

	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}
}
