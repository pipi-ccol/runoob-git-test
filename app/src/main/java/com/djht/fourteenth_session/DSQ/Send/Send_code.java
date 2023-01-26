package com.djht.fourteenth_session.DSQ.Send;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Send_code {

    private static OkHttpClient okHttpClient;

    //构造器私有化
    private Send_code(){}

    private static Callback callback=new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {

        }
    };

    public static boolean Send_message_GET(){
        okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.1.170:8088/okhttp/test_simple_get.php")
                .build();
        okHttpClient.newCall(request).enqueue(callback);

        return true;
    }


}
