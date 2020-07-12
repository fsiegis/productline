package bookManager;

import java.util.ArrayList;
import java.util.List;

import interfaces.Iattribte;

public class Book implements Comparable<Book>
{
	private String name = "";
	private int bookidx = -1;

	List<Iattribte> attributeList;
	
	//List<String> AttributNameList;
	//List<String> valueList;

	public Book(String name, List<Iattribte> generalAttributeList)
	{
		this.name = name;
		//this.attributeList = attributeList;
		this.attributeList = new ArrayList<Iattribte>();
		for(Iattribte singleAttribute : generalAttributeList)
		{
			attributeList.add(singleAttribute.myAttribute());
		}
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
			
			if(singleAttribute.getName() == attribute)
			{
				System.out.print("Val : " +  val);
				
				singleAttribute.setValue(val);
			}
		}
	}
	public String getAttribute(String attribute)
	{
		for(Iattribte singleAttribute : attributeList)
		{
			if(singleAttribute.getName() == attribute)
			{
				return singleAttribute.getValue();
			}
		}
		return "Fehler "; //valueList.get(idx);
		}
	
	
	@Override
	public int compareTo(Book compareBook) 
	{
		double compareQuantity = Double.parseDouble(compareBook.getAttribute("Preis"));
		return (int) (Double.parseDouble((this.getAttribute("Preis"))) - compareQuantity);
	}
	
 	public String toString()
	{
		String bookString = "";
		bookString = this.name + "  ";
		try
		{
			for(Iattribte singleAttribute : attributeList)
			{
				if(singleAttribute.dispOnTable())
				{
					bookString = bookString + singleAttribute.getAttributeName() + ": " + singleAttribute.getValue() + "  ";
				}
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
		String bookString = "";
		bookString = this.name + "    ";
		try
		{
			for(Iattribte singleAttribute : attributeList)
			{
				bookString = bookString + singleAttribute.getAttributeName() + ": " + singleAttribute.getValue() + "    \n";
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
	}
	
}
