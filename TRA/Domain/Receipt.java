/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

import java.util.ArrayList;

public class Receipt {

    //Type of order this receipt is for
    private final int receiptType;
    public static final int TYPE_CANCELLATION = 0;
    public static final int TYPE_TICKET = 1;
    public static final int TYPE_FEE = 2;

    //Total cost of order this receipt is for
    private final double amount;

    // Summary of contents of order that this receipt is for
    private final String summaryMessage;

    public Receipt(TicketOrder ticketOrder) {
        this.receiptType = TYPE_TICKET;
        this.amount = ticketOrder.getTotalPrice();
        this.summaryMessage = buildTicketOrderMessage(ticketOrder);
    }

    public Receipt(TicketCancellationOrder cancellationOrder) {
        this.receiptType = TYPE_CANCELLATION;
        this.amount = cancellationOrder.getTotalPrice();
        this.summaryMessage = buildTicketCancellationOrderMessage(cancellationOrder);
    }

    public Receipt(FeeOrder feeOrder) {
        this.receiptType = Receipt.TYPE_FEE;
        this.amount = feeOrder.getTotalPrice();
        this.summaryMessage = buildFeeOrderMessage(feeOrder);
    }

    /**
     * Builds message breaking down cost of fee and type of fee
     * @param feeOrder
     * @return
     */
    private String buildFeeOrderMessage(FeeOrder feeOrder) {
        String message = "";
        message = message.concat("\t\tFee name:\t\tPrice:\n");
        message = message.concat("\t\t" + feeOrder.getFeeTitle() + "\t\t\t$" + feeOrder.getTotalPrice() + "\n");
        return message;

    }

    /**
     * Creates message breaking down all tickets in cancellation order and their
     * refund costs
     * @param cancellationOrder
     * @return
     */
    private String buildTicketCancellationOrderMessage(TicketCancellationOrder cancellationOrder) {
        String message = "";
        if (cancellationOrder.isAddAdminFee()) {
            message = message.concat("\t\tAn admin fee of " + (cancellationOrder.getAdminFeeAmount() * 100) + "% has been added to your order.\n");
        }
        message = message.concat("\t\tTicket ID:\t\tRefund:\n");
        //Add IDs and prices of tickets from order
        ArrayList<Ticket> tickets = cancellationOrder.getTicketListCopy();
        for (Ticket ticket : tickets) {
            if (cancellationOrder.isAddAdminFee()) {
                message = message.concat("\t\t" + ticket.getTicketID() + "\t\t\t$" + ticket.getCost() * cancellationOrder.getAdminFeeAmount() + "\n");
            } else {
                message = message.concat("\t\t" + ticket.getTicketID() + "\t\t\t$" +ticket.getCost() + "\n");
            }
        }
        return message;
    }

    /**
     * Creates an order summary message based on a ticket order
     * @param ticketOrder
     * @return order summary message
     */
    private static String buildTicketOrderMessage(TicketOrder ticketOrder) {
        String message = "";
        message = message.concat("\t\tTicket ID:\t\tPrice:\n");
        //Add IDs and prices of tickets from order
        ArrayList<Ticket> tickets = ticketOrder.getTicketListCopy();
        for (Ticket ticket : tickets) {
            message = message.concat("\t\t" + ticket.getTicketID() + "\t\t\t$" + ticket.getCost() + "\n");
        }
        return message;
    }

    /**
     * Returns type of order as String that can be inserted into a sentence. The
     * string is all lower case
     * @return type of order
     */
    public String receiptTypeToString() {
        String type = "";
        switch(this.receiptType) {
            case TYPE_CANCELLATION:
                type =  "cancellation";
                break;
            case TYPE_TICKET:
                type =  "ticket";
                break;
            case TYPE_FEE:
                type = "fee payment";
                break;
        }
        return type;
    }

    @Override
    public String toString() {
        return "Receipt:\n" +
                "\tReceipt type: " + this.receiptTypeToString() + "\n" +
                "\tAmount: $" + amount + "\n" +
                "\tSummary:\n" + summaryMessage;
    }
}
