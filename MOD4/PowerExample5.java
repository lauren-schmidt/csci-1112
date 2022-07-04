
public class PowerExample5 {

    // Declare "a" as global to be set in main() and accessed elsewhere.
    static int a;
    
    // Now try "b"
    static int b;

    public static void main (String[] argv)
    {
        a = 3;
        b = 2;
        
        int p = power ();                   // No parameters.
        System.out.println ( "3^2 = " + p);

        b = 4;
        p = power ();
        System.out.println ( "3^4 = " + p);

        a = 2;
        b = 8;
        p = power ();
        System.out.println ( "2^8 = " + p);
        
    }



    // No parameter.

    static int power ()
    {
        int p;
        
        if (b == 0) {
            p = 1;
        }
        else {
            b = b - 1;
            p = a * power();
        }

        System.out.println ("Intermediate result: " + a + "^" + b + "=" + p);
        return p;
    }

}