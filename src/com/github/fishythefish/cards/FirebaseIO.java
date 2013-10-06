package com.github.fishythefish.cards;

import java.util.HashMap;

import com.firebase.client.Firebase;

public class FirebaseIO {

	public static final String HOME = "https://cardsapp.firebaseIO.com/";
	
	Firebase fb;
	
	public FirebaseIO(String address) {
		fb = new Firebase(address);
	}
	
	public void child(String childString) {
		fb.child(childString);
	}
	
	public void write(String childString, Object value) {
		fb.child(childString).setValue(value);
	}
	
	public void writeMultiple(HashMap<String, Object> map) {
		fb.setValue(map);
	}
	
	public void update(HashMap<String, Object> map) {
		fb.updateChildren(map);
	}
	
}
