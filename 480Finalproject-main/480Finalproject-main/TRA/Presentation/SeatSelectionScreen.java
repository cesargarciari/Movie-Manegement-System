package TRA.Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import TRA.Control.OrderSelectionController;
import TRA.Control.Subject;
import TRA.Domain.SeatMap;

public class SeatSelectionScreen extends OrderSelectionScreen{

	private JFrame frame;
	private SeatMapFrame seatPanel;
	private SeatMap seats;
	private ArrayList<Integer> selectedSeat = new ArrayList<Integer>();
	
	private JButton cancelBut = new JButton("Cancel");
	private JButton nextBut = new JButton("Next");
	private int sIndex;
	
	public SeatSelectionScreen(JFrame frame, Subject subject, SeatMap seats) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.subject = subject;
		this.seats = seats;
		createSelection();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createSelection() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		frame.getContentPane().removeAll();
		
		subject.setID(6);
		subject.addData(selectedSeat.get(0).toString());
		sIndex = selectedSeat.get(0) - 1;
		subject.addData(String.valueOf(sIndex));
		frame.repaint();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void buildScreen() {
		// TODO Auto-generated method stub
		System.out.println("We're in ShowTime Selection");
		frame.setLayout(new BorderLayout());
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/4,Toolkit.getDefaultToolkit().getScreenSize().height/2);
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(cancelBut);
		buttons.add(nextBut);
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel seatPanel = new JPanel(new BorderLayout());
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		JLabel screenGraphic = new JLabel("Screen", SwingConstants.CENTER);
		screenGraphic.setBorder(blackline);
		seatPanel.add("North", screenGraphic);
		seatPanel.add("Center", new SeatMapFrame(seats, selectedSeat));
		
		panel.add("Center", seatPanel);
		panel.add("South", buttons);
		frame.add("North", new JLabel("Seat Selection"));
		
		frame.add("Center", panel);
		
		frame.setVisible(true);
		frame.repaint();
		
		controlButtons();
		
	}
	
	/**
	 * This method controls the buttons on the Frame.
	 */
	private void controlButtons() {
		// TODO Auto-generated method stub
		getCancelBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					frame.dispose();
					
			}});
		
		
		getNextBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					if(selectedSeat.size() == 0) {
						JOptionPane.showMessageDialog(new JFrame(), "You have not selected a seat yet!");
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

	public SeatMapFrame getSeatPanel() {
		return seatPanel;
	}

	public void setSeatPanel(SeatMapFrame seatPanel) {
		this.seatPanel = seatPanel;
	}

	public SeatMap getSeats() {
		return seats;
	}

	public void setSeats(SeatMap seats) {
		this.seats = seats;
	}

	public ArrayList<Integer> getSelectedSeat() {
		return selectedSeat;
	}

	public void setSelectedSeat(ArrayList<Integer> selectedSeat) {
		this.selectedSeat = selectedSeat;
	}

	public JButton getCancelBut() {
		return cancelBut;
	}

	public void setCancelBut(JButton cancelBut) {
		this.cancelBut = cancelBut;
	}

	public JButton getNextBut() {
		return nextBut;
	}

	public void setNextBut(JButton nextBut) {
		this.nextBut = nextBut;
	}
	
	

}
