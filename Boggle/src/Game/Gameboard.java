/* Copyright Mark Frezell 2017
 * All Rights Reserved
 */

package Game;

import java.util.Scanner;
import Dictionary.Dictionary;

public class Gameboard {

	static boolean DEBUGGABLE = true;
	
	public static void main(String[] args) {
		Dictionary dict = new Dictionary();
		Scanner sc = new Scanner(System.in);
		Board board = new Board();

		String input;

		//Start Game
		do{
			board.print();
			System.out.println("Input"); input = sc.nextLine();
			//System.out.println(dict.contains(input));
			//if(dict.contains(input)){//if the input is matched in the dictionary 
			//	System.out.println("in Dict");
				board.findWord(input,board);//finds if the word exists on the board
			//}
			//else System.out.println("Not in dic");
		}while(!input.equals("1234"));
		sc.close();
		dict.close();
	}

}
