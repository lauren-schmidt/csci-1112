
public class DoublyLinkedListExample2 {

    public static void main (String[] argv)
    {
	DoublyLinkedList2 favoriteShows = new DoublyLinkedList2();
	favoriteShows.add ("Crocodile Hunter");
	favoriteShows.add ("Jon Stewart");
	favoriteShows.add ("Evening at the Improv");
	favoriteShows.add ("Monty Python");
	favoriteShows.add ("SNL");

        favoriteShows.reversePrint ();
    }

}