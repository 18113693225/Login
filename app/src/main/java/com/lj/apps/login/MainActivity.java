package com.lj.apps.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    ImageView m1, m2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();


    }

    private void init() {
        e1 = (EditText) findViewById(R.id.phone_number);
        e2 = (EditText) findViewById(R.id.password);
        m1 = (ImageView) findViewById(R.id.del_phone_number);
        m2 = (ImageView) findViewById(R.id.del_password);
        EditTextClearTools.addClearListener(e1, m1);
        EditTextClearTools.addClearListener(e2, m2);

    }
}
