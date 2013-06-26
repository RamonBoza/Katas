package org.boza.katas;

import org.boza.katas.PotterPriceCalculator;
import org.junit.*;

/**
 * Unit test for simple App.
 */
public class PotterPriceCalculatorTest 
{
	@Test
	public void testNoBooks(){
		int[] booksSet = new int[]{0};
		double price = new PotterPriceCalculator().price(booksSet);
		Assert.assertEquals("Price for no books is 0",0,price,0);
	}

	@Test
	public void testOneBook(){
		int[] booksSet = new int[]{1};
		double price = new PotterPriceCalculator().price(booksSet);
		Assert.assertEquals("Price for no books is 8",8,price,0);
	}

	@Test
	public void testTwoDifferentBooks(){
		int[] booksSet = new int[]{1,1};
		double price = new PotterPriceCalculator().price(booksSet);
		Assert.assertEquals("Price for no books is 15.2",15.2,price,0);
	}

	@Test
	public void testTwoSameBooks(){
		int[] booksSet = new int[]{2};
		double price = new PotterPriceCalculator().price(booksSet);
		Assert.assertEquals("Price for two same books is 16",16,price,0.01);
	}
	@Test
	public void testDisasterBooksSet(){
		int[] booksSet = new int[]{4,2,2,3,1};
		double price = new PotterPriceCalculator().price(booksSet);
		Assert.assertEquals("Price for two same books is 70.4",70.4,price,0.01);
	}


}

