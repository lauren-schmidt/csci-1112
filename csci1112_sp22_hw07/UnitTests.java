/*--------------------------------------------------------------------------
GWU CSCI 1112 Spring 2022
author: James Taylor

A suite of unit tests that validate the methods and behaviors for 
map implementations
--------------------------------------------------------------------------*/

public class UnitTests {
    static String[][] mapdata;

    public static void main(String[] args) {

        mapdata = MapReader.getData("mapdata");

        validateMap(new TreeMap(true), "BINARY TREE as MAP");
        System.out.println();
        validateMap(new HashMap(100), "HASH TABLE as MAP");
        System.out.println();
    }

    /// Validates a map type using a battery of tests.  Report is generated
    /// via text output.
    /// @param map the map to validate
    /// @return pfx a text prefix to annotate the tests
    public static void validateMap(Map map, String pfx) {
        int passes = 0;
        int fails = 0;
        boolean result;
        String value;

        System.out.println(pfx);

        // subtest 1 - basic interactions
        value = map.get(mapdata[mapdata.length-1][0], new int[1]);
        if( value != null ) {
            fails++;
            System.out.println("::TEST 1::FAILED");
        } else {
            passes++;
        }

        map.set(mapdata[0][0], mapdata[0][1], new int[1]);
        value = map.get(mapdata[0][0], new int[1]);
        if( value == null || value != mapdata[0][1] ) {
            fails++;
            System.out.println("::TEST 2::FAILED.");
        } else {
            passes++;
        }
        value = map.get(mapdata[mapdata.length-1][0], new int[1]);
        if( value != null ) {
            fails++;
            System.out.println("::TEST 3::FAILED.");
        } else {
            passes++;
        }

        // subtest 2 - multiple items
        map.set(mapdata[1][0], mapdata[1][1], new int[1]);
        map.set(mapdata[2][0], mapdata[2][1], new int[1]);
        value = map.get(mapdata[0][0], new int[1]);
        if( value == null || value != mapdata[0][1] ) {
            fails++;
            System.out.println("::TEST 4::FAILED.");
        } else {
            passes++;
        }
        value = map.get(mapdata[mapdata.length-1][0], new int[1]);
        if( value != null ) {
            fails++;
            System.out.println("::TEST 5::FAILED.");
        } else {
            passes++;
        }

        value = map.get(mapdata[1][0], new int[1]);
        if( value == null || value != mapdata[1][1] ) {
            fails++;
            System.out.println("::TEST 6::FAILED.");
        } else {
            passes++;
        }
        value = map.get(mapdata[2][0], new int[1]);
        if( value == null || value != mapdata[2][1] ) {
            fails++;
            System.out.println("::TEST 7::FAILED.");
        } else {
            passes++;
        }
        map.clear();
        value = map.get(mapdata[0][0], new int[1]);
        if( value != null ) {
            fails++;
            System.out.println("::TEST 8::FAILED.");
        } else {
            passes++;
        }
        value = map.get(mapdata[mapdata.length-1][0], new int[1]);
        if( value != null ) {
            fails++;
            System.out.println("::TEST 9::FAILED.");
        } else {
            passes++;
        }

        map.set(mapdata[0][0], mapdata[0][1], new int[1]);
        map.set(mapdata[1][0], mapdata[1][1], new int[1]);
        map.set(mapdata[2][0], mapdata[2][1], new int[1]);
        value = map.get(mapdata[0][0], new int[1]);
        if( value == null || value != mapdata[0][1] ) {
            fails++;
            System.out.println("::TEST 10::FAILED.");
        } else {
            passes++;
        }
        value = map.get(mapdata[mapdata.length-1][0], new int[1]);
        if( value != null ) {
            fails++;
            System.out.println("::TEST 11::FAILED.");
        } else {
            passes++;
        }


        // subtest 3 - large data sets
        map.clear();
        buildMap( map, new int[1] );

        result = validateAllExistingKeys( map );
        if( !result ) {
            fails++;
            System.out.println("::TEST 12::FAILED: unable to locate all keys for the large data set.");
        } else {
            passes++;
        }

        result = validateNonexistentKeys( map );
        if( !result ) {
            fails++;
            System.out.println("::TEST 13::FAILED: matched a key in the large data set that should not exist.");
        } else {
            passes++;
        }

        // report summary
        if( fails > 0 ) {
            System.out.print( "OVERALL : FAILED " );
        } else {
            System.out.print( "OVERALL : PASS " );
        }
        System.out.println("[passes=" + passes + ", fails=" + fails + "]");

    }

    /// inserts all the kvp data in the mapdata global into the designated
    /// map.
    /// @param map the map to insert data into
    /// @param profile the profile array in which to store comparisons
    public static void buildMap( Map map, int[] profile ) {
        for(int i = 0; i < mapdata.length; i++ ) {
            map.set(mapdata[i][0], mapdata[i][1], profile);
        }
    }

    /// validates a map containing all the information in mapdata
    /// @param map the map to validate
    /// @return true if all of the mapdata can be retrieved from the map;
    ///         otherwise, false
    public static boolean validateAllExistingKeys( Map map ) {
        for( int i = 0; i < mapdata.length; i++ ) {
            String key = mapdata[i][0];
            String value = map.get(key, new int[1]);

            if( value == null ) {
                return false;
            }

            if( value != mapdata[i][1] ) {
                return false;
            }
        }
        return true;
    }

    /// validates a map does not return values for invalid keys
    /// @param map the map to validate
    /// @return true the map never returns a value for a random sequence
    ///         of characters; otherwise, false
    public static boolean validateNonexistentKeys( Map map ) {
        for( int i = 0; i < mapdata.length; i++ ) {
            String key = Utilities.randomString( mapdata[i][0].length() );
            String value = map.get(key, new int[1]);

            if( value != null ) {
                return false;
            }
        }
        return true;
    }
}

