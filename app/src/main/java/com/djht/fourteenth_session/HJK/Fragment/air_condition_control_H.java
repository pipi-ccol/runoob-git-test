package com.djht.fourteenth_session.HJK.Fragment;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.djht.fourteenth_session.R;

public class air_condition_control_H extends Fragment implements View.OnClickListener{
    static int on_off_state = 0;//默认未开机，以后可以传参进来初始化
    View snow_btn;
    View on_off_btn;
    View heat_btn;
    View air_improve_btn;
    Button drop_temperature_btn;
    Button add_temperature_btn;
    TextView text_temperature;
    View hight_wind_btn;
    View mid_wind_btn;
    View low_wind_btn;
    View back_ground;
    View back_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.air_condition_control__h, container, false);
        on_off_btn = view.findViewById(R.id.on_off_btn);
        snow_btn = view.findViewById(R.id.snow_btn);
        heat_btn = view.findViewById(R.id.heat_btn);
        air_improve_btn = view.findViewById(R.id.air_improve_btn);
        drop_temperature_btn = view.findViewById(R.id.drop_temperature_btn);
        add_temperature_btn = view.findViewById(R.id.add_temperature);
        text_temperature = view.findViewById(R.id.temperature);
        hight_wind_btn = view.findViewById(R.id.hight_wind);
        mid_wind_btn = view.findViewById(R.id.mid_wind);
        back_ground = view.findViewById(R.id.back_groud);
        low_wind_btn = view.findViewById(R.id.low_wind_btn);
        back_btn = view.findViewById(R.id.back_btn);
        on_off_btn.setOnClickListener(this);
        add_temperature_btn.setOnClickListener(this);
        drop_temperature_btn.setOnClickListener(this);
        back_btn.setOnClickListener(this);
        //默认未开机，开机键设置为黑色
        GradientDrawable drawable =(GradientDrawable)on_off_btn.getBackground();
        int off_color = Color.rgb(0,0,0);
        drawable.setColor(off_color);

        snow_btn.setVisibility(View.INVISIBLE);
        heat_btn.setVisibility(View.INVISIBLE);
        air_improve_btn.setVisibility(View.INVISIBLE);
        drop_temperature_btn.setVisibility(View.INVISIBLE);
        add_temperature_btn.setVisibility(View.INVISIBLE);
        hight_wind_btn.setVisibility(View.INVISIBLE);
        mid_wind_btn.setVisibility(View.INVISIBLE);
        low_wind_btn.setVisibility(View.INVISIBLE);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //灯控制页面跳转
            case R.id.drop_temperature_btn:
                //跳转逻辑
                changeTemperature(0);
                break;
            case R.id.add_temperature:
                changeTemperature(1);
                break;
            case R.id.on_off_btn:
                changeState(view);
                break;
            case R.id.back_btn:
                getActivity().finish();
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param state
     * 用来增加、减少温度示数
     * 0代表减少，1代表增加
     */
    public void changeTemperature(int state){
        int tem = Integer.parseInt((String)text_temperature.getText());
        if(state==0&&tem>16){
            tem--;
            text_temperature.setText(String.valueOf(tem));
        }else if(state==1&&tem<30){
            tem++;
            text_temperature.setText(String.valueOf(tem));
        }
    }

    /**
     * 关机与开机
     * on_off_state=0表示关机，1表示开机
     * @param view
     */
    public void changeState(View view){
        GradientDrawable drawable =(GradientDrawable)on_off_btn.getBackground();
        if(on_off_state==0){
            on_off_state = 1;
            int on_color = Color.rgb(70,157,99);
            int on_back_color = Color.rgb(223,223,225);
            drawable.setColor(on_color);
            drawable.setColor(on_color);
            back_ground.setBackgroundColor(on_back_color);
            snow_btn.setVisibility(View.VISIBLE);
            heat_btn.setVisibility(View.VISIBLE);
            air_improve_btn.setVisibility(View.VISIBLE);
            drop_temperature_btn.setVisibility(View.VISIBLE);
            add_temperature_btn.setVisibility(View.VISIBLE);
            hight_wind_btn.setVisibility(View.VISIBLE);
            mid_wind_btn.setVisibility(View.VISIBLE);
            low_wind_btn.setVisibility(View.VISIBLE);
        }else if(on_off_state==1){
            on_off_state = 0;
            int off_color = Color.rgb(0,0,0);
            drawable.setColor(off_color);
            int back_off_color = Color.rgb(204,207,217);
            back_ground.setBackgroundColor(back_off_color);
            snow_btn.setVisibility(View.INVISIBLE);
            heat_btn.setVisibility(View.INVISIBLE);
            air_improve_btn.setVisibility(View.INVISIBLE);
            drop_temperature_btn.setVisibility(View.INVISIBLE);
            add_temperature_btn.setVisibility(View.INVISIBLE);
            hight_wind_btn.setVisibility(View.INVISIBLE);
            mid_wind_btn.setVisibility(View.INVISIBLE);
            low_wind_btn.setVisibility(View.INVISIBLE);
        }
    }
}