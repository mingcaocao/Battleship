package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BattleshipTest {

	Battleship battleship1;
	
	@Before
	public void setUp() throws Exception {
		battleship1 = new Battleship();
	}

	@Test
	public void testGetShipType() {
		assertEquals(battleship1.getShipType(), "battleship");
	}

	@Test
	public void testBattleship() {
		assertEquals(battleship1.getLength(), 4);
		assertFalse(battleship1.hit[3]);
	}

}
