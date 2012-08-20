package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class Connection {
	private int count;
	private JSONObject data;
	
	public Connection(JSONObject data){
		if(data != null){
			this.count = data.optInt("count");
			this.data = data.optJSONObject("data");
		}
	}

	public int getCount() {
		return count;
	}

	public JSONObject getData() {
		return data;
	}
}
