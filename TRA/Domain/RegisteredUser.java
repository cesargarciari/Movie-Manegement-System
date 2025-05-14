/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

/**
 * This class extends the abstract User class and contains information for a user that has been registered into the database
 */
public class RegisteredUser extends User {
    /**
     * The account of the registered user
     */
    private Account userAccount;

    /**
     * The default constructor creates a new account for the registered user
     */
    public RegisteredUser() {
        userAccount = new Account();
    }

    /**
     * Constructs the payment object and sets its information
     * @param accountID the ID of the user's account
     * @param cardNumber the user's card number
     * @param expiryDate the card's expiry date
     * @param csv the card's csv
     * @param emailAddress the user's email
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param password the user's password
     */
    public RegisteredUser(int accountID, String cardNumber, String expiryDate, int csv, String emailAddress, String firstName, String lastName, String password) {
        userAccount = new Account(accountID, new Card(cardNumber, expiryDate, csv), emailAddress, firstName, lastName, password);
    }

    /**
     * Registers the new user into the database
     * @param accountID the ID of the user's account
     * @param cardNumber the user's card number
     * @param expiryDate the card's expiry date
     * @param csv the card's csv
     * @param emailAddress the user's email
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param password the user's password
     */
    public void register(int accountID, String cardNumber, String expiryDate, int csv, String emailAddress, String firstName, String lastName, String password) {
        userAccount = new Account(accountID, new Card(cardNumber, expiryDate, csv), emailAddress, firstName, lastName, password);
    }

    /**
     * Gets the account of the user
     * @return the account
     */
    public Account getUserAccount() {
        return userAccount;
    }
}
