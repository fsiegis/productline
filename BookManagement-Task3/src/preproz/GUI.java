package preproz;

import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame
{
    private ControlPanel control;

	Book[] books = new Book[0];
	int bookPointer = 0;
	
	JList<Book> bookList;
	DefaultListModel<Book> model;
	
	JLabel title;
	JLabel headline;
	Font head = new Font("Verdana", Font.BOLD, 15);
	
	Algorithms sorter;
	
	public GUI()
	{
		control = new ControlPanel(this);
		sorter = new Algorithms();
		
		//Setze Titel & Layout
		this.setTitle("Book Management");
		setLayout(new BorderLayout());
		
		
		//Setze Tabellen??berschrift
		headline = new JLabel();
		headline.setBackground(Color.WHITE);
		headline.setFont(head);
		headline.setOpaque(true);
		// #if Price
	    {	
			headline.setText("Name    Preis [???]");	
	    }
		// #else
//@		{
//@			headline.setText("Name");
//@		}
		// #endif
		add(headline, BorderLayout.NORTH);
		
		//Setze Buecherliste
		model = new DefaultListModel<Book>();
		bookList = new JList<Book>(model); 
		add(bookList, BorderLayout.CENTER);
		
		//Setze Controllpanel
		add(control, BorderLayout.SOUTH);
		
		setLocation(50,0);
        setSize(700,600);
        setMinimumSize(new Dimension(300,250));
        setVisible(true);
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
	
	public void sortBooks()
	{
		books = sorter.sortBooks(this.books);
		this.model.removeAllElements();
		for(int i = 0; i < books.length; i++)
		{
			this.model.addElement(this.books[i]);
		}
	}
	
	public void getBookInfo()
	{
		new InfoPanel(bookList.getSelectedValue());
	}
	
	public void lendBook()
	{
		Book oneBook = bookList.getSelectedValue();
		if(oneBook.getislend() == true)
		{
			System.out.println("Fehler: Buch ist bereits verliehen");
		}
		else
		{
			oneBook.setislend(true);
			System.out.println("Buch wurde als verliehen markiert");
			
		}
	}
	public void returnBook()
	{
		Book oneBook = bookList.getSelectedValue();
		if(oneBook.getislend() == true)
		{
			oneBook.setislend(false);
			System.out.println("Buch wurde als zur??ckgegeben merkiert");
		}
		else
		{
			System.out.println("Fehler: Buch ist nicht als verliehen markiert");
		}
	}
	
	public static void main(String[] args) {
		GUI myGui = new GUI();
	}

}
