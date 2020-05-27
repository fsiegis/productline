package runtimeVar;
import properties.PropertyManager;

public class Book implements Comparable<Book>
{
	private String name = "";
	private double price = -1;
	private String ISBN = "";
	private int bookidx = -1;

	public Book(String name)
	{
		this.name = name;
	}
	public Book(String name, double price)
	{
		this.name = name;
		this.price = price;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public double getPrice()
	{
		return this.price;
	}
	public void setISBN(String isbn)
	{
		this.ISBN = isbn;
	}
	public String getISBN()
	{
		return this.ISBN;
	}
	public int getidx()
	{
		return this.bookidx;
	}
	public void setidx(int idx)
	{
		this.bookidx = idx;
	}
	
	@Override
	public int compareTo(Book compareBook) 
	{
		double compareQuantity = compareBook.getPrice();
		return (int) (this.price - compareQuantity);
	}
	
 	public String toString()
	{
		String bookString;
		if(PropertyManager.getProperty("Price"))
		{
			bookString = this.name + "    " + Double.toString(this.price);
		}
		else
		{
			bookString = this.name;
		}
        return bookString;
    }
	
}
