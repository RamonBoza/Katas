package org.boza.katas;

import java.util.Arrays;

public class HandRetriever {

	
	private static final int MAX_VALUE_OF_CARDS_FOR_POKER = 13;
	private static final int MAX_TYPES_OF_CARDS_FOR_POKER = 4;
	private int[] _numOfCards;
	private int[] _numOfTypes;
	
	private int[] _howManyRepeatedValuesOf;

	public PokerHandValue calculateHandValue(PokerHand hand){
		
		PokerHandValue handValue = PokerHandValue.NOTHING;

		preevaluateHand(hand);
		
		handValue = calculateHandValue(handValue);
		
		return handValue;
		
	}

	private PokerHandValue calculateHandValue(PokerHandValue handValue) {
		if(isHandARoyalStraight()){
			handValue = PokerHandValue.ROYAL_STRAIGHT;
		}
		else if(isHandAColorStraight()){
			handValue = PokerHandValue.COLOR_STRAIGHT;
		}
		else if(isHandAPoker()){
			handValue = PokerHandValue.POKER;
		}
		else if(isHandAFull()){
			handValue = PokerHandValue.FULL;
		}
		else if(isHandColor()){
			handValue = PokerHandValue.COLOR;
		}
		else if(isHandAStraight()){
			handValue = PokerHandValue.STRAIGHT;
		}
		else if(isHandADouble()){
			handValue = PokerHandValue.DOUBLE_PAIR;
		}
		else if(isHandATrio()){
			handValue = PokerHandValue.TRIO;
		}
		else if(isHandAPair()){
			handValue = PokerHandValue.PAIR;
		}
		return handValue;
	}
	
	private boolean isHandARoyalStraight() {
		return areAllDifferent() && areAllConsecutive() && isHandColor() && _numOfCards[0] > 0;
	}

	private boolean isHandAColorStraight() {
		return areAllDifferent() && areAllConsecutive() && isHandColor();
	}

	private boolean isHandColor() {
		int[] types = _numOfTypes.clone();
		Arrays.sort(types);
		return types[MAX_TYPES_OF_CARDS_FOR_POKER-1] == 5;
	}

	private boolean isHandAPoker(){
		return howManyPoker() == 1;
	}
	
	private boolean isHandAFull(){
		return howManyPairs() == 1 && howManyTrios() == 1;
	}
	
	private boolean isHandAStraight(){
		if(areAllDifferent()){
			return areAllConsecutive();
		}
		return false;
	}
	
	private boolean isHandADouble() {
		return howManyPairs() == 2;
	}

	private boolean isHandATrio() {
		return howManyPairs() == 0 && howManyTrios() == 1;
	}

	private boolean isHandAPair() {		
		return howManyPairs() == 1 && howManyTrios() == 0;
	}
	
	

	
	/** HELPERS */
	
	private int howManyPairs(){
		return _howManyRepeatedValuesOf[2];
	}
	
	private int howManyTrios(){
		return _howManyRepeatedValuesOf[3];
	}
	
	private int howManyPoker(){
		return _howManyRepeatedValuesOf[4];
	}
	
	private boolean areAllDifferent(){
		return _howManyRepeatedValuesOf[1] == 5;
	}
	
	private boolean areAllConsecutive(){
		int i = 0;
		boolean firstFound = false;
		while(!firstFound){
			firstFound=_numOfCards[i]>0?true:false;
			i++;
		}
		return (_numOfCards[i]&_numOfCards[i+1]&_numOfCards[i+2]&_numOfCards[i+3])>0;
		
	}
	
	private void preevaluateHand(PokerHand hand) {
		_numOfCards = new int[MAX_VALUE_OF_CARDS_FOR_POKER];
		_numOfTypes = new int[MAX_TYPES_OF_CARDS_FOR_POKER];
		
		_howManyRepeatedValuesOf = new int[5];
		
		Card[] cards = hand.getCards();
		for (Card card : cards) {
			_numOfCards[card.getCardValue()-1]++;
			_numOfTypes[card.getCardType().ordinal()]++;
		}
		
		for(int i = 0; i < _numOfCards.length; i++){
			_howManyRepeatedValuesOf[_numOfCards[i]]++;
		}
	}
}
