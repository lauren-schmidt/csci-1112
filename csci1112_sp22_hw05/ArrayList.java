/*--------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Spring 2022

TODO : Document this file

authors: Lauren Schmidt, Charles Peeke
--------------------------------------------------------------------------*/
public class ArrayList implements MusicCatalog {
    /// For an array-based list, the array itself
    private CatalogItem[] data;
    /// The counter to track the number of elements in the list
    private int count;

    /// Parameterless Constructor
    public ArrayList() {
        count = 0;
        data = new CatalogItem[2];
    }
   
    /// Adds a song to the end of the current music
    /// catalog. 
    ///
    /// @param the Song object to be added 
    /// @return void
    public void add(Song song) {
    if(count >= data.length)
    {
        CatalogItem [] songArray = new CatalogItem[data.length*2];
        for(int i = 0; i < data.length; i++)
        {
            songArray[i] = data[i];
        }
        data = songArray;
    }

    data[count] = new CatalogItem(song);
    count++;

    }

    /// Removes the first element of the catalog.
    ///
    /// @return The removed Song object 
    public Song remove() 
    {
        Song tempSong = null;

        if(data[0] != null)
        {
            tempSong = data[0].getSong();
            data[0] = null;
            moveSong(0);
            count--;
        }
        return tempSong;    

    }

    /// Removes the first occurence of the song
    /// specified in the parameter in the 
    /// music catalog. 
    /// @param the Song object to be removed 
    /// @return the removed song, and null if the song does not exist in the list. 
    public Song remove(Song song)
    {
        int a = findSong(song);
        if(a == -1)
        {
            return null;
        }

        Song tempSong = data[a].getSong();
        data[a] = null;
        moveSong(a);
        count--; 

        return tempSong;
    }

    /// Shifts a song by one. 
    ///
    /// @param The song to be shifted. 
    public void moveSong(int firstSong)
    {
        for(int i = firstSong; i + 1 < data.length; i++)
        {
            data[firstSong] = data[firstSong+1];
            if(data.length - 1 == firstSong+1)
            {
                data[firstSong+1] = null;
            }
        }
    }

    /// Finds a song in the music catalog. 
    ///
    ///
    /// @param the song we are looking for 
    /// @return the index of the song, and -1 if the song is not in the catalog.  
    public int findSong(Song song)
    {
        for(int i = 0; i < data.length; i++)
        {
            if(data[i] != null && data[i].getSong().equals(song))
            {
                return i;
            }
        }

        return -1;
    }
    
    /// Clears the catalog of all songs. 
    public void clear() {
        data = new CatalogItem[2];
        count = 0; 
    }
    
    /// Checks to see if the current music catalog is 
    /// empty. 
    /// 
    /// @return true if the catalog is empty, and false if it is not. 
    public boolean isEmpty() {
    if(count == 0)
    {
        return true;
    }
    else{
        return false; 
    }
    }
    
    /// Counts the number of elements stored in the catalog. 
    ///
    /// @return the number of elements in the catalog. 
    public int count() {
        return count; 
    }
    
    /// Returns the song at the specified index if that song exists in
    /// the list, otherwise returns null. 
    /// @param The index we are searching for
    /// @return The song at the specified index, and null if the parameter is 
    /// invalid or the song does not exist in the list. 
    public Song get(int i) {
        if(i >= 0 && i < data.length && data[i] != null)
        {
            return data[i].getSong();
        }
        else{
            return null;
        }
    }

     /// Checks to see if the catalog contains a song. 
    ///
    /// @param The song we are searching for 
    /// @return true if the song is in the catalog, and false if it is not. 
    public boolean contains(Song song) {
        for(int i = 0; i < count; i++)
        {
            if(data[i].getSong().equals(song))
            {
                return true;
            }
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
            return false;
        }
        if(data == null) {
            return false;
        }
        if(count > data.length) {
            return false;
        }
        for(int i = 0; i < count; i++) {
            if(data[i] == null) {
                return false;
            }
        }

        return true;
    }

    /// Returns a string that contains information about the list and the 
    /// contents of the list.  This is mostly useful for visual debugging 
    /// @return a string containing information about the contents of the 
    ///         catalog
    public String toString() {
        String s = "";
        s = "ArrayList::allocated=" + data.length;
        s += ", count=" + count(); 
        s += ", isEmpty=" + isEmpty(); 
        s += ", ["; 
        for(int i = 0; i < count; i++) {
            if(i > 0) {
                s += ", ";
            }
            s += data[i].getSong().getTitle();
            s += " | ";
            s += data[i].getSong().getYear();
        }
        s += "]";
        return s;
    }

    /// Returns the earliest and most recent years of all the songs in the
    /// catalog and then clears the catalog of all songs
    /// @return an array of the years of the earliest and most recent songs
    public int[] publish() {
        int oldYear = 0;
        int newYear = 0;

        for(int i = 0; i < count; i++) {
            int curYear = data[i].getSong().getYear();
            if (curYear < oldYear) oldYear = curYear;
            if (curYear > newYear) newYear = curYear;
        }
        clear();
        return new int[] { oldYear, newYear };
    }

}
