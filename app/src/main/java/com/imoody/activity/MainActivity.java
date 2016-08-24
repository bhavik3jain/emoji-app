package com.imoody.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.imoody.R;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    public static FragmentManager fragmentManager;
    public static FragmentTransaction fragmentTransaction;

    //private final long SIX_HOURS = 21600000L;
    //private final long SIX_HOURS = 2000;

    private static String TAG = MainActivity.class.getSimpleName();
    SharedPreferences prefs = null;
    public static String name = "";
    public static String gender = "";
    public static String month = "";
    public static String day = "";
    public static String year = "";
    public static String notifications = "";

    public static int graphChoice;
    public static int Gcb1Val = 0;
    public static int Gcb2Val = 0;
    public static int Gcb3Val = 0;
    public static int Gcb4Val = 0;
    public static int Gcb5Val = 0;
    public static int Gcb6Val = 0;
    public static int Gcb7Val = 0;
    public static int Gcb8Val = 0;
    public static int Gcb9Val = 0;
    public static int Gcb10Val = 0;
    public static int Gcb11Val = 0;
    public static int Gcb12Val = 0;
    public static int Gcb13Val = 0;
    public static int Gcb14Val = 0;
    public static int Gcb15Val = 0;
    public static int dateType;

    public static String customName = "Custom Event";
    public static String setCheckedCustom = "";
    public static int drawable = -1;

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    public static SQLiteDatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("com.imoody", MODE_PRIVATE);
        mydatabase = openOrCreateDatabase("BhavikDB",MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS emotion_master(" +
                                "emotion_id INT," +
                                "emotion_name VARCHAR, " +
                                "emotion_status INT);"
                          );

        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS emotion_custom(" +
                                "emotion_id INT," +
                                "emotion_name VARCHAR, " +
                                "emotion_status INT);"
                          );

        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS emotion_log(" +
                                "entryDate DATE, " +
                                "entryTime TIME, " +
                                "emotion_id VARCHAR, " +
                                "dataValue VARCHAR);"
                          );

        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS user_profile_master(" +
                                "name VARCHAR, " +
                                "day VARCHAR, " +
                                "month VARCHAR, " +
                                "year VARCHAR, " +
                                "gender VARCHAR);"
                          );



        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        //Context context = MainActivity.this;
        //AlarmManager mgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//
        //Intent i = new Intent(context, Notify.class);
        //PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
//
        //mgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime(),SIX_HOURS,pi);

        // display the first navigation drawer view on app launch
        if (prefs.getBoolean("firstrun", true) || !getData()) {
            // Do first run stuff here then set 'firstrun' as false
            // using the following line to edit/commit prefs
            initializeTableEmotion_Master();
            displayView(5);
            prefs.edit().putBoolean("firstrun", false).apply();
        }
        else {
            displayView(0);
        }
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return true;
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        String name = "";
        switch (position) {
            case 0:
                fragment = new LogFragment();
                title = getString(R.string.title_log);
                name = "Log";
                break;
            case 1:
                fragment = new CustomFragment();
                makeCustomClear();
                break;
            case 2:
                fragment = new GraphsFragment();
                makeGraphSelectionZero();
                title = getString(R.string.title_graphs);
                name = "Graph";
                break;
            case 3:
                fragment = new ProfileFragment();
                title = getString(R.string.title_profile);
                name = "Profile";
                break;
            case 4:
                fragment = new SettingsFragment();
                title = getString(R.string.title_settings);
                name = "Settings";
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
                fragment = new GenderFragment();
                break;
            case 9:
                fragment = new InitSettingsFragment();
                break;
            case 10:
                fragment = new GraphMoodSelectionFragment();
                break;
            case 11:
                fragment = new GraphEmotionDateFragment();
                break;
            case 12:
                fragment = new GraphEmotionGenerateGraph();
                break;
            default:
                break;
        }

        if (fragment != null) {
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container_body, fragment).addToBackStack(null).commit();


            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

    private void initializeTableEmotion_Master(){
        mydatabase.execSQL("INSERT INTO emotion_master VALUES (1, 'Fear', 0)");
        mydatabase.execSQL("INSERT INTO emotion_master VALUES (2, 'Anger', 0)");
        mydatabase.execSQL("INSERT INTO emotion_master VALUES (3, 'Sadness', 0)");
        mydatabase.execSQL("INSERT INTO emotion_master VALUES (4, 'Joy', 0)");
        mydatabase.execSQL("INSERT INTO emotion_master VALUES (5, 'Disgust', 0)");
        mydatabase.execSQL("INSERT INTO emotion_master VALUES (6, 'Trust', 0)");
        mydatabase.execSQL("INSERT INTO emotion_master VALUES (7, 'Anticipation', 0)");
        mydatabase.execSQL("INSERT INTO emotion_master VALUES (8, 'Surprise', 0)");
        mydatabase.execSQL("INSERT INTO emotion_master VALUES (9, 'Love', 0)");
        mydatabase.execSQL("INSERT INTO emotion_master VALUES (10, 'Remorse', 0)");
    }

    public boolean getData(){
        final String TABLE_NAME = "user_profile_master";
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = mydatabase.rawQuery(selectQuery, null);
        if(cursor.getCount() > 0){
            return true;
        }
        else{
            cursor.close();
            return false;
        }
    }

    public void makeGraphSelectionZero(){
        Gcb1Val = 0;
        Gcb2Val = 0;
        Gcb3Val = 0;
        Gcb4Val = 0;
        Gcb5Val = 0;
        Gcb6Val = 0;
        Gcb7Val = 0;
        Gcb8Val = 0;
        Gcb9Val = 0;
        Gcb10Val = 0;
    }

    public void makeCustomClear(){
        drawable = -1;
        customName = "Custom Event";
        setCheckedCustom = "";
    }
}