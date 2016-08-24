package com.imoody.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Notify extends BroadcastReceiver {
    public Notify() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service1 = new Intent(context, NotifyAlarm.class);
        context.startService(service1);
    }
}