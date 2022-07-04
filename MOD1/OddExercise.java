
import java.util.*;

public class OddExercise {

    public static void main (String[] argv)
    {
	int[] oddIntegers = makeOddArray (10);
	System.out.println ( "Our array: " + Arrays.toString(oddIntegers) );
        boolean found = search (5, oddIntegers);
        System.out.println ("found=" + found);
        found = search (6, oddIntegers);
        System.out.println ("found=" + found);
    }


    // Note: return type is an array.

    static int[] makeOddArray (int size)
    {
	// Note use of variable "size" in creating array space.
	int[] oddGuys = new int [size];
	for (int i=0; i<oddGuys.length; i++) {
	    oddGuys[i] = 2*i + 1;
	}
	return oddGuys;
    }

    // INSERT YOUR CODE FOR THE METHOD search HERE.
    public static boolean search(int value, int[] array)
    {
	    //Traverses the array and checks each index to see if it matches the value we 
	    //are looking for
	    //If array contains value, method will return true, otherwise false  
	    for(int i= 0; i < array.length; i++)
	    {
		    if(array[i] == value)
		    {
			    return true;
		    }
	    }
	    return false;
    }

}
