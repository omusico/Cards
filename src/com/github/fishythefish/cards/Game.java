package com.github.fishythefish.cards;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

public class Game {
	public static String HOME = "https://cardsapp.firebaseIO.com/";
	
	long game_num;
	
	FirebaseIO fb;
	
	public Game(String name) {
		Firebase temp = new Firebase(HOME);
		
		temp.addValueEventListener(new ValueEventListener() {

			@Override
	    	public void onDataChange(DataSnapshot snap) {
	        	game_num = snap.getChildrenCount() + 1;
	    	}
			    
	    	@Override public void onCancelled() { }
		});
		
		fb = new FirebaseIO(HOME + game_num);
		//fb.setValue();
		
		//fb = new FirebaseIO(HOME + game_num + "/" + name);
		fb.write(name, 0);
	}
	
	public Game(String number, String name) {
		game_num = Integer.parseInt(number);
		fb = new FirebaseIO(HOME + game_num);
		fb.write(name, 0);
	}
	
	public long getGameNum() {
		return game_num;
	}
	
	public FirebaseIO getFIO() {
		return fb;
	}
}
