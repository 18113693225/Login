package com.lj.apps.login.ui.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by SEELE on 2016-11-04.
 */

public class EditTextClearTools {

    public static void addClearListener(final EditText e1, final ImageView m1) {
        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String s1 = s + "";
                if (s.length() > 0) {
                    m1.setVisibility(View.VISIBLE);
                } else {
                    m1.setVisibility(View.INVISIBLE);
                }
            }
        });
        m1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                e1.setText("");
            }
        });

    }
}
