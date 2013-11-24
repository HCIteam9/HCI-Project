package com.example.ulruru;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;

public class GameActivity extends Activity {
	
	GridView cardTableView;
	ImageView boardView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		cardTableView = (GridView) findViewById(R.id.cardtableView);
		CardTableAdapter cda = new CardTableAdapter(this);
		cardTableView.setAdapter(cda);
		
		boardView = (ImageView) findViewById(R.id.boardView);
	}
	
	@Override
	protected void onStart(){
		super.onStart();

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		//boardView.setLayoutParams(new LayoutParams(metrics.widthPixels, (int) (metrics.widthPixels*0.8)));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_game, menu);
		return true;
	}

}
