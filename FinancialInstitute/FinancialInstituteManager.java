/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package FinancialInstitute;

import TRA.Domain.Payment;

/**
 * Class implementing financialInstitute to control interactions with an institute
 *
 */
public class FinancialInstituteManager implements FinancialInstitute {

    /**
     * If payment is pending, then accept or decline it. It accepts all payments
     * from cards with odd CSVs and rejects the rest.
     * @param payment
     */
    public void processPayment(Payment payment) {
        if (payment.isPending()) {
            if (payment.getCard().getCsv() % 2 == 0) {
                payment.setStatus(Payment.PAYMENT_STATUS_REJECTED);
            } else {
                payment.setStatus(Payment.PAYMENT_STATUS_ACCEPTED);
            }
        }
    }
}
