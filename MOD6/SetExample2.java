
import java.util.*;

public class SetExample2 {

    public static void main (String[] argv)
    {
	LinkedList<String> favoriteShows1 = new LinkedList<String>();
	favoriteShows1.add ("Yes minister");
	favoriteShows1.add ("Seinfeld");
	favoriteShows1.add ("Cheers");
	favoriteShows1.add ("Frasier");
	favoriteShows1.add ("Simpsons");

	LinkedList<String> favoriteShows2 = new LinkedList<String>();
	favoriteShows2.add ("Mad about you");
	favoriteShows2.add ("Seinfeld");
	favoriteShows2.add ("Frasier");
	favoriteShows2.add ("Cosby show");

	computeUnion (favoriteShows1, favoriteShows2);
    }

    // INSERT YOUR CODE HERE.

	static void computeUnion(LinkedList<String> listA, LinkedList<String> listB)
	{
		System.out.println("Union: ");

		//First, print out all of the elements in list A. 
		for(int i = 0; i < listA.size(); i++)
		{
			String s = listA.get(i);
			System.out.println(" " + s);
		}

		//Next, run through loop B, and only print the elements that have not already been printed. 
		for(int i = 0; i < listB.size(); i++)
		{
			String s = listB.get(i);
			if(!listA.contains(s))
			{
				System.out.println(" " + s);
			}
		}
	}
	


}