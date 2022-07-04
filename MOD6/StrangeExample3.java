
// We'll use instances of this object in main() below.

class ListItem {

    String data;    
    ListItem next;

}


public class StrangeExample3 {

    public static void main (String[] argv)
    {
	// Make one instance and put a string in the data field.
	ListItem first = new ListItem();
	first.data = "Yes minister";
        ListItem last = first;

	// Make a second one.
	ListItem nextOne = new ListItem();
	nextOne.data = "Seinfeld";
	last.next = nextOne;
        last = nextOne;

	// Make a third and make the second point to the third.
	nextOne = new ListItem();
	nextOne.data = "Cheers";
	last.next = nextOne;
        last = nextOne;


	// Make a fourth etc.
	nextOne = new ListItem();
	nextOne.data = "Frasier";
	last.next = nextOne;
        last = nextOne;

        // Last one.
	nextOne = new ListItem();
	nextOne.data = "Simpsons";
	last.next = nextOne;
        last = nextOne;


	// Now print by repeatedly advancing the pointer - in a simple loop.
        ListItem listPointer = first;
        while (listPointer != null) {
            System.out.println(listPointer);
            System.out.println (listPointer.data);
            listPointer = listPointer.next;
        }
    }

}

