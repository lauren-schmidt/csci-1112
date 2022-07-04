
// A simple static object. Note: all members (data and methods) are declared
// with the "static" keyword.

class ObjX {

    static int i;
    static int j; 

    static void print ()
    {
	System.out.println ("i=" + i);
    System.out.println ("j=" + j);
    }

} //end-ObjX


// The class that has "main"

public class StaticExample {

    public static void main (String[] argv)
    {
        // Refer to a member of ObjX using the class name.
	ObjX.i = 5;
    ObjX.j = 6;

        // Call a method in the class using the class name and dot-operator.
	ObjX.print();
    }

}