public class SimpleSearchMain {

    public static void main (String[] argv)
    {
        // Fill an array with some random values - for testing
        int[] testData = {51, 24, 63, 73, 42, 85, 71, 41, 87, 32};

        // Create a test value to search for
        int searchTerm = 32;
        
        boolean found = false;

        for (int i=0; i < testData.length; i++) {
            if (testData[i] == searchTerm) {
                found = true;
            }
        }

        // Print result
        System.out.println ("found = " + found);
    }
}