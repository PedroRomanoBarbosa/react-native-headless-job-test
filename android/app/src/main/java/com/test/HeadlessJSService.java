package com.test;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;

import javax.annotation.Nullable;

public class HeadlessJSService extends HeadlessJSJob {
    private static final int JOB_ID = 1337;

    @Nullable
    @Override
    protected HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        Log.v("HEADLESS JS SERVICE", "ON TASK CONFIG");
        return new HeadlessJsTaskConfig(
                "task",
                Arguments.createMap(),
                5000, // timeout for the task
                false // optional: defines whether or not  the task is allowed in foreground. Default is false
        );
    }

    static void enqueueWork(Context context, Intent work) {
        Log.d("HEADLESS JS JOB", "ENQUEUE WORK");
        enqueueWork(context, HeadlessJSService.class, JOB_ID, work);
    }
}
