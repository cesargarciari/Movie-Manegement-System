package TRA.Domain;

import java.util.ArrayList;

public class TicketOrder extends Order {

    //Tickets in order
    private final ArrayList<Ticket> ticketList;

    public TicketOrder(ArrayList<Ticket> ticketList) {
        //Set order cost which is summation of cost of each ticket
        double ticketCost = 0;
        for (Ticket ticket : ticketList) {
            ticketCost += ticket.getCost();
        }
        this.setTotalPrice(ticketCost);
        this.ticketList = (ArrayList<Ticket>) ticketList.clone();
    }

    public ArrayList<Ticket> getTicketListCopy() {
        return (ArrayList<Ticket>) ticketList.clone();
    }

}
