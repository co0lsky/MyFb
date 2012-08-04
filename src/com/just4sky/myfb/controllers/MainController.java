package com.just4sky.myfb.controllers;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.just4sky.myfb.models.MainModel;
import com.just4sky.myfb.utils.Utilities;
import com.just4sky.myfb.vos.BasicDialogListener;
import com.just4sky.myfb.vos.BasicRequestListener;

public class MainController {
    private MainModel mainModel;

    public static final String TEXT_LOGIN = "Login";
    public static final String TEXT_LOGOUT = "Logout";

    public MainController(MainModel mainModel){
        this.mainModel = mainModel;
    }

    public void init(){
         if(Utilities.facebook.isSessionValid()){
             getInfo();
         }else{
             setAnonymous();
         }
    }

    private void setAnonymous(){
        mainModel.setName("Anonymous");
        mainModel.setButton(TEXT_LOGIN);
    }

    private void setInfo(String name){
        mainModel.setName(name);
        mainModel.setButton(TEXT_LOGOUT);
    }

    public void getInfo(){
        Utilities.facebookRunner.request("me", new GetInfoListener());
    }

    private class GetInfoListener extends BasicRequestListener {
        @Override
        public void onComplete(String response, Object state) {
            try {
                JSONObject json = new JSONObject(response);
                setInfo(json.getString("name"));
            } catch (JSONException e) {
                Log.e(Utilities.tag, e.getMessage());
            }

        }
    }

    public void logout(Context context){
        Utilities.facebookRunner.logout(context, new LogoutListener());
    }

    private class LogoutListener extends BasicRequestListener {
        @Override
        public void onComplete(String response, Object state) {
            setAnonymous();
        }
    }

    public void login(Activity activity){
        Utilities.facebook.authorize(activity, new LoginListener());
    }

    private class LoginListener extends BasicDialogListener {

        @Override
        public void onComplete(Bundle values) {
            SharedPreferences.Editor editor = Utilities.mPrefs.edit();
            editor.putString("access_token", Utilities.facebook.getAccessToken());
            editor.putLong("access_expires", Utilities.facebook.getAccessExpires());
            editor.commit();
            getInfo();
        }
    }
}
