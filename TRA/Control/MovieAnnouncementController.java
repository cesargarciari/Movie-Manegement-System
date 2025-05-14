/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Domain.Movie;
import TRA.Domain.TRA;

import java.util.ArrayList;

public class MovieAnnouncementController extends Controller {

    public MovieAnnouncementController() {
    }

    @Override
    /**
     * Sends a movie announcement email to all users in database
     */
    public void doAction() {
        TRA tra = new TRA();

        //Get all emails from database
        ArrayList<String> emailAddresses = tra.getEmails();

        //Send announcement email to each user
        SendEmailController emailController;
        for (String emailAddress : emailAddresses) {
            emailController = new SendEmailController(new MovieAnnouncementEmailStrategy(emailAddress));
            emailController.doAction();
            System.out.println("Sending email to: " + emailAddress);
        }


    }

    @Override
    public void addData(String data) {

    }
}
