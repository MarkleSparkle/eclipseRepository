import java.util.Scanner; 
public class Test {

	public static void main(String[] args) {

		Timer timer = new Timer();
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
	}
	
}

