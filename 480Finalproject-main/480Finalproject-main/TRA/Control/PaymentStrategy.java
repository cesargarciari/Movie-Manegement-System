package TRA.Control;

import FinancialInstitute.FinancialInstitute;
import TRA.Domain.*;

import java.util.ArrayList;

abstract public class PaymentStrategy {

    protected final Card card;
    protected final TRA tra;
    protected final String receiptEmailAddress;

    public PaymentStrategy(Card card,
                           TRA tra,
                           String receiptEmailAddress) {
        this.card = card;
        this.tra = tra;
        this.receiptEmailAddress = receiptEmailAddress;
    }

    /**
     * Perform payment strategy
     */
    abstract public void perform();

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

        TicketCancellationOrder cancellationOrder = new TicketCancellationOrder(tickets, false);
        CancellationOrderPaymentStrategy cancellationStrategy =
                new CancellationOrderPaymentStrategy(new Card(
                        "22", "may", 37), new TRA(),
                        "roland@tra.com", cancellationOrder);
        paymentController = new PaymentController(cancellationStrategy);
        paymentController.doAction();

        cancellationOrder = new TicketCancellationOrder(tickets, true);
        cancellationStrategy = new CancellationOrderPaymentStrategy(new Card(
                        "22", "may", 37), new TRA(),
                        "roland@tra.com", cancellationOrder);
        paymentController = new PaymentController(cancellationStrategy);
        paymentController.doAction();

        FeeOrder feeOrder = new FeeOrder(20.00, "Annual Fee");
        FeeOrderPaymentStrategy feeStrategy = new FeeOrderPaymentStrategy(new Card(
                "22", "may", 37), new TRA(),
                "roland@tra.com", feeOrder);
        paymentController = new PaymentController(feeStrategy);
        paymentController.doAction();

    }


}