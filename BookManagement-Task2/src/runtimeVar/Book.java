package runtimeVar;
import properties.PropertyManager;

public class Book implements Comparable<Book>
{
	private String name = "";
	private double price = -1;
	
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
	
	@Override
	public int compareTo(Book compareBook) {

		double compareQuantity = compareBook.getPrice();

		//ascending order
		return (int) (this.price - compareQuantity);

		//descending order
		//return compareQuantity - this.quantity;

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
