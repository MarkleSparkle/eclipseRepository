import java.util.Scanner;

public class Ess {
	
	///////////////////////////////////////////// CONSOLE CLEANERS//////////////////////////////////////////////////////

	/********************************************* printArray **********************************************/

	public static void printArray(int[] array, int dashType, String title) { // prints
		// array
		String msg = "";

		for (int i = 0; i < array.length; i++) {
			msg += array[i];
			if (i + 1 != array.length) {// if array != EOF then print comma
				msg += ", ";
			}
		}
		if (dashType != 0)
			dashSeperator(dashType);
		if (title.equals(null))
			title = "PRINT ARRAY";
		output(" ~ " + title + " ~ ");
		output(" Positions: " + array.length);
		output(" FULL PRINT:\n" + " " + msg);
		if (dashType != 0)
			dashSeperator(dashType);
	}

	public static void printArray(String[] array, int dashType, String title) { // prints
		// array
		String msg = "";

		for (int i = 0; i < array.length; i++) {
			msg += array[i];
			if (i + 1 != array.length) {// if array != EOF then print comma
				msg += ", ";
			}
		}
		if (dashType != 0)
			dashSeperator(dashType);
		if (title.equals(null))
			title = "PRINT ARRAY";
		output(" ~ " + title + " ~ ");
		output(" Positions: " + array.length);
		output(" FULL PRINT:\n" + " " + msg);
		if (dashType != 0)
			dashSeperator(dashType);
	}

	public static void printArray(double[] array, int dashType, String title) { // prints
		// array
		String msg = "";

		for (int i = 0; i < array.length; i++) {
			msg += array[i];
			if (i + 1 != array.length) {// if array != EOF then print comma
				msg += ", ";
			}
		}
		if (dashType != 0)
			dashSeperator(dashType);
		if (title.equals(null))
			title = "PRINT ARRAY";
		output(" ~ " + title + " ~ ");
		output(" Positions: " + array.length);
		output(" FULL PRINT:\n" + " " + msg);
		if (dashType != 0)
			dashSeperator(dashType);
	}

	public static void printArray(int[] array, int dashType, int position, String title) { // prints
		// array
		// and
		// shows
		// the
		// value
		// at
		// position
		String msg = "";

		for (int i = 0; i < array.length; i++) {
			msg += array[i];
			if (i + 1 != array.length) {// if array != EOF then print comma
				msg += ", ";
			}
		}
		if (dashType != 0)
			dashSeperator(dashType);
		if (title.equals(null))
			title = "PRINT ARRAY";
		output(" ~ " + title + " ~ ");
		output(" Positions: " + array.length);
		output(" Position at " + position + ": " + array[position]);
		output(" FULL PRINT:\n" + msg);
		if (dashType != 0)
			dashSeperator(dashType);

	}

	public static void printArray(String[] array, int dashType, int position, String title) { // prints
		// array
		// and
		// shows
		// the
		// value
		// at
		// position
		String msg = "";

		for (int i = 0; i < array.length; i++) {
			msg += array[i];
			if (i + 1 != array.length) {// if array != EOF then print comma
				msg += ", ";
			}
		}
		if (dashType != 0)
			dashSeperator(dashType);
		if (title.equals(null))
			title = "PRINT ARRAY";
		output(" ~ " + title + " ~ ");
		output(" Positions: " + array.length);
		output(" Position at " + position + ": " + array[position]);
		output(" FULL PRINT:\n" + msg);
		if (dashType != 0)
			dashSeperator(dashType);

	}

	public static void printArray(double[] array, int dashType, int position, String title) { // prints
		// array
		// and
		// shows
		// the
		// value
		// at
		// position
		String msg = "";

		for (int i = 0; i < array.length; i++) {
			msg += array[i];
			if (i + 1 != array.length) {// if array != EOF then print comma
				msg += ", ";
			}
		}
		if (dashType != 0)
			dashSeperator(dashType);
		if (title.equals(null))
			title = "PRINT ARRAY";
		output(" ~ " + title + " ~ ");
		output(" Positions: " + array.length);
		output(" Position at " + position + ": " + array[position]);
		output(" FULL PRINT:\n" + msg);
		if (dashType != 0)
			dashSeperator(dashType);
	}

	/********************************************* print 2D *******************************************/

	public static void print2D(double[][] array, int dashType, String title) {//prints array
		String msg = "[";

		for (int i = 0; i < array[0].length; i++){
			for(int j=0; j < array[1].length; j++){
				msg += array[i][j];
				if(j+1 == array[1].length){
					j=0;
					msg+="]\n[";
				}
				if (i + 1 != array[0].length) {// if array is not at the end then print comma
					msg += ", ";
				}
			}

		}
		msg += "]";
		if (dashType != 0)
			dashSeperator(dashType);
		if (title.equals(null))
			title = "PRINT ARRAY";
		output(" ~ " + title + " ~ ");
		output(" Positions: " + array.length);
		output(" FULL PRINT:\n" + " " + msg);
		if (dashType != 0)
			dashSeperator(dashType);

	}

	/********************************************* truncateArray *******************************************/

	public static String[] truncateArray(String[]array, int positionsNotIndex){//uses the positions that have value (inputed) and truncates the rest
		String[]trunked = new String[positionsNotIndex];

		for(int i=0; i<positionsNotIndex;i++){
			trunked[i]=array[i];
		}
		return trunked;


	}

	/********************************************* output *********************************************/

	public static void output(String string) { // outputs String to the console
		System.out.println(string);
	}
	public static void out(String string) { // outputs String to the console WITHOUT NEW LINE
		System.out.print(string);
	}

	/********************************************* center *********************************************/

	public static void center(String string){

		int spaces = (int) ((126/2)-(string.length()/2));

		for(int i=0; i<spaces; i++){
			Ess.out(" ");
		}
		Ess.out("~ ~ ~ ");
		Ess.out(string);
		Ess.output(" ~ ~ ~");
	}

	/********************************************* margin *********************************************/

	public static void margin(int margin, String string){

		for(int i=0; i<margin; i++){
			Ess.out(" ");
		}
		Ess.out("~ ~ ~ ");
		Ess.out(string);
		Ess.output(" ~ ~ ~");
	}

	/********************************************* title *********************************************/

	public static void title(String string){

		int spaces = (int) ((126/2)-(string.length()/2));

		for(int i=0; i<spaces; i++){
			Ess.out("-");
		}
		Ess.out(string);
		for(int i=0; i<spaces; i++){
			Ess.out("-");
		}
		Ess.output("");
	}

	/********************************************* printMenu *********************************************/

	public static void printMenu(String first, String second, String third, String fourth){
		boolean three=true, four=true;//false if there is no content
		double spaces;
		int counter=0;
		int difference;
		if(third.equals(""))three=false;
		if(fourth.equals(""))four=false;

		System.out.println("**************************");


		//printing number 1
		counter++;
		System.out.println("*                        *");
		spaces = (24-first.length())/2;
		Ess.out("*"); for(int i=0; i<spaces; i++) Ess.out(" "); Ess.out(first);for(int i=0; i<spaces; i++) Ess.out(" "); 
		if(24>((spaces*2)+first.length())){
			difference=(int) (24-(spaces*2+first.length()));
			for(int i=0; i<difference;i++)Ess.out(" ");
		} 
		Ess.output("*");
		System.out.println("*        Press "+counter+"         *");


		//printing number 2
		counter++;
		System.out.println("*                        *");
		spaces = (24-second.length())/2;
		Ess.out("*"); for(int i=0; i<spaces; i++) Ess.out(" "); Ess.out(second);for(int i=0; i<spaces; i++) Ess.out(" ");
		if(24>((spaces*2)+second.length())){
			difference=(int) (24-(spaces*2+second.length()));
			for(int i=0; i<difference;i++)Ess.out(" ");
		} 
		Ess.output("*");
		System.out.println("*        Press "+counter+"         *");


		if(three){//print number 3 if there is three
			counter++;
			System.out.println("*                        *");
			spaces = (24-third.length())/2;
			Ess.out("*"); for(int i=0; i<spaces; i++) Ess.out(" "); Ess.out(third);for(int i=0; i<spaces; i++) Ess.out(" ");
			if(24>((spaces*2)+third.length())){
				difference=(int) (24-(spaces*2+third.length()));
				for(int i=0; i<difference;i++)Ess.out(" ");
			} 
			Ess.output("*");
			System.out.println("*        Press "+counter+"         *");
		}


		if(four){
			counter++;
			System.out.println("*                        *");
			spaces = (24-fourth.length())/2;
			Ess.out("*"); for(int i=0; i<spaces; i++) Ess.out(" "); Ess.out(fourth);for(int i=0; i<spaces; i++) Ess.out(" "); 
			if(24>((spaces*2)+fourth.length())){
				difference=(int) (24-(spaces*2+fourth.length()));
				for(int i=0; i<difference;i++)Ess.out(" ");
			} 
			Ess.output("*");
			System.out.println("*        Press "+counter+"         *");
		}
		//Exit
		counter++;
		System.out.println("*                        *");
		System.out.println("*         Exit?          *");
		System.out.println("*        Press "+counter+"         *");
		System.out.println("*                        *");
		System.out.println("**************************");



	}

	/********************************************* clearScreen *********************************************/

	public static void clearScreen() { // clears screen with newline characters
		for (int i = 0; i < 100; i++) {
			System.out.println("\n");
		}
	}

	/********************************************* lines *********************************************/

	public static void lines(int amount) { // prints newline characters
		for (int i = 0; i < amount; i++) {
			System.out.println("");
		}
	}

	/********************************************* dashSeperator *********************************************/

	public static void dashSeperator(int dashType) {
		char[] dash = new char[] { ' ', '~', '-', '=', '/', '\\' };
		// types of cross console dashes to use

		for (int i = 0; i < 134; i++) {
			System.out.print(dash[dashType]);
		}
		output("");// newline
	}

	/********************************************* dashSeperator *********************************************/

	public static void DEBUG(boolean DEBUGGABLE, String x) {

		if(DEBUGGABLE){
			System.out.println("DEBUG: "+x);
		}

	}
	
	/********************************************* readDouble *********************************************/
	
	public static void readDouble(String promptText){
	
		Scanner scanner = new Scanner(System.in);
		Double input;
		
		out(promptText+" > ");
		input = scanner.nextDouble();
		
		scanner.close();
		return input;
	}
	
	//TODO make implementation for all the inputs

	/********************************************* EOP *********************************************/

	public static void eop() {
		output("~ ~ End Of Program! ~ ~");
	}

	//////////////////////////////////////// SORTING ALGORITHMS///////////////////////////////////////////

	/********************************************* selectionSort *********************************************/

	public static int[] selectionSort(int[] array, boolean printable, String printTitle) {

		for (int i = 0; i < array.length - 1; i++) {// goes through the whole
			// array
			int index = i;
			for (int j = i + 1; j < array.length; j++)
				if (array[j] < array[index])
					index = j;

			int smallerNumber = array[index];
			array[index] = array[i];
			array[i] = smallerNumber;
		}
		if (printable)
			printArray(array, 3, printTitle);
		// Resources from:
		// http://www.java2novice.com/java-sorting-algorithms/selection-sort/#sthash.dYabLSIO.dpuf
		return array;
	}

	public static String[] selectionSort(String[] array, boolean printable, String printTitle) {

		for (int i = 0; i < array.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < array.length; j++)
				if (array[j].compareTo(array[index]) < 0)// if the target is
					// later in the
					// alphabet
					index = j;

			String wordCloserToA = array[index];
			array[index] = array[i];
			array[i] = wordCloserToA;
		}
		if (printable)
			printArray(array, 3, printTitle);
		// Resources from:
		// http://www.java2novice.com/java-sorting-algorithms/selection-sort/#sthash.dYabLSIO.dpuf
		return array;
	}

	/********************************************* bubbleSort *********************************************/

	public static int[] bubbleSort(int[] array, boolean printable, String printTitle) {
		int n = array.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {// looping while the array still has length
			for (int j = 1; j < (n - i); j++) {// looks at the next two
				// variables while they are out
				// of order
				if (array[j - 1] > array[j]) {
					// swaps elements
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;

				}
			}
		}
		if (printable)
			printArray(array, 3, printTitle);
		// Resources from:
		// http://www.javatpoint.com/bubble-sort-in-java
		return array;
	}

	public static String[] bubbleSort(String[] array, boolean printable, String printTitle) {
		int n = array.length;
		String temp = "";

		for (int i = 0; i < n; i++) {// looping while the array still has length
			for (int j = 1; j < (n - i); j++) {// looks at the next two
				// variables while they are out
				// of order
				if (array[j - 1].compareTo(array[j]) > 0) {
					// swaps elements
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;

				}
			}
		}
		if (printable)
			printArray(array, 3, printTitle);
		// Resources from:
		// http://www.javatpoint.com/bubble-sort-in-java
		return array;
	}

	/********************************************* insertionSort *********************************************/

	public static int[] insertionSort(int[] array, boolean printable, String printTitle) {

		for (int i = 1; i < array.length; i++) {// looping so the entire array
			// is looked at
			int temp = array[i];
			int j;

			for (j = i - 1; j >= 0 && temp < array[j]; j--) {// loops while the
				// two viewed
				// boxes are
				// unsorted
				// //while
				// array[i] is
				// in the wrong
				// spot...
				array[j + 1] = array[j];// switches the positions of array[i]
				// and the previous (assuming the
				// previous position is less than
				// array[i])
				array[j + 1] = temp;// resets temp to the next number for
				// comparison
			}

		}
		if (printable)
			printArray(array, 3, printTitle);
		// Resources from:
		// http://courses.cs.washington.edu/courses/cse373/01wi/slides/Measurement/sld010.htm
		return array;
	}

	public static String[] insertionSort(String array[], boolean printable, String printTitle) {
		int n = array.length;// initializing vars
		for (int j = 1; j < n; j++) {// loops through the entire array
			String key = array[j];// sets the key to the first unsorted position
			// (1 and onward)
			int i = j - 1;
			while ((i > -1) && (array[i].compareToIgnoreCase(key) > 0)) {// while
				// there's
				// stuff
				// in
				// the
				// array
				// and
				// the
				// data
				// is
				// unordered
				array[i + 1] = array[i];// switches the data
				i--;// going to check the previous variable
			}
			array[i + 1] = key;// going to check again

		}
		if (printable)
			printArray(array, 3, printTitle);
		return array;
	}

	/********************************************* checkSort ***************************************************/

	public static boolean checkSort(int[] array) {
		boolean sorted = false;
		int counter = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i - 1] <= array[i])
				counter++;
		}
		if (counter == array.length)
			sorted = true;

		return sorted;

	}

	////////////////////////////////////////// MERGE ALGORITMS //////////////////////////////////////////

	/********************************************** Concatenate List *********************************************/

	public static int[] concatenate(int[] array1, int[] array2, boolean printable, String printTitle) {// concatenate
		// array
		// method
		int index = (array1.length) + (array2.length);// creating an index the
		// length of array1 and
		// 2 combined
		int i;// initializing variables
		int[] newArray = new int[index];// creating that new array that will be
		// used for the combination
		for (i = 0; i < array1.length; i++)
			newArray[i] = array1[i]; // adding the first array of values into
		// the new array
		for (int j = 0; j < array2.length; j++) {// adding the second array of
			// values into the new array
			newArray[i] = array2[j];
			i++;
		}

		if (printable)
			printArray(newArray, 3, printTitle);// printing array
		return newArray;// returning the new array
	}

	public static String[] concatenate(String[] array1, String[] array2, boolean printable, String printTitle) {// concatenate
		// array
		// method
		int index = (array1.length) + (array2.length);// creating an index the
		// length of array1 and
		// 2 combined
		int i;// initializing variables
		String[] newArray = new String[index];// creating that new array that
		// will be used for the
		// combination
		for (i = 0; i < array1.length; i++)
			newArray[i] = array1[i]; // adding the first array of values into
		// the new array
		for (int j = 0; j < array2.length; j++) {// adding the second array of
			// values into the new array
			newArray[i] = array2[j];
			i++;
		}

		if (printable)
			printArray(newArray, 3, printTitle);// printing array
		return newArray;// returning the new array
	}

	/********************************************** Interweave List	 *********************************************/

	public static String[] interweave(String[] array1, String[] array2, boolean printable, String printTitle) {
		int index = (array1.length) + (array2.length);// creating an index the
		// length of array1 and
		// 2 combined
		int i;// initializing variables
		String[] newArray = new String[index];// creating that new array that
		// will be used for the
		// combination

		Ess.lines(2);
		Ess.output("My Algorithm Performs As:");
		newArray = concatenate(array1, array2, false, null);
		newArray = insertionSort(newArray, false, null);
		if (printable)
			printArray(newArray, 2, printTitle);
		return newArray;
	}

	////////////////////////////////////// SEARCHING ALGORITHMS///////////////////////////////////

	/********************************************* binarySearch *********************************************/

	public static int binarySearch(String[] a, String target) {// returns the
		// place the
		// srchVal was
		// in (otherwise
		// returns -1)

		int low = 0;
		int high = a.length - 1;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			if (target.compareTo(a[mid]) == 0) {// if they are the same
				return mid;
			} else if (target.compareTo(a[mid]) < 0) {// the search value is
				// less than the value
				// in the revealed box
				high = mid - 1;
			} else {// the search value is greater than the value in the
				// revealed box
				low = mid + 1;
			}
		}
		return -1;// returns -1 if the value is not found
	}

}
