
class ObjX {

    // No "static" keyword for either member.

    int i;
    int j;

    void print ()
    {
	System.out.println ("i=" + i);
    System.out.println("j=" + j);
    }

}


public class DynamicExample {

    public static void main (String[] argv)
    {
        // First create an instance, which allocates space from the heap.
	ObjX x = new ObjX (); 

        // Now access members via the variable and the dot-operator.
	x.i = 5;
    x.j = 6;
	x.print();
    }

}