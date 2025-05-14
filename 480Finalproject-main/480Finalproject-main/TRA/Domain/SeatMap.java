/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

import java.util.ArrayList;

/**
 * Contains all the information about a seat map object
 */
public class SeatMap {
	/**
	 * The list of seats in the map
	 */
	private ArrayList<Seat> seats;
	/**
	 * The number of reserved seats
	 */
	private int reservedSeatCount;
	/**
	 * The number of rows in the map
	 */
	private int numberOfRows;
	/**
	 * The number of available seats in the map
	 */
	private int numberOfAvailableSeats;
	/**
	 * The ID of the map
	 */
	private int seatMapID;

	/**
	 * Constructs the seatmap object and sets its information
	 * @param seatMapID the ID of the map
	 * @param reservedSeatCount the number of reserved seats
	 * @param numberOfRows the number of rows
	 * @param numberOfAvailableSeats the number of available seats
	 * @param seats the ArrayList of seats in the map
	 */
	public SeatMap(int seatMapID, int reservedSeatCount, int numberOfRows, int numberOfAvailableSeats, ArrayList<Seat> seats) {
	        this.seats = seats;
	        this.reservedSeatCount = reservedSeatCount;
	        this.numberOfRows = numberOfRows;
	        this.numberOfAvailableSeats = numberOfAvailableSeats;
	        this.seatMapID = seatMapID;
	    }

	/**
	 * Sets the number of reserved seats
	 * @param reservedSeatNum the new number of reserved seats
	 */
	public void updateReservedSeatCount(int reservedSeatNum) {
	        reservedSeatCount = reservedSeatNum;
	    }

	/**
	 * Sets the number of available seats
	 * @param availableSeats the new number of available seats
	 */
	public void updateAvailableSeats(int availableSeats) {
	        numberOfAvailableSeats = availableSeats;
	    }

	/**
	 * Gets the list of seats in the map
	 * @return the ArrayList of seats
	 */
	public ArrayList<Seat> getSeats() {
	        return this.seats;
	    }

	/**
	 * Gets the number of reserved seats
	 * @return the number of reserved seats
	 */
	public int getReservedSeatCount() {
	        return reservedSeatCount;
	    }

	/**
	 * Gets the number of rows
	 * @return the number of rows
	 */
	public int getNumberOfRows() {
	        return numberOfRows;
	    }

	/**
	 * Gets the number of available seats
	 * @return the number of available seats
	 */
	public int getNumberOfAvailableSeats() {
	        return numberOfAvailableSeats;
	    }

	/**
	 * Gets the ID of the map
	 * @return the ID
	 */
	public int getSeatMapID() {
			return seatMapID;
		}

	/**
	 * Sets the map ID
	 * @param seatMapID the new ID
	 */
		public void setSeatMapID(int seatMapID) {
			this.seatMapID = seatMapID;
		}
	    
	    

}
