package com.lj.apps.login.ui.activity;


import android.os.Bundle;
import android.view.View;

import com.lj.apps.login.Navigator;
import com.lj.apps.login.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.loginButton, R.id.takePhotoButton, R.id.rxJavaButton})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginButton:
                Navigator.startLoginActivity(this);
                break;
            case R.id.takePhotoButton:
                Navigator.startTakePhotoActivity(this);
                break;
            case R.id.rxJavaButton:
                Navigator.startRxJavaActivity(this);
                break;
            default:
                break;
        }
    }

}
