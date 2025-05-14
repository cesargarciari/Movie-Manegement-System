package TRA.Presentation;

import javax.swing.JList;

public abstract class OrderSelectionScreen extends Screen{
	
	public JList list;
	
	/**
	 * This method creates a JList with the passed Data from the Subject.
	 */
	abstract public void createSelection();
	
	public JList getList() {
		return list;
	}
}
