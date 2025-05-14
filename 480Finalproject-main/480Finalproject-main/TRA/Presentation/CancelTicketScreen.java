package TRA.Presentation;

import javax.swing.*;

public abstract class CancelTicketScreen extends Screen {

    public JList list;
    
    abstract public void createSelection();

    public JList getList() {
        return list;
    }

}
