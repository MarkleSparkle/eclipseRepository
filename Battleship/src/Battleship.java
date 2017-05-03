import java.util.Scanner;

/* Copyright Mark Frezell 2017
 * All Rights Reserved
 */

public class Battleship {

	static Position[][] player = Board.generatePlayer();
	static Position[][] computer;
	static boolean DEBUGGABLE=false;


	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		String input="";
		boolean correctInput;
		boolean endGame=false;
		computer=Board.generateComputer();


		Ess.margin(4,"Would you like to have your boats auto assigned? (a) Or you can set them yourself (y).");
		if(sc.nextLine().equalsIgnoreCase("a")){
			player=Board.generateComputer();
		}
		else{
			player=Board.playerPlace(player, computer);
		}

		Ess.lines(100);//clearing the board each time a new board is created
		do{

			Ess.output("Computer's TURN"); Ess.lines(5); Ess.output("		Waiting...");Ess.lines(5);
			Thread.sleep(1500);
			Board.computerFires(player, computer);

			//player's turn
			Ess.output("Player's TURN");
			correctInput=false;//initializing

			//DEBUG
			//Board.print2D(computer, 0, "");
			Board.printLegend();
			Board.printGame(player,computer);	
			Ess.lines(0);//spacing at the bottom so the board is at a comfortable eye level

			do{
				Ess.output("Private! Enter your next fire coordinates! (Ex. \"A3\")");

				input=sc.nextLine();

				if(input.equalsIgnoreCase("peek")){
					Board.print2D(computer, 0, "");
				}

				if(input.length()==2){
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
