public class SimpleSearchFunction {

    public static void main (String[] argv)
    {
        // Fill an array with some random values - for testing.
        int[] testData = {51, 24, 63, 73, 42, 85, 71, 41, 87, 32};

        // Create a test value to search for.
        int searchTerm = 32;
        
        boolean found = search (testData, searchTerm);

        // Print result.
        System.out.println ("found = " + found);
    }


    static boolean search (int[] A, int value)
    {
        for (int i=0; i < A.length; i++) {
            if (A[i] == value) {
                return true;
            }
        }
        return false;
    }

}