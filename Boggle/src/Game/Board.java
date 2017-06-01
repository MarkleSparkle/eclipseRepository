/* Copyright Mark Frezell 2017
 * All Rights Reserved
 */

package Game;

public class Board {
	static boolean DEBUGGABLE = true;
	static String wordCheck = "";
	static char[][] board = {//creates an array of random lowercase letters :D
			{(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0)},
			{(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0)},
			{(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0)},
			{(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0)},
			{(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0),(Character.toString ((char) (int)(25*(Math.random())+98))).charAt(0)},
	};

	public Board() {
		/*
		 * Board handles the creation of a board and whether letters are adjacent or not.
		 */
	}

	public void print(){
		/*
		 * Prints the board
		 */
		String msg="";

		for (int i = 0; i < board[0].length; i++){
			msg+="[";
			for(int j=0; j < board[1].length; j++){
				msg += board[i][j];
				if(j+1 == board[1].length){
					msg+="]\n";
				}
				if (j + 1 != board[0].length) {// if array is not at the end then print comma
					msg += ", ";
				}
			}
		}
		System.out.println(msg);

	}

	public int[] contains(char letter){
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board.length; j++){
				if(board[i][j]==letter){
					return new int[]{i,j};
				}
			}
		}
		return null;
	}

	public boolean isAdjacent(char ch){
		int x,y;



		return false;
	}

	public void findWord(String input, Board b) {
		char[] letters = input.toCharArray();
		int [] position = new int [2];

		System.out.println("Got before FOR (findWord)");
		for(int i=0; i<letters.length; i++){
			if(null != (position = b.contains(letters[0]))){//if the board contains the first letter
				Ess.printArray(position, 1, "POSITION OF 1st LETTER");
				Ess.DEBUG(DEBUGGABLE, "Got into IF (findWord)");
				//begin to search around this letter for the second letter
				if(loopSearch(b, letters, position)){

				}
				Ess.DEBUG(DEBUGGABLE, "findWord() :: FINAL -- "+wordCheck);

				break;
			}
		}
	}

	private boolean loopSearch(Board b, char[] letters, int[]position){
		boolean ret;
		int counter=0;
		wordCheck="";
		for(int i=0; i<letters.length; i++){//looping through all of the letters
			if(search(b, letters, position, 1)){//if the next letter is found, increase the counter
				counter++;
				Ess.DEBUG(DEBUGGABLE, "loopSearch() :: Letter "+letters[i]+" FOUND! " +"Counter:"+counter);
			}else Ess.DEBUG(DEBUGGABLE, "loopSearch() :: next letter not found");
		}

		if(counter==letters.length){//if all the letters are found (adjacent to each other) return true
			Ess.DEBUG(DEBUGGABLE, "loopSearch() :: THAT WORD WAS FOUND!!!");
			return true;
		}
		Ess.DEBUG(DEBUGGABLE, "loopSearch() :: Could not find all letters");
		return false;
	}

	private boolean search(Board b, char[] letters, int[]position, int bound){
		Ess.DEBUG(DEBUGGABLE, "search() :: Into Search -- letters.length:"+letters.length+" \\\\ bound:"+bound);
		if(letters.length==0||letters.length==1){//BASE CASE: if there is nothing to be searched return false
			Ess.DEBUG(DEBUGGABLE, "search() :: Returned due to insufficent characters");
			return false;
		}
		if(bound>=9){//BASE CASE: if the search wrapped ALL the way around and nothing was returned
			Ess.DEBUG(DEBUGGABLE, "search() :: Returned: Bound >= 9 : "+bound);
			return false;//no letter found
		}

		try{
			//above
			if(board[position[0]-1][position[1]]==letters[bound]){//if the position above the previous letter is the next letter
				Ess.DEBUG(DEBUGGABLE, "search() :: ABOVE");
				Ess.DEBUG(DEBUGGABLE, "search() :: FOUND letter "+bound+1+" above letter "+bound +" \\\\" +board[position[0]-1][position[1]] +" \\\\" +letters[bound]);
				position[0]= position[0]--;//redefining position (to be accurate for the next letter search)
				Ess.DEBUG(DEBUGGABLE, "search() :: New position[0],[1] - "+position[0]+","+position[1]);
				return search(b, letters, position, bound+1);//recursion
			}
			//above and right
			else if(board[position[0]-1][position[1]+1]==letters[bound]){//checking above and to the left of the previous letter
				Ess.DEBUG(DEBUGGABLE, "search() :: ABOVE AND RIGHT");
				Ess.DEBUG(DEBUGGABLE, "search() :: FOUND letter "+bound+1+" top-left to letter "+bound +" \\\\ " +board[position[0]-1][position[1]+1] +" \\\\ " +letters[bound]);
				position[0]= position[0]--; position[1]=position[1]+1;//redefining position (to be accurate for the next letter search)
				Ess.DEBUG(DEBUGGABLE, "search() :: New position[0],[1] - "+position[0]+","+position[1]);
				return search(b, letters, position, bound+1);//recursion
			}//right
			else if(board[position[0]][position[1]+1]==letters[bound]){//checking to the right of the previous letter
				Ess.DEBUG(DEBUGGABLE, "search() :: RIGHT");
				Ess.DEBUG(DEBUGGABLE, "search() :: FOUND letter "+bound+1+" top-left to letter "+bound +" \\\\ " +board[position[0]][position[1]+1] +" \\\\ " +letters[bound]);
				position[1]=position[1]+1;//redefining position (to be accurate for the next letter search)
				Ess.DEBUG(DEBUGGABLE, "search() :: New position[0],[1] - "+position[0]+","+position[1]);
				return search(b, letters, position, bound+1);//recursion
			}//below and right
			else if(board[position[0]+1][position[1]+1]==letters[bound]){
				Ess.DEBUG(DEBUGGABLE, "search() :: BELOW AND RIGHT");
				Ess.DEBUG(DEBUGGABLE, "search() :: FOUND letter "+bound+1+" top-left to letter "+bound +" \\\\ " +board[position[0]][position[1]+1] +" \\\\ " +letters[bound]);
				position[0]=position[0]+1; position[1]=position[1]+1;//redefining position (to be accurate for the next letter search)
				Ess.DEBUG(DEBUGGABLE, "search() :: New position[0],[1] - "+position[0]+","+position[1]);
				return search(b, letters, position, bound+1);//recursion
			}//below
			else if(board[position[0]+1][position[1]]==letters[bound]){
				Ess.DEBUG(DEBUGGABLE, "search() :: BELOW");
				Ess.DEBUG(DEBUGGABLE, "search() :: FOUND letter "+bound+1+" top-left to letter "+bound +" \\\\ " +board[position[0]][position[1]+1] +" \\\\ " +letters[bound]);
				position[0]=position[0]+1;//redefining position (to be accurate for the next letter search)
				Ess.DEBUG(DEBUGGABLE, "search() :: New position[0],[1] - "+position[0]+","+position[1]);
				return search(b, letters, position, bound+1);//recursion
			}//below and left
			else if(board[position[0]+1][position[1]-1]==letters[bound]){
				Ess.DEBUG(DEBUGGABLE, "search() :: BELOW AND LEFT");
				Ess.DEBUG(DEBUGGABLE, "search() :: FOUND letter "+bound+1+" top-left to letter "+bound +" \\\\ " +board[position[0]][position[1]+1] +" \\\\ " +letters[bound]);
				position[0]=position[0]+1; position[1]=position[1]-1;//redefining position (to be accurate for the next letter search)
				Ess.DEBUG(DEBUGGABLE, "search() :: New position[0],[1] - "+position[0]+","+position[1]);
				return search(b, letters, position, bound+1);//recursion
			}//left
			else if(board[position[0]][position[1]-1]==letters[bound]){
				Ess.DEBUG(DEBUGGABLE, "search() :: LEFT");
				Ess.DEBUG(DEBUGGABLE, "search() :: FOUND letter "+bound+1+" top-left to letter "+bound +" \\\\ " +board[position[0]][position[1]+1] +" \\\\ " +letters[bound]);
				position[0]=position[0]; position[1]=position[1]-1;//redefining position (to be accurate for the next letter search)
				Ess.DEBUG(DEBUGGABLE, "search() :: New position[0],[1] - "+position[0]+","+position[1]);
				return search(b, letters, position, bound+1);//recursion
			}//above and left
			else if(board[position[0]-1][position[1]-1]==letters[bound]){
				Ess.DEBUG(DEBUGGABLE, "search() :: ABOVE AND LEFT");
				Ess.DEBUG(DEBUGGABLE, "search() :: FOUND letter "+bound+1+" top-left to letter "+bound +" \\\\ " +board[position[0]][position[1]+1] +" \\\\ " +letters[bound]);
				position[0]=position[0]-1; position[1]=position[1]-1;//redefining position (to be accurate for the next letter search)
				Ess.DEBUG(DEBUGGABLE, "search() :: New position[0],[1] - "+position[0]+","+position[1]);
				return search(b, letters, position, bound+1);//recursion
			}
			else{
				Ess.DEBUG(DEBUGGABLE, "search() :: Didn't find a letter \\ Position : "+position[0]+","+position[1] +" \\ Bound : "+bound);
			}
			
			
			
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("search() :: Went out of bounds");
			e.printStackTrace();
		}

		//TODO do search here (around a single letter at a time)
		return true;//del
	}


}
