 
public class OurLinkedListExample2 {

    public static void main (String[] argv)
    {
	OurLinkedList2 favoriteShows = new OurLinkedList2();
	favoriteShows.add ("Yes minister");
	favoriteShows.add ("Seinfeld");
	favoriteShows.add ("Cheers");
	favoriteShows.add ("Frasier");
	favoriteShows.add ("Simpsons");
	System.out.println ("List: " + favoriteShows);

	favoriteShows.printWithAddresses();
	favoriteShows.delete ("Frasier");
	System.out.println ("After delete: ");
	favoriteShows.printWithAddresses();

	favoriteShows.delete ("Cosby");
	System.out.println ("After delete: ");
	favoriteShows.printWithAddresses();

    }
}
