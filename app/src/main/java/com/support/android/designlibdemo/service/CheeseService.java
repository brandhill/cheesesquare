package com.support.android.designlibdemo.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

import com.support.android.designlibdemo.utils.DetachableResultReceiver;


public class CheeseService extends IntentService {

    private static final String TAG = CheeseService.class.getSimpleName();

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.support.android.designlibdemo.service.action.FOO";
    private static final String ACTION_BAZ = "com.support.android.designlibdemo.service.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.support.android.designlibdemo.service.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.support.android.designlibdemo.service.extra.PARAM2";
    private static final String EXTRA_PARAM_RECEIVER = "com.support.android.designlibdemo.service.extra.PARAM2";

    public static final String EXTRA_PARAM = "extra_param";
    public static final int STATUS_RUNNING = 0x1;
    public static final int STATUS_ERROR = 0x2;
    public static final int STATUS_FINISHED = 0x3;
    public static final int STATUS_SYNCING = 0x4;
    public static final int STATUS_SYNC_ERROR = 0x5;


    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2, DetachableResultReceiver receiver) {
        Intent intent = new Intent(context, CheeseService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        intent.putExtra(EXTRA_PARAM_RECEIVER, receiver);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2, DetachableResultReceiver receiver) {
        Intent intent = new Intent(context, CheeseService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        intent.putExtra(EXTRA_PARAM_RECEIVER, receiver);
        context.startService(intent);
    }

    public CheeseService() {
        super("BackgroundService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            final ResultReceiver receiver = intent.getParcelableExtra(EXTRA_PARAM_RECEIVER);
            final Bundle b = new Bundle();

            if (ACTION_FOO.equals(action)) {

                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);


                receiver.send(STATUS_RUNNING, Bundle.EMPTY);
                handleActionFoo(param1, param2);
                b.putString(EXTRA_PARAM, "foo");

                receiver.send(STATUS_FINISHED, b);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);

                receiver.send(STATUS_RUNNING, Bundle.EMPTY);
                handleActionBaz(param1, param2);

                b.putString(EXTRA_PARAM, "baz");
                receiver.send(STATUS_FINISHED, b);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        Log.d(TAG, "handleActionFoo");

        //throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        Log.d(TAG, "handleActionBaz");
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
