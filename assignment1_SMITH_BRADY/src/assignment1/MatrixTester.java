/*
 * Here is a starting point for your Matrix tester. You will have to fill in the rest of "main" with
 * more code to sufficiently test your Matrix class. We will be using our own MatrixTester for grading. 
*/
package assignment1;

public class MatrixTester {
	public static void main(String[] args)
	{			
		Matrix M1 = new Matrix(new int[][]
		                       {{1, 2, 3},
							   {2, 5, 6}});
		
		Matrix M2 = new Matrix(new int[][]
		                       {{4, 5},
							   {3, 2},
							   {1, 1}});
		
		Matrix M3 = new Matrix(new int[][] {{4, 5},
											{9, 3}});
		
		Matrix M4 = new Matrix(new int[][] {{7, 6},
											{4, 2}});
		
		// this is the known correct result for adding M3 and M4
		Matrix referencePlus = new Matrix(new int[][] {{11, 11},
														{13, 5}});
		
		// this is the known correct result of multiplying M1 by M2
		Matrix referenceMultiply = new Matrix(new int[][]
		                                      {{13, 12},
								              {29, 26}});
		
		
		/* 
		 * Note that none of the tests below will be correct until you have implemented all methods.
		 * This is just one example of a test, you must write more tests and cover all cases.
		 */
		
		// exercise your toString method
		String m1Expected = "1 2 3 \n2 5 6 \n";
		String m1Result = M1.toString();
		if(!m1Expected.equals(m1Result))
			System.out.println("toString Error.\nGot:\n" + m1Result + "\nExpected:\n" + m1Expected);
		
		// get the matrix computed by your times method
		Matrix computedMultiply = M1.times(M2);
		
		// exercises your toString method as well
		System.out.println("Computed result for M1 * M2:\n" + computedMultiply); 
		
		// exercises your .equals method, and makes sure that your computed result is the same as the known correct result
		if(!referenceMultiply.equals(computedMultiply)) 
			System.out.println("equals error (M1 * M2 not equal to expected result)");
		
		// exercises the plus method as well as the toString method
		Matrix computedPlus = M3.plus(M4);
		System.out.println("Computed result for M3 + M4:\n" + computedPlus);
		
		// error-checks the times method
		Matrix errorMultiply = M1.times(M3);
		System.out.println("Computed result for M1 * M3:\n" + errorMultiply);

		// error-checks the plus method
		Matrix errorPlus = M3.plus(M2);
		System.out.println("Computed result for M3 + M2:\n" + errorPlus);
		
		// error-checks the .equals method and the plus method
		if (!referencePlus.equals(computedPlus))
			System.out.println("equals error (M3 + M4 not equal to expected result)");
		
		// error-checks the .equals method
		System.out.println("Returns true if M1 and M3 are equal, false if not:\n" + M1.equals(M3));
			
		
	}
}
