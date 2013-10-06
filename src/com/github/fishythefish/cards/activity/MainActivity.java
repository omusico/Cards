package com.github.fishythefish.cards.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.github.fishythefish.cards.Card;
import com.github.fishythefish.cards.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setTitle("Cards");
		long binary = 1 << 63;
		for (Card card : Card.fromBinary(binary)) {
			System.out.println(card.toString());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
