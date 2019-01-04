package assignment1;

public class Matrix {
	private int numRows;
	private int numColumns;
	private int data[][];
	
	// Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		numRows = d.length; // d.length is the number of 1D arrays in the 2D array
		if(numRows == 0)
			numColumns = 0;
		else
			numColumns = d[0].length; // d[0] is the first 1D array
		data = new int[numRows][numColumns]; // create a new matrix to hold the data
		// copy the data over
		for(int i=0; i < numRows; i++) 
			for(int j=0; j < numColumns; j++)
				data[i][j] = d[i][j];
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		if (m.numRows == data.length) 		// checks to make sure the two matrices are the same size
		{	
			if (m.numColumns == data[0].length) 
			{
				for (int rowIndex = 0; rowIndex < data.length; rowIndex++) 	//loops through both matrices, testing to see if all the items in each are equal
				{ 
					for (int colIndex = 0; colIndex < data[0].length; colIndex++) 
					{
						return (m.data[rowIndex][colIndex] == data[rowIndex][colIndex]); // returns true if the two Matrices are equal and false if not
					}
				}
			}
		}
		return false;
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
		String result = ""; // the string that will hold the Matrix being converted to String
		for (int rowIndex = 0; rowIndex < data.length; rowIndex++) 
		{
			for (int colIndex = 0; colIndex < data[0].length; colIndex++) 
			{
				result += data[rowIndex][colIndex] + " "; // adds each item to the String
				if (colIndex == numColumns - 1) // if the loop reaches the end of a row, a new line is inserted
					result += "\n";
			}
		}
		return result;
	}
	
	public Matrix times(Matrix m)
	{
		Matrix result = new Matrix(new int[numRows][m.numColumns]); // the new Matrix containing the result of multiplying the two Matrices
		if (numColumns == m.numRows) // check to see if the two Matrices are compatible to be multiplied
		{
			for (int rowIndex = 0; rowIndex < numRows; rowIndex++) 
			{
				for (int colIndex = 0; colIndex < m.numColumns; colIndex++)
				{
					for (int mColIndex = 0; mColIndex < numColumns; mColIndex++) 
					{
						result.data[rowIndex][colIndex] = result.data[rowIndex][colIndex] + data[rowIndex][mColIndex] * m.data[mColIndex][colIndex];
					} // loops through the two Matrices, performing the necessary steps to multiply two Matrices together, then adds the product to the result Matrix
				}
			}
		}
		else 
		{
			return null; // returns null if the two Matrices are not compatible to be multiplied
		}
		return result;
	}
	
	public Matrix plus(Matrix m)
	{
		Matrix result = new Matrix(new int[m.numRows][m.numColumns]); // the new Matrix containing the result of adding the two Matrices together
		if (m.numRows == numRows) // checks to see if the two Matrices are compatible to be added together
		{
			if (m.numColumns == numColumns) 
			{
				for (int rowIndex = 0; rowIndex < data.length; rowIndex++) 
				{
					for (int colIndex = 0; colIndex < data[0].length; colIndex++) 
					{
						result.data[rowIndex][colIndex] = m.data[rowIndex][colIndex] + data[rowIndex][colIndex]; // loops through each Matrix, adding the sum of each item to the result Matrix
					}
				}
			}
			else 
			{
				return null; // returns null if the two Matrices are not compatible to be multiplied
			}
		}
		else 
		{
			return null; // returns null if the two Matrices are not compatible to be multiplied
		}
		
		return result;
	}
}
