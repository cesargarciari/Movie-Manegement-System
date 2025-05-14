/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

/**
 * Contains all the information about a payment made by a user
 */
public class Payment {
    /**
     * The user's card
     */
    private Card card;
    /**
     * The cost of the payment
     */
    private double cost;
    /**
     * The user's order
     */
    private Order order;
    /**
     * The payment's ID
     */
    private final int paymentID;
    /**
     * The ID of the next payment
     */
    private static int nextPaymentID;

    /**
     * pending payment status
     */
    public static final int PAYMENT_STATUS_PENDING = 0;
    /**
     * accepted payment status
     */
    public static final int PAYMENT_STATUS_ACCEPTED = 1;
    /**
     * rejected payment status
     */
    public static final int PAYMENT_STATUS_REJECTED = 2;
    /**
     * The status of the payment
     */
    private int status; //accepted, rejected or pending

    /**
     * Constructs the payment object and sets its information
     * @param card the user's card
     * @param order the user's order
     */
    public Payment(Card card, Order order) {
        this.card = card;
        this.cost = order.getTotalPrice();
        this.order = order;
        this.paymentID = nextPaymentID++;
        this.status = PAYMENT_STATUS_PENDING;
    }

    /**
     * Gets the user's card
     * @return the card
     */
    public Card getCard() {
        return card;
    }

    /**
     * Sets the user's card
     * @param card the new card
     */
    public void setCard(Card card) {
        this.card = card;
    }

    /**
     * gets the cost of the payment
     * @return the payment cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the payment's cost
     * @param cost the new cost of the payment
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Gets the order
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order for the payment
     * @param order the new order
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Gets the ID of the payment
     * @return the ID
     */
    public int getPaymentID() {
        return paymentID;
    }

    /**
     * Sets the status of the payment to pending
     * @return the status of the payment
     */
    public boolean isPending() {
        return this.status == PAYMENT_STATUS_PENDING;
    }

    /**
     * Sets the status of the payment to accepted
     * @return the status of the payment
     */
    public boolean isAccepted() {
        return this.status == PAYMENT_STATUS_ACCEPTED;
    }

    /**
     * Sets the status of the payment to rejected
     * @return the status of the payment
     */
    public boolean isRejected() {
        return this.status == PAYMENT_STATUS_REJECTED;
    }

    /**
     * Sets the status of the payment
     * @param status the new status
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
