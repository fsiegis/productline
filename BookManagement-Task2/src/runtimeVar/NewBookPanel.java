package runtimeVar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import properties.PropertyManager;
import runtimeVar.ControlPanel.ButtonListener;
import runtimeVar.GUI;


public class NewBookPanel extends JFrame{
	
	JPanel bookPanel;
	JPanel savePanel;
	JTextField newBookName;
	JTextField newBookPrice;
	JButton saveButton;
	ActionListener listener;

	runtimeVar.GUI controlGUI;
    
	public NewBookPanel(runtimeVar.GUI controlGUI)
	{
		this.controlGUI = controlGUI;
		bookPanel = new JPanel();
		savePanel = new JPanel();
		
		JLabel NameLabel = new JLabel("Name:");
		newBookName = new JTextField("Name des neuen Buchens", 15);
		bookPanel.add(NameLabel);
		bookPanel.add(newBookName);
	    
	    if(PropertyManager.getProperty("Price"))
	    {
	    	JLabel PriceLabel = new JLabel("Preis:");
	    	newBookPrice = new JTextField("Preis des neuen Buchens", 15);
	    	bookPanel.add(PriceLabel);
	    	bookPanel.add(newBookPrice);
	    }
	    
	    saveButton = new JButton("Sichern");
	    savePanel.add(saveButton);
		
		listener = new ButtonListener();
	    saveButton.addActionListener(listener);
	    
	    setLayout(new BorderLayout());
	    add(bookPanel, BorderLayout.CENTER);
	    add(saveButton, BorderLayout.SOUTH);
	    setLocation(50,0);
        setSize(600,500);
	    setVisible(true);
	}
//	static void panalGenerator()
//	{
//		JLabel label = new JLabel("Name:");
//		JTextField tfName = new JTextField("Name des neuen Buchens", 15);
//		panel.add(label);
//	    panel.add(tfName);
//	}
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == saveButton)
            {
            	runtimeVar.Book newBook;
            	try
            	{
            		if(PropertyManager.getProperty("Price"))
            		{
            			newBook = new runtimeVar.Book(newBookName.getText(), Double.parseDouble(newBookPrice.getText()));
            			controlGUI.addBook(newBook);
                    	dispose();
            		}
            		else
            		{
            			newBook = new runtimeVar.Book(newBookName.getText());
                		controlGUI.addBook(newBook);
                    	dispose();
            		}
            		
            	}
            	catch(NumberFormatException ex) 
            	{
            		System.out.println("NumberFormat Exception: Buch konnte nicht eingelesen werden");
            		dispose();
            	}
            	catch(NullPointerException ex) 
            	{
            		System.out.println("NullPointer Exception: Buch konnte nicht eingelesen werden");
            		dispose();
            	}
            }
        }
    }
}
