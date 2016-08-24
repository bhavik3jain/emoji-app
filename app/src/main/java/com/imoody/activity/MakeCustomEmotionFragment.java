package com.imoody.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.imoody.R;


public class MakeCustomEmotionFragment extends Fragment implements View.OnClickListener {

    View rootView;

    public MakeCustomEmotionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_createcustomevent, container, false);

        EditText editText = (EditText) rootView.findViewById(R.id.editText);
        if(MainActivity.customName.equals("Custom Event")){
            editText.setHint(MainActivity.customName);
        }
        else{
            editText.setText(MainActivity.customName);
        }
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_NEXT){
                    MainActivity.customName = v.getText().toString();
                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                }
                return true;
            }
        });

        ImageView imageView = (ImageView) rootView.findViewById(R.id.icon);
        if(MainActivity.drawable == -1){
            imageView.setImageResource(R.drawable.emoji_2795);
        }
        else{
            imageView.setImageResource(MainActivity.drawable);
            System.out.println("HERE!!!!!!!!!!     " + MainActivity.drawable); //2130838347
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayView(6);
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
                sendToCustomDB();
                displayView(7);
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
                fragment = new CustomEventFragment();
                break;
            case 7:
                fragment = new CustomFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.container_body, fragment).addToBackStack(null).commit();
        }
    }

    public void sendToCustomDB(){
        MainActivity.mydatabase.execSQL("INSERT INTO emotion_custom VALUES ("+MainActivity.drawable+", '"+MainActivity.customName+"', 1)");
    }
}
