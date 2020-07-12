import interfaces.Iattribte;

public class Genre implements Iattribte {
	String genre;
	public String getValue() {
		
		return genre;
	}

	public void setValue(String val) {
		genre = val;

	}

	public boolean dispOnTable() {
		return false;
	}

	public String getAttributeName() {
		return "Genre";
	}
	public Iattribte myAttribute()
	{
		return new Genre();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "Genre";
	}

}
