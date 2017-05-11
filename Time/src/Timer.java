import java.text.SimpleDateFormat;
import java.util.Calendar;

/* Copyright Mark Frezell 2017
 * All Rights Reserved
 */

public class Timer {

    Calendar cal;
    SimpleDateFormat sdf;
    int startMillis, startSecs, startMins, startHour;
    int stopMillis, stopSecs, stopMins, stopHour;
    int compareMillis, compareSecs, compareMins, compareHour;
	
	public Timer() {
		compareMillis=0;
		compareSecs=0;
		compareMins=0;
		compareHour=0;
	}
	
	private void instantate(){
	    cal = Calendar.getInstance();
	}
	
	public void startTimer(){
		instantate();//gets calendar again
	    sdf = new SimpleDateFormat("hh");
		startHour = Integer.parseInt(sdf.format(cal.getTime()));
		
	    sdf = new SimpleDateFormat("mm");
		startMins = Integer.parseInt(sdf.format(cal.getTime()));
		
	    sdf = new SimpleDateFormat("ss");
		startSecs= Integer.parseInt(sdf.format(cal.getTime()));
		
	    sdf = new SimpleDateFormat("SSS");
		startMillis = Integer.parseInt(sdf.format(cal.getTime()));
		
		System.out.println(startHour+":"+startMins+":"+startSecs+":"+startMillis);
		System.out.println("sdf.format = "+sdf.format(cal.getTime()));
	}
	
	public void stopTimer(){
		instantate();//gets calendar again
	    sdf = new SimpleDateFormat("hh");
		stopHour = Integer.parseInt(sdf.format(cal.getTime()));
		
	    sdf = new SimpleDateFormat("mm");
		stopMins = Integer.parseInt(sdf.format(cal.getTime()));
		
	    sdf = new SimpleDateFormat("ss");
		stopSecs= Integer.parseInt(sdf.format(cal.getTime()));
		
	    sdf = new SimpleDateFormat("SSS");
		stopMillis = Integer.parseInt(sdf.format(cal.getTime()));
		
		System.out.println(stopHour+":"+stopMins+":"+stopSecs+":"+stopMillis);
		System.out.println("sdf.format = "+sdf.format(cal.getTime()));
		
		/**						STARTING COMPARE  				**/
		
/*		if(startMins>stopMins) compareHour = (60+startHour)-stopHour;
		else compareHour= stopHour-startHour;//this should also work
		
		if(startSecs>stopSecs) compareMins = (60+startMins)-stopMins;
		else compareMins = stopMins-startMins;//this should also work
		//TODO I have no clue!
		if(startMillis>stopMillis)compareSecs= (60+startSecs)-stopSecs;
		else compareSecs = stopSecs-startSecs;
		
		if(compareSecs<0)compareMillis= (1000+stopMillis-startMillis);
		else compareMillis = stopMillis-startMillis;*/
		
		
		compareHour= stopHour-startHour;
		compareMins= stopMins-startMins; 
		if(compareMins<0){
			compareMins= compareMins+60;
			if(compareHour>0) compareHour--;
		}
		
		compareSecs = stopSecs-startSecs;
		if(compareSecs<0){
			compareSecs= compareSecs+60;
			if(compareMins>0) compareMins--;
		}
		
		compareMillis = stopMillis-startMillis;
		if(compareMillis<0){
			compareMillis= compareMillis+60;
			if(compareSecs>0) compareSecs--;
		}
		
		//System.out.println("Start: "+startMillis +"   Stop: "+stopMillis+"     Compare: "+compareMillis);
		
	}
	
	public String getTime(boolean print){
		String compareTime="";
		if(compareMillis ==0 && compareSecs ==0 && compareMins ==0 && compareHour ==0){
			System.out.println("You must not have ended the timer. There is no final time.");
			return "";
		}
		
		compareTime=compareHour+"hrs "+compareMins+"mins "+compareSecs+"secs "+compareMillis+"millis";
		
		if(print){
			System.out.println("The timer was stopped after "+compareTime);
		}
		
		return compareTime;
	}

}
