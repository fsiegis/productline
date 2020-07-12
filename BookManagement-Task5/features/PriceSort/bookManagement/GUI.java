package bookManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import bookManagement.NewBookPanel;


public class GUI extends JFrame
{
	
	JButton priceSort;
	Algorithms sorter;

		
	public GUI()
	{
		
		priceSort = new JButton("Preis Sortieren");
		//ActionListener listener = new ButtonListener();
		priceSort.addActionListener(listener);
		control.add(priceSort);
		sorter = new Algorithms();
	}
	
	public void sortBooks()
	{
		books = sorter.sortBooks(this.books);
		this.model.removeAllElements();
		for(int i = 0; i < books.length; i++)
		{
			this.model.addElement(this.books[i]);
		}
	}

	
	
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == newBook)
            {
            	new bookManagement.NewBookPanel(mainGUI);
            }
            if(e.getSource() == infoPanel)
            {
            	mainGUI.getBookInfo();
            }
            if(e.getSource() == priceSort)
            {
            	mainGUI.sortBooks();
            }
        }
    }
}
