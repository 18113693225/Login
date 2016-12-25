package com.lj.apps.login.ui.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by LXG on 2016/12/22.
 */

public class LoginApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }
}
