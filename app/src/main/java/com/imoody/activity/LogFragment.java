package com.imoody.activity;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import com.imoody.R;

public class LogFragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private ArrayList<Integer> a;
    private SeekBar s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15;
    private TextView s1T, s2T, s3T, s4T, s5T, s6T, s7T, s8T, s9T, s10T, s11T, s12T, s13T, s14T, s15T;
    private View rootView;
    private int s1Val, s2Val, s3Val, s4Val, s5Val, s6Val, s7Val, s8Val, s9Val, s10Val, s11Val, s12Val, s13Val, s14Val, s15Val;

    ArrayList<Integer> drawable = new ArrayList<>();
    ArrayList<String> moods = new ArrayList<>();

    public LogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_log, container, false);
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

        ImageView im1 = (ImageView) rootView.findViewById(R.id.emoji11);
        im1.setImageResource(drawable.get(0));
        ImageView im2 = (ImageView) rootView.findViewById(R.id.emoji12);
        im2.setImageResource(drawable.get(1));
        ImageView im3 = (ImageView) rootView.findViewById(R.id.emoji13);
        im3.setImageResource(drawable.get(2));
        ImageView im4 = (ImageView) rootView.findViewById(R.id.emoji14);
        im4.setImageResource(drawable.get(3));
        ImageView im5 = (ImageView) rootView.findViewById(R.id.emoji15);
        im5.setImageResource(drawable.get(4));

        RelativeLayout relLayout1 = (RelativeLayout) rootView.findViewById(R.id.relLayout1);
        RelativeLayout relLayout2 = (RelativeLayout) rootView.findViewById(R.id.relLayout2);
        RelativeLayout relLayout3 = (RelativeLayout) rootView.findViewById(R.id.relLayout3);
        RelativeLayout relLayout4 = (RelativeLayout) rootView.findViewById(R.id.relLayout4);
        RelativeLayout relLayout5 = (RelativeLayout) rootView.findViewById(R.id.relLayout5);
        RelativeLayout relLayout6 = (RelativeLayout) rootView.findViewById(R.id.relLayout6);
        RelativeLayout relLayout7 = (RelativeLayout) rootView.findViewById(R.id.relLayout7);
        RelativeLayout relLayout8 = (RelativeLayout) rootView.findViewById(R.id.relLayout8);
        RelativeLayout relLayout9 = (RelativeLayout) rootView.findViewById(R.id.relLayout9);
        RelativeLayout relLayout10 = (RelativeLayout) rootView.findViewById(R.id.relLayout10);
        RelativeLayout relLayout11 = (RelativeLayout) rootView.findViewById(R.id.relLayout11);
        RelativeLayout relLayout12 = (RelativeLayout) rootView.findViewById(R.id.relLayout12);
        RelativeLayout relLayout13 = (RelativeLayout) rootView.findViewById(R.id.relLayout13);
        RelativeLayout relLayout14 = (RelativeLayout) rootView.findViewById(R.id.relLayout14);
        RelativeLayout relLayout15 = (RelativeLayout) rootView.findViewById(R.id.relLayout15);

        s1T = (TextView) rootView.findViewById(R.id.seek1Text);
        s2T = (TextView) rootView.findViewById(R.id.seek2Text);
        s3T = (TextView) rootView.findViewById(R.id.seek3Text);
        s4T = (TextView) rootView.findViewById(R.id.seek4Text);
        s5T = (TextView) rootView.findViewById(R.id.seek5Text);
        s6T = (TextView) rootView.findViewById(R.id.seek6Text);
        s7T = (TextView) rootView.findViewById(R.id.seek7Text);
        s8T = (TextView) rootView.findViewById(R.id.seek8Text);
        s9T = (TextView) rootView.findViewById(R.id.seek9Text);
        s10T = (TextView) rootView.findViewById(R.id.seek10Text);
        s11T = (TextView) rootView.findViewById(R.id.seek11Text);
        s12T = (TextView) rootView.findViewById(R.id.seek12Text);
        s13T = (TextView) rootView.findViewById(R.id.seek13Text);
        s14T = (TextView) rootView.findViewById(R.id.seek14Text);
        s15T = (TextView) rootView.findViewById(R.id.seek15Text);

        a = arrayOfVals();

        if(a.get(0) == 1){
            relLayout1.setVisibility(View.VISIBLE);
        }
        if(a.get(1) == 1){
            relLayout2.setVisibility(View.VISIBLE);
        }
        if(a.get(2) == 1){
            relLayout3.setVisibility(View.VISIBLE);
        }
        if(a.get(3) == 1){
            relLayout4.setVisibility(View.VISIBLE);
        }
        if(a.get(4) == 1){
            relLayout5.setVisibility(View.VISIBLE);
        }
        if(a.get(5) == 1){
            relLayout6.setVisibility(View.VISIBLE);
        }
        if(a.get(6) == 1){
            relLayout7.setVisibility(View.VISIBLE);
        }
        if(a.get(7) == 1){
            relLayout8.setVisibility(View.VISIBLE);
        }
        if(a.get(8) == 1){
            relLayout9.setVisibility(View.VISIBLE);
        }
        if(a.get(9) == 1){
            relLayout10.setVisibility(View.VISIBLE);
        }
       if(!moods.get(0).equals("")){
            relLayout11.setVisibility(View.VISIBLE);
        }
        if(!moods.get(1).equals("")){
            relLayout12.setVisibility(View.VISIBLE);
        }
        if(!moods.get(2).equals("")){
            relLayout13.setVisibility(View.VISIBLE);
        }
        if(!moods.get(3).equals("")){
            relLayout14.setVisibility(View.VISIBLE);
        }
        if(!moods.get(4).equals("")){
            relLayout15.setVisibility(View.VISIBLE);
        }


        s1 = (SeekBar)rootView.findViewById(R.id.seekBar1);
        s1.setOnSeekBarChangeListener(this);
        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s1Val = progress;
                s1T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s2 = (SeekBar)rootView.findViewById(R.id.seekBar2);
        s2.setOnSeekBarChangeListener(this);
        s2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s2Val = progress;
                s2T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s3 = (SeekBar)rootView.findViewById(R.id.seekBar3);
        s3.setOnSeekBarChangeListener(this);
        s3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s3Val = progress;
                s3T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s4 = (SeekBar)rootView.findViewById(R.id.seekBar4);
        s4.setOnSeekBarChangeListener(this);
        s4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s4Val = progress;
                s4T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s5 = (SeekBar)rootView.findViewById(R.id.seekBar5);
        s5.setOnSeekBarChangeListener(this);
        s5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s5Val = progress;
                s5T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s6 = (SeekBar)rootView.findViewById(R.id.seekBar6);
        s6.setOnSeekBarChangeListener(this);
        s6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s6Val = progress;
                s6T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s7 = (SeekBar)rootView.findViewById(R.id.seekBar7);
        s7.setOnSeekBarChangeListener(this);
        s7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s7Val = progress;
                s7T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s8 = (SeekBar)rootView.findViewById(R.id.seekBar8);
        s8.setOnSeekBarChangeListener(this);
        s8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s8Val = progress;
                s8T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s9 = (SeekBar)rootView.findViewById(R.id.seekBar9);
        s9.setOnSeekBarChangeListener(this);
        s9.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s9Val = progress;
                s9T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s10 = (SeekBar)rootView.findViewById(R.id.seekBar10);
        s10.setOnSeekBarChangeListener(this);
        s10.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s10Val = progress;
                s10T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s11 = (SeekBar)rootView.findViewById(R.id.seekBar11);
        s11.setOnSeekBarChangeListener(this);
        s11.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s11Val = progress;
                s11T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s12 = (SeekBar)rootView.findViewById(R.id.seekBar12);
        s12.setOnSeekBarChangeListener(this);
        s12.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s12Val = progress;
                s12T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s13 = (SeekBar)rootView.findViewById(R.id.seekBar13);
        s13.setOnSeekBarChangeListener(this);
        s13.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s13Val = progress;
                s13T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s14 = (SeekBar)rootView.findViewById(R.id.seekBar14);
        s14.setOnSeekBarChangeListener(this);
        s14.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s14Val = progress;
                s14T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s15 = (SeekBar)rootView.findViewById(R.id.seekBar15);
        s15.setOnSeekBarChangeListener(this);
        s15.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                s15Val = progress;
                s15T.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View rootView){
        switch(rootView.getId()){
            case R.id.fab:
                if(a.get(0) == 0 && a.get(1) == 0 && a.get(2) == 0 && a.get(3) == 0 && a.get(4) == 0
                        && a.get(5) == 0 && a.get(6) == 0 && a.get(7) == 0 && a.get(8) == 0 && a.get(9) == 0){
                    Snackbar.make(rootView, "Please Select Emotions to Log!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    break;
                }
                else{
                    logData();
                    Snackbar.make(rootView, "Your Data Has Been Logged!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    break;
                }
        }
    }

    public void logData(){
        if(a.get(0) == 1){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'1'," + s1Val + " );");
        }
        if(a.get(1) == 1){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'2'," + s2Val + " );");
        }
        if(a.get(2) == 1){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'3'," + s3Val + " );");
        }
        if(a.get(3) == 1){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'4'," + s4Val + " );");
        }
        if(a.get(4) == 1){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'5'," + s5Val + " );");
        }
        if(a.get(5) == 1){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'6'," + s6Val + " );");
        }
        if(a.get(6) == 1){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'7'," + s7Val + " );");
        }
        if(a.get(7) == 1){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'8'," + s8Val + " );");
        }
        if(a.get(8) == 1){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'9'," + s9Val + " );");
        }
        if(a.get(9) == 1){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'10'," + s10Val + " );");
        }
        if(!moods.get(0).equals("")){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'"+drawable.get(0)+"'," + s11Val + " );");
        }
        if(!moods.get(1).equals("")){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'"+drawable.get(1)+"'," + s12Val + " );");
        }
        if(!moods.get(2).equals("")){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'"+drawable.get(2)+"'," + s13Val + " );");
        }
        if(!moods.get(3).equals("")){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'"+drawable.get(3)+"'," + s14Val + " );");
        }
        if(!moods.get(4).equals("")){
            MainActivity.mydatabase.execSQL("INSERT INTO emotion_log VALUES(CURRENT_DATE,time('now', 'localtime'),'"+drawable.get(4)+"'," + s15Val + " );");
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar){

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar){

    }

    private ArrayList<Integer> arrayOfVals(){
        ArrayList<Integer> arr = new ArrayList<>();
        final String TABLE_NAME = "emotion_master";
        String selectQuery = "SELECT emotion_status FROM " + TABLE_NAME;
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                arr.add(cursor.getInt(cursor.getColumnIndex("emotion_status")));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return arr;
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
}
