
class ListItem {

    String data;
    ListItem next;

}


public class OurLinkedList2 {

    ListItem front = null;
    ListItem rear = null;

    int numItems = 0;


    public void add (String s)
    {
	if (front == null) {
	    front = new ListItem ();
	    front.data = s;
	    rear = front;
	    rear.next = null;
	}
	else {
            ListItem nextOne = new ListItem ();
	    nextOne.data = s;
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

        // Otherwise, count up to the i-th item.
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

        // Start from the front and walk down the list. If it's there,
        // we'll be able to return true from inside the loop.
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

        // Put all the elements (data only) into the string.
	String s = "[";
	ListItem listPtr = front;
	while (listPtr != null) {
	    s += " \"" + listPtr.data + "\"";
	    listPtr = listPtr.next;
	}
	return s + "]";
    }


    public void printWithAddresses ()
    {
	if (front == null) {
	    return;
	}

	ListItem listPtr = front;
	while (listPtr != null) {
            //  listPtr's default toString() prints out the memory address.
	    System.out.println (" \"" + listPtr.data + "\"  at address " + listPtr);
	    listPtr = listPtr.next;
	}
    }

    public void delete(String s)
    {
        ListItem current = front;
        ListItem previous = null;

        if(current == null || current.data == s)
        {
            front = current.next; 
            return; 
        }

        while(current != null && current.data != s)
        {
            previous = current;
            current = current.next; 
        }

        if(current == null)
        {
            return;
        }

        previous.next = current.next; 

        ListItem current2 = front; 
        while(current2.next != previous)
        {
                current2 = current2.next; 
        }

        if(previous == front)
        {
            previous = previous.next;
            return; 
        }
        else if(previous == rear)
        {
            previous = null;
        }

        current2.next = previous.next; 
    }
    

}
