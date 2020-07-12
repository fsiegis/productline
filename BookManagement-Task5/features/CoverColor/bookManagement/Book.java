package bookManagement;


public class Book implements Comparable<Book>
{
	private String color = "";

	
	public void setColor(String color)
	{
		this.color = color;
	}
		
	public String getColor()
	{
		return this.color;
	}
	
	public String getAllInfos()
	{
		String infoString = original();
		infoString += "Color: " + this.getColor() + "    ";
		
		return infoString;
	}	
}
