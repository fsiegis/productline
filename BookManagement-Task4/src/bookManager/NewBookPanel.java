package bookManager;

import javax.swing.*;

import interfaces.IGUI;
import interfaces.Iattribte;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NewBookPanel
{
	JPanel bookPanel;
	JPanel savePanel;

	JLabel NameLabel[];
	JTextField TextFiels[];
	
	JButton saveButton;
	ActionListener listener;

	BookManager mainBookManager;
	JFrame gui;
	List<Iattribte> attributeList;
	int index = 1;
    
	public NewBookPanel(BookManager mainBookManager, List<IGUI> myGUI, List<Iattribte> attributeList)
	{
		this.attributeList = attributeList;
		this.mainBookManager = mainBookManager;
		this.gui = myGUI.get(0).getFrame("NewBook");

		System.out.print("NewBookPanel");
		
		bookPanel = new JPanel();
		savePanel = new JPanel();
		
		NameLabel =  new JLabel[20];
		TextFiels = new JTextField[20];
		
		
		NameLabel[0] = new JLabel("Name:");
		TextFiels[0] = new JTextField("Name des neuen Buchens", 15);
		
		//System.out.print("Attribute Name: " + attributeList.get(0).getAttributeName());
		
		int index = 1;
		try
		{
			for(Iattribte singleAttribute : attributeList)
			{
				NameLabel[index] = new JLabel(singleAttribute.getAttributeName());
				TextFiels[index] = new JTextField("---", 15);
				index++;
			}
		}
		
		catch(IllegalStateException e)
		{
			System.out.print("Keine Attribute zum Abfragen");
		}
		
		for(int iindex = 0; iindex < index; iindex++)
		{
			bookPanel.add(NameLabel[iindex]);
			bookPanel.add(TextFiels[iindex]);
		}
		
		
		
	    saveButton = new JButton("Sichern");
	    savePanel.add(saveButton);
		
		listener = new ButtonListener();
	    saveButton.addActionListener(listener);
	    
	    gui.setLayout(new BorderLayout());
	    gui.add(bookPanel, BorderLayout.CENTER);
	    gui.add(saveButton, BorderLayout.SOUTH);
	    gui.setVisible(true);
	}

	
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == saveButton)
            {
            	Book newBook;
            	//System.out.print("\n" + TextFiels[0].getText() + "\n");
            	//System.out.print("\nInndex: " + index + "\n");
            	try
            	{
            		{
	           			newBook = new Book(TextFiels[0].getText(), attributeList);
	           			mainBookManager.addBook(newBook);

	           			try
	           			{
	           				for(int iindex = 1; iindex <= attributeList.size(); iindex++)
	           				{
	           					newBook.setAtribute(NameLabel[iindex].getText(), TextFiels[iindex].getText());	
	           	            	System.out.print("\nNameLabel: " + NameLabel[iindex].getText() + "  TextFirled: " + TextFiels[iindex].getText());

	           				}
	           			}
	           			catch(IllegalStateException es)
	           			{
	           				System.out.print("Attribute konnten dem Buch nicht eingegeben werden");
	           			}
	           			gui.dispose();
	            	}	
            		//newBook = new bookManager.Book(newBookName.getText(), Double.parseDouble(newBookPrice.getText()));
            	}
            	catch(NumberFormatException ex) 
            	{
            		System.out.println("NumberFormat Exception: Buch konnte nicht eingelesen werden");
            		gui.dispose();
            	}
            	catch(NullPointerException ex) 
            	{
            		System.out.println("NullPointer Exception: Buch konnte nicht eingelesen werden");
            		gui.dispose();
            	}
            }
        }
    }
}
