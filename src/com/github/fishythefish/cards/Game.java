package com.github.fishythefish.cards;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

public class Game {
	
	long gameNum;
	
	FirebaseIO fb;
	
	public Game(final String name) {
		Firebase temp = new Firebase(FirebaseIO.HOME);
		
		temp.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
	    	public void onDataChange(DataSnapshot snap) {
	        	gameNum = snap.getChildrenCount();
	    		
	    		fb = new FirebaseIO(FirebaseIO.HOME);
	    		fb.child(Long.toString(gameNum));
	    		addPlayer(name);
	    	}
			    
	    	@Override public void onCancelled() {
	    		System.err.println("Listener was cancelled");
	    	}
		});
	}
	
	public Game(long number) {
		gameNum = number;
		fb = new FirebaseIO(FirebaseIO.HOME + number);
	}
	
	public void addPlayer(final String name) {
		Firebase temp = new Firebase(FirebaseIO.HOME + gameNum + "/");
		
		temp.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
	    	public void onDataChange(DataSnapshot snap) {
	        	long players = snap.getChildrenCount();
	    		
	    		fb = new FirebaseIO(FirebaseIO.HOME + gameNum + "/");
	    		fb.write(Long.toString(players), name);
	    	}
			    
	    	@Override public void onCancelled() {
	    		System.err.println("Listener was cancelled");
	    	}
		});
	}
	
	public long getGameNum() {
		return gameNum;
	}
	
	public FirebaseIO getFIO() {
		return fb;
	}
}
