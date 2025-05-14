/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

/**
 * Contains all the information about a seat
 */
public class Seat {

    /**
     * The vacancy of the seat will be true if available for purchase
     */
    private boolean vacant;
    /**
     * The number of the seat
     */
    private int seatNumber;
    /**
     * The ID of the seat map that the seat exists in
     */
	private int seatMapID;

    /**
     * Constructs the seat object and sets its information
     * @param seatMapID the ID of the seat map
     * @param seatNumber the seat number
     * @param vacant the vacancy of the seat
     */
    public Seat(int seatMapID, int seatNumber, boolean vacant) {
        this.vacant = vacant;
        this.seatNumber = seatNumber;
        this.seatMapID = seatMapID;
    }

    /**
     * Checks if the seat is vacant
     * @return true if vacant
     */
    public boolean isVacant() {
        return vacant;
    }

    /**
     * Sets the vacancy of the seat
     * @param vacant the new seat status
     */
    public void setVacant(boolean vacant) {
        this.vacant = vacant;
    }

    /**
     * Gets the seat number
     * @return the number
     */
    public int getSeatNumber() {
        return seatNumber;
    }

    /**
     * Sets the number of the seat
     * @param seatNumber the new seat number
     */
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * Gets the ID of the seat map
     * @return the ID
     */
    public int getSeatMapID() {
        return seatMapID;
    }

    /**
     * Sets the ID of the seat map
     * @param seatMapID the new ID
     */
    public void setSeatMapID(int seatMapID) {
        this.seatMapID = seatMapID;
    }
}
