/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Domain.*;

import java.util.ArrayList;

/**
 * Controller that sends multiple kinds of emails. Uses strategy pattern to
 * determine what kind of email to send
 */
public class SendEmailController extends Controller {

    //Strategy determines what type of email to send
    private EmailStrategy strategy;

    /**
     * Ensure default constructor is never called
     */
    private SendEmailController() {

    }

    public SendEmailController(EmailStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Perform email strategy
     */
    public void doAction() {
        //Send the email
        this.strategy.perform();
    }

    public static void main(String args []) {
        Movie movie = new Movie("Cats", "yesterday", 17, "horror");
        Theatre theatre = new Theatre("Silver City");
        Seat seat = new Seat(17, 72, true);
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(movie, theatre, seat, 9000.72, 82, "2020-11-30 10:00 AM"));
        tickets.add(new Ticket(movie, theatre, seat, 9000.72, 85, "2020-11-30 10:00 AM"));
        TicketEmailStrategy ticketEmailStrategy = new TicketEmailStrategy("roland@email.com", tickets);
        SendEmailController sendEmailController = new SendEmailController((ticketEmailStrategy));
        sendEmailController.doAction();

        TicketOrder ticketOrder  = new TicketOrder(tickets);
        Receipt receipt = new Receipt(ticketOrder);
        ReceiptEmailStrategy receiptEmailStrategy = new ReceiptEmailStrategy("roland@email.com", receipt);
        sendEmailController = new SendEmailController(receiptEmailStrategy);
        sendEmailController.doAction();

        sendEmailController = new SendEmailController(new MovieAnnouncementEmailStrategy("roland@email.com"));
        sendEmailController.doAction();
    }

	@Override
	public void addData(String data) {
		// TODO Auto-generated method stub
		
	}
}
