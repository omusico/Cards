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
		return ((pile & in) == pile);
	}
	
	public void add(long in) {
		if (!checkContains(in))
			pile += in;
	}
}
