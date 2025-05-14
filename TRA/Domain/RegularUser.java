/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

/**
 * This class extends the abstract User class and contains information for a user that has not registered
 */
public class RegularUser extends User {
    /**
     * The user's email
     */
    private String email;
    /**
     * The user's card
     */
    private Card card;

    /**
     * The default constructor
     */
    public RegularUser() {}

    /**
     * Gets the email of the user
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's card
     * @return the card
     */
    public Card getCard() {
        return card;
    }

    /**
     * Sets the user's card
     * @param cardNumber the card number
     * @param expiry the expiry date
     * @param csv the card's csv
     */
    public void setCard(String cardNumber, String expiry, int csv) {
        this.card = new Card(cardNumber, expiry, csv);
    }
}
