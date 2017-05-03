import java.util.Scanner;

/* Copyright Mark Frezell 2017
 * All Rights Reserved
 */

public class Board {

	static boolean DEBUGGABLE = true;

	public static void print2D(Position[][] array, int dashType, String title) {//prints array (for testing purpose only)
		String msg="";

		for (int i = 0; i < array[0].length; i++){
			msg+="[";
			for(int j=0; j < array[1].length; j++){
				msg += array[i][j].getState();
				if(j+1 == array[1].length){
					msg+="]\n";
				}
				if (j + 1 != array[0].length) {// if array is not at the end then print comma
					msg += ", ";
				}
			}
		}
		Ess.output(msg);
	}

	private static void privatePrintBoard(String[][] array) {//prints an array in a board format
		String msg="";										//this method DOES NOT CONTROL ANYTHING other than printing
		String[]boardMat = new String[]{
				"0","1","2","3","4","5","6","7","8","9"
		};
		msg += ("    A  B  C  D  E  F  G  H  I  J\n");//column names
		msg += ("  +------------------------------+\n");//start of board
		for (int i = 0; i < array[0].length; i++){
			msg+=(boardMat[i]+" | ");//at the start of each row, a | is placed
			for(int j=0; j < array[1].length; j++){
				msg += array[i][j];//printing each element 
				if (j + 1 != array[0].length) {// if array is not at the end then print a space
					msg += "  ";
				}
			}
			msg+=" |\n";//at the end of each row, a | is placed
		}
		msg += ("  +------------------------------+\n");//end of board

		Ess.output(msg);//prints it all out
	}

	public static void printStatusBoard(Position[][]player){	//creates a new array that looks like a game board from the 
		//Position array and then determines then it prints the 
		//newly created array
		String[][]board = new String[10][10];//in the board: ~ is water, O - boat
		for (int i = 0; i < player[0].length; i++){
			for(int j=0; j < player[0].length; j++){	//open water
				if(player[i][j].getState()==0){
					board[i][j]="~";
				}
				else if(player[i][j].getState()==2){	//hit boat
					board[i][j]="X";
				}				
				else if(player[i][j].getState()==3){ //miss (attacked open water)
					board[i][j]="0";
				}
				else {
					board[i][j]="8";
				}
			}
		}
		privatePrintBoard(board);//prints the board
	}

	public static void printShootBoard(Position[][]computer){//prints the previous shots on the computer
		//Position array and then determines then it prints the 
		//newly created array
		String[][]board = new String[10][10];//in the board: ~ is water, O - boat
		for (int i = 0; i < computer[0].length; i++){
			for(int j=0; j < computer[0].length; j++){	//open water
				if(computer[i][j].getState()==0){
					board[i][j]="~";
				}

				else if(computer[i][j].getState()==2){	//hit boat
					board[i][j]="X";
				}				
				else if(computer[i][j].getState()==3){ //miss (attacked open water)
					board[i][j]="0";
				}
				else{	//untouched boat (will appear as water)
					board[i][j]="~";
				}
			}
		}
		privatePrintBoard(board);//prints the board
	}


	public static void printGame(Position[][] player, Position[][] computer){
		//prints the player's part of the board (player's view)

		//first is the board that shows where you have shot
		//second is the board with your boats, what was shot at and what was missed
		Ess.margin(7, "Your Shots"); Ess.lines(1);
		printShootBoard(computer);//prints the COMPUTER'S boat status with limited info (for the player to view)
		Ess.margin(7, "Your Boats"); Ess.lines(1);
		printStatusBoard(player);//second
	}

	public static void fire(Position[][]player, Position[][]computer, String input){
		String col=input.substring(0, 1);
		int column=0;
		int row=0;

		switch(col){//changing the letter input into a usable integer
		case "A": column = 0; break;
		case "B": column = 1; break;
		case "C": column = 2; break;
		case "D": column = 3; break;
		case "E": column = 4; break;
		case "F": column = 5; break;		//changing to a valid (usable) index
		case "G": column = 6; break;
		case "H": column = 7; break;
		case "I": column = 8; break;
		case "J": column = 9; break;
		default: Ess.DEBUG(DEBUGGABLE, "Crap... could not recognise my letter input");
		}
		row=Integer.parseInt(input.substring(1, 2));//parsing the input for the program to find the index inputted
		Ess.DEBUG(DEBUGGABLE, "col = "+col+" \\\\ column = "+column+" \\\\ row = "+row);
		Ess.DEBUG(DEBUGGABLE, "REMEMBER array[row][column]!!");
		Ess.DEBUG(DEBUGGABLE, "state before = "+computer[row][column].getState());

		//checking if a boat exists at the position
		if(computer[row][column].getState()!=0&&computer[row][column].getState()!=2&&computer[row][column].getState()!=3){
			//if there IS a boat (untouched)

			computer[row][column].setState(2);//set that position's state to HIT
			Ess.title("\"Good shot private! Keep searching!!\"");
		}
		else if (computer[row][column].getState()==2){//previously hit
			//if there is already a hit boat there (waste of turn)
			Ess.title("\"...really? PRIVATE! You ALREADY hit that!! You're FIIIIREEDDD!!!\"");
		}
		else if(computer[row][column].getState()==3){//previously missed
			Ess.title("\"You're wasting our ammo on... OPEN WATER?!?! GEEEET OUTTTTT!!!\"");
		}
		else if(computer[row][column].getState()==0){//open water
			Ess.title("Missed! Keep firing private!");
			computer[row][column].setState(3);
		}
		Ess.DEBUG(DEBUGGABLE, "state after = "+computer[row][column].getState());
	}

	private static int[] rowColumn(String input){

		String col=input.toUpperCase().substring(0, 1);
		String r = input.substring(1, 2);
		int column = 0;
		int row= Integer.parseInt(r);
		int [] rowColumn = new int[2];

		switch(col){//changing the letter input into a usable integer
		case "A": column = 0; break;
		case "B": column = 1; break;
		case "C": column = 2; break;
		case "D": column = 3; break;
		case "E": column = 4; break;
		case "F": column = 5; break;		//changing to a valid (usable) index
		case "G": column = 6; break;
		case "H": column = 7; break;
		case "I": column = 8; break;
		case "J": column = 9; break;
		default: Ess.DEBUG(DEBUGGABLE, "Crap... could not recognise my letter input");
		}
		Ess.DEBUG(DEBUGGABLE, "row = "+row+" \\\\ column = "+column );
		rowColumn[0]=row;
		rowColumn[1]=column;

		return rowColumn;		
	}

	public static Position[][] playerPlace(Position[][]player, Position[][]computer){
		Board.printGame(player, computer);
		Scanner sc = new Scanner(System.in);
		String input="";
		String direction="";
		boolean exception=true;
		int [] rc = new int[2];

		/***************************************FIRST BOAT***************************************/
		
		//TODO, not sure what happened here but.... debug the crap out of it
		
		Ess.output("Now place the Aircraft Carrier (5 spaces long)");//state of "5" //should be 5 of them
		do{
			Ess.output("Enter the point you would like to start your ship on. \"A3\"");
			input=sc.nextLine();
			rc=rowColumn(input);

			Ess.output("Would you like to go up (u), right (r), down(d), or left(l) from the point "+input);
			direction = sc.nextLine();
			//separates the directions and attempts to place the boat
			if(direction.equalsIgnoreCase("u")){//if the direction is up
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(5);
					player[rc[0]-1][rc[1]].setState(5);
					player[rc[0]-2][rc[1]].setState(5);		//setting "5" to the boats above 'input'
					player[rc[0]-3][rc[1]].setState(5);
					player[rc[0]-4][rc[1]].setState(5);
					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if (direction.equalsIgnoreCase("r")){//if direction is right
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(5);
					player[rc[0]][rc[1]+1].setState(5);
					player[rc[0]][rc[1]+2].setState(5);		//setting "5" to the boats to the right of 'input'
					player[rc[0]][rc[1]+3].setState(5);
					player[rc[0]][rc[1]+4].setState(5);
					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if (direction.equalsIgnoreCase("d")){//if direction is down
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(5);
					player[rc[0]+1][rc[1]].setState(5);
					player[rc[0]+2][rc[1]].setState(5);		//setting "5" to the boats below 'input'
					player[rc[0]+3][rc[1]].setState(5);
					player[rc[0]+4][rc[1]].setState(5);
					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if(direction.equalsIgnoreCase("l")){//if direction is left
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(5);
					player[rc[0]][rc[1]-1].setState(5);
					player[rc[0]][rc[1]-2].setState(5);		//setting "5" to the boats to the left of 'input'
					player[rc[0]][rc[1]-3].setState(5);
					player[rc[0]][rc[1]-4].setState(5);
					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else{
				Ess.output("Something messed up placing the first boat (could not find direction). restarting placement");
				exception=true;
			}
		}while(exception==true);
		Ess.output("GREAT! Your boat is placed!");
		
		printGame(player,computer);

		/***************************************SECOND BOAT***************************************/
		Ess.output("Now place the Battleship (4 spaces long)");//state of "6" //should be 4
		do{
			Ess.output("Enter the point you would like to start your ship on. \"A3\"");
			Ess.DEBUG(DEBUGGABLE, "input before = "+input);
			input=sc.nextLine();
			Ess.DEBUG(DEBUGGABLE, "input after = "+input);
			rc=rowColumn(input);

			Ess.output("Would you like to go up (u), right (r), down(d), or left(l) from the point "+input);
			direction = sc.nextLine();
			//seperates the directions and attempts to place the boat
			if(direction.equalsIgnoreCase("u")){//if the direction is up
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(6);
					player[rc[0]-1][rc[1]].setState(6);
					player[rc[0]-2][rc[1]].setState(6);		//setting "6" to the boats above 'input'
					player[rc[0]-3][rc[1]].setState(6);
					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if (direction.equalsIgnoreCase("r")){//if direction is right
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(6);
					player[rc[0]][rc[1]+1].setState(6);
					player[rc[0]][rc[1]+2].setState(6);		//setting "6" to the boats to the right of 'input'
					player[rc[0]][rc[1]+3].setState(6);
					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if (direction.equalsIgnoreCase("d")){//if direction is down
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(6);
					player[rc[0]+1][rc[1]].setState(6);
					player[rc[0]+2][rc[1]].setState(6);		//setting "6" to the boats below 'input'
					player[rc[0]+3][rc[1]].setState(6);
					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if(direction.equalsIgnoreCase("l")){//if direction is left
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(6);
					player[rc[0]][rc[1]-1].setState(6);
					player[rc[0]][rc[1]-2].setState(6);		//setting "6" to the boats to the left of 'input'
					player[rc[0]][rc[1]-3].setState(6);
					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else{
				Ess.output("Something messed up placing the first boat (could not find direction). restarting placement");
				exception=true;
			}
		}while(exception==true);
		Ess.output("GREAT! Your boat is placed!");

		printGame(player,computer);
		
		/***************************************THIRD BOAT***************************************/
		Ess.output("Now place the Submarine (3 spaces long)");//state of "7" //should be 3
		do{
			Ess.output("Enter the point you would like to start your ship on. \"A3\"");
			input=sc.nextLine();
			rc=rowColumn(input);

			Ess.output("Would you like to go up (u), right (r), down(d), or left(l) from the point "+input);
			direction = sc.nextLine();
			//seperates the directions and attempts to place the boat
			if(direction.equalsIgnoreCase("u")){//if the direction is up
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(7);
					player[rc[0]-1][rc[1]].setState(7);
					player[rc[0]-2][rc[1]].setState(7);		//setting "7" to the boats above 'input'

					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if (direction.equalsIgnoreCase("r")){//if direction is right
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(7);
					player[rc[0]][rc[1]+1].setState(7);
					player[rc[0]][rc[1]+2].setState(7);		//setting "7" to the boats to the right of 'input'

					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if (direction.equalsIgnoreCase("d")){//if direction is down
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(7);
					player[rc[0]+1][rc[1]].setState(7);
					player[rc[0]+2][rc[1]].setState(7);		//setting "7" to the boats below 'input'

					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if(direction.equalsIgnoreCase("l")){//if direction is left
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(7);
					player[rc[0]][rc[1]-1].setState(7);
					player[rc[0]][rc[1]-2].setState(7);		//setting "7" to the boats to the left of 'input'

					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else{
				Ess.output("Something messed up placing the first boat (could not find direction). restarting placement");
				exception=true;
			}
		}while(exception==true);
		Ess.output("GREAT! Your boat is placed!");
		
		printGame(player,computer);
		
		/***************************************FOURTH BOAT***************************************/
		Ess.output("Now place the Destroyer (3 spaces long)");//state of "8" //should be 3

		do{
			Ess.output("Enter the point you would like to start your ship on. \"A3\"");
			input=sc.nextLine();
			rc=rowColumn(input);

			Ess.output("Would you like to go up (u), right (r), down(d), or left(l) from the point "+input);
			direction = sc.nextLine();
			//seperates the directions and attempts to place the boat
			if(direction.equalsIgnoreCase("u")){//if the direction is up
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(8);
					player[rc[0]-1][rc[1]].setState(8);
					player[rc[0]-2][rc[1]].setState(8);		//setting "8" to the boats above 'input'

					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if (direction.equalsIgnoreCase("r")){//if direction is right
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(8);
					player[rc[0]][rc[1]+1].setState(8);
					player[rc[0]][rc[1]+2].setState(8);		//setting "8" to the boats to the right of 'input'

					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if (direction.equalsIgnoreCase("d")){//if direction is down
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(8);
					player[rc[0]+1][rc[1]].setState(8);
					player[rc[0]+2][rc[1]].setState(8);		//setting "8" to the boats below 'input'

					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if(direction.equalsIgnoreCase("l")){//if direction is left
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(8);
					player[rc[0]][rc[1]-1].setState(8);
					player[rc[0]][rc[1]-2].setState(8);		//setting "8" to the boats to the left of 'input'

					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else{
				Ess.output("Something messed up placing the first boat (could not find direction). restarting placement");
				exception=true;
			}
		}while(exception==true);
		Ess.output("GREAT! Your boat is placed!");
		
		printGame(player,computer);
		
		/***************************************FIFTH BOAT***************************************/
		Ess.output("Now place the Partrol Boat (2 spaces long)");//state of "9" //should be 2

		do{
			Ess.output("Enter the point you would like to start your ship on. \"A3\"");
			input=sc.nextLine();
			rc=rowColumn(input);

			Ess.output("Would you like to go up (u), right (r), down(d), or left(l) from the point "+input);
			direction = sc.nextLine();
			//seperates the directions and attempts to place the boat
			if(direction.equalsIgnoreCase("u")){//if the direction is up
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(9);
					player[rc[0]-1][rc[1]].setState(9);		//setting "9" to the boats above 'input'

					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if (direction.equalsIgnoreCase("r")){//if direction is right
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(9);
					player[rc[0]][rc[1]+1].setState(9);		//setting "9" to the boats to the right of 'input'

					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if (direction.equalsIgnoreCase("d")){//if direction is down
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(9);
					player[rc[0]+1][rc[1]].setState(9);		//setting "9" to the boats below 'input'

					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else if(direction.equalsIgnoreCase("l")){//if direction is left
				try{
					//row	//column
					player[rc[0]][rc[1]].setState(9);
					player[rc[0]][rc[1]-1].setState(9);		//setting "9" to the boats to the left of 'input'

					Ess.DEBUG(DEBUGGABLE,"Placed all boat parts");

					exception=false;
				}catch(ArrayIndexOutOfBoundsException  e){
					Ess.output("You tried to place the boats OUTSIDE of the board. Do it again.");
					Ess.DEBUG(DEBUGGABLE, "exception: "+e);
					exception=true;
				}
			}
			else{
				Ess.output("Something messed up placing the first boat (could not find direction). restarting placement");
				exception=true;
			}
		}while(exception==true);
		Ess.output("GREAT! Your boat is placed!");
		
		printGame(player,computer);
		
		/***************************************FINAL BOAT CHECK******************************************/

		int first = 0, second = 0, third = 0, fourth = 0, fifth = 0;
		for(int i=0; i<player.length; i++){
			for(int j=0; j<player.length; j++){
				if(player[i][j].getState()==5) first++;
				if(player[i][j].getState()==6) second++;
				if(player[i][j].getState()==7) third++;	//checking for all the boats to see if they are in the array
				if(player[i][j].getState()==8) fourth++;
				if(player[i][j].getState()==9) fifth++;
			}
		}
		
		if(first == 5 && second == 4 && third == 3 && fourth == 3 && fifth == 2){//if they are, WE'RE GOOD
			Ess.output("Looks like we've got everything! Let's play!");
		}
		else{//if not.... FRICK
			Ess.output("Looks like something went wrong...");
			Ess.DEBUG(DEBUGGABLE, "first  = "+first+" \\\\ second = "+second+" \\\\ third = "+third+
					" \\\\ fourth = "+fourth+" \\\\ fifth = "+fifth);
		}
		
		return player;
	}


	public static void computerFires(Position[][]player, Position[][]computer){
		boolean shot=false;
		int row=0;
		int column=0;
		do{
			column = (int) (10*Math.random());
			row	=    (int) (10*Math.random());

			Ess.DEBUG(DEBUGGABLE," compColumn = "+column+" \\\\ compRow = "+row);
			Ess.DEBUG(DEBUGGABLE, "state before = "+player[row][column].getState());

			//checking if a boat exists at the position
			if(player[row][column].getState()!=0&&player[row][column].getState()!=2&&player[row][column].getState()!=3){
				//if there IS a boat (untouched)
				player[row][column].setState(2);//set that position's state to HIT
				Ess.title("\"THEY JUST HIT US! FIRE BACK!!\"");
				shot=true;
			}
			else if (player[row][column].getState()==2||player[row][column].getState()==3){
				//previously shot at
				Ess.DEBUG(DEBUGGABLE,"Computer shot at a previously shot target");
			}

			else if(player[row][column].getState()==0){//open water
				Ess.title("HA HA! They missed us! Blind as mice.");
				player[row][column].setState(3);
				shot=true;
			}
		}while(shot==false);
		Ess.DEBUG(DEBUGGABLE, "state after = "+player[row][column].getState());
	}


	public static Position[][] generatePlayer(){

		//		Position temp = new Position(0);
		//		Position[][] array = new Position[10][10];
		Position[][] newArray = {
				{new Position(0), new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0)},
				{new Position(0), new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0)},
				{new Position(0), new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0)},
				{new Position(0), new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0)},
				{new Position(0), new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0)},
				{new Position(0), new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0)},
				{new Position(0), new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0)},
				{new Position(0), new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0)},
				{new Position(0), new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0)},
				{new Position(0), new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0),new Position(0)},
		};

		/*		for(int i=0; i<array[0].length; i++){ 
			for(int j=0; j<array[1].length; j++){
				array[i][j]=temp;
			}
		}*/

		return newArray;
	}

	public static Position[][] generateComputer(){

		Position[][] array;
		int [] selected = new int[5];
		int random=0;
		int secondRandom=0;
		boolean completeBoard=false;

		do{
			array = generatePlayer();
			random = (int) (21*Math.random());
			secondRandom = (int) (6*Math.random());

			/*START ASSIGNING THE COMPUTER'S SHIPS*/

			/**************************************************FIRST SHIP (5)**************************************************/
			Ess.DEBUG(DEBUGGABLE, "first - random: "+random+" \\\\ secondRandom: "+secondRandom);
			if(random<=10){//the ships will be printed in a column (A-J)
				selected[0]=random;
				random = (int) (6*Math.random());
				for(int i=0; i<5; i++){//prints for each part of the ship
					array[random+i][secondRandom].setState(5);
				}
			}

			else{//this ship will be printed in a column (0-9)
				random = (int) (6*Math.random());
				for(int i=0; i<5; i++){//prints for each part of the ship
					array[random][secondRandom+i].setState(5);
				}
			}
			/**************************************************SECOND SHIP (4)**************************************************/
			secondRandom = (int) (7*Math.random());
			do{//doing random while 
				random = (int) (21*Math.random());
			}while(random==selected[0]);
			Ess.DEBUG(DEBUGGABLE, "second - random: "+random+" \\\\ secondRandom: "+secondRandom);

			if(random<=10){//the ships will be printed in a column (A-J)
				selected[1]=random;
				random = (int) (7*Math.random());
				for(int i=0; i<4; i++){//prints for each part of the ship
					array[random+i][secondRandom].setState(6);
				}
			}

			else{//this ship will be printed in a column (0-9)
				random = (int) (7*Math.random());
				for(int i=0; i<4; i++){//prints for each part of the ship
					array[random][secondRandom+i].setState(6);
				}
			}
			/**************************************************THIRD SHIP (3)**************************************************/
			secondRandom = (int) (8*Math.random());
			do{//doing random while 
				random = (int) (21*Math.random());
			}while(random==selected[0]&&random==selected[1]);
			Ess.DEBUG(DEBUGGABLE, "third - random: "+random+" \\\\ secondRandom: "+secondRandom);

			if(random<=10){//the ships will be printed in a column (A-J)
				selected[2]=random;
				random = (int) (8*Math.random());
				for(int i=0; i<3; i++){//prints for each part of the ship
					array[random+i][secondRandom].setState(7);
				}
			}

			else{//this ship will be printed in a column (0-9)
				random = (int) (8*Math.random());
				for(int i=0; i<3; i++){//prints for each part of the ship
					array[random][secondRandom+i].setState(7);
				}
			}
			/**************************************************FOURTH SHIP (3)**************************************************/
			secondRandom = (int) (8*Math.random());
			do{//doing random while 
				random = (int) (21*Math.random());
			}while(random==selected[0]&&random==selected[1]&&random==selected[2]);
			Ess.DEBUG(DEBUGGABLE, "fourth - random: "+random+" \\\\ secondRandom: "+secondRandom);

			if(random<=10){//the ships will be printed in a column (A-J)
				selected[3]=random;
				random = (int) (8*Math.random());
				for(int i=0; i<3; i++){//prints for each part of the ship
					array[random+i][secondRandom].setState(8);
				}
			}

			else{//this ship will be printed in a column (0-9)
				random = (int) (8*Math.random());
				for(int i=0; i<3; i++){//prints for each part of the ship
					array[random][secondRandom+i].setState(8);
				}
			}
			/**************************************************FIFTH SHIP (2)**************************************************/
			secondRandom = (int) (9*Math.random());
			do{//doing random while 
				random = (int) (21*Math.random());
			}while(random==selected[0]&&random==selected[1]&&random==selected[2]&&random==selected[3]);
			Ess.DEBUG(DEBUGGABLE, "fifth - random: "+random+" \\\\ secondRandom: "+secondRandom);

			if(random<=10){//the ships will be printed in a column (A-J)
				selected[4]=random;
				random = (int) (9*Math.random());
				for(int i=0; i<2; i++){//prints for each part of the ship
					array[random+i][secondRandom].setState(9);
				}
			}

			else{//this ship will be printed in a column (0-9)
				random = (int) (9*Math.random());
				for(int i=0; i<2; i++){//prints for each part of the ship
					array[random][secondRandom+i].setState(9);
				}
			}

			/********************************CHECKING IF ALL OF THE COMPONENTS ARE IN THE AREA********************************/

			//by the end of the loops:
			int shipOne=0;//ship one should equal 5
			int shipTwo=0;//ship two should equal 4
			int shipThree=0;//ship three should equal 3
			int shipFour=0;//ship four should equal 3
			int shipFive=0;//ship five should equal 2

			for (int i = 0; i < array[0].length; i++){
				for(int j=0; j < array[1].length; j++){
					if(array[i][j].getState()==5) shipOne++;
					else if(array[i][j].getState()==6) shipTwo++;
					else if(array[i][j].getState()==7) shipThree++;
					else if(array[i][j].getState()==8) shipFour++;
					else if(array[i][j].getState()==9) shipFive++;
				}
			}
			if(shipOne==5&&shipTwo==4&&shipThree==3&&shipFour==3&&shipFive==2)
				completeBoard=true;	//if all the ships have all their parts, the program will continue
			//to pass back the completed array


		}while(completeBoard==false);//while the board is incomplete

		Ess.DEBUG(DEBUGGABLE, "completeBoard = "+completeBoard);

		return array;//returns the completed board array
	}

	private static boolean checkBoard(Position[][]array){
		int counter=0;

		///for loops
		for (int i = 0; i < array[0].length; i++){
			for(int j=0; j < array[0].length; j++){
				if(array[i][j].getState()==5||array[i][j].getState()==6||array[i][j].getState()==7||array[i][j].getState()==8||array[i][j].getState()==9){
					//if any of the boats are found the counter will go up
					counter++;
				}
			}
		}
		Ess.DEBUG(DEBUGGABLE, "Counter = "+counter);
		if(counter==0){ return true; }//if there is no boats left
		else { return false; }
	}

	public static boolean gameOver(Position[][]player, Position[][]computer){

		Ess.DEBUG(DEBUGGABLE, "Checking player's:");
		if(checkBoard(player)==true){//player is ded
			Ess.title("Player's Ships Are Sunk. Computer Wins!");
			return true;
		}

		Ess.DEBUG(DEBUGGABLE, "Checking player's:");
		if(checkBoard(computer)==true){//computer is ded
			Ess.title("Computer's Ships Are Sunk. You Win!");
			return true;
		}

		return false;
	}

	public static void printLegend() {
		Ess.lines(2);
		Ess.margin(45,"         Legend         ");
		Ess.margin(45," +--------------------+ ");
		Ess.margin(45," |                    | ");
		Ess.margin(45," |   ~ - open water   | ");
		Ess.margin(45," |   0 - missed shot  | ");
		Ess.margin(45," |   X - hit boat     | ");
		Ess.margin(45," |                    | ");
		Ess.margin(45," +--------------------+ ");

	}
}



