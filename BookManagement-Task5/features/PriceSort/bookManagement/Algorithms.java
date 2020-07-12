package bookManagement;

import java.util.*;

//Klasse fuer alle folgenden Algorithmen
public class Algorithms {
	boolean direction = true;
	
	public Book[] sortBooks(Book[] books)
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
}
