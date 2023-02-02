package com.djht.fourteenth_session.HJK.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.djht.fourteenth_session.HJK.airRecyclerViewAdapter;
import com.djht.fourteenth_session.HJK.air_condition_main_h;
import com.djht.fourteenth_session.HJK.itemModel_h;
import com.djht.fourteenth_session.R;

import java.util.ArrayList;


public class air_condition_list_H extends Fragment implements View.OnClickListener,airRecyclerViewAdapter.ItemClickListener{
    RecyclerView recyclerView;
    private View view;
    private ArrayList<itemModel_h> itemList = new ArrayList<>();
    private airRecyclerViewAdapter airRecyclerViewAdapter;
    private ImageView back_btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.air_condition_list__h, container, false);
        airRecyclerViewAdapter = new airRecyclerViewAdapter(this);
        initRecyclerView();
        initData();
        initBtn();
        return view;
    }


    public void initBtn(){
        back_btn = view.findViewById(R.id.air_list_back_btn);
        back_btn.setOnClickListener(this);
    }

    /**
     * 初始化recyclerView
     */
    private void initRecyclerView(){
        recyclerView = view.findViewById(R.id.air_item_recylerView);
        airRecyclerViewAdapter = new airRecyclerViewAdapter(getActivity(),itemList);
        recyclerView.setAdapter(airRecyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity() ,2));
    }

    /**
     * 生成模拟数据
     * 但是有bug：每次从control回退时会新增两个数据
     */
    private void initData(){
        for(int i = 0;i<2;i++){
            itemModel_h itemModel = new itemModel_h();
            itemModel.setAirName("小米空调");
            itemModel.setRoomName("客厅");
            itemList.add(itemModel);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.air_list_back_btn:
                getActivity().finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClicked(int itemId) {
        System.out.println(itemId);
        NavController navController = Navigation.findNavController(view);
        Bundle bundle = new Bundle();
        bundle.putString("num", String.valueOf(itemId));
        navController.navigate(R.id.action_air_condition_list_H_to_air_condition_control_H,bundle);
    }
}