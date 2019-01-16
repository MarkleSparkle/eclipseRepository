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
