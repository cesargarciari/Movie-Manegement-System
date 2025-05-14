package TRA.Control;

import TRA.Domain.*;
import TRA.Presentation.*;

import javax.swing.*;
import java.util.ArrayList;

public class TicketRefundController extends Subject {

    private TicketRefundController itself;
    private JFrame frame;
    private ArrayList<String> data;
    private String email;
    private Card userCard;
    private Ticket ticket;

    public TicketRefundController(JFrame frame, Subject subject, Ticket t, String email) {
        this.frame = frame;
        this.ticket = t;
        this.email = email;
        this.data = new ArrayList<String>();
        setID(4);

    }

    public void runRefund(boolean ru, RegisteredUser user) {
        if(ru == true) {
            int prevID;
            Screen Screen = new TicketRefundScreen(frame, itself);
            Screen.buildScreen();

            prevID = getID();
            int i = 0;
            while(getID() == prevID) {
                if(i == 0)
                    System.out.println("waiting for TicketRefundScreen to finish...");
                i++;
            }
            userCard = new Card(data.get(0), data.get(1), Integer.parseInt(data.get(2)));
        }
        else {
            userCard = user.getUserAccount().getCard();
        }

        sendRefundEmail(ru);

    }

    private void sendRefundEmail(boolean ru) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);
        TicketCancellationOrder cancellationOrder = new TicketCancellationOrder(tickets, ru);
        CancellationOrderPaymentStrategy cancellationStrategy = new CancellationOrderPaymentStrategy(userCard , new TRA(), email, cancellationOrder);
        PaymentController paymentController = new PaymentController(cancellationStrategy);
        paymentController.doAction();
    }

    @Override
    public void addData(String data) {
        // TODO Auto-generated method stub
        this.data.add(data);
    }

    public void setItself(TicketRefundController itself) {
        this.itself = itself;
    }
}
