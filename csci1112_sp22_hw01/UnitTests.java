/*------------------------------------------------------------------------
 GWU CSCI1112 Spring 2022
 author: Charles Peeke, James Taylor
 
This class validates the methods in the WordMultiples class to ensure that
they correctly operate within expected conditions.
-------------------------------------------------------------------------*/

class UnitTests {

    /// The main method acts as a 'driver' for the program.  It is what we
    /// will call a "test harness" where all unit tests will be plugged in 
    public static void main(String[] args) {
        boolean failed = false;
        boolean result;
       
        System.out.println( "BEGIN :: block1 UnitTests" );
        result = block1(); 
        if( !result ) {
            failed = true;
        }
        System.out.println( "END :: block1 UnitTests\n" );

        System.out.println( "BEGIN :: block2 UnitTests" );
        result = block2(); 
        if( !result ) {
            failed = true;
        }
        System.out.println( "END :: block2 UnitTests\n" );

        System.out.println( "BEGIN :: block3 UnitTests" );
        result = block3(); 
        if( !result ) {
            failed = true;
        }
        System.out.println( "END :: block3 UnitTests\n" );


        if( failed ) {
            System.out.println( "FAILED :: Unit testing" );
        } else {
            System.out.println( "PASSED :: Unit testing" );
        }
    }

    //---------------------------------------------------------------------
    //---------------------------------------------------------------------
    /// This block of unit tests validates the behavior of 
    /// WordMultiples.calculate method.  It focuses on validating explicitly
    /// defined standard behaviors.  Testing for non-standard behaviors
    /// are carried out in block3
    /// @return true if all unittests in this block successfully pass;
    ///         otherwise, return false if any unittest fails.
    public static boolean block1() {
        boolean failed = false;
        boolean result;

        result = block1UnitTest1();
        if( !result ) {
            System.out.println( "block1UnitTest1() :: FAILED" );
            failed = true;
        } else {
            System.out.println( "block1UnitTest1() :: PASSED" );
        }

        result = block1UnitTest2();
        if( !result ) {
            System.out.println( "block1UnitTest2() :: FAILED" );
            failed = true;
        } else {
            System.out.println( "block1UnitTest2() :: PASSED" );
        }

        return !failed;
    }

    //---------------------------------------------------------------------
    // This unit test validates that WordMultiples.calculate computes the
    // correct total for a simple string of one character.
    /// @return true if the test succeeds and the class is performing
    ///         as expected; otherwise, false indicating test failure
    public static boolean block1UnitTest1() {
        String letters = "A";

        // call the function we are testing with a specifically defined
        // parameter for which we know the expected output
        int value = WordMultiples.calculate(letters);

        // validate that the result returned from the function matches the
        // expected value.  Note that the logic here is reversed to trigger
        // the branch if the value is not the expected value
        if( value != 65 ) {
            // the structure is because our test is designed to try falsify
            // the case.  We provided a specific parameter and we fail if
            // we do not get the expected value
            return false;
        }
        
        // If we did not fail, assume we succeeded.
        return true;

        // Why is the test structured this way?  It is near impossible to 
        // prove something to be true but it is trivial to proove that 
        // something is false.  Why?  To prove something is false, we only
        // have to find one case that violates theory.  To prove something
        // is true, we may have to prove an infinite number of cases.
    }

    //---------------------------------------------------------------------
    // This unit test validates that WordMultiples.calculate computes the
    // correct total for a string of multiple characters
    /// @return true if the test succeeds and the class is performing
    ///         as expected; otherwise, false indicating test failure
    public static boolean block1UnitTest2() {
        String letters = "ABC";
        int value = WordMultiples.calculate(letters);

        // It follows from the reasoning above that
        // A = 65 + B = 66 + C = 67 => 198.  If this is not true, then
        // calculate must have a problem in it
        if( value != 198 ) {
            return false;
        }
        
        // Otherwise value could only have been 198.  This line is only
        // reachable if our hypothesis holds and the behavior is valid
        // So this test passes.
        return true;
    }

    //---------------------------------------------------------------------
    //---------------------------------------------------------------------
    /// This block of unit tests validates the behavior of 
    /// WordMultiples.findMultiples method.  It focuses on validating 
    /// explicitly defined standard behaviors.  Testing for non-standard 
    /// behaviors are carried out in block3
    /// @return true if all unittests in this block successfully pass;
    ///         otherwise, return false if any unittest fails.
    public static boolean block2() {
        boolean failed = false;
        boolean result;

        result = block2UnitTest1();
        if( !result ) {
            System.out.println( "block2UnitTest1() :: FAILED" );
            failed = true;
        } else {
            System.out.println( "block2UnitTest1() :: PASSED" );
        }

        result = block2UnitTest2();
        if( !result ) {
            System.out.println( "block2UnitTest2() :: FAILED" );
            failed = true;
        } else {
            System.out.println( "block2UnitTest2() :: PASSED" );
        }

        result = block2UnitTest3();
        if( !result ) {
            System.out.println( "block2UnitTest3() :: FAILED" );
            failed = true;
        } else {
            System.out.println( "block2UnitTest3() :: PASSED" );
        }

        return !failed;
    }

    //---------------------------------------------------------------------
    /// This method attempts to validate the logic of 
    /// WordMultiples.findMultiples by testing a specific example
    /// and comparing the results to the expected results from the example
    /// @return true if the test succeeds and the class is performing
    ///         as expected; otherwise, false indicating test failure
    public static boolean block2UnitTest1() {
        String letters = "A";
        int count = 1;
        int[] multiples = WordMultiples.findMultiples(letters, count);

        // Unit tests do not have to be atomic.  Instead, they can test a 
        // number of conditions.  Basically, lets try a number of potential
        // scenarios that if false would prove the function is not correct

        // Try to prove that the length is not what was expected
        if( multiples.length != count ) {
            return false;
        }

        // Try to prove that the array does not contain the expected results
        if( multiples[0] != 65 ) {
            return false;
        }
        
        // Failed to disprove, so assume that this test is successful and 
        // program logic is valid
        return true;
    }

    //---------------------------------------------------------------------
    /// Now that we have performed the most basic validation, we can perform
    /// a more complex validation.  Here we will test the addition component
    /// of the WordMultiples.findMultiples method.
    /// @return true if the test succeeds and the class is performing
    ///         as expected; otherwise, false indicating test failure
    public static boolean block2UnitTest2() {
        int count = 1;
        int[] multiples = WordMultiples.findMultiples( "ABC", count);

        // This is a sanity check meaning it is here to make sure a
        // valid reference was returned by findMultiples.  If an invalid
        // reference is returned than we can't access properties or methods
        // associated with the object
        if( multiples == null ) {
            return false;
        }

        // Again, another sanity check for the same reasons we performed
        // the above test.
        if( multiples.length != count ) {
            return false;
        }

        // This is where we explicitly check the result as we know we have
        // received back an array of the right size, we can now check the
        // content of it.  If the content is not correct, then we fail
        if( multiples[0] != 198 ) {
            return false;
        }

        // Otherwise, the test succeeds and the program logic is valid.
        return true;
    }

    //---------------------------------------------------------------------
    /// Now that we have validated the addition component of the 
    /// WordMultiples.findMultiples method, we can validate that it responds
    /// correctly to the count parameter
    /// @return true if the test succeeds and the class is performing
    ///         as expected; otherwise, false indicating test failure
    public static boolean block2UnitTest3() {
        int count = 3;
        int[] multiples = WordMultiples.findMultiples( "ABC", count);

        // Again, perform both sanity checks
        if( multiples == null ) {
            return false;
        }
        if( multiples.length != count ) {
            return false;
        }

        // Explicitly check all the results
        if( multiples[0] != 198 || multiples[1] != 396 || multiples[2] != 594 ) {
            return false;
        }

        // Otherwise, the test succeeds and the program logic is valid.
        return true;
    }

    //---------------------------------------------------------------------
    //---------------------------------------------------------------------
    /// This block of unit tests validates the behavior of 
    /// non-standard behaviors of methods in the WordMultiples class.
    /// Specifically, it tests for conditions like invalid inputs sent into
    /// these methods and validates that when these failure cases arise,
    /// that the expected return values are produced.
    /// This block is likely to generate exceptions since it is 
    /// intentionally sending invalid inputs into methods and is intends
    /// to force you to guard against invalid inputs.
    /// @return true if all unittests in this block successfully pass;
    ///         otherwise, return false if any unittest fails.
    public static boolean block3() {
        boolean failed = false;
        boolean result;

        result = block3UnitTest1();
        if( !result ) {
            System.out.println( "block3UnitTest1() :: FAILED" );
            failed = true;
        } else {
            System.out.println( "block3UnitTest1() :: PASSED" );
        }

        result = block3UnitTest2();
        if( !result ) {
            System.out.println( "block3UnitTest2() :: FAILED" );
            failed = true;
        } else {
            System.out.println( "block3UnitTest2() :: PASSED" );
        }

        result = block3UnitTest3();
        if( !result ) {
            System.out.println( "block3UnitTest3() :: FAILED" );
            failed = true;
        } else {
            System.out.println( "block3UnitTest3() :: PASSED" );
        }

        return !failed;
    }



    //-------------------------------------------------------------------
    /// When the input to WordMultiples.calculate is null,
    /// WordMultiples.calculate can't do anything.  It has to return
    /// something, so by returning null (an invalid array) it signals to
    /// the rest of the program that its data is invalid.  This will
    /// hopefully guard against the possibility of a null pointer exception
    /// INSIDE WordMultiples.calculate.
    /// @return true if the test succeeds and the class is performing
    ///         as expected; otherwise, false indicating test failure
    public static boolean block3UnitTest1() {
        int value = WordMultiples.calculate(null);

        if( value != 0 ) {
            return false;
        }

        return true;
    }

    //-------------------------------------------------------------------
    /// While the earlier unitTests focus on correct operation given valid 
    /// inputs, this unit test is a little more basic and attempts to
    /// validate a case where WordMultiples.findMultiples fails.  
    /// Specifically, this test validates that WordMultiples.findMultiples
    /// fails when the reference to the array is a null reference.
    /// Afterall, we can't do anything if the array provided is invalid.
    /// @return true if the test succeeds and the class is performing
    ///         as expected; otherwise, false indicating test failure
    public static boolean block3UnitTest2() {
        int count = 1;
        int[] multiples = WordMultiples.findMultiples(null, count);

        // If multiples is anything but null, the test fails
        if( multiples != null ) {
            return false;
        }

        // Otherwise, the test succeeds and the program logic is valid.
        return true;

        // When the input to WordMultiples.findMultiples is null,
        // WordMultiples.findMultiples can't do anything.  It has to return
        // something, so by returning null (an invalid array) it signals to
        // the rest of the program that its data is invalid
    }

    /// Similarly, this test validates that WordMultiples.findMultiples
    /// fails when the number of multiples is specified to be an invalid
    /// number, i.e. negative.  Note that zero would be fine as we can
    /// allocate a zero length array.
    /// @return true if the test succeeds and the class is performing
    ///         as expected; otherwise, false indicating test failure
    public static boolean block3UnitTest3() {
        String letters = "A";
        int count = -1;
        int[] multiples = WordMultiples.findMultiples(letters, count);

        // If multiples is anything but null, the test fails
        if( multiples != null ) {
            return false;
        }

        // This second half, validates that a zero length array is fine.
        // It might be more appropriate to have this in it's own unit test,
        // but sometimes a unit test can validate multiple things.

        count = 0;
        multiples = WordMultiples.findMultiples(letters, count);

        if( multiples.length != count ) {
            return false;
        }

        // Otherwise, the test succeeds and the program logic is valid.
        return true;
    }
    
}

