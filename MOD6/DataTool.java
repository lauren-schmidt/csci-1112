
import java.io.*;
import java.util.*;

public class DataTool {

    public static DataSet[] getDataSetsAsArray (String fileName)
    {
	LinkedList<DataSet> allDataSets = getDataSets (fileName);
	DataSet[] sets = new DataSet [allDataSets.size()];
	for (int i=0; i<allDataSets.size(); i++) {
	    sets[i] = allDataSets.get(i);
	}
	return sets;
    }


    public static LinkedList<DataSet> getDataSets (String fileName)
    {
	String line = null;
	int lineNum = 0;

	try {
	    LineNumberReader lnr = new LineNumberReader (new FileReader (fileName));
	    LinkedList<DataSet> allDataSets = new LinkedList<DataSet>();

	    line = lnr.readLine ();
	    lineNum = 1;
	    DataSet data = null;

	    while (line != null) {

		line = line.trim();

		if (line.startsWith ("#")) {
		    // First end previous round.
		    if (data != null) {
			allDataSets.add (data);
		    }
		    // Start a new data set.
		    data = new DataSet ();
		    data.name = line.substring (1, line.length());
		    data.strings = new LinkedList<String>();
		}
		else {
		    data.strings.add (line.trim().toLowerCase());
		}

		line = lnr.readLine();
		lineNum ++;

	    } //endwhile

	    // Last data set.
	    if (data != null) {
		allDataSets.add (data);
	    }

	    return allDataSets;
	}
	catch (Exception e) {
	    // If something went wrong ...
	    System.out.println ("ERROR in file at line# " + lineNum + ": " + line);
	    System.out.println (e);
	    System.exit (0);
	    return null;
	}
    }


    public static void main (String[] argv)
    {
	// Test.
	DataSet[] data = getDataSetsAsArray ("bookdata");
	for (int k=0; k<data.length; k++) {
	    System.out.println (data[k]);
	}
    }


}

