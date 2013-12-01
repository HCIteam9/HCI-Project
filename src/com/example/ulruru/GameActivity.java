package com.example.ulruru;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class GameActivity extends Activity {

	GridView cardTableView;
	ImageView boardView;
	ProgressBar mProgressBar;
	Button button;
	int nowValue = 300;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		cardTableView = (GridView) findViewById(R.id.cardtableView);
		CardTableAdapter cda = new CardTableAdapter(this);
		cardTableView.setAdapter(cda);
		mProgressBar = (ProgressBar) findViewById(R.id.timeBar);
		button = (Button) findViewById(R.id.start);
		boardView = (ImageView) findViewById(R.id.boardView);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				button.setVisibility(View.GONE);
				mProgressBar.setVisibility(View.VISIBLE);
				new Thread(myThread).start();

			}
		});

	}

	@Override
	protected void onStart() {
		super.onStart();

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		// boardView.setLayoutParams(new LayoutParams(metrics.widthPixels, (int)
		// (metrics.widthPixels*0.8)));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_game, menu);
		return true;
	}

	private Runnable myThread = new Runnable() {

		@Override
		public void run() {
			while (nowValue > 100) {
				try {
					myHandle.sendMessage(myHandle.obtainMessage());
					Thread.sleep(50);
				} catch (Exception e) {
				}
			}

		}
	};

	Handler myHandle = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			nowValue--;
			mProgressBar.setProgress(nowValue);
		}
	};

}
