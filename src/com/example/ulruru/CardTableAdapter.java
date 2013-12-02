package com.example.ulruru;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CardTableAdapter extends BaseAdapter {
	private TransitionDrawable[] drawable = new TransitionDrawable[8];

	private static Context context;
	int[] numbers = new int[] { R.drawable.ulruru_card1,
			R.drawable.ulruru_card2, R.drawable.ulruru_card3,
			R.drawable.ulruru_card4, R.drawable.ulruru_card1,
			R.drawable.ulruru_card2, R.drawable.ulruru_card3,
			R.drawable.ulruru_card4 };

	int[] sub = new int[] { R.drawable.card01, R.drawable.card02,
			R.drawable.card03, R.drawable.card04, R.drawable.card01,
			R.drawable.card02, R.drawable.card03, R.drawable.card04 };

	public CardTableAdapter(Context context) {
		this.context = context;
	}

	public CardTableAdapter(Context context, int[] numbers) {
		this.context = context;
		this.numbers = numbers;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return numbers.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return numbers[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageview = null;

		if (null != convertView)
			imageview = (ImageView) convertView;
		else {

			Bitmap bmp = BitmapFactory.decodeResource(context.getResources(),
					numbers[position]);
			bmp = Bitmap.createScaledBitmap(bmp, 320, 400, false);

			Bitmap bmpSub = BitmapFactory.decodeResource(
					context.getResources(), numbers[position]);
			bmpSub = Bitmap.createScaledBitmap(bmpSub, 320, 400, false);

			Drawable[] layers = new Drawable[2];
			layers[0] = new BitmapDrawable(context.getResources(), bmp);
			layers[1] = new BitmapDrawable(context.getResources(), bmpSub);

			drawable[position] = new TransitionDrawable(layers);

			imageview = new ImageView(context);
			imageview.setAdjustViewBounds(true);
			imageview.setImageDrawable(drawable[position]);
			drawable[position].startTransition(1000);
			

		}
		// TODO Auto-generated method stub
		return imageview;
	}

	public void startTransition() {
		for (int i = 0; i < drawable.length; i++) {
			drawable[i].startTransition(1000);
		}
	}

}
