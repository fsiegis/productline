package bookManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewBookPanel extends JFrame
{
	JTextField newBookGenre;

    
	public NewBookPanel(bookManagement.GUI controlGUI)
	{

		JLabel genreLabel = new JLabel("Genre:");
		newBookGenre = new JTextField(" --- ", 15);
		bookPanel.add(genreLabel);
		bookPanel.add(newBookGenre);
	}
	
	public Book bookFactory()
	{
		Book newBook = original();
		newBook.setGenre(newBookGenre.getText());
    	return newBook;
	}
}
