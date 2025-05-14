package TRA.Presentation;

import TRA.Control.Subject;
import TRA.Domain.TRA;
import TRA.Domain.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class UserEmailScreen extends CancelTicketScreen {

    private JFrame frame;
    private Vector data;
    private JButton cancelBut = new JButton("Exit");
    private JButton nextBut = new JButton("Next");
    private String email = null;
    JTextField emailField;
    private TRA tra;

    public UserEmailScreen(JFrame frame, Subject subject) {
        this.frame = frame;
        this.subject = subject;
        tra = new TRA();
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void update() {
        frame.getContentPane().removeAll();

        subject.setID(3);
        subject.addData(email);
        frame.repaint();
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void buildScreen() {
        frame.setLayout(new BorderLayout());
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/4,Toolkit.getDefaultToolkit().getScreenSize().height/6);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(cancelBut);
        buttons.add(nextBut);

        JPanel email = new JPanel(new FlowLayout());
        JLabel emailLabel = new JLabel("Please enter your email: ");
        emailField = new JTextField(20);
        email.add(emailLabel);
        email.add(emailField);

        panel.add("Center", email);
        panel.add("South", buttons);

        frame.add("Center", panel);

        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();

        controlButtons();

    }

	/**
	 * This method controls the buttons on the Frame.
	 */
    private void controlButtons() {

        getCancelBut().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }});

        getNextBut().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                email = emailField.getText();

                System.out.println("user selected : " + email);

                if(email == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "You have not entered an email yet!");
                }

                else if(tra.emailExistsInOrders(email) == false) {
                    JOptionPane.showMessageDialog(new JFrame(), "There are no orders registered with that email. Please try again.");
                }

                else {
                    update();
                }
            }});
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }

    public JButton getCancelBut() {
        return cancelBut;
    }

    public JButton getNextBut() {
        return this.nextBut;
    }

    @Override
    public void createSelection() {}
}
