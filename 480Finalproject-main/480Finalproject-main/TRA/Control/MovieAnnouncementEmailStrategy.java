/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Domain.*;

import java.util.ArrayList;

public class MovieAnnouncementEmailStrategy extends EmailStrategy {

    /**
     * Ensure default constructor is not called
     */
    private MovieAnnouncementEmailStrategy() {

    }

    public MovieAnnouncementEmailStrategy(String toAddress) {
        this.email = new MovieAnnouncementEmail(toAddress);
    }

    @Override
    public void perform() {
        this.sendEmail();
    }
}
