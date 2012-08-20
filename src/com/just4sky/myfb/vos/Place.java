package com.just4sky.myfb.vos;

import org.json.JSONObject;

public class Place {
	
	private String id;
	private String name;
	private String city;
	private String country;
	private String latitude;
	private String longitude;
	
	public Place(JSONObject place){
		if(place != null){
			this.id = place.optString("id");
			this.name = place.optString("name");
			JSONObject location = place.optJSONObject("location");
			if(location != null){
				this.city = location.optString("city");
				this.country = location.optString("country");
				this.latitude = location.optString("latitude");
				this.longitude = location.optString("longitude");
			}
		}
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}
}
