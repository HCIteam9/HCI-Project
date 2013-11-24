package com.example.ulruru;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CardTableAdapter extends BaseAdapter {

	private static Context context;
	int[] numbers = new int[] { R.drawable.card01, R.drawable.card02,
			R.drawable.card03, R.drawable.card04, R.drawable.card01,
			R.drawable.card02, R.drawable.card03, R.drawable.card04};

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
			
			imageview = new ImageView(context);
			imageview.setAdjustViewBounds(true);
			imageview.setImageBitmap(bmp);
			
		}
		// TODO Auto-generated method stub
		return imageview;
	}

}
