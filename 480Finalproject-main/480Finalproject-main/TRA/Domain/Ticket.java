/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

/**
 * Contains all the information about a ticket object
 */
public class Ticket {
    /**
     * The ticket's movie
     */
    private Movie movie;
    /**
     * The ticket's theatre
     */
    private Theatre theatre;
    /**
     * The ticket's seat
     */
    private Seat seat;
    /**
     * The cost
     */
    private double cost;
    /**
     * The ID of the ticket
     */
    private int ticketID;
    /**
     * The ticket's showtime
     */
    private String showtime;

    /**
     * Constructs the showing object and sets its information
     * @param movie the movie
     * @param theatre the theatre
     * @param seat the seat
     * @param cost the cost
     * @param ticketID the ID
     * @param showtime the time of the showing
     */
    public Ticket(Movie movie, Theatre theatre, Seat seat, double cost, int ticketID, String showtime) {
        this.movie = movie;
        this.theatre = theatre;
        this.seat = seat;
        this.cost = cost;
        this.ticketID = ticketID;
        this.showtime = showtime;
    }

    /**
     * Sets all the information of the ticket to the given values
     * @param m the new movie
     * @param t the new theatre
     * @param s the new seat
     * @param c the new cost
     */
    public void udpateTicket(Movie m, Theatre t, Seat s, double c) {
        movie = m;
        theatre = t;
        seat = s;
        cost = c;
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
     * Gets the seat
     * @return the seat
     */
    public Seat getSeat() {
        return seat;
    }

    /**
     * Sets the seat
     * @param seat the new seat
     */
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    /**
     * Gets the cost of the ticket
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost of the ticket
     * @param cost the new cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Gets the ID of the ticket
     * @return the ID
     */
    public int getTicketID() {
        return ticketID;
    }

    /**
     * Sets the ID of the ticket
     * @param ticketID the new ID
     */
    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    /**
     * Gets the ticket's showtime
     * @return the showtime
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
     * Creates a String that contains the information about the ticket
     * @return the string made
     */
    @Override
    public String toString() {
        return "Ticket:\n" +
                "\tMovie: " + movie.getMovieTitle() + "\n" +
                "\tTheatre: " + theatre.getTheatreName() + "\n" +
                "\tSeat: " + seat.getSeatNumber() + "\n" +
                "\tTicket ID: " + ticketID;
    }
}
