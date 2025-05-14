package TRA.Control;

import TRA.Domain.*;
import TRA.Presentation.*;

import javax.swing.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class CancelTicketController extends Subject {
    private CancelTicketController itself;
    private JFrame frame;

    private ArrayList<String> data;	//1st index: email, 2nd index: ticketID
    private ArrayList<Ticket> tickets;
    private int ticketSelected;
    private Ticket t;
    private String email;
    private TRA tra;
    private RegisteredUser ru;
    private boolean isntRegistered;
    private int index;

    public CancelTicketController(JFrame frame, Subject subject, RegisteredUser ru) {
        this.frame = frame;
        setID(2);
        data = new ArrayList<String>();
        tra = new TRA();
        this.ru = ru;
        index = 0;
    }

    public void runCancelTicketSelection(){

        if(ru == null) {
            runEmailInput();
            System.out.println("EmailInput Exited");
            email = data.get(index);
            isntRegistered = true;
            index++;
            ArrayList<String> emailList = tra.getEmails();
            for(int i = 0; i < emailList.size(); i++) {
                if(email == emailList.get(i)) {
                    isntRegistered = false;
                    break;
                }
            }
        }
        else {
            email = ru.getUserAccount().getEmailAddress();
            isntRegistered = false;
        }

        tickets = tra.getOrder(email);


        runTicketSelection();
        System.out.println("TicketSelection Exited");

        ticketSelected = parseInt(data.get(index));
        for(int i = 0; i < tickets.size(); i++) {
            if(tickets.get(i).getTicketID() == ticketSelected) {
                t = tickets.get(i);
            }
        }

        System.out.println("USER SELECTED THE FOLLOWING: ");
        for(int j = 0; j < data.size(); j++) {
            System.out.println(data.get(j));
        }

        int orderID = tra.cancelTicket(parseInt(data.get(index)));

        tra.checkOrderStatus(orderID);

        runRefund(isntRegistered);

        return;
    }

    private void runEmailInput() {
        int prevID;
        Screen Screen = new UserEmailScreen(frame, itself);
        Screen.buildScreen();

        prevID = getID();
        int i = 0;
        while(getID() == prevID) {
            if(i == 0)
                System.out.println("waiting for UserEmailScreen to finish...");
            i++;
        }
    }

    private void runTicketSelection() {
        int prevID;
        Screen Screen = new TicketSelectionScreen(frame, itself, tickets);
        Screen.buildScreen();

        prevID = getID();
        int i = 0;
        while(getID() == prevID) {
            if(i == 0)
                System.out.println("waiting for TicketSelectionScreen to finish...");
            i++;
        }
    }

    private void runRefund(boolean r) {
        TicketRefundController refund = new TicketRefundController(this.frame, itself, t, email);
        refund.setItself(refund);
        refund.runRefund(r, ru);
    }

    @Override
    public void addData(String data) {
        this.data.add(data);
    }

    public void setItself(CancelTicketController itself ) {
        this.itself = itself;
    }
}
