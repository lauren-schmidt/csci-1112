
import java.util.*;

public class SetExample6 {

    public static void main (String[] argv)
    {
	// Read from file and get an array, one array element for each person.
	// Thus, people[i] is of type DataSet and people[i].strings has
	// all the strings associated with the i-th person.
	DataSet[] people = DataTool.getDataSetsAsArray ("datafortwo");

	System.out.println ("Intersection between " + people[0].name + " and " + people[1].name);
	computeIntersection (people[0].strings, people[1].strings);
    }


    static void computeIntersection (LinkedList<String> listA, LinkedList<String> listB)
    {
	for (int i=0; i<listA.size(); i++) {
	    String s = listA.get(i);
	    // To be in the intersection, s needs to be in both sets.
	    if ( listB.contains(s) ) {
		System.out.println ("  " + s);
	    }
	}
    }

}
