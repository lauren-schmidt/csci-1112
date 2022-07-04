
public class ManhattanWithCallCount {

    static int numCall = 0;

    static int[][] values; 

    public static void main (String[] argv)
    {
        // Test case 1: go from (2,2) to (0,0)
	int r = 2;
	int c = 2;
    values = new int[r+1][c+1];
    numCall = 0;  
	int n = countPaths (r, c);
	System.out.println ("r=" + r + " c=" + c + " => n=" + n+ "  numCall=" + numCall);

        // Test case 2: go from (5,7) to (0,0)
	r = 5;
	c = 7;
    values = new int[r+1][c+1];
    numCall = 0;  
	n = countPaths (r, c);
	System.out.println ("r=" + r + " c=" + c + " => n=" + n + "  numCall=" + numCall);

    }


    static int countPaths (int numRows, int numCols)
    {
        numCall++;
        // Bottom-out case:
	if ( (numRows == 0) || (numCols == 0) ) {
        values[0][0] = 1;
	    return 1;
	}

	// Otherwise, reduce to two sub-problems and add.
    if(values[numRows - 1][numCols] == 0)
    {
        values[numRows-1][numCols] = countPaths (numRows-1, numCols); 
     
    }
    if(values[numRows][numCols - 1] == 0)

    {
        values[numRows][numCols-1] = countPaths (numRows, numCols-1); 
       
    }

	return (values[numRows][numCols-1] + values[numRows-1][numCols]);
    }
}