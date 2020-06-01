package runtimeVar;

import java.util.*;

//Hallo
//Klasse für alle folgenden Algorithmen
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
