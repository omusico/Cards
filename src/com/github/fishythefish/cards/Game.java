package com.github.fishythefish.cards;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

public class Game {
	private static final String HOME = "https://cardsapp.firebaseIO.com/";
	
	long gameNum;
	
	FirebaseIO fb;
	
	public Game(final Object value) {
		Firebase temp = new Firebase(HOME);
		
		temp.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
	    	public void onDataChange(DataSnapshot snap) {
	        	gameNum = snap.getChildrenCount();
	    		
	    		fb = new FirebaseIO(HOME);
	    		fb.write(Long.toString(gameNum), value);
	    	}
			    
	    	@Override public void onCancelled() {
	    		System.err.println("Listener was cancelled");
	    	}
		});
	}
	
	public Game(long number) {
		gameNum = number;
		fb = new FirebaseIO(HOME + number);
	}
	
	public long getGameNum() {
		return gameNum;
	}
	
	public FirebaseIO getFIO() {
		return fb;
	}
}
