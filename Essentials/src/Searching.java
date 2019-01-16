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
