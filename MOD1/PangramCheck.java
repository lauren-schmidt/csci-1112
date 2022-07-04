
public class PangramCheck {

    public static void main (String[] argv)
    {
        // Pangram: a sentence with at least one occurence of each letter 'a' to 'z'.

        String[] pangramWords = {"two", "driven", "jocks", "help", "fax", "my", "big", "quiz"};
        boolean isPangram = checkPangram (pangramWords);
        System.out.println ("isPangram=" + isPangram);

        String[] pangram2 = {"two", "driven", "jocks", "help", "fax", "my", "big"};
        isPangram = checkPangram (pangram2);
        System.out.println ("isPangram=" + isPangram);
    }


    static boolean checkPangram (String[] words)
    {
	    int start = (int) 'a';
	    int end = (int) 'z';

	    // INSERT YOUR CODE HERE. YOU DON'T HAVE TO USE start AND end.

	    //Allocating an array of integers with 26 "buckets" 
	    int[] countChars = new int[26];
	    int current = 0;	

	    for(int i = 0; i < words.length; i++)
	    {
		    for(int j = 0; j < words[i].length(); j++)
		    {
			    current = (int) words[i].charAt(j);
			    current -= start; 
			    countChars[current] ++; 
		    }
	    }

	    for(int k = 0; k < countChars.length; k++)
	    {
		    if(countChars[k] == 0)
		    {
			    return false; 
		    }
	    }

	    return true; 
    }

}
