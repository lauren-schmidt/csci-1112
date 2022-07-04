
class ListItem {

    String data;
    ListItem next;    // To point to next node in list.
    ListItem prev;    // To point to the previous node in the list.

}


public class DoublyLinkedList2 {

    // Instance variables.
    ListItem front = null;
    ListItem rear = null;

    int numItems = 0;

    public void add (String s)
    {
	if (front == null) {
            // Similar to singly-linked list, except for setting rear.prev
	    front = new ListItem ();
	    front.data = s;
	    rear = front;
	    rear.next = null;
	    rear.prev = null;           // Must set this correctly.
	}
	else {
            // Make new ListItem and set its fields correctly.
            ListItem nextOne = new ListItem ();
	    nextOne.data = s;
	    nextOne.next = null;
	    nextOne.prev = rear;

            // Adjust the next pointer of the current last one, and adjust rear itself.
	    rear.next = nextOne;
	    rear = nextOne;
	}    

	numItems ++;
    }


    public int size ()
    {
	return numItems;
    }

    
    public String get (int i)
    {
	if (i >= numItems) {
	    return null;
	}
	int count = 0;

	ListItem listPtr = front;
	while (count < i) {
	    listPtr = listPtr.next;
	    count ++;
	}
	return listPtr.data;
    }


    public boolean contains (String s)
    {
	if (front == null) {
	    return false;
	}

        // Forward traversal.
	ListItem listPtr = front;
	while (listPtr != null) {
	    if ( listPtr.data.equals(s) ) {
		return true;
	    }
	    listPtr = listPtr.next;
	}
	return false;
    }


    public String toString ()
    {
	if (front == null) {
	    return "empty";
	}
	String s = "";
	ListItem listPtr = front;
	while (listPtr != null) {
	    s += " \"" + listPtr.data + "\"";
	    listPtr = listPtr.next;
	}
	return s;
    }



    // INSERT YOUR CODE HERE.
    public void reversePrint()
    {
        while(rear != null)
        {
            System.out.println(rear.data);
            rear = rear.prev; 
        }
    }

}
