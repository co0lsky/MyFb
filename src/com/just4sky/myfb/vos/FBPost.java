package com.just4sky.myfb.vos;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.just4sky.myfb.utils.Utilities;


public class FBPost implements PostInterface {
	private String userNameOrStory;
	private String message;
	private String profilePhotoURL;
	private String pictureURL;
	private String pictureDesc;
	private String albumName;
	private String iconURL;
	private String createdTime;
	private int commentsCount;
	private int likesCount;
	
	public FBPost(){
		this.userNameOrStory = "";
		this.message = "";
		this.profilePhotoURL = "";
		this.pictureURL = "";
		this.pictureDesc = "";
		this.albumName = "";
		this.iconURL = "";
		this.createdTime = "";
		this.commentsCount = 0;
		this.likesCount = 0;
	}
	
	public void createPost(JSONObject postObj){
		
		try {
			
			String type = postObj.getString("type");
			User from = null;
			Connection comments = null;
			Connection likes = null;
			
			// Specific
			if(type.equals("status")){
				
				Status thisPost = new Status(postObj);
				from = thisPost.getFrom();
				comments = thisPost.getComments();
				likes = thisPost.getLikes();
				
				this.userNameOrStory = thisPost.getStory() != "" ? thisPost.getStory() : from.getName();
				this.message = thisPost.getMessage();
				this.profilePhotoURL = Utilities.profilePhotoURL.replace("USER_ID", from.getId());
				this.createdTime = thisPost.getCreatedTime();
				
			}else if(type.equals("photo")){
				
				Photo thisPost = new Photo(postObj);
				from = thisPost.getFrom();
				comments = thisPost.getComments();
				likes = thisPost.getLikes();
				
				this.userNameOrStory = thisPost.getStory() != "" ? thisPost.getStory() : from.getName();
				this.message = thisPost.getMessage();
				this.profilePhotoURL = Utilities.profilePhotoURL.replace("USER_ID", from.getId());
				this.pictureURL = thisPost.getPicture() != "" ? Utilities.handleURL(thisPost.getPicture()) : Utilities.normalPictureURL.replace("USER_ID", thisPost.getObjectId());
				this.pictureDesc = thisPost.getDescription();
				this.albumName = thisPost.getName();
				this.iconURL = thisPost.getIcon();
				this.createdTime = thisPost.getCreatedTime();
				
			}else if(type.equals("link")){
				
				Link thisPost = new Link(postObj);
				from = thisPost.getFrom();
				comments = thisPost.getComments();
				likes = thisPost.getLikes();
				
				this.userNameOrStory = from.getName();
				this.message = thisPost.getMessage();
				this.profilePhotoURL = Utilities.profilePhotoURL.replace("USER_ID",from.getId());
				this.pictureURL = Utilities.handleURL(thisPost.getPicture());
				this.pictureDesc = thisPost.getDescription();
				this.albumName = thisPost.getName();
				this.iconURL = thisPost.getIcon();
				this.createdTime = thisPost.getCreatedTime();
				
			}else if(type.equals("video")){
				
				Video thisPost = new Video(postObj);
				from = thisPost.getFrom();
				comments = thisPost.getComments();
				likes = thisPost.getLikes();
				
				this.userNameOrStory = from.getName();
				this.message = thisPost.getMessage();
				this.profilePhotoURL = Utilities.profilePhotoURL.replace("USER_ID",from.getId());
				this.pictureURL = Utilities.handleURL(thisPost.getPicture());
				this.albumName = thisPost.getName();
				this.iconURL = thisPost.getIcon();
				this.createdTime = thisPost.getCreatedTime();
				
			}else if(type.equals("checkin")){
				
				Checkin thisPost = new Checkin(postObj);
				from = thisPost.getFrom();
				comments = thisPost.getComments();
				likes = thisPost.getLikes();
				
				this.userNameOrStory = thisPost.getCaption() != "" ? thisPost.getCaption() : from.getName();
				this.message = thisPost.getMessage();
				this.profilePhotoURL = Utilities.profilePhotoURL.replace("USER_ID",from.getId());
				this.pictureURL = Utilities.handleURL(thisPost.getPicture());
				this.albumName = thisPost.getName();
				this.iconURL = thisPost.getIcon();
				this.createdTime = thisPost.getCreatedTime();
			
			}else if(type.equals("swf")){
				
				Swf thisPost = new Swf(postObj);
				from = thisPost.getFrom();
				comments = thisPost.getComments();
				likes = thisPost.getLikes();
				
				this.userNameOrStory = from.getName();
				this.message = thisPost.getMessage();
				this.profilePhotoURL = Utilities.profilePhotoURL.replace("USER_ID", from.getId());
				this.pictureURL = Utilities.handleURL(thisPost.getPicture());
				this.pictureDesc = thisPost.getName();
				this.albumName = thisPost.getName();
				this.iconURL = thisPost.getIcon();
				this.createdTime = thisPost.getCreatedTime();
				
			}else{
				this.userNameOrStory = "Sky Just";
				this.message = "says this is pending";
				this.profilePhotoURL = Utilities.profilePhotoURL.replace("USER_ID", "709601128");
				this.createdTime = new Date().getTime()+"";
			}
			
			// Common
			if(comments != null)
				this.commentsCount = comments.getCount();
			
			if(likes != null)
				this.likesCount = likes.getCount();
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public String getProfilePhotoURL() {
		return profilePhotoURL;
	}

	public String getUserNameOrStory() {
		return userNameOrStory;
	}

	public String getMessage() {
		return message;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public String getPictureDesc() {
		return pictureDesc;
	}
	
	public String getAlbumName() {
		return albumName;
	}

	public String getIconURL() {
		return iconURL;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public int getLikesCount() {
		return likesCount;
	}
}
