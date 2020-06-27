package bookManager;

import javax.swing.*;

import interfaces.IGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NewBookPanel
{
	JPanel bookPanel;
	JPanel savePanel;
	JTextField newBookName;
	JTextField newBookPrice;
	JButton saveButton;
	ActionListener listener;

	bookManager.BookManager mainBookManager;
	JFrame gui;
    
	public NewBookPanel(bookManager.BookManager mainBookManager, List<IGUI> myGUI)
	{
		this.mainBookManager = mainBookManager;
		this.gui = myGUI.get(0).getFrame("NewBook");

		System.out.print("NewBookPanel");
		
		bookPanel = new JPanel();
		savePanel = new JPanel();
		
		
		JLabel NameLabel = new JLabel("Name:");
		newBookName = new JTextField("Name des neuen Buchens", 15);
		bookPanel.add(NameLabel);
		bookPanel.add(newBookName);
		
	    saveButton = new JButton("Sichern");
	    savePanel.add(saveButton);
		
		listener = new ButtonListener();
	    saveButton.addActionListener(listener);
	    
	    gui.setLayout(new BorderLayout());
	    gui.add(bookPanel, BorderLayout.CENTER);
	    gui.add(saveButton, BorderLayout.SOUTH);
	    gui.setVisible(true);
	}

	
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == saveButton)
            {
            	bookManager.Book newBook;
            	try
            	{
            		{
	           				newBook = new bookManager.Book(newBookName.getText());
	           				mainBookManager.addBook(newBook);
	           				gui.dispose();
	            	}	
            		//newBook = new bookManager.Book(newBookName.getText(), Double.parseDouble(newBookPrice.getText()));
            	}
            	catch(NumberFormatException ex) 
            	{
            		System.out.println("NumberFormat Exception: Buch konnte nicht eingelesen werden");
            		gui.dispose();
            	}
            	catch(NullPointerException ex) 
            	{
            		System.out.println("NullPointer Exception: Buch konnte nicht eingelesen werden");
            		gui.dispose();
            	}
            }
        }
    }
}
