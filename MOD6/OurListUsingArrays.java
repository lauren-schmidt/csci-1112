
public class OurListUsingArrays {

    // This is the array in which we'll store strings.
    String[] strings = new String [100];;

    // Initially, there are none.
    int numStrings = 0;


    public void add (String s)
    {
	if (numStrings < 100) {
	    strings[numStrings] = s;
	    numStrings ++;
	}
    }


    public int size ()
    {
	return numStrings;
    }


    public String get (int i)
    {
	return strings[i];
    }


    public boolean contains (String s)
    {
	// Note: we need to use numStrings instead of strings.length
	for (int i=0; i<numStrings; i++) {
	    if ( strings[i].equalsIgnoreCase(s) ) {
		return true;
	    }
	}
	return false;
    }

}
