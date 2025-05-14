/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Domain.TRA;
import TRA.Presentation.Observer;

import java.util.ArrayList;

/**
 * Parent class of all controllers.
 */
abstract class Controller extends Subject{

 //   private final ArrayList<Observer> observerList;

    //Only tra instance that is shared by all controllers
    private static TRA tra;

    /**
     * Perform sequence of events controller handles
     */
    abstract public void doAction();

}
