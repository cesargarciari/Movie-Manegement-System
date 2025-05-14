/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

/**
 * This contains all the information about a user's card
 */
public class Card {
    /**
     * The card number
     */
    private String cardNumber;
    /**
     * The card's expiry date
     */
    private String expiryDate;
    /**
     * The csv number
     */
    private int csv;

    /**
     * Sets the card's information to the given fields
     * @param cardNumber the card number
     * @param expiryDate the expity date of the card
     * @param csv the card's csv
     */
    public Card(String cardNumber, String expiryDate, int csv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.csv = csv;
    }

    /**
     * Resets the card information to the given fields
     * @param cardNumber the card number
     * @param expiryDate the expity date of the card
     * @param csv the card's csv
     */
    public void updateCardInformation(String cardNumber, String expiryDate, int csv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.csv = csv;
    }

    /**
     * Gets the card number
     * @return the card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * sets the card number to the given int
     * @param cardNumber the new card number
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the card's expiry date
     * @return the expiry date
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * sets the expiry to the given String
     * @param expiryDate the new expiry date
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Gets the card's csv
     * @return the csv
     */
    public int getCsv() {
        return csv;
    }

    /**
     * sets the csv to the given int
     * @param csv the new csv
     */
    public void setCsv(int csv) {
        this.csv = csv;
    }
}
