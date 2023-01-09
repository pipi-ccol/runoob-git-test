package com.djht.fourteenth_session.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 梅 on 2022/5/17.
 */

public class Get_image_D {
    private static final int CHANGE_UI=1;

    /**
     * 构造器私有化
     */
    private Get_image_D(){

    }

    /**
     * 连接网络获取图片，适配全屏
     * @param screenWidth 屏幕宽度
     * @param screenHeight 屏幕长度
     * @param handler 网络连接获取图片的处理线程
     * @param imageUrl 图片地址
     */
    public static void getImage(final int screenWidth, final int screenHeight, final Handler handler , final String imageUrl){

        new Thread(){
            @Override
            public void run() {
                try {
                    URL url=new URL(imageUrl);
                    HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    //服务器返回
                    int code=connection.getResponseCode();
                    if(code==200){
                        InputStream is=connection.getInputStream();
                        Bitmap bitmap= BitmapFactory.decodeStream(is);
                        bitmap= Image_chage_D.zoomImg(bitmap,screenWidth,screenHeight);
                        Message msg=new Message();
                        msg.obj=bitmap;
                        msg.what=CHANGE_UI;
                        handler.sendMessage(msg);
                        //start.setImageBitmap(bit);
                    }else{
                        //Toast.makeText(MainActivity.this,"获取失败！！！",Toast.LENGTH_SHORT);
                    }
                } catch (Exception e) {
                    //Toast.makeText(MainActivity.this,"连接失败！！！",Toast.LENGTH_SHORT);
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
