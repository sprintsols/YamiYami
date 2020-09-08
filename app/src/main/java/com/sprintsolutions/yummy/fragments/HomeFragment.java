package com.sprintsolutions.yummy.fragments;


import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sprintsolutions.yummy.R;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homeFragment = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView imgJugaat = (ImageView)homeFragment.findViewById(R.id.imgJugaat);

        imgJugaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialogue_delivery_time);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                dialog.setCancelable(false);

                ImageView imgBack = (ImageView)dialog.findViewById(R.id.imgBack);
                LinearLayout lin1 = (LinearLayout)dialog.findViewById(R.id.lin1);
                LinearLayout lin2 = (LinearLayout)dialog.findViewById(R.id.lin2);
                LinearLayout lin3 = (LinearLayout)dialog.findViewById(R.id.lin3);
                LinearLayout lin4 = (LinearLayout)dialog.findViewById(R.id.lin4);
                LinearLayout lin5 = (LinearLayout)dialog.findViewById(R.id.lin5);
                LinearLayout lin6 = (LinearLayout)dialog.findViewById(R.id.lin6);


                lin1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();
                        final Dialog dialog2 = new Dialog(getContext());
                        dialog2.setContentView(R.layout.dialogue_cooking_start);
                        dialog2.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                        dialog2.setCancelable(false);

                        ImageView imgBack2 = (ImageView)dialog2.findViewById(R.id.imgBack);
                        LinearLayout linc1 = (LinearLayout)dialog2.findViewById(R.id.linc1);
                        LinearLayout linc2 = (LinearLayout)dialog2.findViewById(R.id.linc2);
                        imgBack2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                dialog2.dismiss();

                            }
                        });


                        linc1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                dialog2.dismiss();
                                final Dialog dialog3 = new Dialog(getContext());
                                dialog3.setContentView(R.layout.dialogue_order_detail);
                                dialog3.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                                dialog3.setCancelable(false);


                                ImageView imgBack3 = (ImageView)dialog3.findViewById(R.id.imgBack);


                                imgBack3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        dialog3.dismiss();

                                    }
                                });

                                dialog3.show();

                            }
                        });



                        dialog2.show();
                    }
                });


                imgBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();

                    }
                });

                dialog.show();

            }
        });




        return homeFragment;
    }
}