package com.github.fishythefish.cards;

import com.firebase.client.Firebase;

public class FirebaseIO {
	
	Firebase fb;
	
	public FirebaseIO(String address) {
		fb = new Firebase(address);
	}
	
	
}
