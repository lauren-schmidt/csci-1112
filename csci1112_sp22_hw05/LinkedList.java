/*--------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Spring 2022

This file implements a linked-list based music catalog. It includes methods
to organize and manage the music catalog, and those methods are outlined in 
the MusicCatalog. 

authors: Lauren Schmidt, Charles Peeke
--------------------------------------------------------------------------*/
public class LinkedList implements MusicCatalog {

    /// For a linked-list based list, the head pointer
    private CatalogItem head;
    /// The counter to track the number of elements in the list 
    private int count;

    // Parameterless Constructor
    public LinkedList() {
        count = 0;
        head = null;
    }
    
    /// Adds a song to the end of the current music
    /// catalog. 
    ///
    /// @param the Song object to be added 
    /// @return void
    public void add(Song song) 
    {
        //If there are no songs in the catalog: 
        if(head == null)
        {
            head = new CatalogItem(song);
            count = 1; 
        }
        //Otherwise (adding to the end of the catalog):
        else
        {
            CatalogItem newSong = new CatalogItem(song);
            CatalogItem ptrSong = head;
            while(ptrSong.next != null)
            {
                ptrSong = ptrSong.next; 
            }
            ptrSong.next = newSong;
            count++;
        }
    }

    /// Removes the first element of the catalog.
    ///
    /// @return The removed Song object 
    public Song remove() 
    {
        //Check to see if the playlist is empty or only contains one element. 
        if(head == null || head.next == null)
        {
            count = 0; 
            head = null;
            return null;
        }


        //Otherwise, remove the first element. 
        head = head.next; 

        //Decrement counter variable 
        count--; 


        return head.getSong(); 

    }

    /// Removes the first occurence of the song
    /// specified in the parameter in the 
    /// music catalog. 
    /// @param the Song object to be removed 
    /// @return the removed song, and null if the song does not exist in the list. 
    public Song remove(Song song) 
    {
        if(head == null)
        {
            return null;
        }

        CatalogItem ptrSong = head;
        CatalogItem prevSong = head;

        while(ptrSong.getSong() != song)
        {
            prevSong = ptrSong;
            ptrSong = ptrSong.next;
        }

        prevSong = ptrSong.next;
        return prevSong.getSong();
    }

    
    /// Clears the catalog of all songs. 
    public void clear()
    { 
        if(head == null)
        {
            return; 
        }

        head = null;
        count = 0;
 
    }
    
    /// Checks to see if the current music catalog is 
    /// empty. 
    /// 
    /// @return true if the catalog is empty, and false if it is not. 
    public boolean isEmpty() {
        int songCounter = 0;
        // TODO : Implement this function
        if(head == null)
        {
            return true;
        }
        CatalogItem ptrSong = head;
        while(ptrSong != null)
        {
            ptrSong = ptrSong.next;
            songCounter++;
        }
        if(songCounter == 0)
        {
            return true; 
        }
        return false; 
    }
    
    /// Counts the number of elements stored in the catalog. 
    ///
    /// @return the number of elements in the catalog. 
    public int count() {
    if(count >= 0)
    {
        return count;
    }
    return 0;
    }
    
    /// Returns the song at the specified index if that song exists in
    /// the list, otherwise returns null. 
    /// @param The index we are searching for
    /// @return The song at the specified index, and null if the parameter is 
    /// invalid or the song does not exist in the list. 
    public Song get(int i) {

        if(head == null || i < 0)
        {
            return null; 
        }

        if(head.next == null && i == 0)
        {
            return head.getSong();
        }

        int counter = 0;
        while(head != null && counter != i)
        {
            head = head.next;
            i++;
        }

        return head.getSong();
    }

    /// Checks to see if the catalog contains a song. 
    ///
    /// @param The song we are searching for 
    /// @return true if the song is in the catalog, and false if it is not. 
    public boolean contains(Song song) {
        // TODO : Implement this function
        CatalogItem songPtr = head;

        while(songPtr != null)
        {
            if(songPtr.getSong() == song)
            {
                return true;
            }
            songPtr = songPtr.next; 
        }

        return false;
    }

    //--------------------------------------------------------------------
    // Utilities
    //--------------------------------------------------------------------

    /// Returns a truth value indicating whether the catalog's structural
    /// integrity remains valid.  If the integrity is no longer valid,
    /// then the catalog should be invalidated and usage should not be trusted
    /// @return true if the catalog integrity is valid; otherwise, false
    public boolean isIntegrityValid() {
        if(count < 0) {
            System.out.println("1");
            return false;
        }
        if(count == 0 && head == null) {
            return true;
        }
        if(count == 1 && head != null && head.next == null) {
            return true;
        }

        int n = 1;
        CatalogItem it = head;
        while(it.next != null) {
            it = it.next;
            n++;
        }

        if(n != count) {
            System.out.println("2");
            return false;
        }

        return true;
    }

    /// Returns a string that contains information about the list and the 
    /// contents of the list.  This is mostly useful for visual debugging 
    /// @return a string containing information about the contents of the 
    ///         catalog
    public String toString() {
        String s = "";
        s = "LinkedList::count=" + count(); 
        s += ", isEmpty=" + isEmpty(); 
        s += ", ["; 
        CatalogItem it = head;
        while(it != null) {
            if(it != head) {
                s += ", ";
            }
            s += it.getSong().getTitle();
            s += " | ";
            s += it.getSong().getYear();
            it = it.next;
        }
        s += "]";

        return s; 
    }

    /// Returns the earliest and most recent years of all the songs in the
    /// catalog and then clears the catalog of all songs
    /// @return an array of the years of the earliest and most recent songs
    public int[] publish() {
        int[] years = new int[2];
        int oldYear = Integer.MAX_VALUE;
        int newYear = Integer.MIN_VALUE;

        CatalogItem it = head;
        while(it != null) {
            int curYear = it.getSong().getYear();
            if (curYear < oldYear) {
                oldYear = curYear;
                years[0] = oldYear;
            }
            if (curYear > newYear) {
                newYear = curYear;
                years[1] = newYear;
            }
            it = it.next;
        }
        clear();
        return years;
    }

}
