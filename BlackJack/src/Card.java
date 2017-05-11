/* Copyright Mark Frezell 2017
 * All Rights Reserved
 */

class Card {

	 int cardNum;	//holds a number 2 through 14(11-Jack, 12-Queen, 13-King, 14-Ace)
	 char cardSuit;	//holds the suit
	
	public Card(char suit, int number){//simple constructor for the Card class
		cardNum=number;
		cardSuit=suit;
	}	
	
	public char getSuit(){//returns the suit of the card
		return cardSuit;
	}
	public int getNumber(){//returns the number of the card
		return cardNum;
	}
}

