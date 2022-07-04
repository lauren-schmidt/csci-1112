public class PowerExample4 {

    
    static int a;

    public static void main (String[] argv)
    {
        a = 3;
        int p = power (2);                   
        System.out.println ( "3^4 = " + p);

        p = power (4);
        System.out.println ( "3^4 = " + p);

        a = 2;
        p = power (8);
        System.out.println ( "2^8 = " + p);
    }




    static int power (int b)
    {
        int p;
        
        if (b == 0) {
            p = 1;
        }
        else {
            p = (a * power (b-1));
        }

        System.out.println ("Intermediate result: " + a + "^" + b + "=" + p);

        return p;
    }

}
    