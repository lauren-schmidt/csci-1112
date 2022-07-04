/*--------------------------------------------------------------------------
GWU CSCI 1112 Spring 2022
author: Lauren Schmidt

A class to implement the interface of HashMaps.
This class will provide methods that are integral to the use of HashMaps, including set(), get(), 
and clear(). 

Please note: Meant to be used in conjunction with ListNode.java
--------------------------------------------------------------------------*/

public class HashMap implements Map {
  
    /// @variable buckets the list of LinkedLists that contains the buckets. 
    private final ListNode[] buckets;
  
    public HashMap(int length) 
    {
        this.buckets = new ListNode[length];
    }
  
    ///*--------------SET METHODS--------------*\\\

    /// Allows the user to add a key-value pair (node) at its appropriate 
    /// location in the HashMap. Will add to the tail, unless the map is empty, in which case,
    /// add to the head. 
    ///
    /// @param key the unique identifier for this node.  immutable
    /// @param value the value associated with the provided key. 
    /// @param profile profile integer array for analysis 
    /// @return void, but results in an updated HashMap if the key does not 
    /// already exist within the list. 
    /// If the key specified is already in the map (a duplicate), return 
    /// and end without adding anything. 
    public void set(String key, String value, int[] profile) 
    {
        //Find hash value for input key and store in bucket
        int currentBucket = hash(key);

        ListNode node = buckets[currentBucket];

        if(node == null)
        {
            //The bucket is empty and we can insert a new node at the head. 
            buckets[currentBucket] = new ListNode(key, value);
        }
        else
        {
            while(node != null)
            {
                profile[0]++;

                if(node.getKey() == key)
                {
                    node = new ListNode(key, value);
                    break;
                }
                else if(node.next == null)
                {
                    //We have reached the end of the list. Insert after the tail.
                    node.next = new ListNode(key, value);
                    break;
                }

                //Find the next element in the bucket until we get to the end.
                node = node.next;
            }
        }
        
    }
  
    ///*--------------GET METHODS--------------*\\\
    
    ///Provided the key for a node, finds the value associated with that node and returns it to the user. 
    ///
    /// @param key the unique identifier for this node.  immutable
    /// @param profile profile integer array for analysis 
    /// @return the String value associated with the KVP/node.
    public String get(String key, int[] profile) 
    {
        //Find the hash value for the input key. 
        int currentBucket = hash(key);

        //Go through each list of buckets, and search through them starting at the head. 
        //We are looking for the key input that matches. 

        ListNode currentNode = buckets[currentBucket];
        while(currentNode != null)
        {
            profile[0]++;

            if(currentNode.getKey() == key)
            {
                //We have found the key, return the value associated
                //with it in its KVP:
                return currentNode.getValue();
            }

            //Jump to the next element in the bucket and look there. 
            currentNode = currentNode.next; 
        }

        //We never found the key, so return null.
        return null;

    }
  
    ///Clears the buckets by setting the head of each to null. 
    ///Java's garbage collector automatically deletes everything else. 
    public void clear() 
    {
        //Set the head of each bucket to null, clearing each bucket. 
        //Setting the head to null means the Java garbage collector will delete the 
        //rest of the LL. 
        for(int i = 0; i < buckets.length; i++)
        {
            buckets[i] = null; 
        }

    }

    //----------------------------------------------------------------------
    // Utilities
    //----------------------------------------------------------------------
    /// Hash function.  DO NOT MODIFY
    /// @param key string input to be hashed
    /// @return index location of where an object should be put in the table
    private int hash(String key) {
        return Math.abs(key.hashCode() % buckets.length);
    }
}
