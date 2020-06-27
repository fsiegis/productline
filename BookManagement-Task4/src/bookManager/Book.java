package bookManager;

public class Book implements Comparable<Book>
{
	private String name = "";
	private double price = -1;
	private String ISBN = "";
	private int bookidx = -1;
	private boolean islend = false;

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
	public boolean getislend()
	{
		return this.islend;
	}
	public void setislend(boolean islend)
	{
		this.islend = islend;
	}
	
	@Override
	public int compareTo(Book compareBook) 
	{
		double compareQuantity = compareBook.getPrice();
		return (int) (this.price - compareQuantity);
	}
	
 	public String toString()
	{
		String bookString = "";
		// if Price && LendManagement
//		{
//			bookString = this.name + "    Preis: " + Double.toString(this.price) + "    Buch ist verliehen: " + this.islend;
//		}
		// elif LendManagement && !Price
//		{
//			bookString = this.name + "    Buch ist verliehen: " + this.islend;
//		}
		// elif Price && !LendManagement
//		{
//			bookString = this.name + "    Preis: " + Double.toString(this.price);

		bookString = this.name;

        return bookString;
    }
	
}
