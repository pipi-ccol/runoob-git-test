package com.djht.fourteenth_session.HJK.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.djht.fourteenth_session.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link air_condition_control_H#newInstance} factory method to
 * create an instance of this fragment.
 */
public class air_condition_control_H extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public air_condition_control_H() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment air_condition_control_H.
     */
    // TODO: Rename and change types and number of parameters
    public static air_condition_control_H newInstance(String param1, String param2) {
        air_condition_control_H fragment = new air_condition_control_H();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.air_condition_control__h, container, false);
        View on_off_btn = view.findViewById(R.id.on_off_btn);
        View snow_btn = view.findViewById(R.id.snow_btn);
        View heat_btn = view.findViewById(R.id.heat_btn);
        View air_improve_btn = view.findViewById(R.id.air_improve_btn);
        on_off_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}