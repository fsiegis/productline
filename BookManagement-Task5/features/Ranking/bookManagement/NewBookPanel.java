package bookManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewBookPanel extends JFrame
{
	JTextField newBookRanking;

    
	public NewBookPanel(bookManagement.GUI controlGUI)
	{

		JLabel rankingLabel = new JLabel("Ranking [1-100]:");
		newBookRanking = new JTextField(" --- ", 15);
		bookPanel.add(rankingLabel);
		bookPanel.add(newBookRanking);
	}
	
	public Book bookFactory()
	{
		Book newBook = original();
		newBook.setRanking(newBookRanking.getText());
    	return newBook;
	}
}
