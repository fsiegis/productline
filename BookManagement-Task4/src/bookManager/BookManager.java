package bookManager;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import interfaces.IGUI;
import loader.PluginLoader;
import bookManager.NewBookPanel;
import bookManager.Book;

public class BookManager {
	
	Book[] books = new Book[0];
	int bookPointer = 0;
	
	JList<Book> bookList;
	DefaultListModel<Book> model;
	
	List<IGUI> GUIlist;
	
	BookManager mainBookManager;
	
	JButton newBook;
	JFrame gui;
	
	public BookManager(List<IGUI> GUIlist)
	{
		mainBookManager = this;
		
		this.GUIlist = GUIlist;
		this.gui = GUIlist.get(0).getFrame("BookManager");
		gui.setVisible(true);
		
		model = new DefaultListModel<Book>();
		bookList = new JList<Book>(model); 
		gui.add(bookList, BorderLayout.CENTER);
		
		Panel controlPanel = new Panel();
		newBook = new JButton("New Book");
		ButtonListener listener = new ButtonListener();
		newBook.addActionListener(listener);
		
		
		controlPanel.add(newBook);
		gui.add(controlPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) throws InterruptedException {

		List<IGUI> myGUI = PluginLoader.load(IGUI.class);

		new BookManager(myGUI);
	}
	
	public void addBook(Book newBook)
	{
		Book[] newBookArray = new Book[this.books.length + 1];
		for(int i = 0; i < this.books.length; i++)
		{
			newBookArray[i] = books[i];
		}
		newBookArray[newBookArray.length - 1] = newBook;
		
		this.books = newBookArray;
		this.model.addElement(newBook);
		
		newBook.setidx(bookPointer);
		bookPointer++;
	}
	
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == newBook)
            {
            	new NewBookPanel(mainBookManager, GUIlist);
            }
        }
    }
}
