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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.imoody.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GraphMoodSelectionFragment extends Fragment implements View.OnClickListener{

    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15;
    TextView t0;
    View rootView;

    public int maxBoxes = 5;

    ArrayList<Integer> drawable = new ArrayList<>();
    ArrayList<String> moods = new ArrayList<>();

    public GraphMoodSelectionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_graphs_selection, container, false);
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

        ArrayList<String> arr = arrayOfVals();

        if(arr.contains("1")){
            relLayout1.setVisibility(View.VISIBLE);
        }
        if(arr.contains("2")){
            relLayout2.setVisibility(View.VISIBLE);
        }
        if(arr.contains("3")){
            relLayout3.setVisibility(View.VISIBLE);
        }
        if(arr.contains("4")){
            relLayout4.setVisibility(View.VISIBLE);
        }
        if(arr.contains("5")){
            relLayout5.setVisibility(View.VISIBLE);
        }
        if(arr.contains("6")){
            relLayout6.setVisibility(View.VISIBLE);
        }
        if(arr.contains("7")){
            relLayout7.setVisibility(View.VISIBLE);
        }
        if(arr.contains("8")){
            relLayout8.setVisibility(View.VISIBLE);
        }
        if(arr.contains("9")){
            relLayout9.setVisibility(View.VISIBLE);
        }
        if(arr.contains("10")){
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

        t0 = (TextView) rootView.findViewById(R.id.user_profile_short_bio1);

        t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");

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
        cb11 = (CheckBox) rootView.findViewById(R.id.checkBox11);
        cb12 = (CheckBox) rootView.findViewById(R.id.checkBox12);
        cb13 = (CheckBox) rootView.findViewById(R.id.checkBox13);
        cb14 = (CheckBox) rootView.findViewById(R.id.checkBox14);
        cb15 = (CheckBox) rootView.findViewById(R.id.checkBox15);

        maxBoxes = 5;

        if(MainActivity.Gcb1Val == 1){
            cb1.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb2Val == 1){
            cb2.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb3Val == 1){
            cb3.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb4Val == 1){
            cb4.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb5Val == 1){
            cb5.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb6Val == 1){
            cb6.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb7Val == 1){
            cb7.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb8Val == 1){
            cb8.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb9Val == 1){
            cb9.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb10Val == 1){
            cb10.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb11Val == 1){
            cb11.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb12Val == 1){
            cb12.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb13Val == 1){
            cb13.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb14Val == 1){
            cb14.setChecked(true);
            maxBoxes--;
        }
        if(MainActivity.Gcb15Val == 1){
            cb15.setChecked(true);
            maxBoxes--;
        }

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb1Val = 0;
                    cb1.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb1Val = 1;
                    cb1.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb1Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb2Val = 0;
                    cb2.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb2Val = 1;
                    cb2.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb2Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb3Val = 0;
                    cb3.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb3Val = 1;
                    cb3.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb3Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });

        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb4Val = 0;
                    cb4.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb4Val = 1;
                    cb4.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb4Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });

        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb5Val = 0;
                    cb5.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb5Val = 1;
                    cb5.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb5Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });

        cb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb6Val = 0;
                    cb6.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb6Val = 1;
                    cb6.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb6Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });

        cb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb7Val = 0;
                    cb7.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb7Val = 1;
                    cb7.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb7Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });

        cb8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb8Val = 0;
                    cb8.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb8Val = 1;
                    cb8.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb8Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });

        cb9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb9Val = 0;
                    cb9.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb9Val = 1;
                    cb9.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb9Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });

        cb10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb10Val = 0;
                    cb10.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb10Val = 1;
                    cb10.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb10Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });
        cb11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb11Val = 0;
                    cb11.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb11Val = 1;
                    cb11.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb11Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });
        cb12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb12Val = 0;
                    cb12.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb12Val = 1;
                    cb12.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb12Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });
        cb13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb13Val = 0;
                    cb11.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb13Val = 1;
                    cb13.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb13Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });
        cb14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb14Val = 0;
                    cb11.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb14Val = 1;
                    cb14.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb14Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
            }
        });
        cb15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(maxBoxes == 0 && isChecked){
                    MainActivity.Gcb15Val = 0;
                    cb15.setChecked(false);
                    Snackbar.make(rootView, "Limit Reached!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(isChecked){
                    MainActivity.Gcb15Val = 1;
                    cb15.setChecked(true);
                    maxBoxes--;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
                }
                else if(!isChecked){
                    MainActivity.Gcb15Val = 0;
                    maxBoxes++;
                    t0.setText("Select Up to " + maxBoxes + " Emotions to Graph!");
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
                if(MainActivity.graphChoice == 3){
                    displayView(9);
                    break;
                }
                else{
                    displayView(8);
                    break;
                }
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
                fragment = new GraphMoodSelectionFragment();
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
                fragment = new AgeFragment();
                break;
            case 8:
                fragment = new GraphEmotionDateFragment();
                break;
            case 9:
                fragment = new GraphEmotionGenerateGraph();
                break;
            default:
                break;
        }

        if (fragment != null) {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.container_body, fragment).addToBackStack(null).commit();
        }
    }

    private ArrayList<String> arrayOfVals(){
        ArrayList<String> arr = new ArrayList<>();
        final String TABLE_NAME = "emotion_log";
        String selectQuery = "SELECT DISTINCT emotion_id FROM " + TABLE_NAME;
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                arr.add(cursor.getString(cursor.getColumnIndex("emotion_id")));
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
