package org.boza.katas;

public class Card {

	private int _cardValue;
	
	private CardType _cardType;

	
	public Card(int cardValue, CardType type){
		_cardValue = cardValue;
		_cardType = type;
	}
	
	public CardType getCardType() {
		return _cardType;
	}
	
	public int getCardValue(){
		return _cardValue;
	}
	
}
