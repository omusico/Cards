package com.github.fishythefish.cards;

public class Card {

	enum Suit {CLUB, DIAMOND, HEART, SPADE}
	
	enum Value {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}
	
	private Suit suit;
	private Value value;
	
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Value getValue() {
		return value;
	}
	
}
