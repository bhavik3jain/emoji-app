package com.imoody.activity;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.net.LinkAddress;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imoody.R;

import java.util.ArrayList;

public class CustomFragment extends Fragment implements View.OnClickListener{

    ArrayList<Integer> drawable = new ArrayList<>();
    ArrayList<String> moods = new ArrayList<>();
    View rootView;

    public CustomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_custom, container, false);
        moods = emotion_name();
        drawable = emotion_id();
        if(moods.size() > 0){
            for(int i = moods.size(); i < 5; i++){
                moods.add("");
                drawable.add(R.color.windowBackground);
            }
        }
        else{
            moods = new ArrayList<>();
            drawable = new ArrayList<>();
            for(int i = 0; i < 5; i++){
                moods.add("");
                drawable.add(R.color.windowBackground);
            }
        }

        RelativeLayout relLayout1 = (RelativeLayout) rootView.findViewById(R.id.relLayout1);
        RelativeLayout relLayout2 = (RelativeLayout) rootView.findViewById(R.id.relLayout2);
        RelativeLayout relLayout3 = (RelativeLayout) rootView.findViewById(R.id.relLayout3);
        RelativeLayout relLayout4 = (RelativeLayout) rootView.findViewById(R.id.relLayout4);
        RelativeLayout relLayout5 = (RelativeLayout) rootView.findViewById(R.id.relLayout5);

        if(!moods.get(0).equals("")){
            relLayout1.setVisibility(View.VISIBLE);
        }
        if(!moods.get(1).equals("")){
            relLayout2.setVisibility(View.VISIBLE);
        }
        if(!moods.get(2).equals("")){
            relLayout3.setVisibility(View.VISIBLE);
        }
        if(!moods.get(3).equals("")){
            relLayout4.setVisibility(View.VISIBLE);
        }
        if(!moods.get(4).equals("")){
            relLayout5.setVisibility(View.VISIBLE);
        }

        ImageView im1 = (ImageView) rootView.findViewById(R.id.emoji1);
        im1.setImageResource(drawable.get(0));
        ImageView im2 = (ImageView) rootView.findViewById(R.id.emoji2);
        im2.setImageResource(drawable.get(1));
        ImageView im3 = (ImageView) rootView.findViewById(R.id.emoji3);
        im3.setImageResource(drawable.get(2));
        ImageView im4 = (ImageView) rootView.findViewById(R.id.emoji4);
        im4.setImageResource(drawable.get(3));
        ImageView im5 = (ImageView) rootView.findViewById(R.id.emoji5);
        im5.setImageResource(drawable.get(4));
        TextView tv1 = (TextView) rootView.findViewById(R.id.emoji1T);
        tv1.setText(moods.get(0));
        TextView tv2 = (TextView) rootView.findViewById(R.id.emoji2T);
        tv2.setText(moods.get(1));
        TextView tv3 = (TextView) rootView.findViewById(R.id.emoji3T);
        tv3.setText(moods.get(2));
        TextView tv4 = (TextView) rootView.findViewById(R.id.emoji4T);
        tv4.setText(moods.get(3));
        TextView tv5 = (TextView) rootView.findViewById(R.id.emoji5T);
        tv5.setText(moods.get(4));

        FloatingActionButton fab1 = (FloatingActionButton) rootView.findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootView, "Maximum Custom Events Created!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        FloatingActionButton fab2 = (FloatingActionButton) rootView.findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootView, "Maximum Custom Events Created!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        FloatingActionButton fab3 = (FloatingActionButton) rootView.findViewById(R.id.fab3);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootView, "Maximum Custom Events Created!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        FloatingActionButton fab4 = (FloatingActionButton) rootView.findViewById(R.id.fab4);
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootView, "Maximum Custom Events Created!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        FloatingActionButton fab5 = (FloatingActionButton) rootView.findViewById(R.id.fab5);
        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootView, "Maximum Custom Events Created!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(this);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void onClick(View rootView){
        switch(rootView.getId()){
            case R.id.fab:
                makeCustomClear();
                if(countCustom() == 5){
                    Snackbar.make(rootView, "Maximum Custom Events Created!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else{
                    displayView(7);
                }
                break;
        }
    }

    private void displayView(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new LogFragment();
                break;
            case 2:
                fragment = new GraphsFragment();
                break;
            case 3:
                fragment = new ProfileFragment();
                break;
            case 4:
                fragment = new SettingsFragment();
                break;
            case 5:
                fragment = new StartFragment();
                break;
            case 6:
                fragment = new NameFragment();
                break;
            case 7:
                fragment = new MakeCustomEmotionFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.container_body, fragment).addToBackStack(null).commit();
        }
    }

    private ArrayList<String> emotion_name(){
        ArrayList<String> arr = new ArrayList<>();
        final String TABLE_NAME = "emotion_custom";
        String selectQuery = "SELECT emotion_name FROM " + TABLE_NAME;
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                arr.add(cursor.getString(cursor.getColumnIndex("emotion_name")));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return arr;
    }

    private ArrayList<Integer> emotion_id(){
        ArrayList<Integer> arr = new ArrayList<>();
        final String TABLE_NAME = "emotion_custom";
        String selectQuery = "SELECT emotion_id FROM " + TABLE_NAME;
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                arr.add(cursor.getInt(cursor.getColumnIndex("emotion_id")));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return arr;
    }

    private int countCustom(){
        int total = 0;

        final String TABLE_NAME = "emotion_custom";
        String selectQuery = "SELECT count(*) as counter FROM " + TABLE_NAME;
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        cursor.moveToFirst();

        total = Integer.valueOf(cursor.getInt(cursor.getColumnIndex("counter")));

        cursor.close();
        System.out.println(total);

        return total;
    }

    public void makeCustomClear(){
        MainActivity.drawable = -1;
        MainActivity.customName = "Custom Event";
        MainActivity.setCheckedCustom = "";
    }
}
