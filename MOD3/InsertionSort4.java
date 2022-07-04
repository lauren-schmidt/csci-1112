

import java.util.*;

public class InsertionSort4 {

    public static void main (String[] argv)
    {
        int[] testData = makeRandomArray(100); 
        
        System.out.println ("Before: " + Arrays.toString(testData));
        
	insertionSort (testData);

        System.out.println ("After: " + Arrays.toString(testData));
    }

    static void insertionSort (int[] A)
    {
	int count = 0;
	for (int i=0; i<A.length; i++) {

            for (int j=i; (j>0) && (A[j]<A[j-1]); j--) {
               	count++;
	        int temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;
            }
            
	}
	System.out.println(count);

    }
    
    static int[] makeRandomArray (int length)
    {
        int[] A = new int [length];

	for (int i=0; i<A.length; i++) {
	    A[i] = UniformRandom.uniform (1, 100);
	}

        return A;
    }

}
