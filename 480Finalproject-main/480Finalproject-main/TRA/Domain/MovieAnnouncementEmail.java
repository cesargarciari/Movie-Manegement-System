/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

public class MovieAnnouncementEmail extends Email {

    public MovieAnnouncementEmail(String toAddress) {
        super(toAddress, "Movie Announcement");
    }

    @Override
    public String toString() {
        String message = "";
        message = message.concat(this.makeHeader());
        message = message.concat("Message:\n\n");
        message = message.concat("Make sure to check out these upcoming movies!\n\n");
        TRA tra = new TRA();
        for (Movie movie : tra.sendMovieList()) {
            message = message.concat(movie.toString() + "\n\n");
        }

        return message;
    }
}
