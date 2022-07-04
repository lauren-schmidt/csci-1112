
// Ex: Think through how one could use the stack directly,
// instead of first removing non-letters. Why is it difficult?

import java.util.*;

public class Palindrome2 {

    public static void main (String[] argv)
    {
	// Oldest known recorded palindrome.
        String str = "Evil did I dwell; lewd I did live";
        System.out.println ( str + " " + checkPalindrome(str) );

	// Oldest reference.
        str = "Madam, I'm Adam";
        System.out.println ( str + " " + checkPalindrome(str) );

	// One of the most famous.
        str = "A man, a plan, a canal: Panama";
        System.out.println ( str + " " + checkPalindrome(str) );

	// Not a palindrome, but a palingram:
        str = "He was, was he?";
        System.out.println ( str + " " + checkPalindrome(str) );
    }
    

    static String checkPalindrome (String str)
    {
        //Extract the letters.
        char[] letters = str.toCharArray();

        //Create an empty stack. 
        Stack<Character> stack = new Stack<Character>();

        //The letters must "balance" up to the middle. 
        int mid = letters.length / 2;

        //Push the first half. 
        
        for(int i = 0; i < mid; i++)
        {
            if(Character.isLetter(i))
            {
                stack.push(letters[i]);
            }
        }

        //Odd or even? We have to adjust the mid-point accordingly. 
        if(letters.length % 2 > 0)
        {
            //Odd number => swallow middle letter. 
            mid = mid+1;
        }

        //Now check the second half.
        for(int i = mid; i < letters.length; i++)
        {
            if(! stack.isEmpty())
            {
                char ch = stack.pop();
                if(ch != letters[i])
                {
                    //Mismatch => not a palindrome. 
                    return "it is not a palindrome";
                }
            }
        }

        return "it is a palindrome";

    }

}