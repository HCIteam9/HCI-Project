package com.example.ulruru;

import java.util.ArrayList;
import data.roomAdapter;
import data.roomData;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class JoinGameActivity extends Activity {
	
	ImageView return_btn;
	ListView room_list;
	roomAdapter adapter;
	ArrayList<roomData> room_arr = new ArrayList<roomData>();
	String pass;
	int tpos;
	
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
					roomData.rdat.setInstance(room_arr.get(pos).getGamename(), room_arr.get(pos).getMax_size(), room_arr.get(pos).getPsswd(), room_arr.get(pos).getPlayer());
					Intent i = new Intent(JoinGameActivity.this,WaitRoomActivity.class);
					startActivity(i);
				}
				else
				{
					pass=room_arr.get(pos).getPsswd();
					tpos=pos;
					showDialog(1);
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
		room_arr.add(new roomData(3,"","Ang?",new ArrayList<String>()));
		room_arr.get(0).getPlayer().add("Van Darkholm");
		room_arr.get(0).getPlayer().add("Billy Herrington");
		room_arr.get(0).getPlayer().add("Hong Seok-Cheon");
		
		room_arr.add(new roomData(6,"","단호하네 단호박인줄",new ArrayList<String>()));
		room_arr.add(new roomData(4,"66","노쓰랜드로!",new ArrayList<String>()));
		room_arr.get(2).getPlayer().add("은빛성기사");
		room_arr.get(2).getPlayer().add("센진");
		room_arr.get(2).getPlayer().add("알도르");
		
		room_arr.add(new roomData(3,"lol","LOL",new ArrayList<String>()));
		room_arr.add(new roomData(5,"","<^오^>",new ArrayList<String>()));
		room_arr.get(4).getPlayer().add("티모");
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_join_game, menu);
		return true;
	}
	
	DialogInterface mPopupDlg = null;
	protected Dialog onCreateDialog(int id) {
		  
		final EditText pass_edit;
		final ImageView ok_btn,cancel_btn;
		
		
		LayoutInflater vi  = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		View lo = (RelativeLayout)vi.inflate(R.layout.room_pass_diag, null);
		 
		dialog.setView(lo);  
		dialog.setTitle("Check Password");
		
		pass_edit=(EditText)lo.findViewById(R.id.rpass_edit);
		ok_btn=(ImageView)lo.findViewById(R.id.rpass_ok);
		cancel_btn=(ImageView)lo.findViewById(R.id.rpass_cancel);
		
		ok_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(checkpass(pass_edit.getText().toString()))
				{
					makeToast("Correct! Joining room....");
					roomData.rdat.setInstance(room_arr.get(tpos).getGamename(), room_arr.get(tpos).getMax_size(), room_arr.get(tpos).getPsswd(), room_arr.get(tpos).getPlayer());
					Intent i = new Intent(JoinGameActivity.this,WaitRoomActivity.class);
					startActivity(i);
				}
				else
				{
					makeToast("Wrong password!");
				}
				mPopupDlg.dismiss();		
			}
		});
		cancel_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mPopupDlg.dismiss();	
			}
		});
		
		mPopupDlg = dialog.show();
		return null;
	 }
	public boolean checkpass(String inp)
	{
		if(pass.equals(inp))
			return true;
		else
			return false;
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
