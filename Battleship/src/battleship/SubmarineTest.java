package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubmarineTest {
	
	Submarine submarine1;

	@Before
	public void setUp() throws Exception {
		submarine1 = new Submarine();
	}

	@Test
	public void testGetShipType() {
		assertEquals(submarine1.getShipType(), "submarine");
	}

	@Test
	public void testSubmarine() {
		assertEquals(submarine1.getLength(), 1);
		assertFalse(submarine1.hit[0]);
	}

}
