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

	private TextWatcher textWatcher = new TextWatcher() {
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			EditText displayNameText = (EditText)findViewById(R.id.display_name_text);
			EditText gameNumberText = (EditText)findViewById(R.id.game_number_text);
			((Button)findViewById(R.id.new_game_button)).setEnabled(displayNameText.getText().toString().trim().length() > 0);
			((Button)findViewById(R.id.join_game_button)).setEnabled(displayNameText.getText().toString().trim().length() > 0 & gameNumberText.getText().toString().trim().length() > 0);
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
		
		setTitle("Cards");
		EditText displayNameText = (EditText)findViewById(R.id.display_name_text);
		EditText gameNumberText = (EditText)findViewById(R.id.game_number_text);
		displayNameText.addTextChangedListener(textWatcher);
		gameNumberText.addTextChangedListener(textWatcher);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
