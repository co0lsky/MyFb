package com.just4sky.myfb.vos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import android.util.Log;

import com.facebook.android.AsyncFacebookRunner.RequestListener;
import com.facebook.android.FacebookError;
import com.just4sky.myfb.utils.Utilities;

public class BasicRequestListener implements RequestListener {
    @Override
    public void onComplete(String response, Object state) {
        Log.i(Utilities.tag,response);
    }

    @Override
    public void onIOException(IOException e, Object state) {
        Log.e(Utilities.tag,e.getMessage());
    }

    @Override
    public void onFileNotFoundException(FileNotFoundException e, Object state) {
        Log.e(Utilities.tag,e.getMessage());
    }

    @Override
    public void onMalformedURLException(MalformedURLException e, Object state) {
        Log.e(Utilities.tag,e.getMessage());
    }

    @Override
    public void onFacebookError(FacebookError e, Object state) {
        Log.e(Utilities.tag,e.getMessage());
    }
}
