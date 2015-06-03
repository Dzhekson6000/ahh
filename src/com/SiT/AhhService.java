package com.SiT;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.IBinder;

public class AhhService extends Service {
	AhhBroadcastReceiver _rec;
	SharedPreferences _settings;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
    public void onCreate() {
		_rec = new AhhBroadcastReceiver(this);
		_settings = getSharedPreferences(Main.APP_PREFERENCES, Context.MODE_PRIVATE);
    }
	
	@Override
    public void onDestroy() {
		unregisterReceiver(_rec);
    }

    @Override
    public void onStart(Intent intent, int startid) {
    	if(_settings.getBoolean(Main.APP_PREFERENCES_STATUS, false))
    		registerReceiver(_rec, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
