package com.github.fishythefish.cards;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

public class Game {
	public static String HOME = "https://cardsapp.firebaseIO.com/test/";
	
	long game_num;
	
	FirebaseIO fb;
	
	public Game() {
		Firebase temp = new Firebase(HOME);
		
		temp.addValueEventListener(new ValueEventListener() {

			@Override
	    	public void onDataChange(DataSnapshot snap) {
	        	game_num = snap.getChildrenCount() + 1;
	    	}
			    
	    	@Override public void onCancelled() { }
		});
		
		fb = new FirebaseIO(HOME + game_num);
	}
	
	public long getGameNum() {
		return game_num;
	}
}
