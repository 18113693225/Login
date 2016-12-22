package com.lj.apps.login.ui.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.lj.apps.login.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LXG on 2016/12/22.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.phone_number)
    EditText e1;
    @BindView(R.id.password)
    EditText e2;
    @BindView(R.id.del_phone_number)
    ImageView m1;
    @BindView(R.id.del_password)
    ImageView m2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        EditTextClearTools.addClearListener(e1, m1);
        EditTextClearTools.addClearListener(e2, m2);
    }

}
