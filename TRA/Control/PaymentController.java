/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Domain.*;

import java.util.ArrayList;

/**
 * Controller that sends multiple kinds of emails. Uses strategy pattern to
 * determine what kind of email to send
 */
public class PaymentController extends Controller {

    //Strategy determines what type of email to send
    private PaymentStrategy strategy;

    /**
     * Ensure default constructor is never called
     */
    private PaymentController() {

    }

    public PaymentController(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Perform payment strategy
     */
    public void doAction() {
        this.strategy.perform();
    }

    public void addData(String data) {

    }

}
