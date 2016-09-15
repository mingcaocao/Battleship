package battleship;

public class EmptySea extends Ship {

	public EmptySea() {
		this.length = 1;
		this.hit = new boolean[]{false};
	}

	@Override
	boolean shootAt(int row, int column){
		hit[0] = true;
		return false;
	}

	@Override
	boolean isSunk(){
		return false;
	}

	@Override
	public String toString(){
		return"-";
	}

	@Override
	String getShipType() {
		return "empty";
	}

}
