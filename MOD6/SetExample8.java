
import java.util.*;

public class SetExample8 {

    public static void main (String[] argv)
    {
	// Create an instance of the data structure.
	OurListUsingArrays favoriteShows1 = new OurListUsingArrays();
	favoriteShows1.add ("Yes minister");
	favoriteShows1.add ("Seinfeld");
	favoriteShows1.add ("Cheers");
	favoriteShows1.add ("Frasier");
	favoriteShows1.add ("Simpsons");

	// Create a second instance and add some elements.
	OurListUsingArrays favoriteShows2 = new OurListUsingArrays();
	favoriteShows2.add ("Mad about you");
	favoriteShows2.add ("Seinfeld");
	favoriteShows2.add ("Frasier");
	favoriteShows2.add ("Cosby show");

	// Compute set intersection and the difference favoriteShows1-favoriteShows2
	computeUnion (favoriteShows1, favoriteShows2);
    }

    // INSERT YOUR CODE.

    static void computeUnion(OurListUsingArrays listA, OurListUsingArrays listB)
    {
        System.out.println("Union: ");

        for(int i = 0; i < listA.size(); i++)
        {
            String s = listA.get(i);
            System.out.println(" " + s);
        }

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