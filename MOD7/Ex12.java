public class Ex12
{
    public static void main(String[] argv)
    {
        int n = 10;
        System.out.println("Value when n = " + n + " is: " + polynomial(n));
        System.out.println("Value when n = " + n + " is: " + exponential(2,n));
        System.out.println("Ratio of the two: "  + exponential(2,n)/polynomial(n));

        n = 20;
        System.out.println("n^4 when n = " + n + " is: " + polynomial(n));
        System.out.println("2^n when n = " + n + " is: " + exponential(2,n));
        System.out.println("Ratio of the two: "  + exponential(2,n)/polynomial(n));

        n = 30;
        System.out.println("n^4 when n = " + n + " is: " + polynomial(n));
        System.out.println("2^n when n = " + n + " is: " + exponential(2,n));
        System.out.println("Ratio of the two: "  + exponential(2,n)/polynomial(n));

        n = 40;
        System.out.println("n^4 when n = " + n + " is: " + polynomial(n));
        System.out.println("2^n when n = " + n + " is: " + exponential(2,n));
        System.out.println("Ratio of the two: "  + exponential(2,n)/polynomial(n));

        n = 50;
        System.out.println("n^4 when n = " + n + " is: " + polynomial(n));
        System.out.println("2^n when n = " + n + " is: " + exponential(2,n));
        System.out.println("Ratio of the two: "  + exponential(2,n)/polynomial(n));

        n = 60;
        System.out.println("n^4 when n = " + n + " is: " + polynomial(n));
        System.out.println("2^n when n = " + n + " is: " + exponential(2,n));
        System.out.println("Ratio of the two: "  + exponential(2,n)/polynomial(n));

        n = 70;
        System.out.println("n^4 when n = " + n + " is: " + polynomial(n));
        System.out.println("2^n when n = " + n + " is: " + exponential(2,n));
        System.out.println("Ratio of the two: "  + exponential(2,n)/polynomial(n));

        n = 80;
        System.out.println("n^4 when n = " + n + " is: " + polynomial(n));
        System.out.println("2^n when n = " + n + " is: " + exponential(2,n));
        System.out.println("Ratio of the two: "  + exponential(2,n)/polynomial(n));

        n = 90;
        System.out.println("n^4 when n = " + n + " is: " + polynomial(n));
        System.out.println("2^n when n = " + n + " is: " + exponential(2,n));
        System.out.println("Ratio of the two: "  + exponential(2,n)/polynomial(n));

        n = 100;
        System.out.println("n^4 when n = " + n + " is: " + polynomial(n));
        System.out.println("2^n when n = " + n + " is: " + exponential(2,n));
        System.out.println("Ratio of the two: "  + exponential(2,n)/polynomial(n));

    }

    static int polynomial(int x)
    {
        x = x * x * x * x;
        return x;

    }

    static double exponential(double base, int exp)
    {
        double result = 1;
        for(int i = 0; i < exp; i++)
        {
            result *= base; 
        }

        return result;
    }
}


