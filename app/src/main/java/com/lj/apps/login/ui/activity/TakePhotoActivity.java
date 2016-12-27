package com.lj.apps.login.ui.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lj.apps.login.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TakePhotoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.save_bt)
    public void onClick(View view) {
        
    }
}
