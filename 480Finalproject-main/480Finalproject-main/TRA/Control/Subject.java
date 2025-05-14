package TRA.Control;

import java.util.ArrayList;

public abstract class Subject {
	
	
	private int frameID; //ID of current GUI
	
	public void setID(int i) {
		this.frameID = i;
	}
	
	public int getID() {
		return this.frameID;
	}

	abstract public void addData(String data);
	
	
	
	
}
