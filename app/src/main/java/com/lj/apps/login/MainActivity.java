package com.lj.apps.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import me.zhanghai.android.materialprogressbar.IndeterminateProgressDrawable;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    ImageView m1, m2;

    ProgressBar indeterminateProgressLarge;
    ProgressBar indeterminateProgress;
    ProgressBar indeterminateProgressSmall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
//        indeterminateProgressLarge = (ProgressBar) findViewById(R.id.indeterminate_progress_large_library);
//
//        indeterminateProgress = (ProgressBar) findViewById(R.id.indeterminate_progress_library);
//
//        indeterminateProgressSmall = (ProgressBar) findViewById(R.id.indeterminate_progress_small_library);
//
//        indeterminateProgressLarge.setIndeterminateDrawable(
//                new IndeterminateProgressDrawable(this));
//        indeterminateProgress.setIndeterminateDrawable(new IndeterminateProgressDrawable(this));
//        indeterminateProgressSmall.setIndeterminateDrawable(
//                new IndeterminateProgressDrawable(this));

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
