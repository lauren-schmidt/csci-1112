import java.util.*;

public class ArraySize {

    public static void main (String[] argv)
    {

        int[] A = new int [5];
        System.out.println ("Array A has size " + A.length);
        
        
        int size = 6;
        int[] B = new int [size];
        System.out.println ("Array B has size " + B.length);
        
        
        size = getSize ();
        int[] C = new int [size];
        System.out.println ("Array C has size " + C.length);

        
        size = getSizeFromScreen ();
        int[] D = new int [size];
        System.out.println ("Array D has size " + D.length);
    }


    static int getSize ()
    {
        return 7;
    }
    
    
    static int getSizeFromScreen ()
    {
        System.out.print ("Enter size: ");
        Scanner scanner = new Scanner (System.in);
        return scanner.nextInt ();
    }

}

       
