package bookManagement;


public class Book //implements Comparable<Book>
{

	public String getAllInfos()
	{
		String infoString = "Name: " + this.getName() + "    ";
		infoString += "Index: " + this.getidx() + "    ";
		
		return infoString;
	}	
}
