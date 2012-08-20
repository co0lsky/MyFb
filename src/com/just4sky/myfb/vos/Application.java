package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class Application {
	
	private String id;
	private String name;
	private String canvas_name;
	private String namespace;
	
	public Application(JSONObject application){
		if(application != null){
			this.name = application.optString("name");
			this.id = application.optString("id");
			this.canvas_name = application.optString("canvas_name");
			this.namespace = application.optString("namespace");
		}
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCanvas_name() {
		return canvas_name;
	}

	public String getNamespace() {
		return namespace;
	}
}
