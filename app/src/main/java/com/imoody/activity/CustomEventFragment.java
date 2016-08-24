package com.imoody.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.imoody.R;


public class CustomEventFragment extends Fragment implements View.OnClickListener {

    View rootView;

    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16, cb17, cb18, cb19, cb20;

    int maxBoxes = 1;

    public CustomEventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_customeventicon, container, false);

        cb1 = (CheckBox) rootView.findViewById(R.id.radio1);
        cb2 = (CheckBox) rootView.findViewById(R.id.radio2);
        cb3 = (CheckBox) rootView.findViewById(R.id.radio3);
        cb4 = (CheckBox) rootView.findViewById(R.id.radio4);
        cb5 = (CheckBox) rootView.findViewById(R.id.radio5);
        cb6 = (CheckBox) rootView.findViewById(R.id.radio6);
        cb7 = (CheckBox) rootView.findViewById(R.id.radio7);
        cb8 = (CheckBox) rootView.findViewById(R.id.radio8);
        cb9 = (CheckBox) rootView.findViewById(R.id.radio9);
        cb10 = (CheckBox) rootView.findViewById(R.id.radio10);
        cb11 = (CheckBox) rootView.findViewById(R.id.radio11);
        cb12 = (CheckBox) rootView.findViewById(R.id.radio12);
        cb13 = (CheckBox) rootView.findViewById(R.id.radio13);
        cb14 = (CheckBox) rootView.findViewById(R.id.radio14);
        cb15 = (CheckBox) rootView.findViewById(R.id.radio15);
        cb16 = (CheckBox) rootView.findViewById(R.id.radio16);
        cb17 = (CheckBox) rootView.findViewById(R.id.radio17);
        cb18 = (CheckBox) rootView.findViewById(R.id.radio18);
        cb19 = (CheckBox) rootView.findViewById(R.id.radio19);
        cb20 = (CheckBox) rootView.findViewById(R.id.radio20);

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f911;
                    MainActivity.setCheckedCustom = "cb1";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f608;
                    MainActivity.setCheckedCustom = "cb2";
                    cb1.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_267b;
                    MainActivity.setCheckedCustom = "cb3";
                    cb2.setChecked(false); cb1.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f3c6;
                    MainActivity.setCheckedCustom = "cb4";
                    cb2.setChecked(false); cb3.setChecked(false); cb1.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f3a7;
                    MainActivity.setCheckedCustom = "cb5";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb1.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f4b3;
                    MainActivity.setCheckedCustom = "cb6";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb1.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f913;
                    MainActivity.setCheckedCustom = "cb7";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb1.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f3cb;
                    MainActivity.setCheckedCustom = "cb8";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb1.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f37b;
                    MainActivity.setCheckedCustom = "cb9";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb1.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f3b0;
                    MainActivity.setCheckedCustom = "cb10";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb1.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f915;
                    MainActivity.setCheckedCustom = "cb11";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb1.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f4a9;
                    MainActivity.setCheckedCustom = "cb12";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb1.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f577;
                    MainActivity.setCheckedCustom = "cb13";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb1.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f34e;
                    MainActivity.setCheckedCustom = "cb14";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb1.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f4ac;
                    MainActivity.setCheckedCustom = "cb15";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb1.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f5c4;
                    MainActivity.setCheckedCustom = "cb16";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb1.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f6cf;
                    MainActivity.setCheckedCustom = "cb17";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb1.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f6ec;
                    MainActivity.setCheckedCustom = "cb18";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb1.setChecked(false); cb19.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f36b;
                    MainActivity.setCheckedCustom = "cb19";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb1.setChecked(false);
                    cb20.setChecked(false);
                }
            }
        });

        cb20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MainActivity.drawable = R.drawable.emoji_1f579;
                    MainActivity.setCheckedCustom = "cb20";
                    cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                    cb5.setChecked(false); cb6.setChecked(false); cb7.setChecked(false);
                    cb8.setChecked(false); cb9.setChecked(false); cb10.setChecked(false);
                    cb11.setChecked(false); cb12.setChecked(false); cb13.setChecked(false);
                    cb14.setChecked(false); cb15.setChecked(false); cb16.setChecked(false);
                    cb17.setChecked(false); cb18.setChecked(false); cb19.setChecked(false);
                    cb1.setChecked(false);
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

    @Override
    public void onClick(View rootView){
        switch(rootView.getId()){
            case R.id.fab:
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
}
