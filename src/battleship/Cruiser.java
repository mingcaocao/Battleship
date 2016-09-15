package battleship;

public class Cruiser extends Ship {

	public Cruiser() {
		this.length = 3;
		this.hit =new boolean[]{false, false, false};
	}

	@Override
	String getShipType() {
		return "cruiser";
	}

}
