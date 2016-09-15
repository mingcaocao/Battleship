package battleship;

public class Destroyer extends Ship {

	public Destroyer() {
		this.length = 2;
		this.hit = new boolean[] {false, false};
	}

	@Override
	String getShipType() {
		return "destroyer";
	}

}
