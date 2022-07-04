
public class Log {

    public static void main (String[] argv)
    {
        int K = 64;
        System.out.println ("K=" + K + " log2(K)=" + log2(K));

        K = 1024;
        System.out.println ("K=" + K + " log2(K)=" + log2(K));

        K = 1000;
        System.out.println ("K=" + K + " log2(K)=" + log2(K));
    }

    public static int log2(int x)
    {
        int numDiv = 0;

        while(x > 1)
        {
            x = x / 2; 
            numDiv++; 
        }

        return numDiv; 

    }

}

