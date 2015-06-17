package com.support.android.designlibdemo.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;

/**
 * Created by Hill on 15/6/17.
 */
public class DetachableResultReceiver extends ResultReceiver {

    private static final String TAG = "DetachableResultReceiver";
    private Receiver mReceiver;

    public interface Receiver {
        void onReceiveResult(int resultCode, Bundle resultData);
    }

    public void clearReceiver() {
        mReceiver = null;
    }

    public void setReceiver(Receiver receiver) {
        mReceiver = receiver;
    }

    public DetachableResultReceiver(Handler handler) {
        super(handler);
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (mReceiver != null) {
            mReceiver.onReceiveResult(resultCode, resultData);
        } else {
            Log.w(TAG, "Dropping result on floor for code " + resultCode + ": "
                    + resultData.toString());
        }
    }
}
