/* Copyright Mark Frezell 2017
 * All Rights Reserved
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Deck {//only actually uses TWO suits

	static Queue <Card> deck = new LinkedList<Card>();
	static int pot=0;

	/*************************************** CREATING ALL THE DANG CARDS ***************************************/

	static Card spade2 = new Card('@',2);
	static Card spade3 = new Card('@',3);
	static Card spade4 = new Card('@',4);
	static Card spade5 = new Card('@',5);
	static Card spade6 = new Card('@',6);
	static Card spade7 = new Card('@',7);
	static Card spade8 = new Card('@',8);
	static Card spade9 = new Card('@',9);		//spade
	static Card spade10 = new Card('@',10);
	static Card spade11 = new Card('@',11);
	static Card spade12 = new Card('@',12);
	static Card spade13= new Card('@',13);
	static Card spade14 = new Card('@',14);

	static Card diamond2 = new Card('^',2);
	static Card diamond3 = new Card('^',3);
	static Card diamond4 = new Card('^',4);
	static Card diamond5 = new Card('^',5);
	static Card diamond6 = new Card('^',6);
	static Card diamond7 = new Card('^',7);
	static Card diamond8 = new Card('^',8);
	static Card diamond9 = new Card('^',9);		//diamond
	static Card diamond10 = new Card('^',10);
	static Card diamond11 = new Card('^',11);
	static Card diamond12 = new Card('^',12);
	static Card diamond13 = new Card('^',13);
	static Card diamond14 = new Card('^',14);

	static Card clover2 = new Card('$',2);
	static Card clover3 = new Card('$',3);
	static Card clover4 = new Card('$',4);
	static Card clover5 = new Card('$',5);
	static Card clover6 = new Card('$',6);
	static Card clover7 = new Card('$',7);
	static Card clover8 = new Card('$',8);
	static Card clover9 = new Card('$',9);			//clover
	static Card clover10 = new Card('$',10);
	static Card clover11 = new Card('$',11);
	static Card clover12 = new Card('$',12);
	static Card clover13 = new Card('$',13);
	static Card clover14 = new Card('$',14);

	static Card heart2 = new Card('*',2);
	static Card heart3 = new Card('*',3);
	static Card heart4 = new Card('*',4);
	static Card heart5 = new Card('*',5);
	static Card heart6 = new Card('*',6);
	static Card heart7 = new Card('*',7);
	static Card heart8 = new Card('*',8);
	static Card heart9 = new Card('*',9);		//heart
	static Card heart10 = new Card('*',10);
	static Card heart11 = new Card('*',11);
	static Card heart12 = new Card('*',12);
	static Card heart13 = new Card('*',13);
	static Card heart14 = new Card('*',14);

	public static Queue<Card> generateDeck(){//places all cards in the deck

		deck.add(spade2);
		deck.add(spade3);
		deck.add(spade4);
		deck.add(spade5);
		deck.add(spade6);
		deck.add(spade7);		//adding all the cards of the appropriate suit into player one's hand (Queue)
		deck.add(spade8);
		deck.add(spade9);
		deck.add(spade10);
		deck.add(spade11);
		deck.add(spade12);
		deck.add(spade13);
		deck.add(spade14);
		deck.add(diamond2);
		deck.add(diamond3);
		deck.add(diamond4);
		deck.add(diamond5);
		deck.add(diamond6);
		deck.add(diamond7);		//adding all the cards of the appropriate suit into player two's hand (Queue)
		deck.add(diamond8);
		deck.add(diamond9);
		deck.add(diamond10);
		deck.add(diamond11);
		deck.add(diamond12);
		deck.add(diamond13);
		deck.add(diamond14);
		deck.add(clover2);
		deck.add(clover3);
		deck.add(clover4);
		deck.add(clover5);
		deck.add(clover6);
		deck.add(clover7);		//adding all the cards of the appropriate suit into player one's hand (Queue)
		deck.add(clover8);
		deck.add(clover9);
		deck.add(clover10);
		deck.add(clover11);
		deck.add(clover12);
		deck.add(clover13);
		deck.add(clover14);
		deck.add(heart2);
		deck.add(heart3);
		deck.add(heart4);
		deck.add(heart5);
		deck.add(heart6);
		deck.add(heart7);		//adding all the cards of the appropriate suit into player two's hand (Queue)
		deck.add(heart8);
		deck.add(heart9);
		deck.add(heart10);
		deck.add(heart11);
		deck.add(heart12);
		deck.add(heart13);
		deck.add(heart14);

		Collections.shuffle((List<?>) deck);//shuffles up the hand

		return deck;//gives the queue to the main class
	}

	public static Queue<Card> getCards(Queue<Card> deck, Queue<Card> hand){//gives players cards
		if(!deck.isEmpty())hand.add(deck.poll()); else System.out.println("deck is empty (getCards)");
		if(!deck.isEmpty())hand.add(deck.poll()); else System.out.println("deck is empty (getCards)");
		return hand;

	}

	public static Card addCard(Queue<Card>deck){//to add a card to a player's hand, call handName.add(addCard(deck));
		if(!deck.isEmpty()) return(deck.poll());
		return null;

	}

	public static void setPot(int amount){//player brings chips to the game
		pot=amount;
	}
	
	public static int doublePot(){//player takes their chips and leaves the game
		int value = 2*pot;
		pot=0;
		return value;
	}

	public static String faceConvert(int number){//converts the face VALUES to the actual letter represented by it
		String convertion="";

		if (number==10) convertion="T";
		else if(number==11) convertion="J";
		else if(number==12) convertion="Q";
		else if(number==13) convertion="K";
		else if (number==14) convertion="A";
		else convertion = ""+number;

		return convertion;
	}

	public static int convertNumber(int number){
		int newNum=0;

		if (number==10) newNum=10;
		else if(number==11) newNum=10;
		else if(number==12) newNum=10;
		else if(number==13) newNum=10;
		else if (number==14) newNum=1;
		else newNum = number;

		return newNum;
	}

	public static int getTotal(Queue<Card>hand){
		Queue<Card> thisHand = new LinkedList<Card>(hand);
		int total=0;

		while(!thisHand.isEmpty()){
			total+=convertNumber(thisHand.poll().getNumber());
		}

		
		return total;
	}
	

	public static void displayGameboard(Queue<Card> play, Queue<Card> comp, int turn){//displays game board of the player that's turn it is
		int counterPlayer = play.size();
		int counterDealer = comp.size();
		Ess.DEBUG(false, "playerSize: "+counterPlayer+". dealerSize: "+counterDealer+".");
		char tempChar = ' ';
		String tempStringNum = " ";

		Queue<Card> computer = new LinkedList<Card>(comp);//cloning queues (non destructive)
		Queue<Card> player = new LinkedList<Card>(play);

		char playerChar[] = new char[2];
		char computerChar[] = new char[2];
		String playerNum[] = new String[2];
		String computerNum[] = new String[2];

		/*START adding cards to vars*/


		playerChar[0]=player.peek().getSuit();
		playerNum[0]=faceConvert(player.poll().getNumber());

		computerChar[0]=computer.peek().getSuit();
		computerNum[0]=faceConvert(computer.poll().getNumber());

		playerChar[1]=player.peek().getSuit();
		playerNum[1]=faceConvert(player.poll().getNumber());

		computerChar[1]=computer.peek().getSuit();
		computerNum[1]=faceConvert(computer.poll().getNumber());

		/* END adding cards to vars */



		//PLAYER'S TURN
		//printing computer's hand 
		if(turn==1){
			Ess.title("YOUR TURN"); Ess.lines(1);
			Ess.margin(8, "Computer's Hand");
			System.out.println("*************                *************");
			System.out.println("*************                * "+computerNum[1]+"         *");
			System.out.println("*************                * "+computerChar[1]+"         *");
			System.out.println("*************                *    |-     *");
			System.out.println("*************                *    -|     *");
			System.out.println("*************                *         "+computerChar[1]+" *");
			System.out.println("*************                *         "+computerNum[1]+" *");
			System.out.println("*************                *************");

			if(counterDealer>2){
				tempStringNum=faceConvert(computer.peek().getNumber());
				tempChar=computer.poll().getSuit();
				Ess.lines(1);
				System.out.println("*************");
				System.out.println("* "+tempStringNum+"         *");
				System.out.println("* "+tempChar+"         *");
				System.out.println("*    |-     *");
				System.out.println("*    -|     *");
				System.out.println("*         "+tempChar+" *");
				System.out.println("*         "+tempStringNum+" *");
				System.out.println("*************");

				if(counterDealer>3){
					tempStringNum=faceConvert(computer.peek().getNumber());
					tempChar=computer.poll().getSuit();

					System.out.println("*************");
					System.out.println("* "+tempStringNum+"         *");
					System.out.println("* "+tempChar+"         *");
					System.out.println("*    |-     *");
					System.out.println("*    -|     *");
					System.out.println("*         "+tempChar+" *");
					System.out.println("*         "+tempStringNum+" *");
					System.out.println("*************");
					if(counterDealer>4){
						tempStringNum=faceConvert(computer.peek().getNumber());
						tempChar=computer.poll().getSuit();

						System.out.println("*************");
						System.out.println("* "+tempStringNum+"         *");
						System.out.println("* "+tempChar+"         *");
						System.out.println("*    |-     *");
						System.out.println("*    -|     *");
						System.out.println("*         "+tempChar+" *");
						System.out.println("*         "+tempStringNum+" *");
						System.out.println("*************");
					}
				}

			}


			//printing player's hand
			Ess.margin(11,"Your Hand");
			System.out.println("*************                *************");
			System.out.println("* "+playerNum[0]+"         *                * "+playerNum[1]+"         *");
			System.out.println("* "+playerChar[0]+"         *                * "+playerChar[1]+"         *");
			System.out.println("*    |-     *                *    |-     *");
			System.out.println("*    -|     *                *    -|     *");
			System.out.println("*         "+playerChar[0]+" *                *         "+playerChar[1]+" *");
			System.out.println("*         "+playerNum[0]+" *                *         "+playerNum[1]+" *");
			System.out.println("*************                *************");

			if(counterPlayer>2){
				tempStringNum=faceConvert(player.peek().getNumber());
				tempChar=player.poll().getSuit();

				System.out.println("*************");
				System.out.println("* "+tempStringNum+"         *");
				System.out.println("* "+tempChar+"         *");
				System.out.println("*    |-     *");
				System.out.println("*    -|     *");
				System.out.println("*         "+tempChar+" *");
				System.out.println("*         "+tempStringNum+" *");
				System.out.println("*************");

				if(counterPlayer>3){
					tempStringNum=faceConvert(player.peek().getNumber());
					tempChar=player.poll().getSuit();

					System.out.println("*************");
					System.out.println("* "+tempStringNum+"         *");
					System.out.println("* "+tempChar+"         *");
					System.out.println("*    |-     *");
					System.out.println("*    -|     *");
					System.out.println("*         "+tempChar+" *");
					System.out.println("*         "+tempStringNum+" *");
					System.out.println("*************");
					if(counterPlayer>4){
						tempStringNum=faceConvert(player.peek().getNumber());
						tempChar=player.poll().getSuit();

						System.out.println("*************");
						System.out.println("* "+tempStringNum+"         *");
						System.out.println("* "+tempChar+"         *");
						System.out.println("*    |-     *");
						System.out.println("*    -|     *");
						System.out.println("*         "+tempChar+" *");
						System.out.println("*         "+tempStringNum+" *");
						System.out.println("*************");
					}
				}

			}

			Ess.output("Your hand total is "+getTotal(play));
			
		}
		else{
			//DEALER'S TURN
			//printing dealer's hand
			Ess.title("DEALERS'S TURN"); Ess.lines(1);
			Ess.margin(8, "Computer's Hand");
			System.out.println("*************                *************");
			System.out.println("* "+computerNum[0]+"         *                * "+computerNum[1]+"         *");
			System.out.println("* "+computerChar[0]+"         *                * "+computerChar[1]+"         *");
			System.out.println("*    |-     *                *    |-     *");
			System.out.println("*    -|     *                *    -|     *");
			System.out.println("*         "+computerChar[0]+" *                *         "+computerChar[1]+" *");
			System.out.println("*         "+computerNum[0]+" *                *         "+computerNum[1]+" *");
			System.out.println("*************                *************");

			if(counterDealer>2){
				tempStringNum=faceConvert(computer.peek().getNumber());
				tempChar=computer.poll().getSuit();

				System.out.println("*************");
				System.out.println("* "+tempStringNum+"         *");
				System.out.println("* "+tempChar+"         *");
				System.out.println("*    |-     *");
				System.out.println("*    -|     *");
				System.out.println("*         "+tempChar+" *");
				System.out.println("*         "+tempStringNum+" *");
				System.out.println("*************");

				if(counterDealer>3){
					tempStringNum=faceConvert(computer.peek().getNumber());
					tempChar=computer.poll().getSuit();

					System.out.println("*************");
					System.out.println("* "+tempStringNum+"         *");
					System.out.println("* "+tempChar+"         *");
					System.out.println("*    |-     *");
					System.out.println("*    -|     *");
					System.out.println("*         "+tempChar+" *");
					System.out.println("*         "+tempStringNum+" *");
					System.out.println("*************");
					if(counterDealer>4){
						tempStringNum=faceConvert(computer.peek().getNumber());
						tempChar=computer.poll().getSuit();

						System.out.println("*************");
						System.out.println("* "+tempStringNum+"         *");
						System.out.println("* "+tempChar+"         *");
						System.out.println("*    |-     *");
						System.out.println("*    -|     *");
						System.out.println("*         "+tempChar+" *");
						System.out.println("*         "+tempStringNum+" *");
						System.out.println("*************");
						if(getTotal(computer)<=21) declareWinner(0, "5CARDDRAW", Deck.getTotal(computer), Deck.getTotal(player));
					}
				}

			}
			
			Ess.output("Dealer's hand total is "+getTotal(comp));
			

			//printing player's hand
			Ess.margin(11,"Your Hand");
			System.out.println("*************                *************");
			System.out.println("* "+playerNum[0]+"         *                * "+playerNum[1]+"         *");
			System.out.println("* "+playerChar[0]+"         *                * "+playerChar[1]+"         *");
			System.out.println("*    |-     *                *    |-     *");
			System.out.println("*    -|     *                *    -|     *");
			System.out.println("*         "+playerChar[0]+" *                *         "+playerChar[1]+" *");
			System.out.println("*         "+playerNum[0]+" *                *         "+playerNum[1]+" *");
			System.out.println("*************                *************");

			if(counterPlayer>2){
				tempStringNum=faceConvert(player.peek().getNumber());
				tempChar=player.poll().getSuit();

				System.out.println("*************");
				System.out.println("* "+tempStringNum+"         *");
				System.out.println("* "+tempChar+"         *");
				System.out.println("*    |-     *");
				System.out.println("*    -|     *");
				System.out.println("*         "+tempChar+" *");
				System.out.println("*         "+tempStringNum+" *");
				System.out.println("*************");

				if(counterPlayer>3){
					tempStringNum=faceConvert(player.peek().getNumber());
					tempChar=player.poll().getSuit();

					System.out.println("*************");
					System.out.println("* "+tempStringNum+"         *");
					System.out.println("* "+tempChar+"         *");
					System.out.println("*    |-     *");
					System.out.println("*    -|     *");
					System.out.println("*         "+tempChar+" *");
					System.out.println("*         "+tempStringNum+" *");
					System.out.println("*************");
					if(counterPlayer>4){
						tempStringNum=faceConvert(player.peek().getNumber());
						tempChar=player.poll().getSuit();

						System.out.println("*************");
						System.out.println("* "+tempStringNum+"         *");
						System.out.println("* "+tempChar+"         *");
						System.out.println("*    |-     *");
						System.out.println("*    -|     *");
						System.out.println("*         "+tempChar+" *");
						System.out.println("*         "+tempStringNum+" *");
						System.out.println("*************");
						if(getTotal(player)<=21) declareWinner(1, "5CARDDRAW", Deck.getTotal(computer), Deck.getTotal(player));
						
					}
				}
			}
			
			Ess.output("Your hand total is "+getTotal(play));
			
		}	
	}

	public static void compare(Queue<Card> play, Queue<Card> comp){
		int playerTotal=0;
		int computerTotal=0;

		Queue<Card> computer = new LinkedList<Card>(comp);//cloning queues (non destructive)
		Queue<Card> player = new LinkedList<Card>(play);
		
		//adding the total of the cards while there are still cards in the hand
		//		(both player and computer's hand)
		while(!player.isEmpty())   playerTotal=+player.poll().getNumber();
		while(!computer.isEmpty()) computerTotal=+computer.poll().getNumber();

		//checking if any BUST
		if(playerTotal>21)
			if(computerTotal>21)declareWinner(2, "BUST", 0, 0);

		if(computerTotal>21)declareWinner(0, "BUST", 0, 0);

		if(playerTotal>21)declareWinner(1, "BUST", 0, 0);		
	}

	private static void displayHands(int dealerTotal, int playerTotal){
		
		Ess.lines(1);
		Ess.output("+-------------------+");//25 -
		Ess.output("     Dealer: "+dealerTotal+"     ");
		Ess.output("     Player: "+playerTotal+"      ");
		Ess.output("+-------------------+");//25 -
		Ess.lines(1);
		
	}

	public static int declareWinner(int player, String value, int dealerValue, int playerValue){//values are the values of each player IF they are needed
		int players = player; //0 is computer, 1 is player, 2 is both
		//looks at 
		
		displayHands(dealerValue, playerValue);
		
		if(value.equals("BLACKJACK")){//if someone blackjacks
			if(player==2){
				System.out.println("Both players blackjack! Return bet");
				return 0;
			}
			else if(player==1){
				System.out.println("You blackjack!! Dealer Wins!");
				return -1;
			}
			else{
				System.out.println("Dealer busted! You win ");
				return doublePot();
			}
		}
		else if(value.equals("5CARDDRAW")){//if someone pulls 5 cards
			if(player==2){
				System.out.println("Both players pull 5 cards! Return bet");
				return 0;
			}
			else if(player==1){
				System.out.println("You pull a 5 card draw!! You double your bet!");
				return doublePot();
			}
			else{
				System.out.println("Dealer pulls a 5 card draw! Dealer takes all.");
				return -1;
			}
		}
		else if(value.equals("BUST")){//if someone busts
			if(player==2){
				System.out.println("Both players bust! Return bet");
				return 0;
			}
			else if(player==1){
				System.out.println("You busted. Dealer takes all.");
				return -1;
			}
			else{
				System.out.println("Dealer busted! You double your bet!");
				return doublePot();
			}
		}
		else{//if none of the above cases apply: compare the values of the cards
			if(dealerValue==playerValue){
				System.out.println("Card Value is a draw. Return bet");
				return 0;
			}
			else if(dealerValue>playerValue){
				System.out.println("DEALER's value is higher. Dealer takes all.");
				return -1;
			}
			else if(playerValue>dealerValue){
				System.out.println("PLAYER's value is higher. You double your bet.");
				return doublePot();
			}
			else{
				System.out.println("ERROR - in declare winner");
				System.out.println("dealerValue: "+dealerValue +" playerValue: "+playerValue);
			}

		}
		return 0;
	}

}

