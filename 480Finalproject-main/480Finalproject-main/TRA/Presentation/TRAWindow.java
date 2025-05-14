/**
 * Controller of Ticket Reservation App
 */

package TRA.Presentation;

import TRA.Control.TRAController;
import TRA.Domain.TRA;

import javax.swing.*;
import java.awt.*;

/**
 * Window containing ticket reservation app gui
 */
public class TRAWindow extends JFrame implements Observer {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

//    private Screen screen;
//    private TRAController traController;
//
//    public TRAWindow(TRAController traController) {
//        super("Ticket Reservation App");
//
//        //Set controller
//        this.traController = traController;
//        this.traController.addObserver(this);
//
//        //Update self
//        this.update();
//
//        //Set frame attributes
//        this.setLayout(new BorderLayout());
//        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/4,Toolkit.getDefaultToolkit().getScreenSize().height/6);
//        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.add(screen);
//        this.setVisible(true);
//    }
//
//    @Override
//    /**
//     * Update frame displayed in window
//     */
//    public void update() {
//        this.screen = this.traController.getCurrentFrame();
//    }

}
