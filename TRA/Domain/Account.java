/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

/**
 * The account of a registered user stores all user data
 */
public class Account {
    /**
     * The ID of the account
     */
    private int accountID;
    /**
     * The user's card
     */
    private Card card;
    /**
     * The user's email
     */
    private String emailAddress;
    /**
     * The user's first name
     */
    private String firstName;
    /**
     * The user's last name
     */
    private String lastName;
    /**
     * The user's password
     */
    private String password;

    public Account() {}

    /**
     * Sets the account of the user so that it contains the given user information
     * @param accountID the account ID
     * @param card the user's card
     * @param emailAddress the user's email
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param password the user's password
     */
    public Account(int accountID, Card card, String emailAddress, String firstName, String lastName, String password) {
        this.accountID = accountID;
        this.card = card;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    /**
     * gets the ID of the account
     * @return the ID
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     * sets the account ID
     * @param id the new ID
     */
    public void setAccountID(int id) {
        accountID = id;
    }

    /**
     * gets the user's card
     * @return the card
     */
    public Card getCard() {
        return card;
    }

    /**
     * gets the user's email
     * @return the email
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
}
