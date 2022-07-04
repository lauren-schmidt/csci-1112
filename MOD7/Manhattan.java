public class Manhattan {

    public static int counter = 0; 

    public static void main (String[] argv)
    {
    // Test case 1: go from (1,1) to (0,0)
	int r = 1, c = 1;
	int n = countPaths (r, c);
	System.out.println ("r=" + r + " c=" + c + " => n=" + n);
    System.out.println("Number of calls made to countPaths when r = " + r + ": " + counter);
    counter = 0;

    // Test case 2: go from (2,2) to (0,0)
	r = 2;
	c = 2;
	n = countPaths (r, c);
	System.out.println ("r=" + r + " c=" + c + " => n=" + n);
    System.out.println("Number of calls made to countPaths when r = " + r + ": " + counter);
    counter = 0;

    // Test case 2: go from (3,3) to (0,0)
    r = 3;
	c = 3;
	n = countPaths (r, c);
	System.out.println ("r=" + r + " c=" + c + " => n=" + n);
    System.out.println("Number of calls made to countPaths when r = " + r + ": " + counter);
    counter = 0;

    // Test case 2: go from (4,4) to (0,0)
    r = 4;
	c = 4;
	n = countPaths (r, c);
	System.out.println ("r=" + r + " c=" + c + " => n=" + n);
    System.out.println("Number of calls made to countPaths when r = " + r + ": " + counter);
    counter = 0;

    // Test case 2: go from (5,5) to (0,0)
    r = 5;
	c = 5;
	n = countPaths (r, c);
	System.out.println ("r=" + r + " c=" + c + " => n=" + n);
    System.out.println("Number of calls made to countPaths when r = " + r + ": " + counter);
    counter = 0;

    // Test case 2: go from (6,6) to (0,0)
    r = 6;
	c = 6;
	n = countPaths (r, c);
	System.out.println ("r=" + r + " c=" + c + " => n=" + n);
    System.out.println("Number of calls made to countPaths when r = " + r + ": " + counter);
    counter = 0;
    
    // Test case 2: go from (7,7) to (0,0)
    r = 7;
	c = 7;
	n = countPaths (r, c);
	System.out.println ("r=" + r + " c=" + c + " => n=" + n);
    System.out.println("Number of calls made to countPaths when r = " + r + ": " + counter);
    counter = 0;

    // Test case 2: go from (8,8) to (0,0)
    r = 8;
	c = 8;
	n = countPaths (r, c);
	System.out.println ("r=" + r + " c=" + c + " => n=" + n);
    System.out.println("Number of calls made to countPaths when r = " + r + ": " + counter);
    counter = 0;

    // Test case 2: go from (9,9) to (0,0)
    r = 9;
	c = 9;
	n = countPaths (r, c);
	System.out.println ("r=" + r + " c=" + c + " => n=" + n);
    System.out.println("Number of calls made to countPaths when r = " + r + ": " + counter);
    counter = 0;

    // Test case 2: go from (10,10) to (0,0)
    r = 10;
	c = 10;
	n = countPaths (r, c);
	System.out.println ("r=" + r + " c=" + c + " => n=" + n);
    System.out.println("Number of calls made to countPaths when r = " + r + ": " + counter);
    
    }


    static int countPaths (int numRows, int numCols)
    {
    counter++;
	// Bottom out case: there's only one way to (0,0). 
        // Note: it's || and not &&.
	if ( (numRows == 0) || (numCols == 0) ) {
	    return 1;
	}

	// Otherwise, reduce to two sub-problems and add.
        int downCount = countPaths (numRows-1, numCols);
	int rightCount = countPaths (numRows, numCols-1);
	return (downCount + rightCount);
    }
}