package com.sprintsolutions.yummy.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;
import com.sprintsolutions.yummy.R;
import com.sprintsolutions.yummy.fragments.CrossFragment;
import com.sprintsolutions.yummy.fragments.HomeFragment;
import com.sprintsolutions.yummy.fragments.TickFragment;

public class FragmentContainerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    View headerLayout;
    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);


        ImageView set_Icon = (ImageView)findViewById(R.id.set_Icon);
        ImageView price_Icon = (ImageView)findViewById(R.id.price_Icon);
        final View view_cross = (View)findViewById(R.id.view_cross);
        final View view_order = (View)findViewById(R.id.view_order);
        final View view_tick = (View)findViewById(R.id.view_tick);
        RelativeLayout relTick = (RelativeLayout)findViewById(R.id.relTick);

        RelativeLayout relOrder = (RelativeLayout)findViewById(R.id.relOrder);
        RelativeLayout relCross = (RelativeLayout)findViewById(R.id.relCross);
        RelativeLayout relPickedDriver = (RelativeLayout)findViewById(R.id.relPickedDriver);


        view_cross.setVisibility(View.GONE);
        view_order.setVisibility(View.VISIBLE);
        view_tick.setVisibility(View.GONE);

        final Fragment menuPractiseFragment=new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                menuPractiseFragment,menuPractiseFragment.getClass().getSimpleName())
                .commit();

        mDrawerLayout=(DrawerLayout)findViewById(R.id.activity_main);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();


        relOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_cross.setVisibility(View.GONE);
                view_tick.setVisibility(View.GONE);
                view_order.setVisibility(View.VISIBLE);
                Fragment menuPractiseFragment=new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        menuPractiseFragment,menuPractiseFragment.getClass().getSimpleName())
                        .commit();

            }
        });

        relCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_order.setVisibility(View.GONE);
                view_cross.setVisibility(View.VISIBLE);
                view_tick.setVisibility(View.GONE);
                Fragment menuPractiseFragment=new CrossFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        menuPractiseFragment,menuPractiseFragment.getClass().getSimpleName())
                        .commit();

            }
        });

        relTick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_order.setVisibility(View.GONE);
                view_cross.setVisibility(View.GONE);
                view_tick.setVisibility(View.VISIBLE);
                Fragment menuPractiseFragment=new TickFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                        menuPractiseFragment,menuPractiseFragment.getClass().getSimpleName())
                        .commit();

            }
        });


        price_Icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final Dialog dialog = new Dialog(FragmentContainerActivity.this);
                dialog.setContentView(R.layout.dialogue_calculator);
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


        relPickedDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(FragmentContainerActivity.this);
                dialog.setContentView(R.layout.dialogue_about_the_order_with_map);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                dialog.setCancelable(false);

                mMapView = (MapView) dialog.findViewById(R.id.map11);
                mMapView.onCreate(savedInstanceState);
                mMapView.onResume(); // needed to get the map to display immediately

                try {
                    MapsInitializer.initialize(FragmentContainerActivity.this.getApplicationContext());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mMapView.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap mMap) {

                        googleMap = mMap;
                        LatLng sydney = new LatLng(32.1877,74.1945);
                        googleMap.addMarker(new MarkerOptions().position(sydney).title("Gujranwala").snippet("Marker Description"));
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                    }
                });


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



//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.navvv);
        headerLayout = navigationView.inflateHeaderView(R.layout.header);

        set_Icon.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {

                DrawerLayout navDrawer = findViewById(R.id.activity_main);
                if(!navDrawer.isDrawerOpen(Gravity.START)) navDrawer.openDrawer(Gravity.START);
                else navDrawer.closeDrawer(Gravity.END);

            }
        });


//        getSupportActionBar().hide();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}