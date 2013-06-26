package org.boza.katas;

/**
 * Hello world!
 *
 */
public class PotterPriceCalculator 
{
	public double price(int[] booksSet){
		double price = 0;	
		int booksInSerie;
		double[] priceDiscount= new double[]{0, 1, 0.95,0.90,0.85,0.50};
		int priceBase = 8;
		do{
			booksInSerie = 0;			
			for(int i = 0; i < booksSet.length; i++){
				if (booksSet[i] > 0){
					booksInSerie++;
					booksSet[i]--;
				}
			}
			price += booksInSerie * priceBase * priceDiscount[booksInSerie];

		}while (booksInSerie > 0);	


		return price;
	}
}
