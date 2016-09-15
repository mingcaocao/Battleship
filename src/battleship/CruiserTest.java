package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CruiserTest {
	
	Cruiser cruiser1;

	@Before
	public void setUp() throws Exception {
		cruiser1 = new Cruiser();
	}

	@Test
	public void testGetShipType() {
		assertEquals(cruiser1.getShipType(), "cruiser");
	}

	@Test
	public void testCruiser() {
		assertEquals(cruiser1.getLength(), 3);
		assertFalse(cruiser1.hit[2]);
	}

}
