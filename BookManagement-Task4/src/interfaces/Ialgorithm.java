package interfaces;

import javax.swing.JButton;

import bookManager.BookManager;
import bookManager.Book;

public interface Ialgorithm {
	public Book[] runAlgorithm(Book[] books);
	public JButton getButton(BookManager bookManager);
}
