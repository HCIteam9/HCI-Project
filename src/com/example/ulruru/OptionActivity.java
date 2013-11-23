package com.example.ulruru;

import data.userData;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class OptionActivity extends Activity {

	ImageView return_btn;
	ToggleButton BGM_toggle,SF_toggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option);
		
		return_btn = (ImageView)findViewById(R.id.option_return_btn);
		BGM_toggle = (ToggleButton)findViewById(R.id.option_bgm_toggle);
		SF_toggle = (ToggleButton)findViewById(R.id.option_sf_toggle);
		
		BGM_toggle.setChecked(userData.usr.isBgm());
		SF_toggle.setChecked(userData.usr.isSoundeffect());
		
		BGM_toggle.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				userData.usr.setBgm(isChecked);
			}
		});
		
		SF_toggle.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				userData.usr.setSoundeffect(isChecked);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_option, menu);
		return true;
	}

}
