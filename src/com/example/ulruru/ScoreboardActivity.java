package com.example.ulruru;

import data.userData;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ScoreboardActivity extends Activity {

	TextView Single_txt,Multy_txt,OnlineR_txt;
	ImageView return_btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scoreboard);
		
		Single_txt = (TextView)findViewById(R.id.scoreg_disp1);
		Multy_txt = (TextView)findViewById(R.id.scoreg_disp2);
		OnlineR_txt = (TextView)findViewById(R.id.scoreg_disp3);
		return_btn = (ImageView)findViewById(R.id.scoreb_return_btn);
		
		Single_txt.setText(""+userData.usr.getSingle_high());
		Multy_txt.setText(""+userData.usr.getMulty_high());
		OnlineR_txt.setText(""+userData.usr.getOnline_rank());
		
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
		getMenuInflater().inflate(R.menu.activity_scoreboard, menu);
		return true;
	}

}
