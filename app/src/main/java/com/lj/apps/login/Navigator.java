package com.lj.apps.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;

import com.lj.apps.login.ui.activity.LoginActivity;
import com.lj.apps.login.ui.activity.TakePhotoActivity;


public final class Navigator {

    /**
     * 跳转到登陆页面
     */
    public static void startLoginActivity(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    /**
     * 跳转到图片裁剪页面
     */
    public static void startTakePhotoActivity(Activity activity) {
        Intent intent = new Intent(activity, TakePhotoActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
}
