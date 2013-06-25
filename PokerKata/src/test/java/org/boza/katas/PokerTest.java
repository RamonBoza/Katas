package org.boza.katas;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class PokerTest 
{
	
	private HandRetriever _retriever;

	@Before
	public void before(){
		_retriever = new HandRetriever();
	}
	
    @Test
	public void testNoHandIsNothing() throws Exception {
    	Card twoHearts = new Card(2, CardType.HEART);
    	Card threeHearts = new Card(3, CardType.HEART);
    	Card sixHearts = new Card(6, CardType.HEART);
    	Card eightClubs = new Card(8, CardType.CLUB);
    	Card elevenHearts = new Card(11, CardType.DIAMOND);
    	
		PokerHand hand = new PokerHand(twoHearts,threeHearts,sixHearts,eightClubs,elevenHearts);
		PokerHandValue calculatedValue = _retriever.calculateHandValue(hand);
		Assert.assertEquals("The hand must have no value",PokerHandValue.NOTHING, calculatedValue);
	}
    
    @Test
	public void testWeHaveAPair() throws Exception {
    	Card twoHearts = new Card(2, CardType.HEART);
    	Card threeHearts = new Card(3, CardType.HEART);
    	Card sixHearts = new Card(6, CardType.HEART);
    	Card twoClubs = new Card(2, CardType.CLUB);
    	Card elevenHearts = new Card(11, CardType.DIAMOND);
    	
		PokerHand hand = new PokerHand(twoHearts,threeHearts,sixHearts,twoClubs,elevenHearts);
		PokerHandValue calculatedValue = _retriever.calculateHandValue(hand);
		Assert.assertEquals("The hand must be a pair",PokerHandValue.PAIR, calculatedValue);
	}
    
    @Test
	public void testWeHaveADoublePair() throws Exception {
    	Card twoHearts = new Card(2, CardType.HEART);
    	Card threeHearts = new Card(3, CardType.HEART);
    	Card sixHearts = new Card(6, CardType.HEART);
    	Card twoClubs = new Card(2, CardType.CLUB);
    	Card sixSpades = new Card(6, CardType.SPADES);
    	
		PokerHand hand = new PokerHand(twoHearts,threeHearts,sixHearts,twoClubs,sixSpades);
		PokerHandValue calculatedValue = _retriever.calculateHandValue(hand);
		Assert.assertEquals("The hand must be a pair",PokerHandValue.DOUBLE_PAIR, calculatedValue);
	}
    
    
    @Test
	public void testWeHaveATrio() throws Exception {
    	Card twoHearts = new Card(2, CardType.HEART);
    	Card threeHearts = new Card(3, CardType.HEART);
    	Card sixHearts = new Card(6, CardType.HEART);
    	Card twoClubs = new Card(2, CardType.CLUB);
    	Card twoSpades= new Card(2, CardType.SPADES);
    	
		PokerHand hand = new PokerHand(twoHearts,threeHearts,sixHearts,twoClubs,twoSpades);
		PokerHandValue calculatedValue = _retriever.calculateHandValue(hand);
		Assert.assertEquals("The hand must be a pair",PokerHandValue.TRIO, calculatedValue);
	}
    
    @Test
	public void testWeHaveAStraight() throws Exception {
    	Card twoHearts = new Card(2, CardType.HEART);
    	Card threeHearts = new Card(3, CardType.HEART);
    	Card fourHearts = new Card(4, CardType.HEART);
    	Card fiveClubs = new Card(5, CardType.CLUB);
    	Card sixSpades= new Card(6, CardType.SPADES);
    	
		PokerHand hand = new PokerHand(twoHearts,threeHearts,fourHearts,fiveClubs,sixSpades);
		PokerHandValue calculatedValue = _retriever.calculateHandValue(hand);
		Assert.assertEquals("The hand must be a pair",PokerHandValue.STRAIGHT, calculatedValue);
	}
    
    @Test
	public void testWeHaveColor() throws Exception {
    	Card twoHearts = new Card(2, CardType.HEART);
    	Card threeHearts = new Card(3, CardType.HEART);
    	Card sixHearts = new Card(6, CardType.HEART);
    	Card eightHeart = new Card(8, CardType.HEART);
    	Card elevenHeart= new Card(11, CardType.HEART);
    	
		PokerHand hand = new PokerHand(twoHearts,threeHearts,sixHearts,eightHeart,elevenHeart);
		PokerHandValue calculatedValue = _retriever.calculateHandValue(hand);
		Assert.assertEquals("The hand must be a pair",PokerHandValue.COLOR, calculatedValue);
	}
    
    @Test
	public void testWeHaveAFull() throws Exception {
    	Card twoHearts = new Card(2, CardType.HEART);
    	Card threeHearts = new Card(3, CardType.HEART);
    	Card threeSpades = new Card(3, CardType.SPADES);
    	Card twoClubs = new Card(2, CardType.CLUB);
    	Card twoSpades= new Card(2, CardType.SPADES);
    	
		PokerHand hand = new PokerHand(twoHearts,threeHearts,threeSpades,twoClubs,twoSpades);
		PokerHandValue calculatedValue = _retriever.calculateHandValue(hand);
		Assert.assertEquals("The hand must be a pair",PokerHandValue.FULL, calculatedValue);
	}

    @Test
	public void testWeHaveAPoker() throws Exception {
    	Card twoHearts = new Card(2, CardType.HEART);
    	Card threeHearts = new Card(3, CardType.HEART);
    	Card twoDiamonds = new Card(2, CardType.DIAMOND);
    	Card twoClubs = new Card(2, CardType.CLUB);
    	Card twoSpades= new Card(2, CardType.SPADES);
    	
		PokerHand hand = new PokerHand(twoHearts,threeHearts,twoDiamonds,twoClubs,twoSpades);
		PokerHandValue calculatedValue = _retriever.calculateHandValue(hand);
		Assert.assertEquals("The hand must be a pair",PokerHandValue.POKER, calculatedValue);
	}
	
    @Test
	public void testWeHaveAColorStraight() throws Exception {
    	Card twoHearts = new Card(2, CardType.HEART);
    	Card threeHearts = new Card(3, CardType.HEART);
    	Card fourHearts = new Card(4, CardType.HEART);
    	Card fiveHeart = new Card(5, CardType.HEART);
    	Card sixHeart= new Card(6, CardType.HEART);
    	
		PokerHand hand = new PokerHand(twoHearts,threeHearts,fourHearts,fiveHeart,sixHeart);
		PokerHandValue calculatedValue = _retriever.calculateHandValue(hand);
		Assert.assertEquals("The hand must be a pair",PokerHandValue.COLOR_STRAIGHT, calculatedValue);
	}
    
    @Test
	public void testWeHaveARoyalStraight() throws Exception {
    	Card twoHearts = new Card(2, CardType.HEART);
    	Card threeHearts = new Card(3, CardType.HEART);
    	Card fourHearts = new Card(4, CardType.HEART);
    	Card fiveHeart = new Card(5, CardType.HEART);
    	Card aceHeart= new Card(1, CardType.HEART);
    	
		PokerHand hand = new PokerHand(twoHearts,threeHearts,fourHearts,fiveHeart,aceHeart);
		PokerHandValue calculatedValue = _retriever.calculateHandValue(hand);
		Assert.assertEquals("The hand must be a pair",PokerHandValue.ROYAL_STRAIGHT, calculatedValue);
	}
}
