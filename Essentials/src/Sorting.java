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
