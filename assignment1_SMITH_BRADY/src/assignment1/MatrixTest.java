package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class MatrixTest {
	
	private Matrix M1;
	private Matrix M2;
	private Matrix M3;
	private Matrix M4;
	private Matrix referencePlus;
	private Matrix referenceMultiply;
	@Before
	public void initialize() {
		M1 = new Matrix(new int[][] {{1, 2, 3},{2, 5, 6}});
		M2 = new Matrix(new int[][]{{4, 5},{3, 2},{1, 1}});
		M3 = new Matrix(new int[][] {{4, 5},{9, 3}});
		M4 = new Matrix(new int[][] {{7, 6},{4, 2}});
		
		// this is the known correct result for adding M3 and M4
		referencePlus = new Matrix(new int[][] {{11, 11},{13, 5}});
		
		// this is the known correct result of multiplying M1 by M2
		referenceMultiply = new Matrix(new int[][] {{13, 12},{29, 26}});

	}

	@Test
	public void testPlusMethod() {
		assertEquals(referencePlus, M3.plus(M4));
	}
	
	@Test
	public void testMultiplyMethod() {
		assertEquals(referenceMultiply, M1.times(M2));
	}
}
