package com.sprintsolutions.yummy.fragments;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.sprintsolutions.yummy.R;

public class TickFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View tickFragment = inflater.inflate(R.layout.fragment_tick, container, false);

        ImageView imgJugaat = (ImageView)tickFragment.findViewById(R.id.imgJugaat);

        imgJugaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialogue_with_more_bottom_items);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                dialog.setCancelable(false);

                ImageView imgBack = (ImageView)dialog.findViewById(R.id.imgBack);
                imgBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });

        return tickFragment;
    }
}