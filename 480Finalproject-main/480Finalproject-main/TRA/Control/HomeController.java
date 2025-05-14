
package TRA.Control;

import java.util.ArrayList;

import javax.swing.*;


import TRA.Domain.MovieAnnouncementEmail;
import TRA.Domain.RegisteredUser;
import TRA.Domain.TRA;
import TRA.Presentation.HomeScreen;
import TRA.Presentation.Screen;

public class HomeController extends Subject{
	
	
	HomeController itself;
	private JFrame frame;
	private OrderSelectionController orderSelectionController;
	private CancelTicketController cancelTicketController;

	public static final int USER_SELECTION_MOVIE_ANNOUNCEMENT = 5;
	public static final int USER_SELECTION_PAY_ANNUAL_ACCOUNT_FEE = 28;
	private RegistrationController registrationController;
	private LoginController loginController;
	private RegisteredUser theUser;
	private TRA theTRA;

	
	public HomeController(JFrame frame) {
		this.frame = frame;
		theTRA = new TRA();
		theUser = null;
		setID(1);
	}
	
	
	/**
	 * Uses the given frame, and constructs the HomeScreen frame. Afterwards, the method waits for an input from the HomeScreen
	 * where it calls the next function.
	 */
	public void doAction() {
		
		
		while(true) {
			setID(1);
			int prevID = getID();
			Screen Screen = new HomeScreen(frame, itself);
			Screen.buildScreen();
			System.out.println("This is the ID: " + getID());
			int i = 0;
			while(getID() == prevID) {
				if(i == 0)
					System.out.println("Waiting for button press on HomeScreen...");
				i++;
			}
			System.out.println("We have exited the while loop!!11!!!");
			switch (getID()) {
				case 2:
					System.out.println("User Selected Order");
					doOrderSelection();
					break;
				case 3:
					System.out.println("User Selected Cancel Ticket");
					doCancelTicketSelection();
					break;
				case 4:
					System.out.println("User Selected Registration");
					doRegistration();
					break;
				case USER_SELECTION_MOVIE_ANNOUNCEMENT:
					System.out.println("Beginning Movie Announcement Email");
					doMovieAnnouncement();
					break;
				case 7:
					System.out.println("User Selected Registration");
					doLogin();
					break;
				case USER_SELECTION_PAY_ANNUAL_ACCOUNT_FEE:
					System.out.println("Beginning pay annual account fee");
					doPayAnnualAccountFee();
					break;
			}

		}
		
	}

	/**
	 * This method checks whether or not there is a user that is logged, and if there is,
	 * calls the related Annual Payment controllers to complete the payment.
	 */
	private void doPayAnnualAccountFee() {
		System.out.println("Doing pay annual account fee");
		//Check if user is logged in and if they aren't tell them they can't pay their fee
		if (this.theUser == null) {
			JOptionPane.showMessageDialog(new JFrame(), "Please log in before paying annual account fee.");
		} else {
			//Otherwise do annual account fee payment for user
			PayAnnualAccountFeeController feeController =
					new PayAnnualAccountFeeController(this.theUser, this.theTRA);
			feeController.doAction();
			JOptionPane.showMessageDialog(new JFrame(), "Your annual account fee has been paid! Please check your email for your receipt.");
		}

	}
	
	/**
	 * This method calls the MovieAnnouncementController doAction to perform the MovieAnnouncment for all the registered users
	 * in the database.
	 */
	private void doMovieAnnouncement() {
		System.out.println("Doing movie announcement");
		JOptionPane.showMessageDialog(new JFrame(), "Movie Announcement Email has been sent to all registered users!");
		MovieAnnouncementController movieAnnouncementController = new MovieAnnouncementController();
		movieAnnouncementController.doAction();
	}
	
	/**
	 * Creates an OrderSelectionController and passes GUI control to the controller to run the Order Selection sequence.
	 */
	private void doOrderSelection() {
		// TODO Auto-generated method stub
		orderSelectionController = new OrderSelectionController(frame, itself, theUser);
		orderSelectionController.setItself(orderSelectionController);
		orderSelectionController.runOrderSelection();
	}
	
	/**
	 * Creates a RegistrationController and passes GUI control to the controller to run the registration sequence.
	 */
	private void doRegistration() {
		// TODO Auto-generated method stub
		registrationController = new RegistrationController(frame, itself);
		registrationController.setItself(registrationController);
		registrationController.runRegistration();
	}
	
	/**
	 * Creates a LoginController and passes GUI control to the controller to run the login sequence.
	 */
	private void doLogin() {
		// TODO Auto-generated method stub
		loginController = new LoginController(frame, itself, theTRA);
		loginController.setItself(loginController);
		loginController.runLogin();
		theUser = loginController.getTheUser();
	}

	/**
	 * This method finds the order status of theUser, and afterwards 
	 * Creates a CancelTicketController and passes GUI control to the controller to run the cancel ticket sequence.
	 */
	private void doCancelTicketSelection() {
		// TODO Auto-generated method stub
		boolean orderExists = true;
		if(theUser != null) {
			orderExists = theTRA.emailExistsInOrders(theUser.getUserAccount().getEmailAddress());
		}
		if(orderExists) {
			cancelTicketController = new CancelTicketController(frame, itself, theUser);
			cancelTicketController.setItself(cancelTicketController);
			cancelTicketController.runCancelTicketSelection();
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "There are no orders registered with this account");
		}
	}

	@Override
	public void addData(String data) {
		// TODO Auto-generated method stub
		
	}
	
	public void setItself(HomeController itself) {
		this.itself = itself;
	}
	
	public RegisteredUser getTheUser() {
		return theUser;
	}

	public void setTheUser(RegisteredUser theUser) {
		this.theUser = theUser;
	}
	
}
