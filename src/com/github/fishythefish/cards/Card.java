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
	
	public static long toBinary(Card[] cards) {
		long binary = 0;
		for (Card card : cards) {
			binary |= 1 << toIndex(card);
		}
		return binary;
	}
	
	public static Card[] fromBinary(long binary) {
		binary &= (1L << 52) - 1;
		Card[] cards = new Card[Long.bitCount(binary)];
		int index = 0;
		while (index < cards.length) {
			int cardIndex = Long.numberOfTrailingZeros(binary);
			cards[index++] = fromIndex(cardIndex);
			binary -= 1 << cardIndex;
		}
		return cards;
	}
	
	public static int toIndex(Card card) {
		return card.suit.ordinal() * 13 + card.value.ordinal();
	}
	
	public static Card fromIndex(int index) {
		return new Card(Suit.values()[index / 13], Value.values()[index % 13]);
	}
	
	@Override
	public String toString() {
		return "Suit: " + suit + ", Value: " + value;
	}
	
}
