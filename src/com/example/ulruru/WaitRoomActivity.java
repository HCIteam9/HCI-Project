package com.example.ulruru;

import java.util.ArrayList;

import data.roomData;
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
import android.widget.Toast;

public class WaitRoomActivity extends Activity {

	ArrayList<TextView> p_txt = new ArrayList<TextView>();
	boolean ready_chk[] = new boolean[10];
	TextView roomname_txt,title;
	ImageView return_btn,RS_btn;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wait_room);
		
		return_btn = (ImageView)findViewById(R.id.wait_return_btn);
		
		p_txt.add( (TextView)findViewById(R.id.wait_player1) );
		p_txt.add( (TextView)findViewById(R.id.wait_player2) );
		p_txt.add( (TextView)findViewById(R.id.wait_player3) );
		p_txt.add( (TextView)findViewById(R.id.wait_player4) );
		p_txt.add( (TextView)findViewById(R.id.wait_player5) );
		p_txt.add( (TextView)findViewById(R.id.wait_player6) );
		return_btn = (ImageView)findViewById(R.id.wait_return_btn);
		RS_btn = (ImageView)findViewById(R.id.wait_RS_btn);
		roomname_txt = (TextView)findViewById(R.id.wait_room_title);
		title =  (TextView)findViewById(R.id.wait_title_textview);
		
		for(int i=0 ; i<roomData.rdat.getPlayer().size() ; i++)
		{
			p_txt.get(i).setText(roomData.rdat.getPlayer().get(i));
		}
		for(int i=roomData.rdat.getPlayer().size() ; i<6 ; i++)
			p_txt.get(i).setText("");
		if(userData.usr.isRoom_maker())
			RS_btn.setImageResource(R.drawable.btn_gamestart);
		else
			RS_btn.setImageResource(R.drawable.btn_ready);
		roomname_txt.setText("Room name: "+roomData.rdat.getGamename());
		
		return_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		RS_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(userData.usr.isRoom_maker())
				{
					if(chkready())
					{
						Intent i = new Intent(WaitRoomActivity.this,GameActivity.class);
						startActivity(i);
					}
					else
						makeToast("All players must ready");
				}
				else
				{
					if(userData.usr.isReady())
						RS_btn.setImageResource(R.drawable.btn_ready);
					else
						RS_btn.setImageResource(R.drawable.cancel_btn);
					userData.usr.setReady(!userData.usr.isReady());
				}
			}
		});		
		
		for(int i=0 ; i<roomData.rdat.getMax_size() ; i++)
		{
			final int ti = i;
			p_txt.get(i).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if(ready_chk[ti])
						p_txt.get(ti).setBackgroundResource(0);
					else
						p_txt.get(ti).setBackgroundResource(R.drawable.highlight);
					
					ready_chk[ti]=!ready_chk[ti];
				
				}
			});
		}
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/SHOWG.TTF");
		title.setTypeface(typeFace);
		roomname_txt.setTypeface(typeFace);
	}
	
	public boolean chkready()
	{
		for(int i=0 ; i<roomData.rdat.getMax_size() ; i++)
		{
			if(ready_chk[i]==false)
				return false;
		}
		return true;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_wait_room, menu);
		return true;
	}
	void makeToast(final String msg){
    	new Thread(){
    		@Override
    		public void run() {
    			// TODO Auto-generated method stub
		super.run();
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
				}
			});
		}
	}.start();
}

}

