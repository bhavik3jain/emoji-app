package com.imoody.activity;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;

import com.imoody.R;

public class NotifyAlarm extends Service {

    private SharedPreferences prefs;
    private String task;
    private NotificationManager mNotificationManager;
    private android.support.v4.app.NotificationCompat.Builder mBuilder;

    public NotifyAlarm() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @SuppressWarnings("static-access")
    @Override
    public void onStart(Intent intent, int startId)
    {
        super.onStart(intent, startId);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        task = prefs.getString("Current_Task", "");

        if (!task.equals("")){
            mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            Intent intent1 = new Intent(this.getApplicationContext(),MainActivity.class);
            mBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Current task")
                    .setContentText("Hey! Have you " + task + "?");

            mNotificationManager.notify(0, mBuilder.build());
        }
    }
}