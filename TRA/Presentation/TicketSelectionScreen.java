package TRA.Presentation;

import TRA.Control.Subject;
import TRA.Domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class TicketSelectionScreen extends CancelTicketScreen {

    ArrayList<Ticket> tickets;
    private JFrame frame;
    private Vector data;
    private JButton cancelBut = new JButton("Exit");
    private JButton nextBut = new JButton("Confirm Cancellation");
    private String ticketSelection = null;

    public TicketSelectionScreen(JFrame frame, Subject subject, ArrayList<Ticket> tickets) {
        this.frame = frame;
        this.subject = subject;
        this.tickets = tickets;
        createSelection();
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void createSelection() {
        this.list = new JList();
        data = new Vector();

        for(int i = 0; i < tickets.size(); i++) {
            data.addElement(tickets.get(i).toString());
        }

        list.setListData(data);
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void update() {
        frame.getContentPane().removeAll();

        subject.setID(4);
        subject.addData(ticketSelection);
        frame.repaint();
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void buildScreen() {
        frame.setLayout(new BorderLayout());
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(cancelBut);
        buttons.add(nextBut);

        frame.add("North", new JLabel("Ticket Cancellation Selection"));
        panel.add("Center", list);
        panel.add("West", new JLabel("Please select the ticket you would like to cancel"));
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

        getList().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if(me.getClickCount() == 1) {
                    JList target = (JList)me.getSource();
                    int index = target.locationToIndex(me.getPoint());
                    if(index >=0) {
                        Object item = target.getModel().getElementAt(index);
                        ticketSelection = item.toString();
                        for(int i = 0; i < tickets.size(); i++) {
                            if(item.toString().compareTo(tickets.get(i).toString()) == 0) {
                                ticketSelection = String.valueOf(tickets.get(i).getTicketID());
                            }
                        }
                        System.out.println("user selected : " + ticketSelection);
                    }

                }
            }
        });

        getNextBut().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(ticketSelection == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "You have not selected a ticket yet!");
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

}
