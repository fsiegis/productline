package bookManagement;


public class Book implements Comparable<Book>
{
	private int ranking = 0;

	
	public void setRanking(String ranking)
	{
		this.ranking = Integer.parseInt(ranking);
	}
		
	public String getRanking()
	{
		return Integer.toString(this.ranking);
	}
	
	public String getAllInfos()
	{
		String infoString = original();
		infoString += "Ranking[1-100]: " + this.getRanking() + "    ";
		
		return infoString;
	}	
}
