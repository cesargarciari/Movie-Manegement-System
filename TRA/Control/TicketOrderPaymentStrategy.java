/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import FinancialInstitute.FinancialInstitute;
import TRA.Domain.*;

import java.util.ArrayList;

public class TicketOrderPaymentStrategy extends PaymentStrategy {

    private final TicketOrder ticketOrder;

    public TicketOrderPaymentStrategy(Card card,
                                      TRA tra, String receiptEmailAddress, TicketOrder ticketOrder) {
        super(card, tra, receiptEmailAddress);
        this.ticketOrder = ticketOrder;
    }

    /**
     * Builds payment from ticket order and card info and sends it to financial
     * institute for processing.  If the payment is accepted, a receipt for the
     * ticket purchase is send. (The tickets are not sent in this email, though.)
     * Marks the TicketOrder as either accepted or rejected.
     */
    public void perform() {
        //create and process payment
        Payment payment = new Payment(this.card, this.ticketOrder);
        this.tra.sendPaymentToFinancialInstituteForProcessing(payment);

        //If payment is accepted, send email
        if (payment.isAccepted()) {
            this.ticketOrder.approve();

            Receipt receipt = new Receipt(this.ticketOrder);
            ReceiptEmailStrategy strategy = new ReceiptEmailStrategy(this.receiptEmailAddress, receipt);
            SendEmailController emailController = new SendEmailController(strategy);
            emailController.doAction();

        } else if (payment.isRejected()) {
            this.ticketOrder.reject();
        }
    }

    public static void main(String args []) {
        TRA tra = new TRA();
        Movie movie = new Movie("Cats", "yesterday", 17, "horror");
        Theatre theatre = new Theatre("Silver City");
        Seat seat = new Seat(17, 72, true);
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(movie, theatre, seat, 9000.72, 82, "2020-11-30 10:00 AM"));
        tickets.add(new Ticket(movie, theatre, seat, 9000.72, 85, "2020-11-30 10:00 AM"));

        TicketOrder order = new TicketOrder(tickets);
        TicketOrderPaymentStrategy paymentStrategy = new TicketOrderPaymentStrategy(new Card("22", "may", 37), new TRA(), "roland@tra.com", order);
        PaymentController paymentController = new PaymentController(paymentStrategy);
        paymentController.doAction();

        System.out.println("Order status is: " + order.getOrderStatus());
        

    }

}
