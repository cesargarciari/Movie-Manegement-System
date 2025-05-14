/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import FinancialInstitute.FinancialInstitute;
import TRA.Domain.*;

import java.util.ArrayList;

public class FeeOrderPaymentStrategy extends PaymentStrategy {

    private final FeeOrder feeOrder;

    public FeeOrderPaymentStrategy(Card card,
                                      TRA tra, String receiptEmailAddress,
                                   FeeOrder feeOrder) {
        super(card, tra, receiptEmailAddress);
        this.feeOrder = feeOrder;
    }

    /**
     * Builds payment from ticket order and card info and sends it to financial
     * institute for processing.  If the payment is accepted, a receipt for the
     * ticket purchase is send. (The tickets are not sent in this email, though.)
     * Marks the TicketOrder as either accepted or rejected.
     */
    public void perform() {
        //create and process payment
        Payment payment = new Payment(this.card, this.feeOrder);
        this.tra.sendPaymentToFinancialInstituteForProcessing(payment);

        //If payment is accepted, send email
        if (payment.isAccepted()) {
            this.feeOrder.approve();

            Receipt receipt = new Receipt(this.feeOrder);
            ReceiptEmailStrategy strategy = new ReceiptEmailStrategy(this.receiptEmailAddress, receipt);
            SendEmailController emailController = new SendEmailController(strategy);
            emailController.doAction();

        } else if (payment.isRejected()) {
            this.feeOrder.reject();
        }
    }

}
