/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

import java.util.ArrayList;

public class FeeOrder extends Order {

    //String representing type of fee this order represents
    private final String feeTitle;

    public FeeOrder(double feeCost, String feeTitle) {
        //Set order cost which is summation of cost of each ticket
        this.setTotalPrice(feeCost);
        this.feeTitle = feeTitle;
    }

    public String getFeeTitle() {
        return feeTitle;
    }
}
