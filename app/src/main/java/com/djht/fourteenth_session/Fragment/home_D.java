package com.djht.fourteenth_session.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import com.djht.fourteenth_session.HJK.air_condition_main_h;
import com.djht.fourteenth_session.R;

public class home_D extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_d, container, false);
        View main_air_conditioning = view.findViewById(R.id.main_air_conditioning);
        main_air_conditioning.setOnClickListener(this);
        return view;
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
                Intent intent_air_condition = new Intent(this.getActivity(), air_condition_main_h.class);
                startActivity(intent_air_condition);
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
