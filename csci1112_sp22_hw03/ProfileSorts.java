/*--------------------------------------------------------------------------
GWU CSCI 1112 Fall 2021
author: Charles Peeke, James Taylor

This program reports profile information for the sorts used by the 
ClassSchedule class using a variety of data sets
--------------------------------------------------------------------------*/
public class ProfileSorts {
    // The master list of schedules
    public static int[][] schedules100;
    public static int[][] schedules1k;
    public static int[][] schedules10k;

    // The referential views of schedules generated by different sorts
    public static String[][] viewSelection;    // generated by selection sort
    public static String[][] viewBubble;       // generated by bubble sort
    public static String[][] viewInsertion;    // generated by insertion sort
    public static String[][] viewQuicksort;    // generated by quicksort

    // The profiling data gathered during a sort
    public static int[] profileSelection;   // profile from selection sort
    public static int[] profileBubble;      // profile from bubble sort
    public static int[] profileInsertion;   // profile from insertion sort
    public static int[] profileQuicksort;   // profile from quicksort

    public static void main(String args[]) {

        profile( ScheduleReader.getSchedule("classes.csv"), "100 Classes" );
        System.out.println();
        /*
        for (int i = 0; i < viewSelection.length; i++) {
            System.out.println(viewSelection[i][2]);
        }
        */

        profile( ScheduleReader.getSchedule("classes1k.csv"), "1000 Classes" );
        System.out.println();

        profile( ScheduleReader.getSchedule("classes10k.csv"), "10000 Classes" );
        System.out.println();
    }

    /// Generates the profiles for all sorts given a set of schedule data
    /// @param schedules The dataset to profile against
    /// @param label The label to drop into the report for this set of
    ///        profiles
    public static void profile( String[][] schedules, String label ) {
        System.out.println(label);
        viewSelection = ClassSchedule.createView(schedules);
        viewBubble = ClassSchedule.createView(schedules);
        viewInsertion = ClassSchedule.createView(schedules);
        viewQuicksort = ClassSchedule.createView(schedules);

        profileSelection = ClassSchedule.sortSelection(viewSelection);
        profileBubble = ClassSchedule.sortBubble(viewBubble);
        profileInsertion = ClassSchedule.sortInsertion(viewInsertion);

        profileQuicksort = ClassSchedule.sortQuicksort(viewQuicksort);

        reportProfiles();
    }

    /// Reports profile information returned by sorts to the console
    public static void reportProfiles() {
        reportProfile(profileSelection, "profileSelection");
        reportProfile(profileBubble, "profileBubble");
        reportProfile(profileInsertion, "profileInsertion");
        reportProfile(profileQuicksort, "profileQuicksort");
    }

    /// Reports the profile information by printing to the standard out
    /// @param profile The profile information to report.  It must be of 
    ///        the form [allocs, compares, swaps]
    /// @param label The label to drop into the report for this profile
    public static void reportProfile(int[] profile, String label) {
        String s;

        if( profile == null ) {
            System.out.println("ERROR: " + label + " is null");
            return;
        }
        if( profile.length != 3 ) {
            System.out.println("ERROR: " + label + " has an unexpected shape");
            return;
        }
        s = label + "::allocs:" + profile[0];
        s += ", compares:" + profile[1];
        s += ", swaps:" + profile[2];
        System.out.println(s);
    }
}
