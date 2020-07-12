package bookManagement;


public class Book //implements Comparable<Book>
{
	private String name = "";
	private int bookidx = -1;

	public Book(String name)
	{
		this.name = name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	
	public int getidx()
	{
		return this.bookidx;
	}
	public void setidx(int idx)
	{
		this.bookidx = idx;
	}


	
//	@Override
//	public int compareTo(Book compareBook) 
//	{
//		double compareQuantity = compareBook.getPrice();
//		return (int) (this.price - compareQuantity);
//	}

	
 	public String toString()
	{
		String bookString = "";

		bookString = bookString + this.name;
        		
		return bookString;
    }
	
}
