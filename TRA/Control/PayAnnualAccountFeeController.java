/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Domain.*;

import java.util.ArrayList;

/**
 * Controller that processes an annual account fee payment.
 */
public class PayAnnualAccountFeeController extends Controller {

    private final RegisteredUser user;
    private final TRA tra;

    public PayAnnualAccountFeeController(RegisteredUser user, TRA tra) {
        this.user = user;
        this.tra = tra;
    }

    /**
     * Creates and processes payment for user paying annual account fee
     */
    public void doAction() {
        //Build annual account fee order and fee strategy from user's credentials
        //Then process fee payment
        FeeOrder feeOrder = new FeeOrder(20.00, "Annual Account Fee");
        FeeOrderPaymentStrategy feeStrategy = new FeeOrderPaymentStrategy(
                this.user.getUserAccount().getCard(), this.tra,
                this.user.getUserAccount().getEmailAddress(), feeOrder);
        PaymentController paymentController = new PaymentController(feeStrategy);
        paymentController.doAction();
    }

    public void addData(String data) {

    }

}
