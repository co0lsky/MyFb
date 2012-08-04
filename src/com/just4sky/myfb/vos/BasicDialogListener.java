package com.just4sky.myfb.vos;

import android.os.Bundle;
import android.util.Log;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.just4sky.myfb.utils.Utilities;

public class BasicDialogListener implements DialogListener {

    @Override
    public void onComplete(Bundle values) {
        Log.i(Utilities.tag,values.toString());
    }

    @Override
    public void onFacebookError(FacebookError e) {
        Log.e(Utilities.tag,e.getMessage());
    }

    @Override
    public void onError(DialogError e) {
        Log.e(Utilities.tag,e.getMessage());
    }

    @Override
    public void onCancel() {
        Log.e(Utilities.tag, "Cancel");
    }
}
