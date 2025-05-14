/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

import java.util.ArrayList;

public class TicketCancellationOrder extends Order {

    //Tickets to be cancelled
    private final ArrayList<Ticket> ticketList;
    //Whether or not to add admin fee
    private final boolean addAdminFee;
    private final double adminFeeAmount = 0.15;

    public TicketCancellationOrder(ArrayList<Ticket> ticketList, boolean addAdminFee) {
        this.addAdminFee = addAdminFee;
        //Set order cost which is summation of negative cost of each ticket
        //Take off admin fee if addAdminFee is on
        double ticketCost = 0;
        for (Ticket ticket : ticketList) {
            if (addAdminFee) {
                ticketCost -= (ticket.getCost() * (1-adminFeeAmount));
            } else {
                ticketCost -= ticket.getCost();
            }
        }
        this.setTotalPrice(ticketCost);
        this.ticketList = (ArrayList<Ticket>) ticketList.clone();
    }

    public ArrayList<Ticket> getTicketListCopy() {
        return (ArrayList<Ticket>) ticketList.clone();
    }

    public boolean isAddAdminFee() {
        return addAdminFee;
    }

    public double getAdminFeeAmount() {
        return adminFeeAmount;
    }
}
