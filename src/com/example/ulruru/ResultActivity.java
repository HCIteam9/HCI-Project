package com.example.ulruru;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity {

	TextView titleText;
	TextView earnText;
	TextView totalText;
	int[] sub;
	ImageView startButton;
	ImageView exitButton;

	ImageView[] card = new ImageView[8];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		sub = getIntent().getIntArrayExtra("card");

		titleText = (TextView) findViewById(R.id.result_title_textview);
		earnText = (TextView) findViewById(R.id.earned_textview);
		totalText = (TextView) findViewById(R.id.total_textview);

		startButton = (ImageView) findViewById(R.id.start_gain_btn);
		exitButton = (ImageView) findViewById(R.id.exit_btn);

		card[0] = (ImageView) findViewById(R.id.card01);
		card[1] = (ImageView) findViewById(R.id.card02);
		card[2] = (ImageView) findViewById(R.id.card03);
		card[3] = (ImageView) findViewById(R.id.card04);
		card[4] = (ImageView) findViewById(R.id.card05);
		card[5] = (ImageView) findViewById(R.id.card06);
		card[6] = (ImageView) findViewById(R.id.card07);
		card[7] = (ImageView) findViewById(R.id.card08);

		Typeface typeFace = Typeface.createFromAsset(getAssets(),
				"fonts/SHOWG.TTF");

		titleText.setTypeface(typeFace);
		earnText.setTypeface(typeFace);
		totalText.setTypeface(typeFace);

		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent t = new Intent();
				t.putExtra("return", "start");
				setResult(RESULT_OK, t);
				finish();
				// TODO Auto-generated method stub

			}
		});

		exitButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent t = new Intent();
				t.putExtra("return", "exit");
				setResult(RESULT_OK, t);
				finish();
				// TODO Auto-generated method stub

			}
		});

		for (int i = 0; i < sub.length; i++) {
			Bitmap bmpSub = BitmapFactory
					.decodeResource(getResources(), sub[i]);
			bmpSub = Bitmap.createScaledBitmap(bmpSub, 280, 350, false);
			card[i].setImageBitmap(bmpSub);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}

}
