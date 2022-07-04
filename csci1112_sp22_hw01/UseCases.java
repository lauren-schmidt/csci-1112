/*------------------------------------------------------------------------
 GWU CSCI1112 Spring 2022
 author: Charles Peeke, James Taylor
 
This program is a demo program for the WordMultiples class and illustrates
expected standard usage.
-------------------------------------------------------------------------*/

class UseCases {

    /// The main method acts as a 'driver' for the funtions. 
    /// Intialize variables here and call functions that run the program.
    public static void main(String[] args) {
        int[] multiples;
        String letters;
        int count;

        letters = "A";
        count = 5;
        multiples = WordMultiples.findMultiples(letters, count);
        WordMultiples.display(letters, multiples);

        System.out.println();

        letters = "Apple";
        count = 3;
        multiples = WordMultiples.findMultiples(letters, count);
        WordMultiples.display(letters, multiples);
    }
}
