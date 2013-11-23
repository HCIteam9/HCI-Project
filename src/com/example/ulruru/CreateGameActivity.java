package com.example.ulruru;

import java.util.ArrayList;
import java.util.Random;

import data.roomData;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class CreateGameActivity extends Activity {

	ImageView Return_btn, Creategame_btn;
	EditText Gamename_edit,Password_edit;
	Spinner NofPlayer_spinner;
	String Gamename,Psswd;
	int NumofPlayer;
	ArrayAdapter<Integer> adapter;
	Integer[] nofp = new Integer[5];
	String[] nick= {"Teemo","TamaDora","Ilidan","Horus","JimRaynor","Ahri","Anduin"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_game);
		
		for(int i=2 ; i<=6 ; i++)
			nofp[i-2]=i;
		
		Return_btn = (ImageView)findViewById(R.id.createg_return_btn);
		Creategame_btn = (ImageView)findViewById(R.id.createg_createg_btn);
		Gamename_edit = (EditText)findViewById(R.id.createg_gname_edit);
		Password_edit = (EditText)findViewById(R.id.createg_pass_edit);
		NofPlayer_spinner = (Spinner)findViewById(R.id.createg_N_spinner);
		
		adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,nofp);
		NofPlayer_spinner.setAdapter(adapter);
		
		Return_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		Creategame_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Gamename = Gamename_edit.getText().toString();
				Psswd = Password_edit.getText().toString();
				NumofPlayer = (Integer)NofPlayer_spinner.getSelectedItem();
				
				ArrayList<String> temp = new ArrayList<String>();
				for(int i=0 ; i<NumofPlayer ; i++)
					temp.add(nick[ new Random().nextInt(nick.length) ]);
				
				roomData.rdat.setInstance(Gamename, NumofPlayer, Psswd,temp);
				
				//서버에 게임 생성 처리 
				Intent i = new Intent(CreateGameActivity.this,DiffSelectActivity.class);
				startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_create_game, menu);
		return true;
	}

}
