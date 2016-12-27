package com.lj.apps.login.ui.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lj.apps.login.R;
import com.lj.apps.login.ui.widget.ImageRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TakePhotosActivity extends BaseActivity implements ImageRecyclerView.OnItemClickListener {

    @BindView(R.id.img_rv)
    ImageRecyclerView img_rv;
    @BindView(R.id.img)
    ImageView img;
    String[] image = {"http://img.51ztzj.com/upload/image/20140401/sj2014040305_279x419.jpg", "http://img.51ztzj.com/upload/image/20140916/sj201409161014_279x419.jpg"
            , "http://img.51ztzj.com/upload/image/20141111/sj201411101025_279x419.jpg", "http://img.51ztzj.com/upload/image/20141225/sj201412251021_279x419.jpg", "http://img2.imgtn.bdimg.com/it/u=1922929249,102637201&fm=23&gp=0.jpg"};
    List<String> Img = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        Glide.with(this).load(image[0]).error(R.mipmap.ic_launcher).into(img);
        for (int i = 0; i < image.length; i++) {
            Img.add(image[i]);
        }
        img_rv.setData(Img, this);
    }

    @OnClick(R.id.save_bt)
    public void onClick(View view) {

    }


    @Override
    public void onSubjectItemClick(View v, String data, int position) {
        Glide.with(this).load(data).error(R.mipmap.ic_launcher).into(img);
    }
}
