package com.example.ulruru;

import data.userData;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class DiffSelectActivity extends Activity {

	ImageView Return_btn,CS_btn;
	CheckBox lv1_chkb,lv2_chkb,lv3_chkb,lv4_chkb,lv5_chkb;
	ToggleButton cond_toggle;
	boolean cond_status,lv1,lv2,lv3,lv4,lv5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diff_select);
		
		Return_btn = (ImageView)findViewById(R.id.diffsel_return_btn);
		CS_btn = (ImageView)findViewById(R.id.diffsel_crst_btn);
		lv1_chkb = (CheckBox)findViewById(R.id.diffsel_lv1chk);
		lv2_chkb = (CheckBox)findViewById(R.id.diffsel_lv2chk);
		lv3_chkb = (CheckBox)findViewById(R.id.diffsel_lv3chk);
		lv4_chkb = (CheckBox)findViewById(R.id.diffsel_lv4chk);
		lv5_chkb = (CheckBox)findViewById(R.id.diffsel_lv5chk);
		cond_toggle = (ToggleButton)findViewById(R.id.diffsel_mcond_toggle);
		cond_status=cond_toggle.isChecked();
		
		if(userData.usr.isGame_mode()==true)
			CS_btn.setImageResource(R.drawable.btn_create_game);
		else
			CS_btn.setImageResource(R.drawable.btn_gamestart);
		
		Return_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		CS_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(userData.usr.isGame_mode()==true)
				{
					Intent i = new Intent(DiffSelectActivity.this,WaitRoomActivity.class);
					startActivity(i);
				}
				else
				{
					Intent i = new Intent(DiffSelectActivity.this,GameActivity.class);
					startActivity(i);
				}
			}
		});
		
		cond_toggle.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				cond_status=isChecked;
			}
		});
	
		lv1_chkb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(lv1==true)
					lv1=false;
				else
					lv1=true;
			}
		});
		lv2_chkb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(lv2==true)
					lv2=false;
				else
					lv2=true;
			}
		});
		lv3_chkb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(lv3==true)
					lv3=false;
				else
					lv3=true;
			}
		});
		lv4_chkb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(lv4==true)
					lv4=false;
				else
					lv4=true;
			}
		});
		lv5_chkb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(lv5==true)
					lv5=false;
				else
					lv5=true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_diff_select, menu);
		return true;
	}

}
