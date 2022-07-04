
class ListItem {

    int data;
    ListItem next;    // To point to next node in list.
    ListItem prev;    // To point to the previous node in the list.


}


public class DoublyLinkedIntList {

    // INSERT YOUR CODE HERE. 

    // Start by copying over the appropriate methods from DoublyLinkedList.java.
    // Then, change the method signatures.
    // After that, make the remaining changes.

     // Instance variables.
    ListItem front = null;
    ListItem rear = null;

    int numItems = 0;

    public void add (int s)
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
    }

    public int size ()
    {
	return numItems;
    }

    
  public int get (int i)
    {
	if (i >= numItems) {
	    return 0;
	}
	int count = 0;

	ListItem listPtr = front;
    System.out.println(i);
	while (count < i) {
        System.out.println(count);
	    listPtr = listPtr.next;
	    count ++;
        
	}

	return listPtr.data;
    }


    public boolean contains (int a)
    {
	if (front == null) {
	    return false;
	}

        // Forward traversal.
	ListItem listPtr = front;
	while (listPtr != null) {
	    if ( listPtr.data == a ) {
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

    public void printList()
    {
        while(front != null)
        {
            System.out.println(front.data);
            front = front.next;
        }
    }


}
