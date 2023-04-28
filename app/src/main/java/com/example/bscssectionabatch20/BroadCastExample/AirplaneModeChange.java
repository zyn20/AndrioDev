package com.example.bscssectionabatch20.BroadCastExample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeChange extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (IsAirplaneModeOn(context.getApplicationContext()))
        {
            Toast.makeText(context,"Airplane Mode is On",Toast.LENGTH_SHORT).show();


        }
        else
        {
            Toast.makeText(context,"Airplane Mode is Off",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean IsAirplaneModeOn(Context applicationContext) {
        return Settings.System.getInt(applicationContext.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON,0) !=0;
    }
}
