package com.djht.fourteenth_session;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.djht.fourteenth_session.DSQ.Fragment.Bedroom;
import com.djht.fourteenth_session.DSQ.Fragment.Kitchen;
import com.djht.fourteenth_session.DSQ.Fragment.Other_zone;
import com.djht.fourteenth_session.DSQ.Fragment.Sitting_room;
import com.djht.fourteenth_session.Fragment.home_D;
import com.djht.fourteenth_session.Fragment.setting_D;

public class light_setting extends AppCompatActivity {

    private String pageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_setting);

        initView();

    }

    private void initView() {
        Intent intent=getIntent();
        pageName=intent.getStringExtra("page");
        System.out.println(pageName);
        select_Fragment(pageName);
    }

    /**
     * 界面切换函数
     * @param page
     */
    private void select_Fragment(String page){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        switch (page){
            case "light_sitting_room":
                //getSupportActionBar().show();
                //main_panel_top.setVisibility(View.GONE);
                //main_top_title.setText(R.string.app_name);
                Sitting_room sitting_room=new Sitting_room();
                transaction.replace(R.id.light_setting_fragment,sitting_room);
                //home_icon.setImageResource(R.mipmap.home_block);
                break;
            case "light_bedroom":
                Bedroom bedroom=new Bedroom();
                transaction.replace(R.id.light_setting_fragment,bedroom);
                break;
            case "light_kitchen":
                Kitchen kitchen=new Kitchen();
                transaction.replace(R.id.light_setting_fragment,kitchen);
                break;
            case "light_other_zone":
                Other_zone other_zone=new Other_zone();
                transaction.replace(R.id.light_setting_fragment,other_zone);
                break;
            default:
                break;
        }
        transaction.commit();
    }


}