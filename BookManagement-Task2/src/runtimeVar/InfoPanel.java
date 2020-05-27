package runtimeVar;

import javax.swing.*;

import properties.PropertyManager;
import runtimeVar.NewBookPanel.ButtonListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPanel extends JFrame{
	JLabel bookName;
	JLabel bookPrice;
	JLabel bookISBN;
	JLabel bookidx;
	
	JButton close;
	ActionListener listener;
	
	public InfoPanel(Book infoBook)
	{
		this.setTitle("Book Info");
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout( new BoxLayout(infoPanel, BoxLayout.Y_AXIS ));
		
		bookName = new JLabel("Name: " + infoBook.getName());
		bookPrice = new JLabel("Preis: " + Double.toString(infoBook.getPrice()));
		bookISBN = new JLabel("ISBN: " + infoBook.getISBN());
		bookidx = new JLabel("Lokaler Index: " + Integer.toString(infoBook.getidx()));
		
		infoPanel.add(bookidx);
		infoPanel.add(bookName);
		if(PropertyManager.getProperty("Price"))
	    {
			infoPanel.add(bookPrice);
	    }
		infoPanel.add(bookISBN);
		
		close = new JButton("Close");
		add(close, BorderLayout.SOUTH);
		
		listener = new ButtonListener();
		close.addActionListener(listener);
	    
		add(infoPanel, BorderLayout.CENTER);
	    setLocation(50,0);
        setSize(600,500);
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
