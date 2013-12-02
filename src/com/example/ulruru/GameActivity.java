package com.example.ulruru;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GameActivity extends Activity {
	private boolean GAMING = false;

	int[] numbers = new int[] { R.drawable.ulruru_card1,
			R.drawable.ulruru_card2, R.drawable.ulruru_card3,
			R.drawable.ulruru_card4, R.drawable.ulruru_card1,
			R.drawable.ulruru_card2, R.drawable.ulruru_card3,
			R.drawable.ulruru_card4 };

	int[] sub = new int[8];

	int[] random = new int[] { R.drawable.card01, R.drawable.card02,
			R.drawable.card03, R.drawable.card04, R.drawable.card01,
			R.drawable.card02, R.drawable.card03, R.drawable.card04 };
	private TransitionDrawable[] drawable = new TransitionDrawable[8];
	private ImageView[] card = new ImageView[8];

	ImageView boardView;
	TextProgressBar mProgressBar;
	Button startButton;
	int nowValue = 800;
	CardTableAdapter cda;

	RelativeLayout gameLayout;
	RelativeLayout buttonLayout;
	RelativeLayout zoomLayout;
	LinearLayout backgroundLayout;

	ImageView birdList[] = new ImageView[8];
	ImageView birdSubList[] = new ImageView[8];
	ImageView bird, birdSub;
	ImageView zoomView;
	MarginLayoutParams saveMargin;
	int saveHeight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		card[0] = (ImageView) findViewById(R.id.card01);
		card[1] = (ImageView) findViewById(R.id.card02);
		card[2] = (ImageView) findViewById(R.id.card03);
		card[3] = (ImageView) findViewById(R.id.card04);
		card[4] = (ImageView) findViewById(R.id.card05);
		card[5] = (ImageView) findViewById(R.id.card06);
		card[6] = (ImageView) findViewById(R.id.card07);
		card[7] = (ImageView) findViewById(R.id.card08);
		for (int i = 0; i < card.length; i++) {
			makeDrawable(i);
		}

		backgroundLayout = (LinearLayout) findViewById(R.id.backgroundLayout);
		Drawable t = backgroundLayout.getBackground();
		t.setAlpha(90);
		backgroundLayout.setBackground(t);

		zoomView = (ImageView) findViewById(R.id.zoomCardView);
		zoomLayout = (RelativeLayout) findViewById(R.id.zoomLayout);
		gameLayout = (RelativeLayout) findViewById(R.id.gameLayout);
		buttonLayout = (RelativeLayout) findViewById(R.id.buttonLayout);
		mProgressBar = (TextProgressBar) findViewById(R.id.timeBar);
		startButton = (Button) findViewById(R.id.start);
		boardView = (ImageView) findViewById(R.id.boardView);
		birdList[0] = (ImageView) findViewById(R.id.bird01);
		birdList[1] = (ImageView) findViewById(R.id.bird02);
		birdList[2] = (ImageView) findViewById(R.id.bird03);
		birdList[3] = (ImageView) findViewById(R.id.bird04);
		birdList[4] = (ImageView) findViewById(R.id.bird05);
		birdList[5] = (ImageView) findViewById(R.id.bird06);
		birdList[6] = (ImageView) findViewById(R.id.bird07);
		birdList[7] = (ImageView) findViewById(R.id.bird08);

		birdSubList[0] = (ImageView) findViewById(R.id.birdSub01);
		birdSubList[1] = (ImageView) findViewById(R.id.birdSub02);
		birdSubList[2] = (ImageView) findViewById(R.id.birdSub03);
		birdSubList[3] = (ImageView) findViewById(R.id.birdSub04);
		birdSubList[4] = (ImageView) findViewById(R.id.birdSub05);
		birdSubList[5] = (ImageView) findViewById(R.id.birdSub06);
		birdSubList[6] = (ImageView) findViewById(R.id.birdSub07);
		birdSubList[7] = (ImageView) findViewById(R.id.birdSub08);

		card[0].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				zoomingCard(0);
			}
		});
		card[1].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				zoomingCard(1);
			}
		});
		card[2].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				zoomingCard(2);
			}
		});
		card[3].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				zoomingCard(3);
			}
		});
		card[4].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				zoomingCard(4);
			}
		});
		card[5].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				zoomingCard(5);
			}
		});
		card[6].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				zoomingCard(6);
			}
		});
		card[7].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				zoomingCard(7);
			}
		});

		zoomView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				zoomLayout.setVisibility(View.GONE);
			}
		});

		birdList[0].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setRemoveBird(0);
			}
		});
		birdList[1].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setRemoveBird(1);
			}
		});
		birdList[2].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setRemoveBird(2);
			}
		});
		birdList[3].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setRemoveBird(3);
			}
		});
		birdList[4].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setRemoveBird(4);
			}
		});
		birdList[5].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setRemoveBird(5);
			}
		});
		birdList[6].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setRemoveBird(6);
			}
		});
		birdList[7].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setRemoveBird(7);
			}
		});

		birdSubList[0].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stateChange(0);
			}
		});
		birdSubList[1].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stateChange(1);
			}
		});
		birdSubList[2].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stateChange(2);
			}
		});
		birdSubList[3].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stateChange(3);
			}
		});
		birdSubList[4].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stateChange(4);
			}
		});
		birdSubList[5].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stateChange(5);
			}
		});
		birdSubList[6].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stateChange(6);
			}
		});
		birdSubList[7].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stateChange(7);
			}
		});

		boardView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					int x = (int) event.getX();
					int y = (int) event.getY();

					if (bird == null)
						return false;

					if (x > 20 && x < 120 && y > 190 && y < 290) {
						setBoardPosition(20, 190);
						Log.d("Touch Event", "Left 1");
					}

					if (x > 240 && x < 340 && y > 20 && y < 120) {
						setBoardPosition(240, 20);
						Log.d("Touch Event", "Left 2");
					}

					if (x > 360 && x < 460 && y > 20 && y < 120) {
						setBoardPosition(360, 20);

						Log.d("Touch Event", "Left 3");
					}

					if (x > 590 && x < 690 && y > 130 && y < 230) {
						setBoardPosition(590, 130);

						Log.d("Touch Event", "Left 4");
					}

					if (x > 590 && x < 690 && y > 250 && y < 350) {
						setBoardPosition(590, 250);

						Log.d("Touch Event", "Left 5");
					}

					if (x > 180 && x < 280 && y > 370 && y < 470) {
						setBoardPosition(180, 370);

						Log.d("Touch Event", "Left 6");
					}

					if (x > 300 && x < 400 && y > 370 && y < 470) {
						setBoardPosition(300, 370);
						Log.d("Touch Event", "Left 7");
					}

					if (x > 420 && x < 520 && y > 370 && y < 470) {
						setBoardPosition(420, 370);
						Log.d("Touch Event", "Left 8");
					}

				}
				return false;

			}
		});

		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GAMING = true;
				for (int i = 0; i < drawable.length; i++)
					drawable[i].startTransition(1500);

				buttonLayout.setVisibility(View.GONE);
				gameLayout.setVisibility(View.VISIBLE);
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
			while (nowValue > 0) {
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
			mProgressBar.setText("" + (int) (nowValue / 20));
		}
	};

	public void makeDrawable(int position) {
		Bitmap bmp = BitmapFactory.decodeResource(getResources(),
				numbers[position]);
		bmp = Bitmap.createScaledBitmap(bmp, 320, 400, false);

		int temp = ((int) (Math.random() * 8)) % 8;
		sub[position] = random[temp];
		Bitmap bmpSub = BitmapFactory.decodeResource(getResources(),
				sub[position]);
		bmpSub = Bitmap.createScaledBitmap(bmpSub, 320, 400, false);

		Drawable[] layers = new Drawable[2];
		layers[0] = new BitmapDrawable(getResources(), bmp);
		layers[1] = new BitmapDrawable(getResources(), bmpSub);

		drawable[position] = new TransitionDrawable(layers);

		card[position].setAdjustViewBounds(true);
		card[position].setImageDrawable(drawable[position]);
	}

	public void stateChange(int position) {
		if(GAMING == false) return;

		if (birdSub != null) {
			saveMargin.setMargins(0, saveHeight, 0, 0);
			birdSub.setLayoutParams(saveMargin);
		}
		bird = birdList[position];
		birdSub = birdSubList[position];
		saveMargin = (MarginLayoutParams) birdSubList[position]
				.getLayoutParams();
		saveHeight = saveMargin.topMargin;
		saveMargin.setMargins(0, 0, 0, 0);
		birdSubList[position].setLayoutParams(saveMargin);
	}

	public void setBoardPosition(int x, int y) {
		if(GAMING == false) return;

		bird.setVisibility(View.VISIBLE);
		MarginLayoutParams parms = (MarginLayoutParams) bird.getLayoutParams();
		parms.setMargins(x, y, 0, 0);
		bird.setLayoutParams(parms);
		saveMargin.setMargins(0, saveHeight, 0, 0);
		birdSub.setLayoutParams(saveMargin);
		birdSub.setVisibility(View.GONE);

		bird = null;
		birdSub = null;
	}

	public void setRemoveBird(int position) {
		if(GAMING == false) return;
		
		if (birdList[position].getVisibility() == View.VISIBLE) {
			birdList[position].setVisibility(View.GONE);
			MarginLayoutParams parms = (MarginLayoutParams) birdList[position]
					.getLayoutParams();
			parms.setMargins(0, 0, 0, 0);
			birdList[position].setLayoutParams(parms);
			birdSubList[position].setVisibility(View.VISIBLE);

		}
	}
	
	public void zoomingCard(int position){
		if(GAMING == false) return;
		
		zoomLayout.bringToFront();
		zoomView.setImageResource(sub[position]);
		zoomLayout.setVisibility(View.VISIBLE);
	}
}
