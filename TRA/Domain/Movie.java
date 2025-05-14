/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

/**
 * Contains all the information about a movie
 */
public class Movie {
    /**
     * The title of the movie
     */
    private String movieTitle;
    /**
     * The date that the movie was released
     */
    private String dateReleased;
    /**
     * The length of the movie
     */
    private int movieLength;
    /**
     * The genre of the movie
     */
    private String genre;

    /**
     * Constructs the movie object and sets its information
     * @param movieTitle the movie's title
     * @param dateReleased the date the movie was released
     * @param movieLength the length of the movie
     * @param genre the genre of the movie
     */
    public Movie(String movieTitle, String dateReleased, int movieLength, String genre) {
        this.movieTitle = movieTitle;
        this.dateReleased = dateReleased;
        this.movieLength = movieLength;
        this.genre = genre;
    }

    /**
     * Gets the title of the movie
     * @return the movie title
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * sets the title of the movie
     * @param movieTitle the title
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * gets the release date of the movie
     * @return the date released
     */
    public String getDateReleased() {
        return dateReleased;
    }

    /**
     * sets the release date of the movie
     * @param dateReleased the new release date
     */
    public void setDateReleased(String dateReleased) {
        this.dateReleased = dateReleased;
    }

    /**
     * gets the length of the movie
     * @return the movie length
     */
    public int getMovieLength() {
        return movieLength;
    }

    /**
     * Sets the length of the movie
     * @param movieLength the new movie length
     */
    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    /**
     * get the genre
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * sets the genre
     * @param genre the new genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Creates a String that contains the information about the movie
     * @return the string made
     */
    @Override
    public String toString() {
        return "Title: " + movieTitle + '\n' +
                "\tRelease Date: " + dateReleased + '\n' +
                "\tLength: " + movieLength + " minutes\n" +
                "\tGenre: " + genre + "\n\n";
    }
}
