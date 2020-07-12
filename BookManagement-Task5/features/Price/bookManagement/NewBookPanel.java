package bookManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewBookPanel extends JFrame
{
	//JPanel bookPanel;
	//JPanel savePanel;
	//JTextField newBookName;
	JTextField newBookPrice;
	//JButton saveButton;
	//ActionListener listener;

	bookManagement.GUI controlGUI;
    
	public NewBookPanel(bookManagement.GUI controlGUI)
	{
		
		JLabel priceLabel = new JLabel("Price:");
		newBookPrice = new JTextField(" --- ", 15);
		bookPanel.add(priceLabel);
		bookPanel.add(newBookPrice);

	}
	public Book bookFactory()
	{
		Book newBook = original();
		newBook.setPrice(newBookPrice.getText());
    	return newBook;
	}
}
