package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class Properties {	
	
	private String name;
	private String text;
	private String href;
	
	public Properties(JSONObject properties){
		if(properties != null){
			this.name = properties.optString("name");
			this.text = properties.optString("text");
			this.href = properties.optString("href");
		}
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}

	public String getHref() {
		return href;
	}
}
