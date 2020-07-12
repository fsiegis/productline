package bookManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import bookManagement.NewBookPanel;


public class GUI extends JFrame
{
	Book[] books = new Book[0];
	int bookPointer = 0;
	
	JList<Book> bookList;
	DefaultListModel<Book> model;
	
	JLabel title;
	JLabel headline;
	JButton newBook;
	Font head = new Font("Verdana", Font.BOLD, 15);
	
	GUI mainGUI;
	
	public GUI()
	{
		mainGUI = this;
		JPanel control = new JPanel();
		newBook = new JButton("Neues Buch");
		ActionListener listener = new ButtonListener();
		newBook.addActionListener(listener);
		control.add(newBook);
		
		control.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		control.setBackground(Color.WHITE);

		
		
		//Setze Titel & Layout
		this.setTitle("Book Management");
		setLayout(new BorderLayout());
		
		
		headline = new JLabel();
		headline.setBackground(Color.WHITE);
		headline.setFont(head);
		headline.setOpaque(true);
		
		headline.setText("Name");

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
	
	

	
//	public void lendBook()
//	{
//		Book oneBook = bookList.getSelectedValue();
//		if(oneBook.getislend() == true)
//		{
//			System.out.println("Fehler: Buch ist bereits verliehen");
//		}
//		else
//		{
//			oneBook.setislend(true);
//			System.out.println("Buch wurde als verliehen markiert");			
//		}
//	}
//	public void returnBook()
//	{
//		Book oneBook = bookList.getSelectedValue();
//		if(oneBook.getislend() == true)
//		{
//			oneBook.setislend(false);
//			System.out.println("Buch wurde als zur??ckgegeben merkiert");
//		}
//		else
//		{
//			System.out.println("Fehler: Buch ist nicht als verliehen markiert");
//		}
//	}
	
	public static void main(String[] args) {
		GUI myGui = new GUI();
	}
	
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == newBook)
            {
            	new bookManagement.NewBookPanel(mainGUI);
            }
        }
    }
}
