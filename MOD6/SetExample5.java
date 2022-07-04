
import java.util.*;

public class SetExample5 {

    public static void main (String[] argv)
    {
	// Create an instance of the data structure.
	LinkedList<String> favoriteShows1 = new LinkedList<String>();

	// Put some elements in so that it becomes a set of strings.
	favoriteShows1.add ("Yes minister");
	favoriteShows1.add ("Seinfeld");
	favoriteShows1.add ("Cheers");
	favoriteShows1.add ("Frasier");
	favoriteShows1.add ("Simpsons");

	// Create a second instance and add some elements.
	LinkedList<String> favoriteShows2 = new LinkedList<String>();
	favoriteShows2.add ("Mad about you");
	favoriteShows2.add ("Seinfeld");
	favoriteShows2.add ("Frasier");
	favoriteShows2.add ("Cosby show");

	// Compute set intersection and the difference favoriteShows1-favoriteShows2
	LinkedList<String> union = computeUnion (favoriteShows1, favoriteShows2);
	System.out.println ("union: " + union);
    }

    static LinkedList<String> computeUnion(LinkedList<String> listA, LinkedList<String> listB)
	{
        LinkedList<String> ListU = new LinkedList<String>();

		System.out.println("Union: ");

		//First, print out all of the elements in list A. 
		for(int i = 0; i < listA.size(); i++)
		{
			String s = listA.get(i);
			ListU.add(s);
		}

		//Next, run through loop B, and only print the elements that have not already been printed. 
		for(int i = 0; i < listB.size(); i++)
		{
			String s = listB.get(i);
			if(!listA.contains(s))
			{
				ListU.add(s);
			}
		}

        return U;
	}
    

}