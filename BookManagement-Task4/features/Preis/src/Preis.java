import interfaces.Iattribte;

public class Preis implements Iattribte {
	double price;
	public String getValue() {
		return Double.toString(price);
	}

	public void setValue(String val) {
		price = Double.parseDouble(val);
	}

	public boolean dispOnTable() {
		return true;
	}
	public String getAttributeName()
	{
		return "Preis";
	}
	public Iattribte myAttribute()
	{
		return new Preis();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "Preis";
	}
}
