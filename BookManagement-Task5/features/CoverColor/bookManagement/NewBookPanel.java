package bookManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewBookPanel extends JFrame
{
	JTextField newBookColor;

    
	public NewBookPanel(bookManagement.GUI controlGUI)
	{

		JLabel colorLabel = new JLabel("Color:");
		newBookColor = new JTextField(" --- ", 15);
		bookPanel.add(colorLabel);
		bookPanel.add(newBookColor);
	}
	
	public Book bookFactory()
	{
		Book newBook = original();
		newBook.setColor(newBookColor.getText());
    	return newBook;
	}
}
