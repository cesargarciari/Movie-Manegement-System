/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

public class ReceiptEmail extends Email {

    private final Receipt receipt;

    public ReceiptEmail(String toAddress, Receipt receipt) {
        super(toAddress, "Your receipt");
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        String message = "";
        message = message.concat(this.makeHeader());
        message = message.concat("Message:\n\n");
        message = message.concat("Thank you for your " + receipt.receiptTypeToString()
                                    + " order!\n\nHere is your receipt:\n\n");
        message = message.concat(receipt.toString());
        return message;
    }
}
