package com.lj.apps.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;

import com.lj.apps.login.ui.activity.LoginActivity;


public final class Navigator {

    /**
     * 跳转到登陆页面
     */
    public static void startLoginActivity(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
}
