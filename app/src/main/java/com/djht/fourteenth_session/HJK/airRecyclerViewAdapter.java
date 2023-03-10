package com.djht.fourteenth_session.HJK;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.djht.fourteenth_session.Fragment.home_D;
import com.djht.fourteenth_session.HJK.Fragment.air_condition_control_H;
import com.djht.fourteenth_session.R;

import java.util.ArrayList;

public class airRecyclerViewAdapter extends RecyclerView.Adapter<airRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<itemModel_h> itemList;
    private static ItemClickListener mListener;
    public interface ItemClickListener {
        void onItemClicked(int itemId);
    }
    public airRecyclerViewAdapter(Context context, ArrayList<itemModel_h> itemList){
        this.context = context;
        this.itemList = itemList;
    }
    /**
     * 回调函数，在adpter与fragment之间进行传参
     * @param listener
     */
    public airRecyclerViewAdapter(ItemClickListener listener) {
        this.mListener = listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.air_condition_item_h,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        itemModel_h data = itemList.get(position);
        holder.airName.setText(data.getAirName());
        holder.roomName.setText(data.getRoomName());
        int id = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClicked(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView airName;
        private TextView roomName;
        ImageView on_off_btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            airName = itemView.findViewById(R.id.air_condition_item_name);
            roomName = itemView.findViewById(R.id.air_room_name);
        }
    }
}
