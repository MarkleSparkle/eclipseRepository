import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner; 
public class Test {

	public static void main(String[] args) {

		/*		Timer timer = new Timer();
		Scanner sc = new Scanner(System.in);
		int counter=0;
		timer.startTimer();

		for(int i=0; i<500000000; i++){
			counter++;
			counter++;
			counter++;
			counter++;
		}
		sc.nextLine();

		timer.stopTimer();
		timer.getTime(true);
		 */

		LinkedList <String> lst = new LinkedList<String>();
		lst.add("1");
		lst.add("2");
		lst.add("3");
		ListIterator <String> iter = (ListIterator<String>) lst.iterator();

		while(iter.hasNext()){ //6.
			iter.next(); //goes to the last element (cycles while there's still next)
		} iter.previous(); //returns the to element before the last
		System.out.println(iter.next()); //prints the last element


		while(iter.hasPrevious()){ //7.
			iter.previous(); //returns the to first index (cycles while still previous)
		} iter.next(); //position one after the first
		System.out.println(iter.previous()); //prints the first element


		int index = 0;
		while(iter.hasNext()){ //8.
			iter.next();
			index = iter.nextIndex(); //gets the last position index (size)
		}
		int middle = (int) (index/2); //divides the size by two and sets that index as the 'middle'
		System.out.println("Middle: "+middle);//states the middle value
		while(middle!=(iter.previousIndex()+1)){//goes to the middle index
			iter.previous();//previous while the index is not the middle index
		} iter.next();
		System.out.println("Removing: "+iter.previous());//says what it's removing
		iter.remove();//removes the var at the index 'middle'


		while(iter.hasNext()){ //9.
			iter.next();//cycles next until there is no next element
		} iter.set("last");//set element to "last"
		iter.previous(); System.out.println(iter.next());//printing last element

		
		int index2 = 0;
		while(iter.hasNext()){ //10.
			iter.next();
			index2 = iter.nextIndex(); //gets the last position index (size)
		}
		int middle2 = (int) (index2/2); //divides the size by two and sets that index as the 'middle'
		System.out.println("Middle: "+middle2);//states the middle value
		while(middle2!=(iter.previousIndex()+1)){//goes to the middle index
			iter.previous();//previous while the index is not the middle index
		} iter.add("middle");
		
		
		while(iter.hasNext()){ //11.
			iter.next(); //goes to the last element (cycles while there's still next)
		} iter.previous(); //returns the to element before the last
		System.out.println(iter.next()); //prints the last element		
	
	
	
		LinkedList <String> list = new LinkedList<String>();
		Iterator <String> iterator = list.iterator(); //12. initializing an Iterator from a list
		ListIterator <String> listIterator = (ListIterator<String>) list.iterator(); //13. initializing a ListIterator from a list
	}
}

