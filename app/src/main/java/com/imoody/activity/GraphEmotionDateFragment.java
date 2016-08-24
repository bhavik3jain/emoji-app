package com.imoody.activity;

import android.app.Activity;
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
import android.widget.RadioGroup;
import android.widget.TextView;

import com.imoody.R;

public class GraphEmotionDateFragment extends Fragment implements View.OnClickListener{

    View rootView;

    public GraphEmotionDateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_graphs_date, container, false);

        RadioGroup rg = (RadioGroup) rootView.findViewById(R.id.myRadioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.day:
                        MainActivity.dateType = 1;
                        break;
                    case R.id.week:
                        MainActivity.dateType = 2;
                        break;
                    case R.id.one_month:
                        MainActivity.dateType = 3;
                        break;
                    case R.id.three_month:
                        MainActivity.dateType = 4;
                        break;
                    case R.id.six_month:
                        MainActivity.dateType = 5;
                        break;
                    case R.id.year:
                        MainActivity.dateType = 6;
                        break;
                    default:
                        MainActivity.dateType = 0;
                        break;
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
                displayView(8);
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
                fragment = new GraphEmotionDateFragment();
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
                fragment = new GraphEmotionGenerateGraph();
                break;
            default:
                break;
        }

        if (fragment != null) {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.container_body, fragment).addToBackStack(null).commit();
        }
    }
}
