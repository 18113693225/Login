package com.lj.apps.login.ui.app;

import android.app.Application;

import com.lj.apps.login.BuildConfig;
import com.lj.apps.login.utils.utils.RetrofitBuilder;
import com.squareup.leakcanary.LeakCanary;


public class LoginApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //配置RetrofitBuilder
        new RetrofitBuilder.Builder().build();
        //leak
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

    }
}
