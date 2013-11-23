package com.example.ulruru;

import java.util.ArrayList;

import data.roomAdapter;
import data.roomData;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class JoinGameActivity extends Activity {
	
	ImageView return_btn;
	ListView room_list;
	roomAdapter adapter;
	ArrayList<roomData> room_arr = new ArrayList<roomData>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_join_game);
		
		return_btn = (ImageView)findViewById(R.id.joing_return_btn);
		room_list = (ListView)findViewById(R.id.joing_list);
		adapter = new roomAdapter(room_arr,JoinGameActivity.this);
		room_list.setAdapter(adapter);
		
		make_dummy();
		
		room_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				// TODO Auto-generated method stub
				if(room_arr.get(pos).getPsswd().length()==0)
				{
					Intent i = new Intent(JoinGameActivity.this,WaitRoomActivity.class);
					startActivity(i);
				}			
			}
		});
		return_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	public void make_dummy()
	{
		room_arr.add(new roomData(2,"","Ang?",new ArrayList<String>()));
		room_arr.add(new roomData(6,"","단호하네 단호박인줄",new ArrayList<String>()));
		room_arr.add(new roomData(4,"66","노쓰랜드로!",new ArrayList<String>()));
		room_arr.add(new roomData(3,"lol","LOL",new ArrayList<String>()));
		room_arr.add(new roomData(5,"","<^오^>",new ArrayList<String>()));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_join_game, menu);
		return true;
	}

}
