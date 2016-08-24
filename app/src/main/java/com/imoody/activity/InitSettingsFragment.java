package com.imoody.activity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.imoody.R;

import java.util.ArrayList;

public class InitSettingsFragment extends Fragment implements View.OnClickListener {

    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10;
    int cb1Val, cb2Val, cb3Val, cb4Val, cb5Val, cb6Val, cb7Val, cb8Val, cb9Val, cb10Val;

    public InitSettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_initsettings, container, false);
        ArrayList<Integer> a = arrayOfVals();

        cb1 = (CheckBox) rootView.findViewById(R.id.checkBox1);
        cb2 = (CheckBox) rootView.findViewById(R.id.checkBox2);
        cb3 = (CheckBox) rootView.findViewById(R.id.checkBox3);
        cb4 = (CheckBox) rootView.findViewById(R.id.checkBox4);
        cb5 = (CheckBox) rootView.findViewById(R.id.checkBox5);
        cb6 = (CheckBox) rootView.findViewById(R.id.checkBox6);
        cb7 = (CheckBox) rootView.findViewById(R.id.checkBox7);
        cb8 = (CheckBox) rootView.findViewById(R.id.checkBox8);
        cb9 = (CheckBox) rootView.findViewById(R.id.checkBox9);
        cb10 = (CheckBox) rootView.findViewById(R.id.checkBox10);

        if(a.get(0) == 1){
            cb1.setChecked(true);
            cb1Val = 1;
        }
        else{
            cb1Val = 0;
        }
        if(a.get(1) == 1){
            cb2.setChecked(true);
            cb2Val = 1;
        }
        else{
            cb2Val = 0;
        }
        if(a.get(2) == 1){
            cb3.setChecked(true);
            cb3Val = 1;
        }
        else{
            cb3Val = 0;
        }
        if(a.get(3) == 1){
            cb4.setChecked(true);
            cb4Val = 1;
        }
        else{
            cb4Val = 0;
        }
        if(a.get(4) == 1){
            cb5.setChecked(true);
            cb5Val = 1;
        }
        else{
            cb5Val = 0;
        }
        if(a.get(5) == 1){
            cb6.setChecked(true);
            cb6Val = 1;
        }
        else{
            cb6Val = 0;
        }
        if(a.get(6) == 1){
            cb7.setChecked(true);
            cb7Val = 1;
        }
        else{
            cb7Val = 0;
        }
        if(a.get(7) == 1){
            cb8.setChecked(true);
            cb8Val = 1;
        }
        else{
            cb8Val = 0;
        }
        if(a.get(8) == 1){
            cb9.setChecked(true);
            cb9Val = 1;
        }
        else{
            cb9Val = 0;
        }
        if(a.get(9) == 1){
            cb10.setChecked(true);
            cb10Val = 1;
        }
        else{
            cb10Val = 0;
        }

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb1Val = 1;
                }
                else{
                    cb1Val = 0;
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb2Val = 1;
                }
                else{
                    cb2Val = 0;
                }
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb3Val = 1;
                }
                else{
                    cb3Val = 0;
                }
            }
        });

        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb4Val = 1;
                }
                else{
                    cb4Val = 0;
                }
            }
        });

        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb5Val = 1;
                }
                else{
                    cb5Val = 0;
                }
            }
        });

        cb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb6Val = 1;
                }
                else{
                    cb6Val = 0;
                }
            }
        });

        cb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb7Val = 1;
                }
                else{
                    cb7Val = 0;
                }
            }
        });

        cb8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb8Val = 1;
                }
                else{
                    cb8Val = 0;
                }
            }
        });

        cb9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb9Val = 1;
                }
                else{
                    cb9Val = 0;
                }
            }
        });

        cb10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb10Val = 1;
                }
                else{
                    cb10Val = 0;
                }
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

    public void onClick(View rootView){
        switch(rootView.getId()){
            case R.id.fab:
                sendToDB();
                savePref();
                displayView(1);
                break;
        }
    }

    public void savePref(){
        if(cb1Val == 1){
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 1 where emotion_id = 1");
        }
        else{
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 0 where emotion_id = 1");
        }
        if(cb2Val == 1){
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 1 where emotion_id = 2");
        }
        else{
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 0 where emotion_id = 2");
        }
        if(cb3Val == 1){
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 1 where emotion_id = 3");
        }
        else{
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 0 where emotion_id = 3");
        }
        if(cb4Val == 1){
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 1 where emotion_id = 4");
        }
        else{
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 0 where emotion_id = 4");
        }
        if(cb5Val == 1){
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 1 where emotion_id = 5");
        }
        else{
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 0 where emotion_id = 5");
        }
        if(cb6Val == 1){
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 1 where emotion_id = 6");
        }
        else{
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 0 where emotion_id = 6");
        }
        if(cb7Val == 1){
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 1 where emotion_id = 7");
        }
        else{
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 0 where emotion_id = 7");
        }
        if(cb8Val == 1){
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 1 where emotion_id = 8");
        }
        else{
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 0 where emotion_id = 8");
        }
        if(cb9Val == 1){
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 1 where emotion_id = 9");
        }
        else{
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 0 where emotion_id = 9");
        }
        if(cb10Val == 1){
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 1 where emotion_id = 10");
        }
        else{
            MainActivity.mydatabase.execSQL("UPDATE emotion_master SET emotion_status = 0 where emotion_id = 10");
        }
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
                fragment = new GenderFragment();
                break;
            case 7:
                fragment = new GenderFragment();
                break;
            case 8:
                fragment = new GenderFragment();
                break;
            case 9:
                fragment = new InitSettingsFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
        }
    }

    private void sendToDB(){
        String n = MainActivity.name;
        String g = MainActivity.gender;
        String m = MainActivity.month;
        String y = MainActivity.year;
        String d = MainActivity.day;
        MainActivity.mydatabase.execSQL("INSERT INTO user_profile_master VALUES('"+n+"','"+d+"','"+m+"','"+y+"','"+g+"');");
    }
}
