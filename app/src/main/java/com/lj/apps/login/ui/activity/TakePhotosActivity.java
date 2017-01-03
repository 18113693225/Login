package com.lj.apps.login.ui.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.lj.apps.login.R;
import com.lj.apps.login.ui.widget.ImageRecyclerView;
import com.lj.apps.login.utils.Constant;
import com.lj.apps.login.utils.tool.SampleSnackBar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    @BindView(R.id.saveView)
    RelativeLayout mSaveArea;
    String[] image = {"http://img.51ztzj.com/upload/image/20140401/sj2014040305_279x419.jpg", "http://img.51ztzj.com/upload/image/20140916/sj201409161014_279x419.jpg"
            , "http://img.51ztzj.com/upload/image/20141111/sj201411101025_279x419.jpg", "http://img.51ztzj.com/upload/image/20141225/sj201412251021_279x419.jpg", "http://img2.imgtn.bdimg.com/it/u=1922929249,102637201&fm=23&gp=0.jpg"};
    List<String> Img = new ArrayList<>();
    private Bitmap saveBitmap;
    private int mCutTop;
    private int mCutLeft;
    private int[] mSavePositions = new int[2];

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

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            mSaveArea.getLocationOnScreen(mSavePositions);
            mCutLeft = mSavePositions[0];
            mCutTop = mSavePositions[1];
        }
    }

    @OnClick(R.id.save_bt)
    public void onClick(View view) {
        screenshot();
    }


    @Override
    public void onSubjectItemClick(View v, String data, int position) {
        Glide.with(this).load(data).error(R.mipmap.ic_launcher).into(img);
    }

    private void screenshot() {
        // 获取屏幕
        View dView = getWindow().getDecorView();
        dView.setDrawingCacheEnabled(true);
        dView.buildDrawingCache();
        Bitmap bmp = dView.getDrawingCache();
        if (bmp != null) {
            try {
                //二次截图
                saveBitmap = Bitmap.createBitmap(mSaveArea.getWidth(), mSaveArea.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(saveBitmap);
                Paint paint = new Paint();
                canvas.drawBitmap(bmp, new Rect(mCutLeft, mCutTop, mCutLeft + mSaveArea.getWidth(), mCutTop + mSaveArea.getHeight()),
                        new Rect(0, 0, mSaveArea.getWidth(), mSaveArea.getHeight()), paint);

                File imageDir = new File(Constant.IMAGE_DIR);
                if (!imageDir.exists()) {
                    imageDir.mkdir();
                }
                String imageName = Constant.SCREEN_SHOT;
                File file = new File(imageDir, imageName);
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FileOutputStream os = new FileOutputStream(file);
                saveBitmap.compress(Bitmap.CompressFormat.PNG, 100, os);
                os.flush();
                os.close();

                //将截图保存至相册并广播通知系统刷新
                MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), imageName, null);
                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file));
                sendBroadcast(intent);
                SampleSnackBar.showShortSnackBar(img, "保存成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            SampleSnackBar.showShortSnackBar(img, "保存失败");
        }

    }
}
