package TRA.Presentation;

import java.awt.BorderLayout;
import java.awt.Component;
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

import TRA.Control.Subject;
import TRA.Domain.Movie;

public class MovieSelectionScreen extends OrderSelectionScreen{
	
	ArrayList<Movie> movies;
	private JFrame frame;
	private Vector data;
	private JButton cancelBut = new JButton("Cancel");
	private JButton nextBut = new JButton("Next");
	private String movieSelection = null;
	private int mIndex;
	
	public MovieSelectionScreen(JFrame frame, Subject subject, ArrayList<Movie> movies) {
		this.frame = frame;
		this.subject = subject;
		this.movies = movies;
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
		
		for(int i = 0; i < movies.size(); i++) {
			data.addElement(movies.get(i).getMovieTitle());
		}
		
		list.setListData(data);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		//BorderLayout layout = (BorderLayout)frame.getLayout();
		//frame.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
		
		frame.getContentPane().removeAll();
		
		subject.setID(3);
		subject.addData(movieSelection);
		subject.addData(String.valueOf(mIndex));
		frame.repaint();
	} 

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void buildScreen() {
		// TODO Auto-generated method stub
		System.out.println("We're in Movie Selection");
		frame.setLayout(new BorderLayout());
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/3,Toolkit.getDefaultToolkit().getScreenSize().height/2);
		
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(cancelBut);
		buttons.add(nextBut);
		
		frame.add("North", new JLabel("Movie Selection"));
		panel.add("Center", list);
		panel.add("West", new JLabel("Please select a movie you would like to watch"));
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
						movieSelection = item.toString();
						mIndex = index;
						System.out.println("user selected : " + movieSelection);
					}
					
				}
			}
		});
		
		getNextBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					if(movieSelection == null) {
						JOptionPane.showMessageDialog(new JFrame(), "You have not selected a movie yet!");
					}
					else {
						update();
					}
			}});
	}


	public ArrayList<Movie> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
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

	public void setCancelBut(JButton cancelBut) {
		this.cancelBut = cancelBut;
	}
	
	public JButton getNextBut() {
		return this.nextBut;
	}

}
