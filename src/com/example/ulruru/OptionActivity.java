package com.example.ulruru;

import data.userData;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class OptionActivity extends Activity {

	ImageView return_btn;
	ToggleButton BGM_toggle,SF_toggle;
	TextView title,bgm_txt,sf_txt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option);
		
		return_btn = (ImageView)findViewById(R.id.option_return_btn);
		BGM_toggle = (ToggleButton)findViewById(R.id.option_bgm_toggle);
		SF_toggle = (ToggleButton)findViewById(R.id.option_sf_toggle);
		title = (TextView)findViewById(R.id.option_title_textview);
		bgm_txt = (TextView)findViewById(R.id.option_bgm_textview);
		sf_txt = (TextView)findViewById(R.id.option_sf_textview);
		
		BGM_toggle.setChecked(userData.usr.isBgm());
		SF_toggle.setChecked(userData.usr.isSoundeffect());
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/SHOWG.TTF");
		title.setTypeface(typeFace);
		bgm_txt.setTypeface(typeFace);
		sf_txt.setTypeface(typeFace);
		
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
		return_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
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
