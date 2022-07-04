public class CompileError
{
    public static void main(String args[]) 
    {	
        int x  = Integer.parseInt(args[0]);
        if (x > 5) 
        {
            System.out.println("Your value " + x + " is greater than 5");
        }
        else
        {
            System.out.println("Your value " + x + " is less than 5");
        }
    }
}
