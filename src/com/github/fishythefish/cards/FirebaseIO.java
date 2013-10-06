package com.github.fishythefish.cards;

import com.firebase.client.Firebase;

public class FirebaseIO {
	
	String base_address;
	
	public FirebaseIO(String address) {
		base_address = address;
		
	}
	
	public void moveCard(String game, String orig, String dest, int origval, int destval) {
		Firebase fb = new Firebase(base_address + game + orig);
		fb.setValue(origval);
		
		fb = new Firebase(base_address + game + dest);
		fb.setValue(destval);
	}
	
}
