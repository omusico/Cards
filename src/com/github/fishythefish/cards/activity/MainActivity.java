package com.github.fishythefish.cards.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

import com.github.fishythefish.cards.R;

public class MainActivity extends Activity {

	private int black;
	private int darkgray;
	private int lightgray;
	private int white;
	
	private Button newGameButton;
	private Button joinGameButton;
	private EditText displayNameText;
	private EditText gameNumberText;
	
	private TextWatcher textWatcher = new TextWatcher() {
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			if (displayNameText.getText().toString().trim().length() > 0) {
				enableButton(newGameButton);
				if (gameNumberText.getText().toString().trim().length() > 0) {
					enableButton(joinGameButton);					
				} else {
					disableButton(joinGameButton);
				}
			} else {
				disableButton(newGameButton);
			}
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}
		
		@Override
		public void afterTextChanged(Editable s) {
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		black = getResources().getColor(R.color.black);
		darkgray = getResources().getColor(R.color.darkgray);
		lightgray = getResources().getColor(R.color.lightgray);
		white = getResources().getColor(R.color.white);
		
		newGameButton = (Button)findViewById(R.id.new_game_button);
		joinGameButton = (Button)findViewById(R.id.join_game_button);
		displayNameText = (EditText)findViewById(R.id.display_name_text);
		gameNumberText = (EditText)findViewById(R.id.game_number_text);
		
		setTitle("Cards");
		displayNameText.addTextChangedListener(textWatcher);
		gameNumberText.addTextChangedListener(textWatcher);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void enableButton(Button button) {
		button.setEnabled(true);
		button.setHintTextColor(white);
		button.setTextColor(white);
	}
	
	private void disableButton(Button button) {
		button.setEnabled(false);
		button.setHintTextColor(darkgray);
		button.setTextColor(darkgray);
	}

}
