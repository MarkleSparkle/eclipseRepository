import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Display implements Time {

    Calendar cal;
    SimpleDateFormat sdf;
	
	public Display() {
	    cal = Calendar.getInstance();
	}
	
	private void instantate(){
	    cal = Calendar.getInstance();
	}
	
	public void displayNormal(){//displays like a normal clock
		instantate();
	    sdf = new SimpleDateFormat("HH:mm");
		System.out.println("Current Time (24hr) : "+sdf.format(cal.getTime()));	
	}
	
	public void displayMinutes() {//displays minutes and seconds
		instantate();
		sdf = new SimpleDateFormat("mm:ss");
		System.out.println("Current Time (mm:ss) : "+sdf.format(cal.getTime()));
	}

	public void displaySecond() {//displays seconds and millis
		instantate();
		sdf = new SimpleDateFormat("mm:SS");
		System.out.println("Current Time (mm:SS) : "+sdf.format(cal.getTime()));
	}
	public void displayMillisecond() {//displays seconds and millis
		instantate();
		sdf = new SimpleDateFormat("SS");
		System.out.println("Current Time (SS) : "+sdf.format(cal.getTime()));
	}
	
	public void compareMillis(){
		//start here to compare two times
	}


}
