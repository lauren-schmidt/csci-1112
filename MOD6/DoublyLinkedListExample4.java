
public class DoublyLinkedListExample4 {

    public static void main (String[] argv)
    {
	DoublyLinkedList4 favoriteShows = new DoublyLinkedList4();
	favoriteShows.add ("Crocodile Hunter");
	favoriteShows.add ("Jon Stewart");
	favoriteShows.add ("Evening at the Improv");
	favoriteShows.add ("Monty Python");
	favoriteShows.add ("SNL");

        System.out.println ("Before deletion: ");
        System.out.println (favoriteShows);

	favoriteShows.delete ("SNL");
	System.out.println ("After deletion:");
        System.out.println (favoriteShows);

	favoriteShows.delete (2);
	System.out.println ("After deletion:");
        System.out.println (favoriteShows);
    }

}