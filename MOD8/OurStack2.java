
import java.util.*;

public class OurStack2 {

    ArrayList<Character> array;
    int top;

    public OurStack2 ()
    {
	// Can be unlimited in size now.
	array = new ArrayList<Character>();
	top = 0;
    }

    public void push (char ch)
    {
        // Test for full stack.
        if(top >= array.size())
        {
            System.out.println("ERROR: OurStack.push(): stack overflow");
            return;
        }

        array.set(top, ch)O; 
        top++;
    }

    public char pop ()
    {
        // Test for empty stack.
        if(top <= 0)
        {
            System.out.println("ERROR in OurStack.pop(): stack empty");
            //Still need to have a return statement, so we return some "junk letter"
            return '@';
        }

        top--;
        return array.get(top);
    }


    public boolean isEmpty ()
    {
        if (top == 0)
        {
            return true;
        }
        else
        {
            return false; 
        }
    }

}