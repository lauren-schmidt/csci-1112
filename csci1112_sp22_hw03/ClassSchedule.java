/*--------------------------------------------------------------------------
GWU CSCI 1112 Fall 2021
author: <laurenschmidt>

This class encapsulates the logic to model ranking in a simple social 
network simulation
--------------------------------------------------------------------------*/

public class ClassSchedule {
    /// Performs a deep copy of the input schedule and returns the deep copy.
    /// This operation might be used to make a permanent backup of the data
    /// as it would make a unique and unlinked copy of the data.
    /// @param schedule the schedule array to copy
    /// @return the deep copy of the schedule array that were copied
    public static String[][] clone(String[][] schedule) {

        //Create a an array to store the copy and return, and set to be the same 
        //size as the original array
        String[][] copy = new String[schedule.length][schedule[0].length];
        
        //Iterate through each row and column and assign schedule to copy, creating 
        //a deep copy
        for(int i = 0; i < schedule.length; i++)
        {
            for(int j = 0; j < schedule[i].length; j++)
            {
                copy[i][j] = schedule[i][j];
            }
        }

        return copy; 
    }

    /// A referential copy (shallow copy of each row) and not an 
    /// element-wise copy (deep copy).  We are sorting elements with respect
    /// to the original data rather than generating a new set of data.
    /// @param schedule data containing the rows to reference
    /// @return an array containing a shallow copy of the input schedule 
    ///         rows
    public static String[][] createView(String[][] schedule) {
        
        //Create an array to store the copy and return. Set it to store a shallow copy of schedule. 
        String [][] copy = new String[schedule.length][];

        for(int i = 0; i < schedule.length; i++)
        {
            copy[i] = schedule[i];
        } 

        return copy;
    }
 
    //--------------------------------------------------------------------- 
    /// Compute the differential between start time (index 3) and end time 
    /// (index 4). The differential is not maintained in the data but is
    /// a virtual field derived by the calculation performed here
    /// @param classInfo a record from the scheduling data
    /// @return the difference in time between the end time and start time
    ///         in minutes
    public static int differential(String[] classInfo) {
        
        //Allocate an integer space in the method to store the value of difference. 
        int diff = 0;

        //Use duration method to find start and end times 
        int startTime = duration(classInfo[3]);
        int endTime = duration(classInfo[4]);

        //Calculate the difference 
        diff = endTime - startTime; 


        return diff;
    }

    //--------------------------------------------------------------------- 
    /// This utility function converts a time string from the "HH:mm:ss" 
    /// format into a value representing minutes
    /// @param time a string representing a time in "HH"mm:ss" format
    /// @return an integer representing the time converted to minutes
    private static int duration(String time) {
        String[] tokens = time.split(":");
        int h = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        int t = h * 60 + m;
        return t;
    }

    //--------------------------------------------------------------------- 
    /// Performs a comparison between two classes that is equivalent to a 
    /// less than operation so that a sort can use this function to order 
    /// classes. The less than criteria is an evaluation between the 
    /// differentials of two classes.
    /// @param class1 a class record that is used as the "left" operand for
    ///        a less than comparison 
    /// @param class2 a class record that is used as the "right" operand for
    ///        a less than comparison 
    /// @return returns true if the computed differential for class1 is less
    ///         than the computed differential for class2; otherwise, 
    ///         returns false (false implies that differential for class1 is
    ///         greater than or equal to class2)
    public static boolean lessThan(String[] class1, String[] class2) {
    
        //Create two integers to compare differential values 
        int class1Diff = differential(class1);
        int class2Diff = differential(class2);

        //Compare the values and return a boolean accordingly. 
        if(class1Diff >= class2Diff)
        {
            return false;
        }
        return true;
    }
    //--------------------------------------------------------------------- 
    /// Swaps references to classes.  Note that this is a "shallow" swap and
    /// not a "deep" swap meaning we swap at a reference level (between rows
    /// in view) and not at the value level
    /// @param view A shallow copy of a set of classes 
    /// @param i the index of the first reference to swap
    /// @param j the index of the second reference to swap
    public static void swapClasses(String[][] view, int i, int j) {
        String[] temp = view[i];
        view[i] = view[j];
        view[j] = temp;

    }

    //--------------------------------------------------------------------- 
    /// Sorts (shallow) a set of references to classes in descending order 
    /// subject to the differential between ups and downs using selection 
    /// sort
    /// @param view A shallow copy of a set of classes 
    /// @return an array of profile information of 3 buckets with the 
    ///         respective buckets containing a count of 0: allocations, 
    ///         1:comparisons, and 2: swaps
    public static int[] sortSelection(String[][] view) {

        // profile[0:allocs (ignore profile), 1:comparisons, 2:swaps]
        int[] profile = new int[3];
        
        //Add to profile because we will allocate space for both largest and pos, but cannot
        //include this counter in the for loop. 
        profile[0] ++; 
        profile[0] ++; 

        //Add allocation for temp in swapClasses 
        profile[0]++; 
       
       
       //Going row by row in the array:
       for(int i = 0; i < view.length - 1; i++)
       {
           // Assume the largest value is i 
           String[] largest = view[i]; 
           int pos = i;

           
           //Search to find the largest value 
           for(int j = i+1; j < view.length; j++)
           {
               profile[1]++; 
               if(lessThan(largest, view[j]))
               {
                   largest = view[j];
                   pos = j;
               }

           }
           
           //Swap accordingly 
           swapClasses(view, i, pos);
           profile[2]++; 

       }


        

        return profile;
    }

    //--------------------------------------------------------------------- 
    /// Sorts (shallow) a set of references to classes in descending order 
    /// subject to the differential between ups and downs using bubble 
    /// sort
    /// @param view A shallow copy of a set of classes 
    /// @return an array of profile information of 3 buckets with the 
    ///         respective buckets containing a count of 0: allocations, 
    ///         1:comparisons, and 2: swaps
    public static int[] sortBubble(String[][] view) {

        // profile[0:allocs (ignore profile), 1:comparisons, 2:swaps]
        int[] profile = new int[3];

        //Add allocations for variables i and j 
        profile[0]++;
        profile[0]++; 

        //Add allocation for temp in swapClasses 
        profile[0]++; 

        for(int i = 0; i < view.length-1; i++)
        {
            for(int j = view.length-1; j > i; j--)
            {
                profile[1]++;
                if(lessThan(view[j-1], view[j]))
                {
                    swapClasses(view, j, j-1);
                    profile[2]++;
                }
            }
        }

        return profile;
    }

    //--------------------------------------------------------------------- 
    /// Sorts (shallow) a set of references to classes in descending order 
    /// subject to the differential between ups and downs using insertion 
    /// sort
    /// @param view A shallow copy of a set of classes 
    /// @return an array of profile information of 3 buckets with the 
    ///         respective buckets containing a count of 0: allocations, 
    ///         1:comparisons, and 2: swaps
    public static int[] sortInsertion(String[][] view) {

        // profile[0:allocs (ignore profile), 1:comparisons, 2:swaps]
        int[] profile = new int[3];

        //Count the allocation of int i and int j.  
        profile[0]++;
        profile[0]++; 

        //Add allocation for temp in swapClasses 
        profile[0]++; 

        for(int i = 0; i < view.length; i++)
        {
            //Find the right place for view[i]
            int j = i; 

            while((j > 0) && lessThan(view[j-1], view[j]))
            {
                profile[1]++;
                swapClasses(view, j, j-1);
                profile[2]++; 
                j--;
            }
        }

        return profile;
    }

    //--------------------------------------------------------------------- 
    /// Sorts (shallow) a set of references to classes in descending order 
    /// subject to the differential between ups and downs using a quicksort.
    /// @param view A shallow copy of a set of classes 
    /// @return an array of profile information of 3 buckets with the 
    ///         respective buckets containing a count of 0: allocations, 
    ///         1:comparisons, and 2: swaps
    public static int[] sortQuicksort(String[][] view) {

        // profile[0:allocs (ignore profile), 1:comparisons, 2:swaps]
        int[] profile = new int[3];

        quickSortRecursive(view, 0, view.length-1, profile);

        return profile;
    }

    static void quickSortRecursive(String[][] data, int left, int right, int[] prof)
        {
            prof[1]++; 
            if(left < right)
            {
                //Partition to find the "right place" for the leftmost element. 
                int partitionPos = quickSortPartition(data, left, right, prof);
                prof[0]++;
                
                //Recurse on the left side: 
                quickSortRecursive(data, left, partitionPos-1, prof);
                
                //Recurse on the right side: 
                quickSortRecursive(data, partitionPos+1, right, prof);

                
            }
            //Else: Left == right so we're done. 
        }

    static int quickSortPartition (String[][] data, int left, int right, int[] prof)
    {
        prof[1]++;
        if(left == right)
        {
            return left; 
        }
        String[] partitionElement = data[right];
        prof[0]++;
        int currentSwapPos = right; 
        prof[0]++;
        prof[0]++; 
        for(int i = right-1; i >= left; i--)
        {
            //Examine everything between left and right -1 inclusive 
            prof[1]++;
            if(lessThan(data[i], partitionElement))
            {
                //Switch with swap position 
                currentSwapPos--;
                swapClasses(data, i, currentSwapPos);
                prof[0]++; // Allocation in swapClasses 
                prof[2]++;
                //Shift swap position rightwards: 
            }
        }
        swapClasses(data, right, currentSwapPos);
        prof[2]++;
        prof[0]++; //Allocation in swapClasses 
        return currentSwapPos;
    }


}
