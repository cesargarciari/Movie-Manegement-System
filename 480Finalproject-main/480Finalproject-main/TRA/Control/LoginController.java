package TRA.Control;

import java.util.ArrayList;

import javax.swing.JFrame;

import Database.DatabaseManager;
import TRA.Domain.RegisteredUser;
import TRA.Domain.TRA;
import TRA.Presentation.LoginScreen;
import TRA.Presentation.Screen;

public class LoginController extends Subject{
	private RegisteredUser theUser;
	static int accountID;
	private String email;
	private String password;
	private TRA tra;
	DatabaseManager db;
	private JFrame frame;
	private LoginController itself;
	
	
	public LoginController(JFrame frame, Subject subject, TRA theTRA) {
		this.tra = theTRA;
		this.frame = frame;
		setID(7);	//ID for OrderSelection Frame;
		//data = new ArrayList<String>();
	}
	
	/**
	 * This method takes the given email and password from the LoginScreen, and send it to the Database to 
	 * retrieve the user with the given information to store in the class.
	 * @param email user given email for account
	 * @param password	user given password for account
	 */
	public void completeLogin(String email, String password) {
		tra.loginUser(email, password);
		theUser = tra.getRegisteredUser();
	}

	@Override
	public void addData(String data) {
		// TODO Auto-generated method stub
		
	}

	
	public void setItself(LoginController registrationController) {
		this.itself = registrationController;
	}

	/**
	 * Creates a LoginScreen and waits until the Screen sends an input.
	 */
	public void runLogin() {
		Screen Screen = new LoginScreen(frame, itself);
		Screen.buildScreen();
		
		int prevID = getID();
		int i = 0;
		while(getID() == prevID) {
			if(i == 0) 
				System.out.println("waiting for RegistrationScreen to finish...");
			i++;
			}
		System.out.println("exited while loop");
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public RegisteredUser getTheUser() {
		return theUser;
	}

	public void setTheUser(RegisteredUser theUser) {
		this.theUser = theUser;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public LoginController getItself() {
		return itself;
	}


}
