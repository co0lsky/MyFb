package com.just4sky.myfb.lists;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import android.content.Context;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fedorvlasov.lazylist.ImageLoader;
import com.just4sky.myfb.activities.R;
import com.just4sky.myfb.utils.Utilities;
import com.just4sky.myfb.vos.FBPost;

public class NewsFeedList extends ArrayAdapter<JSONObject>{

	private Context context;
	private int textViewId;
	private List<JSONObject> objects;
	private ImageLoader imageLoader;

    static class ViewHolder {
		public TextView tvUserNameOrStory;
		public TextView tvMessage;
		public ImageView ivProfilePhoto;
		public ImageView ivPicture;
		public TextView tvPictureDesc;
		public TextView tvTimeAndApp;
		public TextView tvAlbumName;
	}
	
	public NewsFeedList(Context context, int textViewId) {
		super(context, textViewId);
		this.context = context;
		this.textViewId = textViewId;
		this.objects = new ArrayList<JSONObject>();
		imageLoader = new ImageLoader(this.context);
	}
	
	public void setNewsFeed(List<JSONObject> objects){
		this.objects = objects;
		super.clear();
		super.addAll(objects);
	}
	
	public void addNewsFeed(List<JSONObject> objects){
		this.objects.addAll(objects);
		super.addAll(objects);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		if (rowView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.post, null);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.tvUserNameOrStory = (TextView) rowView.findViewById(R.id.tvUserNameOrStory);
			viewHolder.tvMessage = (TextView) rowView.findViewById(R.id.tvMessage);
			viewHolder.ivProfilePhoto = (ImageView) rowView.findViewById(R.id.ivProfilePhoto);
			viewHolder.ivPicture = (ImageView) rowView.findViewById(R.id.ivPicture);
			viewHolder.tvPictureDesc = (TextView) rowView.findViewById(R.id.tvPictureDesc);
			viewHolder.tvTimeAndApp = (TextView) rowView.findViewById(R.id.tvTimeAndApp);
			viewHolder.tvAlbumName = (TextView) rowView.findViewById(R.id.tvAlbumName);
			rowView.setTag(viewHolder);
		}

		ViewHolder holder = (ViewHolder) rowView.getTag();
		
		JSONObject thisObj = objects.get(position);
		FBPost thisPost = new FBPost();
		thisPost.createPost(thisObj);
		holder.tvUserNameOrStory.setText(thisPost.getUserNameOrStory());
		holder.tvMessage.setText(thisPost.getMessage());
		String imageUrl = thisPost.getProfilePhotoURL();
		imageLoader.DisplayImage(imageUrl, holder.ivProfilePhoto);
		
		String pictureUrl = thisPost.getPictureURL();
		if(!pictureUrl.isEmpty()){
			holder.ivPicture.setVisibility(View.VISIBLE);
			imageLoader.DisplayImage(pictureUrl, holder.ivPicture);
		}else{
			holder.ivPicture.setVisibility(View.GONE);
		}
		
		String pictureDesc = thisPost.getPictureDesc();
		holder.tvPictureDesc.setText(pictureDesc);
		
		String albumName = thisPost.getAlbumName();
		if(!albumName.isEmpty()){
			holder.tvAlbumName.setVisibility(View.VISIBLE);
			holder.tvAlbumName.setText(albumName);
		}else{
			holder.tvAlbumName.setVisibility(View.GONE);
		}

		Date currentTime = new Date();
		Date createdTime = currentTime;
		try{
			createdTime = Utilities.dateFormat.parse(thisPost.getCreatedTime());
		}catch(ParseException e){
			Log.e("test", thisPost.getCreatedTime()+" | "+e.getMessage());
		}
		
		String delimiter = " ¡¤ ";
		String footer = DateUtils.getRelativeTimeSpanString(createdTime.getTime(), currentTime.getTime(), DateUtils.MINUTE_IN_MILLIS) + delimiter +
							"Likes (" + thisPost.getLikesCount() + ")" + delimiter +
							"Comments (" + thisPost.getCommentsCount() + ")";
		holder.tvTimeAndApp.setText(footer);
		
		return rowView;
	}
	
	public void clearImageCache(){
		imageLoader.clearCache();
	}

	public int getTextViewId() {
		return textViewId;
	}
}
