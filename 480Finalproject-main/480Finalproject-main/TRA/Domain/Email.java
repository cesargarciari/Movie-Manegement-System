/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

/**
 * Email message class.
 */
abstract public class Email {

    private final int emailID;

    private static int nextEmailID = 0;
    private final String toAddress;
    private final String fromAddress = "tra@tra.com";
    private String subject;

    public Email(String toAddress, String subject) {
        this.toAddress = toAddress;
        this.subject = subject;
        //Assign ID and increment id
        this.emailID = nextEmailID++;
    }

    protected String makeHeader() {
        return "To: " + toAddress + "\n\nFrom: " + fromAddress + "\n\nSubject: " + subject + "\n\n";
    }

    @Override
    public abstract String toString();

    public int getEmailID() {
        return emailID;
    }
}
