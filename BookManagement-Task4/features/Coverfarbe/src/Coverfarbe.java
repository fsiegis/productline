import interfaces.Iattribte;

public class Coverfarbe implements Iattribte {
	String farbe;
	public String getValue() {
		return farbe;
	}

	public void setValue(String val) {
		// TODO Auto-generated method stub
		farbe = val;
	}

	public boolean dispOnTable() {
		return false;
	}

	public String getAttributeName() {
		return "Coverfarbe";
	}

}
