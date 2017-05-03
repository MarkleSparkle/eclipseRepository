/* Copyright Mark Frezell 2017
 * All Rights Reserved
 */

public class Position {
	
	//the Position class is an Object.
	
	//very simple. It only holds a state like any other data type would. 
	//it contributes to the state that any position could be. 2,3,5-9
	
	//this Object is meant to be used in an array of positions where each position could be different

	int state;//state (0 - open water, 2 - hit, (5-9) is a boat 
	
	public Position() {
		state = 0;
	}
	public Position(int state){
		this.state=state;
	}
	
	public int getState(){//gets the state of the position
		return this.state;
	}
	
	public void setState(int state){//sets a new state to the position
		this.state = state;
	}

}
