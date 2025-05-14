package TRA.Presentation;

import TRA.Control.LoginController;
import TRA.Control.RegistrationController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import TRA.Control.Subject;

public class LoginScreen extends Screen{

	LoginController loginController;

	JFrame frame; 
	private JLabel emailLabel = new JLabel("Email: ");
	private JTextField emailBox = new JTextField();
	private JLabel passwordLabel = new JLabel("Password: ");
	private JTextField passwordBox = new JTextField();
	private JLabel errorLabel = new JLabel("Incorrect email or password, try again");
	private JButton confirmBut = new JButton("Confirm Information");
	private JButton cancelBut = new JButton("Cancel");

	
	public LoginScreen(JFrame frame, LoginController itself){
		
		this.subject = itself;
		this.loginController = itself;
		this.frame = frame;
		this.screenID = 6;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub

		frame.getContentPane().removeAll();
		frame.repaint();
		subject.setID(screenID);
		
		//System.out.println("did we change the same subject or a copy..." + subject.getID());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void buildScreen() {
		// TODO Auto-generated method stub
		//frame = new JFrame("Home Page");
		frame.setLayout(new BorderLayout());
		frame.setSize(400,225);
		frame.setLocationRelativeTo(null);
		
		JPanel text = new JPanel(new GridLayout(0,2));
		text.add(emailLabel);
		text.add(emailBox);
		text.add(passwordLabel);
		text.add(passwordBox);
		
		JPanel errorMessage = new JPanel(new FlowLayout());
		errorLabel.setVisible(false);
		errorMessage.add(errorLabel);

		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(confirmBut);
		buttons.add(cancelBut);
		
		frame.add("North", text);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add("Center", errorMessage);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add("South", buttons);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		controlButtons();
		System.out.println("selection is now : " + screenID);
		
		controlButtons();
	}
	
	/**
	 * This method controls the buttons on the Frame.
	 */
	private void controlButtons() {
		
		getCancelBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					frame.dispose();
					
			}});
		
		getConfirmBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					Boolean correct = true;
					String email = emailBox.getText();
					String password = passwordBox.getText();
					
					if(email.isEmpty()) {
						emailLabel.setOpaque( true );
						emailLabel.setBackground(Color.RED);
						correct = false;
					}else {
						emailLabel.setOpaque( false );
					}
					
					if(password.isEmpty()) {
						passwordLabel.setOpaque( true );
						passwordLabel.setBackground(Color.RED);
						correct = false;
					}else {
						passwordLabel.setOpaque( false );
					}
					
					if(correct) {
						loginController.completeLogin(email, password);
						if(loginController.getTheUser()==null) {
							errorLabel.setVisible(true);
							System.out.println("No associated user was found.");
						}else {
							System.out.println("logged in succesully");
							update();
						}
					}
					

			}});
		
	}

	public JButton getCancelBut() {
		return cancelBut;
	}

	public void setCancelBut(JButton cancelBut) {
		this.cancelBut = cancelBut;
	}

	public JTextField getEmailBox() {
		return emailBox;
	}

	public void setEmailBox(JTextField emailBox) {
		this.emailBox = emailBox;
	}


	public JTextField getPasswordBox() {
		return passwordBox;
	}

	public void setPasswordBox(JTextField passwordBox) {
		this.passwordBox = passwordBox;
	}

	public JButton getConfirmBut() {
		return confirmBut;
	}

	public void setConfirmBut(JButton confirmBut) {
		this.confirmBut = confirmBut;
	}

	
	
	
}
