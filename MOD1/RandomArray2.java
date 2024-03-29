public class RandomArray2 {

    public static void main (String[] argv)
    {
        double p = estimateSortedProb (5, 100000);
        System.out.println ("Probability an array of length 5 is sorted: " + p);
    }
    

    static double estimateSortedProb (int arraySize, int numTrials) 
    {
        //Count the number of sorted arrays generated. 
        int numSorted = 0;

        //Repeat for given number of experiments 
        for (int n=0; n < numTrials; n++) {

            //Generate a random array. 
            int[] randomInts = new int [arraySize];
            for (int i=0; i <  randomInts.length; i++) {
                randomInts[i] = UniformRandom.uniform (1, 100);
            }
            
            //See if sorted. 
            boolean isSorted = true;
            for (int i=1; i < randomInts.length; i++) {
                if (randomInts[i] <  randomInts[i-1]) {
                    isSorted = false;
                }
            }
            if (isSorted) {
                numSorted ++;
            }

	    //See if sorted in DECREASING ORDER 
	    for(int j = 1; j < randomInts.length; j++)
	    {	
		    //Makes sure that there is no IndexOutOfBounds error 
		    if((j+1) < randomInts.length)
		    {
			    //Checks for the opposite condition of the increasing checker
			    if(randomInts[j+1] > randomInts[j])
			    {	
				    isSorted = false;
			    }
			    if (isSorted) {
				    numSorted++;
			    }
		    }
	    }

	} //end-for-numTrials 

	//The fraction of trials that resulted in a sorted array:  
        double prob = (double) numSorted / (double) numTrials;

        return prob;
    }


}

