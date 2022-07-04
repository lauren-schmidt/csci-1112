class ListItem{

    //...
    public String toString()
    {
        return data; 
    }

}

public class OurLinkedList {

    // ... same as before ...

    public void add (String s)
    {
        // ...
    }

    public int size()
    {
        // ...
    }

    public String get (int i)
    {
        // ...
    }

    public boolean contains (String s)
    {
        // ... 
    }

    public String toString()
    {
        if(front == null)
        {
            return "empty";
        }

        //Put all the elements (data only) into the string. 
        String s = "[";
        ListItem listPtr = front;
        while(listPtr != null)
        {
            s += " \"" + listPtr.data + "\"";
            listPtr = listPtr.next; 
        }
        return s + "]";
    }

    public void printWithAddresses()
    {
        if(front == null)
        {
            return;
        }

        ListItem listPtr = front;
        while(listPtr != null)
        {
            //listPtr's default toString() prints out the memory address. 
            System.out.println(" \"" + listPtr.data + "\" at address " + listPtr);
            listPtr = listPtr.next; 
        }
    }

}