package bookManager;

import java.util.List;

import interfaces.Iattribte;

public class Book //implements Comparable<Book>
{
	private String name = "";
	private int bookidx = -1;

	List<Iattribte> attributeList;

	public Book(String name, List<Iattribte> attributeList)
	{
		this.name = name;
		this.attributeList = attributeList;
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
	
	public void setAtribute(String attribute, String val)
	{
		for(Iattribte singleAttribute : attributeList)
		{
			if(singleAttribute.getAttributeName() == attribute)
			{
				singleAttribute.setValue(val);
			}
		}
	}
	public String getAttribute(String attribute)
	{
		for(Iattribte singleAttribute : attributeList)
		{
			if(singleAttribute.getAttributeName() == attribute)
			{
				return singleAttribute.getValue();
			}
		}
		
		return null;
	}
	
	
	@Override
//	public int compareTo(Book compareBook) 
//	{
//		double compareQuantity = compareBook.getPrice();
//		return (int) (this.price - compareQuantity);
//	}
	
 	public String toString()
	{
		String bookString = "";
		bookString = this.name + "  ";
		try
		{
			for(Iattribte singleAttribute : attributeList)
			{
				bookString = bookString + singleAttribute.getAttributeName() + ": " + singleAttribute.getValue() + "  ";
			}
		}
		catch(IllegalStateException e)
		{
			System.out.print("Book.toString(): IllegalStateException: Keine Attribute vorhaben");
		}
		catch(NullPointerException ne)
		{
			System.out.print("Book.toString(): NullPointerException: Keine Attribute vorhaben");
		}
        return bookString;
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

		
    }
	public String getAllInfo() {
		String allInfo = this.name + "\n";
		return allInfo;
	}
	
}
