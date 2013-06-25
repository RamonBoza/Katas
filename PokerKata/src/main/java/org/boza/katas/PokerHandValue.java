package org.boza.katas;

public enum PokerHandValue {

	NOTHING(0),
	
	PAIR(1),
		
	DOUBLE_PAIR(2),
	
	TRIO(3),
		
	STRAIGHT(4),
	
	COLOR(5),
	
	FULL(6),
	
	POKER(7),

	COLOR_STRAIGHT(8),
	
	ROYAL_STRAIGHT(9);

	private int _handValue;
	
	private PokerHandValue(final int value){
		_handValue = value;
	}
	
	public int getHandValue(){ 
		return _handValue;
	}
}
