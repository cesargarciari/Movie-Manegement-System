/* ENSF 480 - TRA Final Project 
Group 3, November 2020
*/

package TRA.Presentation;


import TRA.Control.Subject;

public abstract class Screen {
	
	public Subject subject;
	public int screenID;
	
	/**
	 * This method will update the frame and clear its contents when its respective Screen is finished its process, and will notify
	 * its respective Subject that the Screen has finished, and will add the appropriate data.
	 */
	abstract public void update() ;
	
	/**
	 * This method will build and display the GUI using the passed JFrame.
	 */
	abstract public void buildScreen();
	
}
