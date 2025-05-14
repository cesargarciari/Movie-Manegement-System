/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

import java.util.ArrayList;

/**
 * Contains all the information about a showing object
 */
public class Showing {
    /**
     * The date and time of the showing
     */
    private String showtime;
    /**
     * The movie being played
     */
    private Movie movie;
    /**
     * The theatre that is having the showing
     */
    private Theatre theatre;
    /**
     * The seatmap of the showing
     */
    private SeatMap seatMap;
    /**
     * The ID of the showing
     */
    private int showingID;

    /**
     * Constructs the showing object and sets its information
     * @param showingID the ID
     * @param movie the movie
     * @param theatre the theatre
     * @param seatMap the map
     * @param st the time of the showing
     */
    public Showing(int showingID, Movie movie, Theatre theatre, SeatMap seatMap, String st) {
        this.showingID = showingID;
        this.showtime = st;
        this.movie = movie;
        this.theatre = theatre;
        this.seatMap = seatMap;
    }

    /**
     * Gets the show time
     * @return the show time
     */
    public String getShowtime() {
        return showtime;
    }

    /**
     * Sets the showtime
     * @param showtime the new showtime
     */
    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    /**
     * Gets the movie
     * @return the movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Sets the movie
     * @param movie the new movie
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Gets the theatre
     * @return the theatre
     */
    public Theatre getTheatre() {
        return theatre;
    }

    /**
     * Sets the theatre
     * @param theatre the new theatre
     */
    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    /**
     * Gets the seat map
     * @return the seat map
     */
    public SeatMap getSeatMap() {
        return seatMap;
    }

    /**
     * Sets the seat map
     * @param seatMap the new seat map
     */
    public void setSeatMap(SeatMap seatMap) {
        this.seatMap = seatMap;
    }

    /**
     * Gets the showing ID
     * @return the ID
     */
    public int getShowingID() {
        return showingID;
    }

    /**
     * Sets the showing ID
     * @param showingID the new ID
     */
    public void setShowingID(int showingID) {
        this.showingID = showingID;
    }
}
