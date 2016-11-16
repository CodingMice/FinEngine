package com.ifinver.myopengles;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivGrey;
    private ImageView ivOri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivOri = (ImageView) findViewById(R.id.iv_show_ori);
        ivGrey = (ImageView) findViewById(R.id.iv_show_grey);

        ivOri.setImageResource(R.drawable.t);
        ivOri.setOnClickListener(this);

        ivGrey.setOnClickListener(this);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.t);
        int w = bmp.getWidth();
        int h = bmp.getHeight();
        int[] pixels = new int[w * h];
        bmp.getPixels(pixels, 0, w, 0, 0, w, h);
        //recall JNI
        int[] resultInt = GLNative.getGrayImage(pixels, w, h);
        bmp.recycle();
        if (resultInt != null) {
            Bitmap resultImg = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            resultImg.setPixels(resultInt, 0, w, 0, 0, w, h);

            ivGrey.setImageBitmap(resultImg);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_show_ori:
                startActivity(new Intent(this,CameraActivity.class));
                break;
            case R.id.iv_show_grey:
                startActivity(new Intent(this,OpenGLActivity.class));
                break;
        }
    }
}