
package TRA.Control;

import javax.swing.JFrame;

public class TRAController {
	
	//private LoginController;
	//private LogoutController;
	//private RegisterSelfController;
	//private SendMovieAnnouncementController;
	//private CancelTicketController;
	//private payAnnualFeeController;
	//private MakePaymentController;
	
	//
	
	private HomeController homeController;
	
	private JFrame frame;
	
	public TRAController() {
		frame = new JFrame("Main Window");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TRAController mainController = new TRAController();
		mainController.doHome();

	}

	private  void doHome() {
		// TODO Auto-generated method stub
		homeController = new HomeController(frame);
		homeController.setItself(homeController);
		homeController.doAction();
		
	}

}
