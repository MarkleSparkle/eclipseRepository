/* Copyright Mark Frezell 2017
 * All Rights Reserved
 */

package Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class Dictionary {

	static BufferedReader br;

	public Dictionary() {
		/* 
		 * Dictionary searches the English language for a match of an entered word
		 */
		
		try{
			File file = new File("dictionary.txt");
			br = new BufferedReader(new FileReader(file));
		}catch(FileNotFoundException e){
			System.out.println("Failed to open dictionary");
		}

	}

	public boolean contains(String x){

		/* Compares the string to the dictionary's resource.
		 * 
		 * @param String to be checked
		 * @return returns true if the string is matched in the dictionary
		 */

		String dictLine; //line of the dictionary (to be used for cycling)
		try{
			while ((dictLine = br.readLine()) != null) {
				if(dictLine.equalsIgnoreCase(x)) return true;
			}
		}catch(IOException e){
			System.out.println("Forcable closed dictionary search");
		}
		return false;
	}
	
	public void close(){
		
		/*
		 * Closes dictionary
		 */
		
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("Failed to close file");
		}
	}

}
