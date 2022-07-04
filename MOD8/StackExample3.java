import java.util.*;

public class StackExample3 {

    public static void main (String[] argv)
    {

    String s = "!skrow tI";
	printReverse (s);
    }

    static void printReverse (String str)
    {
    Stack<Character> list = new Stack<> ();

    for(int i = 0; i < str.length(); i++)
    {
        list.push(str.charAt(i));
    }
    
    while(! list.isEmpty() )
    {
        System.out.println(list.pop());
    }
    }
    
}