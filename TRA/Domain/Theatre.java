/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

/**
 * Contains all the information about a theatre object
 */
public class Theatre {
    /**
     * The theatre name
     */
    private String theatreName;

    /**
     * Constructs the showing object and sets its information
     * @param theatreName the name of the theatre
     */
    public Theatre(String theatreName) {
        this.theatreName = theatreName;
    }

    /**
     * Gets the name of the theatre
     * @return the name
     */
    public String getTheatreName() {
        return theatreName;
    }

    /**
     * Sets the name of the theatre
     * @param theatreName the new theatre name
     */
    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }
}
