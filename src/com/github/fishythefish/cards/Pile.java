package com.github.fishythefish.cards;

public class Pile {
	private long pile;
	
	public Pile() {
		pile = 0;
	}
	
	public long getPile() {
		return pile;
	}
	
	public boolean checkContains(long in) {
		return ((pile | in) == pile);
	}
	
	public boolean add(long in) {
		if (!checkContains(in)) {
			pile += in;
			return true;
		}
		
		return false;
	}
	
	public boolean remove(long in) {
		if (checkContains(in)){
			pile -= in;
			return true;
		}
		
		return false;
	}
}
