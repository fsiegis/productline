package interfaces;

import javax.swing.JButton;
import javax.swing.JFrame;

import bookManager.Book;
import bookManager.BookManager;

public interface Iview {
	public JButton getButton(BookManager bookManager);
	
	public void showView(JFrame frame, Book infoBook);
}
