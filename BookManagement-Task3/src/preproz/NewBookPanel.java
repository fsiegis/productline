package preproz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewBookPanel extends JFrame
{
	JPanel bookPanel;
	JPanel savePanel;
	JTextField newBookName;
	JTextField newBookPrice;
	JButton saveButton;
	ActionListener listener;

	preproz.GUI controlGUI;
    
	public NewBookPanel(preproz.GUI controlGUI)
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
	    
	    // #if Price
	    {
	    	JLabel PriceLabel = new JLabel("Preis:");
	    	newBookPrice = new JTextField("Preis des neuen Buchens", 15);
	    	bookPanel.add(PriceLabel);
	    	bookPanel.add(newBookPrice);
	    }
	    // #endif
		
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
            	preproz.Book newBook;
            	try
            	{
            		// #if Price
            		{
	           				newBook = new preproz.Book(newBookName.getText(), Double.parseDouble(newBookPrice.getText()));
	            			controlGUI.addBook(newBook);
	                    	dispose();
	            	}
            		// #else
//@            		{
//@            			newBook = new preproz.Book(newBookName.getText());
//@                		controlGUI.addBook(newBook);
//@                    	dispose();
//@            		}
            		// #endif
            		
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
