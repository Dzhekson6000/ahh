package com.SiT;

import com.SiT.ahh.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {
	
	public static final String APP_PREFERENCES = "settings"; 
	public static final String APP_PREFERENCES_STATUS = "status";
	
	SharedPreferences _settings;
	
	@Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        
        final Button btnStart=(Button)findViewById(R.id.start);
        final Button btnStop=(Button)findViewById(R.id.stop);
        
        _settings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Editor editor = _settings.edit();
                editor.putBoolean(APP_PREFERENCES_STATUS, true);
                editor.apply();
                startService(new Intent(Main.this,AhhService.class));

            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Editor editor = _settings.edit();
                editor.putBoolean(APP_PREFERENCES_STATUS, false);
                editor.apply();
                stopService(new Intent(Main.this,AhhService.class));
            }
        });
    }
}
