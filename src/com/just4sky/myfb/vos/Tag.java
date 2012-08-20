package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class Tag {
	
	private String id;
	private String name;
	private int offset;
	private int length;
	
	public Tag(JSONObject tag){
		if(tag != null){
			this.id = tag.optString("id");
			this.name = tag.optString("name");
			this.offset = tag.optInt("offset");
			this.length = tag.optInt("length");
		}
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}
}
