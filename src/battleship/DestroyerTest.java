package battleship;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DestroyerTest {
	
	Destroyer destroyer1;

	@Before
	public void setUp() throws Exception {
		destroyer1 = new Destroyer();
	}

	@Test
	public void testGetShipType() {
		assertEquals(destroyer1.getShipType(), "destroyer");
	}

	@Test
	public void testDestroyer() {
		assertEquals(destroyer1.getLength(), 2);
		assertFalse(destroyer1.hit[1]);
	}

}
