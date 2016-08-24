package com.imoody.activity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.imoody.R;


import java.util.ArrayList;
import java.util.Calendar;

public class ProfileFragment extends Fragment implements View.OnClickListener{

    String mname = "";
    String mday = "";
    String mmonth = "";
    String myear = "";
    String mgender = "";
    String timeStamp = "";
    String timeStamp2 = "";
    ArrayList<Integer> a;

    ArrayList<Integer> drawable = new ArrayList<>();
    ArrayList<String> moods = new ArrayList<>();

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
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

        TextView tv1 = (TextView) rootView.findViewById(R.id.tv1);
        TextView tv2 = (TextView) rootView.findViewById(R.id.tv2);
        TextView tv3 = (TextView) rootView.findViewById(R.id.tv3);
        TextView tv4 = (TextView) rootView.findViewById(R.id.tv4);
        TextView tv5 = (TextView) rootView.findViewById(R.id.tv5);

        ImageView im1 = (ImageView) rootView.findViewById(R.id.emoji11);
        im1.setImageResource(drawable.get(0));
        tv1.setText(moods.get(0));
        ImageView im2 = (ImageView) rootView.findViewById(R.id.emoji12);
        im2.setImageResource(drawable.get(1));
        tv2.setText(moods.get(1));
        ImageView im3 = (ImageView) rootView.findViewById(R.id.emoji13);
        im3.setImageResource(drawable.get(2));
        tv3.setText(moods.get(2));
        ImageView im4 = (ImageView) rootView.findViewById(R.id.emoji14);
        im4.setImageResource(drawable.get(3));
        tv4.setText(moods.get(3));
        ImageView im5 = (ImageView) rootView.findViewById(R.id.emoji15);
        im5.setImageResource(drawable.get(4));
        tv5.setText(moods.get(4));

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

        getData();
        getLog();

        TextView t0 = (TextView) rootView.findViewById(R.id.name);
        TextView t1 = (TextView) rootView.findViewById(R.id.bday);
        TextView t2 = (TextView) rootView.findViewById(R.id.gender);
        TextView t3 = (TextView) rootView.findViewById(R.id.age);
        TextView t4 = (TextView) rootView.findViewById(R.id.lastLogged);

        String y = mmonth + " " + mday + ", " + myear;

        t0.append(mname);
        t1.append(y);
        t2.append(mgender);
        if(myear.equals("") ||mmonth.equals("")||mday.equals("")){
            t3.append("");
        }
        else{
            t3.append(getAge(myear, mmonth, mday));
        }

        timeStamp = timeStamp.substring(5,7) + "/" + timeStamp.substring(8) + "/" + timeStamp.substring(0,4);

        int t = Integer.valueOf(timeStamp2.substring(0,2));

        if(t > 12){
            t = t - 12;
            timeStamp2 = t + timeStamp2.substring(2) + " PM";
        }
        else{
            timeStamp2 = timeStamp2 + " AM";
        }

        t4.append(timeStamp + " " + timeStamp2);

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
        switch(rootView.getId()) {
            case R.id.fab:
                displayView(9);
                break;
        }
    }

    public void getData(){
        final String TABLE_NAME = "user_profile_master";
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
        if(cursor.getCount() != 0){
            cursor.moveToFirst();

            mname = cursor.getString(cursor.getColumnIndex("name"));
            mgender = cursor.getString(cursor.getColumnIndex("gender"));
            mday = cursor.getString(cursor.getColumnIndex("day"));
            mmonth = cursor.getString(cursor.getColumnIndex("month"));
            myear = cursor.getString(cursor.getColumnIndex("year"));
        }
        cursor.close();
    }

    public void getLog(){
        final String TABLE_NAME = "emotion_log";
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
        if(cursor.getCount() != 0){
            cursor.moveToLast();
            timeStamp = cursor.getString(cursor.getColumnIndex("entryDate"));
            timeStamp2 = cursor.getString(cursor.getColumnIndex("entryTime"));
        }
        cursor.close();
    }

    private String getAge(String _year, String _month, String _day){
        int year = Integer.valueOf(_year);
        int month;
        int day = Integer.valueOf(_day);

        switch (_month){
            case "January":
                month = 0;
                break;
            case "February":
                month = 1;
                break;
            case "March":
                month = 2;
                break;
            case "April":
                month = 3;
                break;
            case "May":
                month = 4;
                break;
            case "June":
                month = 5;
                break;
            case "July":
                month = 6;
                break;
            case "August":
                month = 7;
                break;
            case "September":
                month = 8;
                break;
            case "October":
                month = 9;
                break;
            case "November":
                month = 10;
                break;
            case "December":
                month = 11;
                break;
            default:
                month = 0;
                break;
        }

        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
            age--;
        } else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
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
                fragment = new NotificationFragment();
                break;
            case 7:
                fragment = new GenderFragment();
                break;
            case 8:
                fragment = new GenderFragment();
                break;
            case 9:
                fragment = new EditProfileFragment();
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
}
