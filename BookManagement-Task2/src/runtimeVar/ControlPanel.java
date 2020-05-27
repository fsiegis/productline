package runtimeVar;
import javax.swing.*;

import properties.PropertyManager;

import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JPanel
{
	JButton newBook;
	JButton bookInfo;
	JButton priceSort;
	ActionListener listener;
	GUI controlGUI;
	
	public ControlPanel(GUI controlGUI)
	{
		this.controlGUI = controlGUI;
		newBook = new JButton("Neues Buch");
		priceSort = new JButton("Sortieren");
		bookInfo = new JButton("Info");
		
		
		listener = new ButtonListener();
		newBook.addActionListener(listener);
		priceSort.addActionListener(listener);
		bookInfo.addActionListener(listener);
		
		setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        setBackground(Color.WHITE);
        
        add(newBook);
        if(PropertyManager.getProperty("InfoPanel"))
	    {
        	add(bookInfo);
	    }
        if(PropertyManager.getProperty("PriceSort"))
	    {
        	add(priceSort);
	    }
	}
	
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == newBook)
            {
            	new NewBookPanel(controlGUI);
            }
            if(e.getSource() == priceSort)
            {
            	controlGUI.sortBooks();
            }
            if(e.getSource() == bookInfo)
            {
            	controlGUI.getBookInfo();
            }
        }
    }
}
