package bookManagement;


public class Book implements Comparable<Book>
{
	private double price = 0;


	public Book(String name, String price)
	{
		this.name = name;
		this.price = Double.parseDouble(price);
	}
	
	public void setPrice(String price)
	{
		this.price = Double.parseDouble(price);
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
			
	public double getPrice()
	{
		return this.price;
	}
	
	public String getAllInfos()
	{
		String infoString = original();
		infoString += "Preis: " + this.getPrice() + "    ";
		
		return infoString;
	}	
	
	
	public String toString()
	{
		String bookString = original();
		
		bookString = bookString + "    Preis: " + Double.toString(this.price);

        return bookString;
    }

	
	@Override
	public int compareTo(Book compareBook) 
	{
		double compareQuantity = compareBook.getPrice();
		return (int) (this.price - compareQuantity);
	}
}
