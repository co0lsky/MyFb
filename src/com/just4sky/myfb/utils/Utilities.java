package com.just4sky.myfb.utils;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;

import android.content.SharedPreferences;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.Facebook;

public class Utilities {
    public static String appId = "174620119266361";
    public static Facebook facebook;
    public static AsyncFacebookRunner facebookRunner;
    public static SharedPreferences mPrefs;

    public static String tag = "MyFb";
    
    public static String profilePhotoURL = "https://graph.facebook.com/USER_ID/picture?type=square";
	public static String normalPictureURL = "https://graph.facebook.com/USER_ID/picture?type=normal";
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sszzzzz");
	
	public static String handleURL(String url){
		String newUrl = url;
		int indexOfUrl = url.indexOf("url=");
		if(indexOfUrl > -1){
			indexOfUrl += 4;
			newUrl = url.substring(indexOfUrl);
		}
		
		int indexOfSrc = url.indexOf("src=");
		if(indexOfSrc > -1){
			indexOfSrc += 4;
			newUrl = url.substring(indexOfSrc);
		}
		newUrl = newUrl.replace("_s", "_n");
		return URLDecoder.decode(newUrl);
	}
}
