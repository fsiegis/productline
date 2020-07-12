package bookManagement;

import javax.swing.*;

import bookManagement.NewBookPanel.ButtonListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPanel extends JFrame{
	JLabel bookInfos;
	
	JButton close;
	ActionListener listener;
	
	public InfoPanel(Book infoBook)
	{
		this.setTitle("Book Info");
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout( new BoxLayout(infoPanel, BoxLayout.Y_AXIS ));
		
		bookInfos = new JLabel(infoBook.getAllInfos());

		infoPanel.add(bookInfos);
		
		close = new JButton("Close");
		add(close, BorderLayout.SOUTH);
		
		listener = new ButtonListener();
		close.addActionListener(listener);
	    
		add(infoPanel, BorderLayout.CENTER);
	    setLocation(50,0);
        setSize(700,600);
	    setVisible(true);
	}
	
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == close)
            {
            	dispose();
            }
        }
    }
}
