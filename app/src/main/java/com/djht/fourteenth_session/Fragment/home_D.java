package com.djht.fourteenth_session.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.djht.fourteenth_session.R;

public class home_D extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_d, container, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //灯控制页面跳转
            case R.id.main_light:
                //跳转逻辑
                break;
            case R.id.main_electronic_door_lock:
                break;
            case R.id.main_air_conditioning:
                break;
            case R.id.main_smart_optimization:
                break;
            case R.id.main_more_three:
                break;
            default:
                break;
        }
    }
}
