package com.github.fishythefish.cards.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import com.github.fishythefish.cards.R;

public class LobbyActivity extends Activity {

	private boolean host;
	private String name;
	
	private int black;
	private int darkgray;
	private int lightgray;
	private int white;
	
	private TableLayout table;
	private final LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lobby);
		
		black = getResources().getColor(R.color.black);
		darkgray = getResources().getColor(R.color.darkgray);
		lightgray = getResources().getColor(R.color.lightgray);
		white = getResources().getColor(R.color.white);
		
		Intent intent = getIntent();
		
		host = intent.getBooleanExtra("Host", false);
		name = intent.getStringExtra("Name");
		
		table = (TableLayout)findViewById(R.id.table_layout);
		
		setTitle("Game #000000");
		TableRow hostRow = new TableRow(this);
		hostRow.setLayoutParams(lp);
		TextView nameView = new TextView(this);
		nameView.setLayoutParams(lp);
		nameView.setText(name + " (Host)");
		nameView.setTextColor(white);
		hostRow.addView(nameView);
		table.addView(hostRow);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lobby, menu);
		return true;
	}

}
