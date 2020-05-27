package runtimeVar;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import runtimeVar.ControlPanel;

public class GUI extends JFrame
{
    private ControlPanel control;

	Book[] books = new Book[0];
	int bookPointer = 0;
	
	JList bookList;
	DefaultListModel model;
	
	Algorithms sorter;
	
	public GUI()
	{
		control = new ControlPanel(this);
		sorter = new Algorithms();
//		//Book Klasse
//		books[0] = new Book("Steppenwolf");
//		books[1] = new Book("Leere Herzen");
//		
//		//Array
//		BookNames[0] = new String("Steppenwolf");
//		BookNames[1] = new String("Leere Herzen");

		model = new DefaultListModel();
		
		//addBook(new Book("Test Buch", 0.0));
		
		bookList = new JList(model); 
		
		setLayout(new BorderLayout());
		add(control, BorderLayout.SOUTH);
		add(bookList, BorderLayout.CENTER);
		
		
		setLocation(50,0);
        setSize(600,500);
        setMinimumSize(new Dimension(300,250));
        setVisible(true);
	}
	
	public void addBook(Book newBook)
	{
		//books[bookPointer] = newBook;
		//model.add(bookPointer, newBook);
		//bookPointer++;
		Book[] newBookArray = new Book[this.books.length + 1];
		for(int i = 0; i < this.books.length; i++)
		{
			newBookArray[i] = books[i];
		}
		newBookArray[newBookArray.length - 1] = newBook;
		
		this.books = newBookArray;
		this.model.addElement(newBook);
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
	
	public static void main(String[] args) {
		GUI myGui = new GUI();
	}

}
