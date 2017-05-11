import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* Copyright Mark Frezell 2017
 * All Rights Reserved
 */

public class BlackJack {

	static Queue <Card> deck = Deck.generateDeck();//passing in the deck
	static Queue <Card> player = new LinkedList <Card>();//creating the arraylists for the players
	static Queue <Card> computer = new LinkedList <Card>();

	static boolean DEBUGGABLE = false;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);//creating scanners
		Scanner bets = new Scanner(System.in);
		String input="";
		int balance=25;
		int bet=0;				//creating variables for the program
		int betHappenings=0;
		boolean playerBusted=false;
		boolean dealerPlays=true;

		do{

			Ess.lines(100);//resets the console output
			Deck.setPot(0);//resetting the pot
			bet=0;//resetting the bet
			playerBusted=false;//resenting game controls			//reseting for another game (applies after the first)
			dealerPlays=true;
			player.clear();//clearing hands 
			computer.clear();
			
			/*START Dealing cards to players*/
			player = Deck.getCards(deck, player);
			computer = Deck.getCards(deck, computer);
			/* END Dealing cards to players */

			/*STARTING GAME*/

			Deck.displayGameboard(player,computer,1);//displays the board (not showing the dealer's hand)
			
			Ess.output("How much would you like to bet?");
			Ess.output("Chips: "+balance);//allows the player to bet after they see their hand
			Ess.lines(15);
			bet=bets.nextInt();
			Deck.setPot(bet);//sets the pot to the bet amount
			balance-=bet;
			Ess.output("You now have "+balance+" chips left.");//tells the player their bet
			Ess.output("The pot now has "+Deck.pot+" chips.");


			do{/*PLAYER'S TURN*/
				Ess.output("Would you like to hit or pass? (h)");//lets player hit or pass
				input = sc.nextLine();
				if(input.equalsIgnoreCase("h")) player.add(Deck.addCard(deck));//if they hit, add a card to the player's hand
				else break;//if they don't hit, their turn ends			
				Deck.displayGameboard(player,computer,1);
				if(Deck.getTotal(player)>21){
					Deck.declareWinner(1, "BUST", Deck.getTotal(computer), Deck.getTotal(player));//if the player goes over 21 they automatically bust
					Deck.setPot(0);//resetting the pot
					Ess.output("Dealer takes your loss. Chip balance: "+balance);
					playerBusted=true; //will not go through the dealer's turn
					try {
						Thread.sleep(2000);//sleeps the program for two seconds
					} catch (InterruptedException e) {
						Ess.output("Waiting...");
					}
					break;
				}
			}while(input.equalsIgnoreCase("h"));/*END PLAYER'S TURN*/



			while(playerBusted==false&&dealerPlays==true){/*START DEALER'S TURN*/
				do{
					Deck.displayGameboard(player, computer, 0);//displays the game board while showing the dealer's cards
					if(Deck.getTotal(computer)<=17) computer.add(Deck.addCard(deck));//if they hit, add a card to the player's hand
					else {//if they don't hit, their turn ends
						if(Deck.getTotal(computer)>21){//checking if the dealer busts
							balance+=Deck.declareWinner(0, "BUST", Deck.getTotal(computer), Deck.getTotal(player));//dealer busts
							Ess.DEBUG(DEBUGGABLE, "DB2 - pot: " +Deck.pot);
							Ess.output("You doubled your bet. Chip balance: "+balance);//the player wins and doubles their bet
							dealerPlays=false;
							break;
						}
						else{//if neither of the players bust
							Ess.output("Dealer stays with "+Deck.getTotal(computer));
							betHappenings=Deck.declareWinner(2, "Null", Deck.getTotal(computer), Deck.getTotal(player));
							Ess.DEBUG(DEBUGGABLE,"Counting Numbers");	//getting the result of the game based on the total of the cards
																		//betHappenings deturmines the value of the pot that the player gets back (win or loss)
							if(betHappenings==-1){
								bet=0;//if the player loss
								Ess.output("Dealer takes your loss. Chip balance: "+balance);
							}
							else if(betHappenings==0){//tie 
								balance+=bet;//the player get's their chips back
								Ess.output("Returned your bet. Chip balance: "+balance);								
							}
							else{
								balance+=(betHappenings);//the player doubles their chips
								Ess.DEBUG(DEBUGGABLE, "COUNT - betHapp "+betHappenings);
								Ess.output("You doubled your bet. Chip balance: "+balance);
							}
							
							dealerPlays=false;
							break;
						}
					}

					Ess.output("Dealer is taking its turn.");

					try {

						Thread.sleep(2000);
					} catch (InterruptedException e) {}

				}while(true);
			}/*END DEALER'S TURN*/


			//after all have passed (hands are finished)

			//Deck.compare(player, computer);//compares after both turns are over and each 
			Ess.output("Play another hand? (h)");
		}while(sc.nextLine().equalsIgnoreCase("h"));//while the player still wants to play

		Ess.output("Thanks for playing! See you again");
		sc.close();
		bets.close();

	}

}
