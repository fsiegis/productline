package bookManagement;


public class Book implements Comparable<Book>
{
	private String genre = "";

	
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
		
	public String getGenre()
	{
		return this.genre;
	}
	
	public String getAllInfos()
	{
		String infoString = original();
		infoString += "Genre: " + this.getGenre() + "    ";
		
		return infoString;
	}	
}
