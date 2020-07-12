package bookManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import bookManagement.NewBookPanel;


public class GUI extends JFrame
{
	
	JButton infoPanel;
		
	public GUI()
	{
		
		infoPanel = new JButton("Infos");
		//ActionListener listener = new ButtonListener();
		infoPanel.addActionListener(listener);
		control.add(infoPanel);
	}
	
	public void getBookInfo()
	{
		new InfoPanel(bookList.getSelectedValue());
	}
	
	
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == newBook)
            {
            	new bookManagement.NewBookPanel(mainGUI);
            }
            if(e.getSource() == infoPanel)
            {
            	mainGUI.getBookInfo();
            }
        }
    }
}
