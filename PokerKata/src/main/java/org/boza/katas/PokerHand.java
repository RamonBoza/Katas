package org.boza.katas;

public class PokerHand {

	private Card[] _hand = new Card[5];
	
	public PokerHand(Card ... cards) throws Exception{
		if(cards.length != 5)
			throw new Exception("You must initialize this class with 5 cards");
		for(int i = 0; i < 5; i++)
			_hand[i] = cards[i];
	}
	
	public Card[] getCards(){
		return _hand;
	}
	
	public Card getCard(final int cardPosition) throws Exception{
		if(cardPosition<1 || cardPosition > 5){
			throw new Exception("There are only 5 cards");
		}
		
		return _hand[cardPosition - 1];
	}
}
