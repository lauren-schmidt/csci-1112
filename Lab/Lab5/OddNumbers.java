public class OddNumbers {

    public static void main (String[] argv)
    {
        // Read this example:
        example1 ();

        // Debug this one:
        example2 ();

        // Debug this one:
        example3 ();
    }


    static void example1 ()
    {
        int[] oddIntegers = makeOddArray (10);
        printWithWhile (oddIntegers);
        printWithDo (oddIntegers);
    }


    static void example2 ()
    {
        int[] A = {};
        printWithWhile (A);
        printWithDo (A);
    }

    static void example3 ()
    {
        int[] A = {1, 3, 5};
        printWithWhile2 (A);
    }


    static int[] makeOddArray (int size)
    {
        int[] oddGuys = new int [size];
        for (int i=0; i < oddGuys.length; i++) {
            oddGuys[i] = 2*i + 1;
        }
        return oddGuys;
    }


    static void printWithWhile (int[] A)
    {
        System.out.print ("  Array elements: ");
        int i=0;
        while (i < A.length) {
            System.out.print ("  " + A[i]);
            i ++;
        }
        System.out.println ();
    }


    static void printWithDo (int[] A)
    {
        System.out.print ("  Array elements: ");
        int i=0;
        do {
            System.out.print ("  " + A[i]);
            i ++;
        } while (i < A.length);
        System.out.println ();
    }


    static void printWithWhile2 (int[] A)
    {
        System.out.print ("  Array elements: ");
        int i=0;
        while (i < A.length) 
            System.out.print ("  " + A[i]);
            i ++;
        System.out.println ();
    }
}