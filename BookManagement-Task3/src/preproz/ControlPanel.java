package preproz;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JPanel
{
	JButton newBook;
	JButton bookInfo;
	JButton lendBook;
	JButton returnBook;
	JButton priceSort;
	ActionListener listener;
	GUI controlGUI;
	
	public ControlPanel(GUI controlGUI)
	{
		this.controlGUI = controlGUI;
		newBook = new JButton("Neues Buch");
		priceSort = new JButton("Sortieren");
		bookInfo = new JButton("Info");
		lendBook = new JButton("Buch verleihen");
		returnBook = new JButton("Buch zurückgeben");
		
		
		listener = new ButtonListener();
		newBook.addActionListener(listener);
		priceSort.addActionListener(listener);
		bookInfo.addActionListener(listener);
		lendBook.addActionListener(listener);
		returnBook.addActionListener(listener);
		
		setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        setBackground(Color.WHITE);
        
        add(newBook);
        // #if InfoPanel
//@	    {
//@        	add(bookInfo);
//@	    }
        // #endif
        
        // #if LendManagement
//@	    {
//@        	add(lendBook);
//@        	add(returnBook);
//@	    }
        // #endif
        
        // #if PriceSort
//@	    {
//@        	add(priceSort);
//@	    }
        // #endif
	}
	
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == newBook)
            {
            	new NewBookPanel(controlGUI);
            }
            if(e.getSource() == priceSort)
            {
            	controlGUI.sortBooks();
            }
            if(e.getSource() == bookInfo)
            {
            	controlGUI.getBookInfo();
            }
            if(e.getSource() == lendBook)
            {
            	controlGUI.lendBook();
            }
            if(e.getSource() == returnBook)
            {
            	controlGUI.returnBook();
            }
        }
    }
}
