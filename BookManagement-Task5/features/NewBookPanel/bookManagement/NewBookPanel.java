package bookManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewBookPanel extends JFrame
{
	JPanel bookPanel;
	JPanel savePanel;
	JTextField newBookName;
	JButton saveButton;
	ActionListener listener;

	bookManagement.GUI controlGUI;
    
	public NewBookPanel(bookManagement.GUI controlGUI)
	{
		this.controlGUI = controlGUI;
		
		//Setze Titel
		this.setTitle("New Book");
		
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
	    
	    setLayout(new BorderLayout());
	    add(bookPanel, BorderLayout.CENTER);
	    add(saveButton, BorderLayout.SOUTH);
	    setLocation(50,0);
        setSize(700,600);
	    setVisible(true);
	}
	
	public Book bookFactory()
	{
		Book newBook = new Book(newBookName.getText());
    	controlGUI.addBook(newBook);
    	return newBook;
	}
	
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == saveButton)
            {
            	bookManagement.Book newBook;
            	try
            	{
            		bookFactory();
                    dispose();
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
