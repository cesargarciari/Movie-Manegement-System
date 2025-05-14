/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

import java.util.ArrayList;

public class TicketEmail extends Email {

    private final ArrayList<Ticket> tickets;

    public TicketEmail(String toAddress, ArrayList<Ticket> tickets) {
        super(toAddress, "Your tickets");
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        String message = "";
        message = message.concat(this.makeHeader());
        message = message.concat("Message:\n\n");
        message = message.concat("Thank you for your ticket order!\n\nYou have ordered the following tickets:\n\n");
        for (Ticket ticket : tickets) {
            message = message.concat(ticket.toString() + "\n\n");
        }
        return message;
    }
}
