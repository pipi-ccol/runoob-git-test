package com.djht.fourteenth_session.DSQ.Send;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Send_code {

    private static OkHttpClient okHttpClient;

    //构造器私有化
    private Send_code(){}


    //TODO:这里实现数据发送
    public static String Send_message_GET(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


    public static void Send_message_Post(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        //Form表单格式的参数传递
        FormBody formBody = new FormBody
                .Builder()
                .add("username","androidxx.cn")//设置参数名称和参数值
                .build();
        Request request = new Request
                .Builder()
                .post(formBody)//Post请求的参数传递
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //此方法运行在子线程中，不能在此方法中进行UI操作。
                String result = response.body().string();
                Log.d("androixx.cn", result);
                response.body().close();
            }
        });
    }


}
