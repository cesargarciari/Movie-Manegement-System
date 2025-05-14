/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

import Database.DatabaseManager;
import TRA.Presentation.HomeScreen;
import FinancialInstitute.FinancialInstitute;
import FinancialInstitute.FinancialInstituteManager;
import java.util.ArrayList;

/**
 * The TRA class implements communication between the DatabaseManager and the Controller of the application
 */
public class TRA {

    /**
     * An instance of the database. This is needed to interact with the database.
     */
    private DatabaseManager databaseManager;
    /**
     * An instance of the financial institute
     */
    private FinancialInstitute financialInstitute;
    /**
     * The current user that is using the application
     */
    private User user;
    /**
     * The current registered user that is using the application
     */
    private RegisteredUser registeredUser;
    /**
     * The current regular user that is using the application
     */
    private RegularUser regularUser;

    /**
     * Constructs the TRA with a given DatabaseManager and User object
     * @param db The DatabaseManager
     * @param u The user
     */
    public TRA(DatabaseManager db, User u) {
        databaseManager = db;
        user = u;
        this.financialInstitute = new FinancialInstituteManager();
    }

    /**
     * The default constructor initializes the connection to the database and creates a new
     * registered user and financial institute
     */
    public TRA() {
        databaseManager = new DatabaseManager();
        databaseManager.initialize(null);
        registeredUser = new RegisteredUser();
        this.financialInstitute = new FinancialInstituteManager();
    }

    /**
     * Sends a Payment object to the financial institute
     * @param payment the Payment object that needs to be processed
     */
    public void sendPaymentToFinancialInstituteForProcessing(Payment payment) {
        this.financialInstitute.processPayment(payment);
    }

    /**
     * Gets all of the movies in the database and returns them
     * @return The ArrayList of movies from the database
     */
    public ArrayList<Movie> sendMovieList() {
        return databaseManager.getMovies();
    }

    /**
     * Gets all of the theatres in the database and returns them
     * @return The ArrayList of theatres from the database
     */
    public ArrayList<Theatre> sendTheatreList() {
        return databaseManager.getTheatres();
    }

    /**
     * Gets all of the showings in the database and returns them
     * @return The ArrayList of showings from the database
     */
    public ArrayList<Showing> sendAllShowings() {
        return databaseManager.getShowings();
    }

    /**
     * Gets all showings containing a certain movie and theatre and returns them
     * @param m the movie in the showing
     * @param t the theatre in the showing
     * @return the ArrayList of showings
     */
    public ArrayList<Showing> getShowings(String m, String t) {
        return databaseManager.getShowingList(m, t);
    }

    /**
     * Gets the seat map containing a certain movie, theatre, and showtime and returns it
     * @param movieTitle the title of the movie
     * @param theatreName the name of the theatre
     * @param showtime the showtime
     * @return the seatmap
     */
    public SeatMap getSeatMap(String movieTitle, String theatreName, String showtime) {
        return databaseManager.getSeatMap(movieTitle, theatreName, showtime);
    }

    /**
     * changes the status of the seat vacancy in the database
     * @param sm the seatmap
     * @param s the seat
     * @param vacant the vacancy of the seat
     */
    public void updateSeatVacancy(SeatMap sm, Seat s, boolean vacant) {
        s.setVacant(vacant);
        databaseManager.updateSeat(sm, s);
    }

    /**
     * Registers a new user in the database
     * @param cardNumber the user's card number
     * @param expiryDate the card's expiry date
     * @param csv the card's csv
     * @param emailAddress the user's email
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param password the user's password
     */
    public void registerUser(String cardNumber, String expiryDate, int csv, String emailAddress, String firstName, String lastName, String password) {
        boolean validEmail = databaseManager.checkEmailAvailability(emailAddress);
        if(validEmail) {
            registeredUser.register(-1, cardNumber, expiryDate, csv, emailAddress, firstName, lastName, password);
            int accountID = databaseManager.registerUser(registeredUser);
            registeredUser.getUserAccount().setAccountID(accountID);
        }
        else {
            System.out.println("Another user has registered with that email. Please try again.");
        }
    }

    /**
     * Validates and logs in the user
     * @param email the user's email
     * @param password the user's password
     */
    public void loginUser(String email, String password) {
        boolean validLogin = databaseManager.validateLogin(email, password);
        if(validLogin) {
            registeredUser = databaseManager.getUser(email, password);
        }
        else {
            System.out.println("Invalid login. Please try again.");
        }
    }

    /**
     * Adds a list of tickets to the database
     * @param ticket the ArrayList of tickets
     * @param email the user's email
     */
    public void storeTicketOrder(ArrayList<Ticket> ticket, String email) {
        databaseManager.createOrder(ticket, email);
    }

    /**
     * returns a list of all orders that are linked to a certain email
     * @param email the email
     * @return the Arraylist of tickets in the orders
     */
    public ArrayList<Ticket> getOrder(String email) {
        return databaseManager.getOrder(email);
    }

    /**
     * gets the financial institute
     * @return the financial institute
     */
    public FinancialInstitute getFinancialInstitute() {
        return financialInstitute;
    }

    /**
     * gets all registered user emails in the database
     * @return an ArrayList of the emails
     */
    public ArrayList<String> getEmails() {
        return databaseManager.getEmails();
    }

    /**
     * gets the ID of a ticket based on a certain showing and ticket
     * @param s the showing
     * @param t the ticket
     * @return the ID of the ticket
     */
    public int getTicketID(Showing s, Ticket t) {
        return databaseManager.getTicketID(s, t);
    }

    /**
     * Removes ticket from database
     * @param ticketID the ticket's ID
     * @return
     */
    public int cancelTicket(int ticketID) {
        return databaseManager.cancelTicket(ticketID);
    }

    /**
     * Looks for email in list of orders
     * @param email the email
     * @return true if the email exists in the list of orders
     */
    public boolean emailExistsInOrders(String email) {
        return databaseManager.emailExistsInOrders(email);
    }

    /**
     * checks to see if the order needs to be removed from the database
     * @param orderID the ID of the order
     */
    public void checkOrderStatus(int orderID) {
        databaseManager.checkOrderStatus(orderID);
    }

    /**
     * checks if the email exists in the user table in the database
     * @param email the email
     * @return true if email does not exist
     */
    public boolean checkEmail(String email) {
    	if(databaseManager.getUser(email)==null)
    		return true;
    	else
    		return false;
    }

    /**
     * gets the user
     * @return the user
     */
	public User getUser() {
		return user;
	}

    /**
     * sets the user to a new user
     * @param user the new user
     */
	public void setUser(User user) {
		this.user = user;
	}

    /**
     * gets the registered user
     * @return the registered user
     */
	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}
}