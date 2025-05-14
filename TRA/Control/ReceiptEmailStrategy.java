/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Domain.Receipt;
import TRA.Domain.ReceiptEmail;
import TRA.Domain.Ticket;
import TRA.Domain.TicketEmail;

import java.util.ArrayList;

public class ReceiptEmailStrategy extends EmailStrategy {

    /**
     * Ensure default constructor is not called
     */
    private ReceiptEmailStrategy() {

    }

    public ReceiptEmailStrategy(String toAddress, Receipt receipt) {
        this.email = new ReceiptEmail(toAddress, receipt);
    }

    @Override
    public void perform() {
        this.sendEmail();
    }
}
