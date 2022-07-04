public class Ex2
{
    public static void main(String[] argv)
    {
        int n = 1; 

        while(((3*n*n*n)+(5*n*n)+(100*n) >= (4*n*n*n)))
        {
            n++;
        }

        System.out.println("The curve g(n) rises above f(n) when n = " + n);
    }
}