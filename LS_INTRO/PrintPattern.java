
public class PrintPattern {

    public static void main (String[] argv)
    {
        printPattern (5);
        printPattern (7);
    }
    
    static void printPattern (int N)
    {
	//rows of the pattern
	for(int i = 1; i <= N; i++)
	{
		for(int j = i; j > 0; j--)
		{
			System.out.print(j + " ");
		}
		System.out.println();
	}
    }
} 
    

