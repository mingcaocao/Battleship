package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptySeaTest {
	
	EmptySea emptySea1;

	@Before
	public void setUp() throws Exception {
		emptySea1 = new EmptySea();
	}

	@Test
	public void testGetShipType() {
		assertEquals(emptySea1.getShipType(), "empty");
	}

	@Test
	public void testShootAt() {
		assertFalse(emptySea1.shootAt(0, 5));
	}

	@Test
	public void testIsSunk() {
		assertFalse(emptySea1.isSunk());
	}

	@Test
	public void testToString() {
		assertEquals(emptySea1.toString(), ".");
	}

	@Test
	public void testEmptySea() {
		assertEquals(emptySea1.getLength(), 1);
		assertFalse(emptySea1.hit[0]);
	}

}
