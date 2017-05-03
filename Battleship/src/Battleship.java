import java.util.Scanner;

/* Copyright Mark Frezell 2017
 * markfrezelljr@yahoo.ca
 * All Rights Reserved
 */

public class Battleship {
	
	//this is the main class
	
	//Battleship.java takes all the functions from Board and Position
	//and combines it into a working, functional game

	static Position[][] player = Board.generatePlayer();//builds an array of empty Positions
	static Position[][] computer;//initializing variables
	static boolean DEBUGGABLE=false;


	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		String input="";//initializing variables
		boolean correctInput;
		boolean endGame=false;
		computer=Board.generateComputer();	//generating a full array of
											//Positions for the computer

		Ess.margin(4,"Would you like to have your boats auto assigned? (a) Or you can set them yourself (y).");
		if(sc.nextLine().equalsIgnoreCase("a")){
			player=Board.generateComputer();//generating a full array
		}									//of Positions for the player
		else{//let's the player choose where their boats will be 
			player=Board.playerPlace(player, computer);
		}

		Ess.lines(100);//clearing the board each time a new board is created
		do{//entering the game and looping until the game is over

			Ess.output("Computer's TURN"); Ess.lines(5); Ess.output("		Waiting...");Ess.lines(5);
			Thread.sleep(1500);
			Board.computerFires(player, computer);  //the computer takes its turn
													//to fire at the computer's board
			//player's turn
			Ess.output("Player's TURN");
			correctInput=false;//initializing

			//DEBUG
			//Board.print2D(computer, 0, "");
			Board.printLegend();//prints the legend
			Board.printGame(player,computer);	//prints both boards for the player to see
			Ess.lines(0);//spacing at the bottom so the board is at a comfortable eye level

			do{//does while the player's input is valid
				Ess.output("Private! Enter your next fire coordinates! (Ex. \"A3\")");

				input=sc.nextLine();//lets the player enter coordinates

				if(input.equalsIgnoreCase("peek")){//allows the player to cheat
					Board.print2D(computer, 0, "");//if they know the 'peek' code
				}

				if(input.length()==2){//checking if the player's input is valid
					correctInput=true;
					Board.fire(player,computer,input.toUpperCase());//fires a shot at the computer
					Ess.lines(10);
				}
				//input is toUpperCase so there is no uncaught letters in the program
				else{
					Ess.output("INVALID LENGTH - PLEASE RE-ENTER YOUR COORDS! length = "+input.length());
				}

			}while(!correctInput);

			if(Board.gameOver(player, computer)==true){//checks if the game is over
				Ess.DEBUG(DEBUGGABLE, "Game Over");
				endGame=true;
			}

		}while(endGame==false);
		Board.printGame(player, computer);
		Ess.output("Good game! Thanks for playing!");

		//ending the game
		sc.close();
	}
}
