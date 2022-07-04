
public class Palindrome2 {

    public static void main (String[] argv)
    {
        String str = "redder";
        char[] letters = str.toCharArray();
        System.out.println ( str + " " + checkPalindrome(letters,0,letters.length-1) );

        str = "river";
        letters = str.toCharArray();
        System.out.println ( str + " " + checkPalindrome(letters,0,letters.length-1) );

        str = "neveroddoreven";
        letters = str.toCharArray();
        System.out.println ( str + " " + checkPalindrome(letters,0,letters.length-1) );
    }
    

    static String checkPalindrome (char[] A, int first, int last)
    {
        //Two bottom-out cases: 
        if((last-first == 0) || (last-first == 1))
        {
            return "is a palindrome";
        }


        if(A[first] != A[last])
        {
            return "is not a palindrome";
        }

        //Adjust the first and last values being checked to "remove" the first/last chars 
        //Essentially adjust your search window 
        int nextFirst = first + 1;
        int nextLast = last - 1; 

        //Recursive call to checkPalindrome
        return checkPalindrome(A, nextFirst, nextLast);

    }

}