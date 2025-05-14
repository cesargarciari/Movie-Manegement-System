package TRA.Presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import TRA.Control.Subject;
import TRA.Domain.Movie;
import TRA.Domain.Theatre;

public class TheatreSelectionScreen extends OrderSelectionScreen{

	private JFrame frame;
	private ArrayList<Theatre> theatres;
	Vector data;
	private JButton cancelBut = new JButton("Cancel");
	private JButton nextBut = new JButton("Next");
	private String theatreSelection = null;
	private int tIndex;
	
	
	public TheatreSelectionScreen(JFrame frame, Subject subject, ArrayList<Theatre> theatres) {
		this.frame = frame;
		this.subject = subject;
		this.theatres = theatres;
		createSelection();
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createSelection() {
		// TODO Auto-generated method stub

		this.list = new JList();
		data = new Vector();
		
		for(int i = 0; i < theatres.size(); i++) {
			data.addElement(theatres.get(i).getTheatreName());
		}
		
		list.setListData(data);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		frame.getContentPane().removeAll();
		
		subject.setID(4);
		subject.addData(theatreSelection);
		subject.addData(String.valueOf(tIndex));
		frame.repaint();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void buildScreen() {
		// TODO Auto-generated method stub
		System.out.println("We're in Theatre Selection");
		frame.setLayout(new BorderLayout());
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/4,Toolkit.getDefaultToolkit().getScreenSize().height/2);	
		
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(cancelBut);
		buttons.add(nextBut);
		
		frame.add("North", new JLabel("Theatre Selection"));
		panel.add("Center", list);
		panel.add("South", buttons);
		panel.add("West", new JLabel("Please select a theatre: "));
		
		frame.add("Center", panel);
		
		frame.setVisible(true);
		
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
				// TODO Auto-generated method stub
					frame.dispose();
					
			}});
		
		getList().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if(me.getClickCount() == 1) {
					JList target = (JList)me.getSource();
					int index = target.locationToIndex(me.getPoint());
					if(index >=0) {
						Object item = target.getModel().getElementAt(index);
						theatreSelection = item.toString();
						tIndex = index;
						System.out.println("user selected : " + theatreSelection);
					}
					
				}
			}
		});
		
		getNextBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					if(theatreSelection == null) {
						JOptionPane.showMessageDialog(new JFrame(), "You have not selected a theatre yet!");
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


	public ArrayList<Theatre> getTheatres() {
		return theatres;
	}


	public void setTheatres(ArrayList<Theatre> theatres) {
		this.theatres = theatres;
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


	public void setCancelBut(JButton cancelBut) {
		this.cancelBut = cancelBut;
	}


	public JButton getNextBut() {
		return nextBut;
	}


	public void setNextBut(JButton nextBut) {
		this.nextBut = nextBut;
	}


	public String getTheatreSelection() {
		return theatreSelection;
	}


	public void setTheatreSelection(String theatreSelection) {
		this.theatreSelection = theatreSelection;
	}
	
	
	
}
