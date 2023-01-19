package com.djht.fourteenth_session.DSQ;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.djht.fourteenth_session.R;
import com.djht.fourteenth_session.Utils.Image_chage_D;

import java.io.InputStream;

public class light extends AppCompatActivity implements View.OnClickListener{

    private ImageView light_back;
    private ImageView light_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        initView();
    }

    /**
     * 制作顶部导航栏
     * @param hasFocus
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().setStatusBarColor(Color.parseColor("#5DE6D6"));
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.light_action_bar);
            Resources resources = light.this.getResources();
            Drawable drawable = resources.getDrawable(R.drawable.light_action_bar);
            actionBar.setBackgroundDrawable(drawable);

            ImageView light_back= (ImageView) findViewById(R.id.light_back);
            light_back.setOnClickListener(this);
            ImageView light_add= (ImageView) findViewById(R.id.light_add);
            light_add.setOnClickListener(this);
            //返回图标设置
            Resources r = this.getResources();
            @SuppressLint("ResourceType") InputStream is = r.openRawResource(R.mipmap.light_back);
            BitmapDrawable bmpview = new BitmapDrawable(is);
            Bitmap bmp = Image_chage_D.createCircleImage(Image_chage_D.zoomImg(bmpview.getBitmap(),40,40));
            light_back.setImageBitmap(bmp);
            Resources r1 = this.getResources();
            //添加图标设置
            @SuppressLint("ResourceType") InputStream is1 = r1.openRawResource(R.mipmap.light_add);
            BitmapDrawable bmpview1 = new BitmapDrawable(is1);
            Bitmap bmp1 = Image_chage_D.createCircleImage(Image_chage_D.zoomImg(bmpview1.getBitmap(),40,40));
            light_add.setImageBitmap(bmp1);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.light_back:
                this.finish();
                break;
            case R.id.light_add:
                break;
            default:
                break;
        }
    }

    private void initView() {

    }
}