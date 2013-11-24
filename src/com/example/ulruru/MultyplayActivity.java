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

public class MultyplayActivity extends Activity {

	ImageView create_btn,join_btn,return_btn;
	TextView title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multyplay);
		
		create_btn = (ImageView)findViewById(R.id.multyp_create_btn);
		join_btn = (ImageView)findViewById(R.id.multyp_join_btn);
		return_btn = (ImageView)findViewById(R.id.multyp_return_btn);
		title = (TextView)findViewById(R.id.multyp_title_textview);
		
		create_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				userData.usr.setRoom_maker(true);
				Intent i = new Intent(MultyplayActivity.this,CreateGameActivity.class);
				startActivity(i);
			}
		});
		join_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				userData.usr.setRoom_maker(false);
				Intent i = new Intent(MultyplayActivity.this,JoinGameActivity.class);
				startActivity(i);
			}
		});
		return_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/SHOWG.TTF");
		title.setTypeface(typeFace);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_multyplay, menu);
		return true;
	}

}
