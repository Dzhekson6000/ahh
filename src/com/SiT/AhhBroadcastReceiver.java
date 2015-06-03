package com.SiT;

import com.SiT.ahh.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.BatteryManager;
import android.util.Log;

public class AhhBroadcastReceiver extends BroadcastReceiver {
	private boolean 	_isCharging = false;
	private SoundPool 	_soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
	private int 		_soundId;
	
	public AhhBroadcastReceiver(Context context)
	{
		_soundId = _soundPool.load(context, R.raw.sound, 1);
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
		switch (status) {
			case BatteryManager.BATTERY_STATUS_CHARGING:
				if(!_isCharging)ahh();
				_isCharging = true;
			case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
				_isCharging = false;
		}		

	}
	
	private void ahh()
    {
    	_soundPool.play(_soundId, 1, 1, 0, 0, 1);
    }

}
