package com.example.ulruru;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	
	ImageView Gamestart_btn,Option_btn,Scoreboard_btn,Exit_btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Gamestart_btn = (ImageView)findViewById(R.id.main_start_btn);
		Option_btn = (ImageView)findViewById(R.id.main_option_btn);
		Scoreboard_btn=(ImageView)findViewById(R.id.main_scoreboard_btn);
		Exit_btn = (ImageView)findViewById(R.id.main_exit_btn);
		
		Gamestart_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,GameSelectActivity.class);
				startActivity(i);
				
			}
		});
		Option_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,OptionActivity.class);
				startActivity(i);
			}
		});
		Scoreboard_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,ScoreboardActivity.class);
				startActivity(i);
			}
		});
		Exit_btn.setOnClickListener(new OnClickListener() {
			
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
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
