package com.imoody.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.imoody.R;

import java.util.Calendar;


public class AgeFragment extends Fragment implements View.OnClickListener {

    String[] months;
    String[] days;
    String[] years;

    public AgeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_age, container, false);

        Spinner dropdown = (Spinner) rootView.findViewById(R.id.monthSpinner);
        months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, months);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.month = months[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner dropdown1 = (Spinner) rootView.findViewById(R.id.daySpinner);
        days = new String[31];
        for(int i = 0; i < 31; i++){
            int insert = i+1;
            days[i] = insert + "";
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, days);
        dropdown1.setAdapter(adapter1);

        dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.day = days[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner dropdown2 = (Spinner) rootView.findViewById(R.id.yearSpinner);
        int y = Calendar.getInstance().get(Calendar.YEAR);
        int max = y - 1900;
        years = new String[max + 1];
        for(int i = 0; i < years.length; i++){
            int insert = y-i;
            years[i] = insert + "";
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, years);
        dropdown2.setAdapter(adapter2);

        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.year = years[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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
                fragment = new AgeFragment();
                break;
            case 7:
                fragment = new AgeFragment();
                break;
            case 8:
                fragment = new GenderFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.container_body, fragment).addToBackStack(null).commit();
        }
    }
}
