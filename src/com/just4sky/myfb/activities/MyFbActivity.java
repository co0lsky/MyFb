package com.just4sky.myfb.activities;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListActivity;
import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.Facebook;
import com.just4sky.myfb.controllers.MainController;
import com.just4sky.myfb.lists.NewsFeedList;
import com.just4sky.myfb.models.MainModel;
import com.just4sky.myfb.utils.Utilities;
import com.just4sky.myfb.vos.OnChangeListener;

public class MyFbActivity extends SherlockListActivity implements OnChangeListener<MainModel> {
    private MainModel mainModel;
    private MainController mainController;
    private TextView tvName;
    private Button btn;
    private NewsFeedList newsFeedList;

    public void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        mainModel = new MainModel();
        mainModel.addListener(this);

        newsFeedList = new NewsFeedList(this, R.layout.newsfeedlist);
        mainController = new MainController(this, mainModel, newsFeedList);

        tvName = (TextView)findViewById(R.id.name);
        btn = (Button)findViewById(R.id.button);

        initFacebook();
        mainController.init();
    }

    public void initFacebook(){
        Utilities.facebook = new Facebook(Utilities.appId);
        Utilities.facebookRunner = new AsyncFacebookRunner(Utilities.facebook);

        /*
         * Get existing access_token if any
         */
        Utilities.mPrefs = getPreferences(MODE_PRIVATE);
        String access_token = Utilities.mPrefs.getString("access_token", null);
        long expires = Utilities.mPrefs.getLong("access_expires", 0);
        if(access_token != null) {
            Utilities.facebook.setAccessToken(access_token);
        }
        if(expires != 0) {
            Utilities.facebook.setAccessExpires(expires);
        }
    }

    private void updateView() {
        tvName.setText("Welcome, "+mainModel.getName()+"!");
        btn.setText(mainModel.getButton());
        if(btn.getText().equals(MainController.TEXT_LOGIN)){
            btn.setOnClickListener(new LoginListener());
        }else{
            btn.setOnClickListener(new LogoutListener());
        }
    }

    private class LogoutListener implements OnClickListener {
        @Override
        public void onClick(View view) {
            mainController.logout(MyFbActivity.this.getApplicationContext());
        }
    }

    private class LoginListener implements OnClickListener {
        @Override
        public void onClick(View view) {
            mainController.login(MyFbActivity.this);
        }
    }

    @Override
    public void onChange(MainModel mainModel) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                updateView();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Utilities.facebook.authorizeCallback(requestCode, resultCode, data);
    }
}