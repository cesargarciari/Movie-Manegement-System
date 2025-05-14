/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Domain.Ticket;
import TRA.Domain.TicketEmail;

import java.util.ArrayList;

public class TicketEmailStrategy extends EmailStrategy {

    private ArrayList<Ticket> tickets;

    /**
     * Ensure default constructor is not called
     */
    private TicketEmailStrategy() {

    }

    /**
     * Builds email containing ticket information
     * @param toAddress
     * @param tickets
     */
    public TicketEmailStrategy(String toAddress, ArrayList<Ticket> tickets) {
        this.email = new TicketEmail(toAddress, tickets);
    }

    @Override
    public void perform() {
        this.sendEmail();
    }
}
