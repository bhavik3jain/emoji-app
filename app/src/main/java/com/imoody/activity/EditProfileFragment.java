package com.imoody.activity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.imoody.R;

import java.util.ArrayList;
import java.util.Calendar;

public class EditProfileFragment extends Fragment implements View.OnClickListener{

    String mname = "";
    String mday = "";
    String mmonth = "";
    String myear = "";
    String mgender = "";
    String timeStamp = "";
    String[] months;
    String[] days;
    String[] years;
    String[] items;

    View rootView;

    public EditProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_edit, container, false);
        getData();

        EditText editText = (EditText) rootView.findViewById(R.id.editText);
        editText.setText(mname);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_NEXT){
                    MainActivity.name = v.getText().toString();
                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                }
                return true;
            }
        });

        Spinner dropdown = (Spinner) rootView.findViewById(R.id.monthSpinner);
        dropdown.setPrompt(mmonth);
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
        dropdown1.setPrompt(mday);
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
        dropdown2.setPrompt(myear);
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

        Spinner dropdown3 = (Spinner) rootView.findViewById(R.id.ageSpinner);
        dropdown3.setPrompt(mgender);
        items = new String[]{"Male", "Female", "Other"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, items);
        dropdown3.setAdapter(adapter3);

        dropdown3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.gender = items[position];
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
    public void onDetach() {
        super.onDetach();
    }

    public void onClick(View rootView){
        switch(rootView.getId()) {
            case R.id.fab:
                sendToDB();
                displayView(3);
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

    private void sendToDB(){
        String n = MainActivity.name;
        String g = MainActivity.gender;
        String m = MainActivity.month;
        String y = MainActivity.year;
        String d = MainActivity.day;
        MainActivity.mydatabase.execSQL("UPDATE user_profile_master SET name='"+n+"',day='"+d+"',month='"+m+"',year='"+y+"',gender='"+g+"';");
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


}
