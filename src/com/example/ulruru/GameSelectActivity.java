package com.example.ulruru;

import data.userData;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class GameSelectActivity extends Activity {

	ImageView Return_btn,Singleplay_btn,Multyplay_btn;
	TextView title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_select);
		
		Return_btn = (ImageView)findViewById(R.id.gamesel_return_btn);
		Singleplay_btn = (ImageView)findViewById(R.id.gamesel_singlep_btn);
		Multyplay_btn = (ImageView)findViewById(R.id.gamesel_multyp_btn);
		
		title = (TextView)findViewById(R.id.gamesel_title_textview);
		
		Return_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		Singleplay_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				userData.usr.setGame_mode(false);
				Intent i = new Intent(GameSelectActivity.this,DiffSelectActivity.class);
				startActivity(i);
			}
		});
		
		Multyplay_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				userData.usr.setGame_mode(true);
				Intent i = new Intent(GameSelectActivity.this,MultyplayActivity.class);
				startActivity(i);
			}
		});
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/SHOWG.TTF");
		title.setTypeface(typeFace);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_game_select, menu);
		return true;
	}

}
