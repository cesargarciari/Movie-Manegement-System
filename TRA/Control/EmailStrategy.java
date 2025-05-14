/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Domain.Email;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Abstract base class for different implementations of algorithms that send
 * emails.
 */
abstract public class EmailStrategy {

    Email email;
    String message;

    public abstract void perform();

    /**
     * Creates file and appends email message to file
     */
    protected void sendEmail() {
        try {
            FileWriter writer = new FileWriter(
                    "ENSF480_Final_Project/email/email-" +
                            email.getEmailID() + ".txt");
            writer.write(email.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("The following error occurred while writing an email to a file:");
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

}
