package TRA.Presentation;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import TRA.Domain.SeatMap;

@SuppressWarnings("serial")
public class SeatMapFrame extends JPanel{
	
	ArrayList<Integer> selectedSeat; //this int will keep track of how many changes the user makes
	private SeatMap seats;
	private ArrayList<SeatSelectionButton> seatButtons;
	
	/**
	 * This constructor creates the SeatMapFrame, and constructs the seat selection
	 * buttons using the seats passed into this method.
	 * @param seats are the list of seats to be selected from
	 * @param selectedSeat is the data that will be updated in the controller it was called from.
	 */
	public SeatMapFrame(SeatMap seats, ArrayList<Integer> selectedSeat) {
		System.out.println("We're in the SeatMapFrame");
		this.seats = seats;
		this.selectedSeat = selectedSeat;
		setLayout(new GridLayout(seats.getNumberOfRows(), seats.getSeats().size()/seats.getNumberOfRows())); //makes a 5x7 grid
		seatButtons = new ArrayList<SeatSelectionButton>();
		for(int i = 0; i < seats.getSeats().size(); i++) {
				seatButtons.add(new SeatSelectionButton(selectedSeat, seats.getSeats().get(i).getSeatNumber(), 
						seats.getSeats().get(i).isVacant()));
				add(seatButtons.get(i));
		}
		
		setVisible(true);
	}
	
	
}
