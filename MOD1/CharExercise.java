 
import java.util.*;

public class CharExercise {

    public static void main (String[] argv)    
 {
        char[] letters = {'f', 'a', 'c', 'e', 't', 'i', 'o', 'u', 's'};

        String s = "facetious";
        char[] letters2 = s.toCharArray ();

        char[] letters3 = new char [4];
        letters3[0] = 'f';
        letters3[1] = 'a';
        letters3[2] = 'c';
        letters3[3] = 'e';

        if ( checkEqual (letters, letters2) ) {
            System.out.println ( Arrays.toString(letters) + " = " + Arrays.toString(letters2) );
        }
        else {
            System.out.println ( Arrays.toString(letters) + " != " + Arrays.toString(letters2) );
        }

        if ( checkEqual (letters, letters3) ) {
            System.out.println ( Arrays.toString(letters) + " = " + Arrays.toString(letters3) );
        }
        else {
            System.out.println ( Arrays.toString(letters) + " != " + Arrays.toString(letters3) );
        }

    }

    // INSERT YOUR CODE HERE
    public static boolean checkEqual(char[] one, char[] two)
    {
	    //creates a counter variable that will make sure both arrays  are the same 
	    int counter = 0;

	    //checks to make sure both character arrays are equal in length 
	    if(one.length == two.length)
	    {

		    //if both arrays are equal in length; traverses through the array and compares 
		    //elements index by index 
		    for(int i = 0; i < one.length; i++)
		    {
			    if(one[i] == two[i])
			    {
				    counter++;
			    }
		    }

		    //if every element of each char array is the same, the counter value should match
		    //the length.  
		    if(counter == one.length)
		    {
			    return true;
		    }
	    }
	    return false; 
    }   
}
