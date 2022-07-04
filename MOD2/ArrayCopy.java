
public class ArrayCopy {

	public static void main (String[] argv)
	{
		int[][] A = {
			{1},
			{2, 1},
			{3, 2, 1},
			{4, 3, 2, 1},
			{5, 4, 3, 2, 1}
		};
		print (A);

		int[][] B = copy (A);
		print (B);
	}

	static void print (int[][] X)
	{
		for (int i=0; i<X.length; i++) {
			for (int j=0; j < X[i].length; j++) {
				System.out.print (" " + X[i][j]);
			}
			System.out.println ();
		}
	}

	// INSERT YOUR CODE HERE:   
	static int[][] copy(int [][] Y)
	{
		//create a new array to return with the same size as the original array 
		int [][] C = new int[Y.length][];
		
		//implement a for-loop to deep copy the values 
		for(int i = 0; i < Y.length; i++)
		{
		//make sure that each row of the array has the same number of columns as 
		//the original array 
		C[i] = new int[Y[i].length];
			for(int j = 0; j < Y[i].length; j++)
			{
				C[i][j] = Y[i][j]; 
			}
		}

		//return the copied array
		return C;
	}
}
