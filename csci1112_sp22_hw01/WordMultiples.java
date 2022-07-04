/*------------------------------------------------------------------------
 GWU CSCI1112 Spring 2022
 author: Lauren Schmidt 
 
Calculates numeric multiples of a given string based on the ASCII values
of each character in the string.
-------------------------------------------------------------------------*/

class WordMultiples {

    /// Calculate computes the numeric value of the given String.
    /// @param letters The string provided, used to find the numeric 
    ///        value and multiples from
    /// @return The total numeric value of the String.  If the function 
    ///         fails for any reason, returns 0 
	public static int calculate(String letters) {
		int letterVal = 0;
		if(letters == null)
		{
			return 0;
		}
		for(int i = 0; i < letters.length(); i++)
		{
			letterVal += letters.charAt(i);
		}	
		return letterVal;
	}

    //---------------------------------------------------------------------
    /// This function computes all of multiples of the string using 
    /// calculate
    /// @param letters The string provided, used to find the numeric 
    ///        value and multiples from
    /// @param numMultiples The non-negative number indicating the number 
    ///        of multiples to compute
    /// @return If conditions are valid, returns an array of length 
    ///         equal to numMultiples that contains the multiples for the 
    ///         input letters.  If conditions are invalid, returns null
	public static int[] findMultiples(String letters, int numMultiples) {
		//Code to check if the conditions are invalid 
		if((letters == null) || (numMultiples < 0))
		{
			return null;
		}

		//create variables to store value and array to return 
		int value = calculate(letters);
		int[] result = new int[numMultiples];

		//populate array with multiples 
		for(int i = 0; i < result.length; i++)
		{
			result[i] = value*(i+1); 
		}

		return result; 
	}

    //---------------------------------------------------------------------
    /// Display is only responsible for displaying all of the information 
    /// gathered from other methods into a readable and presentable format.
    /// @param letters : The string provided, used to find the numeric 
    ///        value and multiples from
    /// @param multiples : Array that contains the multiples for the String
    public static void display(String letters, int[] multiples) {
        // Please reference the provided PDF for proper formatting and 
        // requirements
        // TODO : Fill in your code here

	    int value = calculate(letters);
	    //checks for invalid conditions 
	    if((letters == null) || (multiples == null))
	    {
		    return; 
	    }

	    //prints out the display 
	    System.out.println("*********************************");
	    System.out.println("Given word: " + letters);
	    System.out.println("ASCII Value: " +  value); 
	    System.out.println("The first " + multiples.length + " multiples:");
	    for(int i = 0; i < multiples.length; i++)
	    {	
		    System.out.print(multiples[i] + " ");
	    }
	    System.out.println();
	    System.out.print("*********************************");
    }

}
