import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;

import bookManager.Book;
import bookManager.BookManager;
import interfaces.Ialgorithm;

public class SortAlgorithm implements Ialgorithm {
	
	JButton sortButton;
	BookManager mainBookManager;
	
	boolean direction = true;
	
	public Book[] runAlgorithm(Book[] books)
	{
		if(direction)
		{
			Arrays.sort(books);
			direction = false;
		}
		else
		{
			Arrays.sort(books, Collections.reverseOrder());
			direction = true;
		}
	
		return books;
	}


	public JButton getButton(BookManager bookManager) {
		mainBookManager = bookManager;
		sortButton = new JButton("Sort Books");
		ButtonListener listener = new ButtonListener();
		sortButton.addActionListener(listener);
		return sortButton;
	}
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == sortButton)
            {
            	mainBookManager.setBookList(runAlgorithm(mainBookManager.getBookList()));
            }
        }
    }

}
