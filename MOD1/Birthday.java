
public class Birthday {

    public static void main (String[] argv)
    {
        double p = birthdayProblem (25);
        System.out.println ("Prob[shared bday with 25 people] = " + p);
    }


    static double birthdayProblem (int numPeople)
    {
        // Number of times to repeatedly create a random group of people:
        int numTrials = 10000;

        // We'll need to count how often we get a shared b'day.
        int numTrialSuccesses = 0;

        // Repeat and count.
        for (int n=0; n<numTrials; n++) {

            // Generate birthdays (random array)
            int[] birthdays = new int [numPeople];
            for (int i=0; i<birthdays.length; i++) {
                birthdays[i] = UniformRandom.uniform (1, 365);
            }

            // Check if any two match.
            boolean matchExists = false;
            for (int i=0; i<birthdays.length; i++) {
                for (int j=0; j<birthdays.length; j++) {
                    if ( (i != j) && (birthdays[i] == birthdays[j]) ) {
                        // Note: musn't forget the i!=j test above!
                        matchExists = true;
                    }
                }
            }
            
            if (matchExists) {
                numTrialSuccesses ++;
            }
            
        } //end-for-trials
        
        double prob = (double) numTrialSuccesses / (double) numTrials;
        return prob;
    }
    
}
