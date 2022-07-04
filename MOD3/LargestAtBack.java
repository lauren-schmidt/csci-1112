
import java.util.*;

public class LargestAtBack {

    public static void main (String[] argv)
    {
        // Some test data (a subset of Java's reserved words).
	String[] reservedWords = {"if", "else", "while", "do", "return", 
				  "true", "false", "instanceof", "class"};
        
        System.out.println ( "Before: " + Arrays.toString(reservedWords) );

	largestAtBack (reservedWords);

        System.out.println ( "After: " + Arrays.toString(reservedWords) );
    }

	static void largestAtBack(String[] A)
	{
		//Start by assuming first is largest.
		String largest = A[0];

		//Record the position where the largest occurs. 
		int pos = 0;

		//Check against A[1], A[2], ... etc. 
		for(int i = 0; i < A.length; i++)
		{
			if(A[i].compareTo(largest) > 0)
			{
				largest = A[i];
				pos = i;
			}
		}

		//Swap
		int lastElement = A.length - 1;
		String temp = A[lastElement];
		A[lastElement] = A[pos];
		A[pos] = temp; 
		
	}
    
}
