package TRA.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SeatSelectionButton extends JButton implements ActionListener{
	boolean vacancy;
	ImageIcon Reserved, Vacant;
	ArrayList<Integer> selectedSeat;
	int seatID;
	
	/**
	 * This method creates a button that flips between 2 images indicating
	 * reserved and not reserved. If the seat that was passed into this method has
	 * a false vacancy, then the button will be disabled.
	 * @param selectedSeat is the parameter that will update in the controller it came from
	 * @param i is the seat number
	 * @param vacancy is the vacancy status of the seat
	 */
	public SeatSelectionButton(ArrayList<Integer> selectedSeat, int i, boolean vacancy) {
		// TODO Auto-generated constructor stub
		Reserved = new ImageIcon("ENSF480_Final_Project/reserved.png");
		Vacant = new ImageIcon("ENSF480_Final_Project/vacant.png");
		this.vacancy = vacancy;
		if(vacancy) {
			setIcon(Vacant);
		}
		else {
			setIcon(Reserved);
			setEnabled(false);
		}
		this.selectedSeat = selectedSeat;
		this.seatID = i;
		this.addActionListener(this);
		
	}
	
	/**
	 * When the button is pressed, this method will either set the selectedSeat attribute
	 * to the buttons seatID, or remove the seatID if the same button is being pressed again.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(selectedSeat.size() ==0) {
			setIcon(Reserved);
			System.out.println("selected seat for seat #: " + seatID + " is : " + selectedSeat.toString());
			selectedSeat.add(seatID);
			repaint();
		}
		else if(selectedSeat.get(0) == seatID) {
			selectedSeat.remove(0);
			setIcon(Vacant);
			repaint();
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "You have already selected a seat, unselect it and try again");
		}
	}



}
