/*--------------------------------------------------------------------------
GWU CSCI 1112 Spring 2022
author: Lauren Schmidt

A class to implement the interface of binary tree structures (referred to from now on as TreeMaps).
This class will provide methods that are integral to the use of TreeMaps, including set(), get(), 
and clear(). 

Please note: Meant to be used in conjunction with TreeNode.java
--------------------------------------------------------------------------*/

// used only in balancing utilities
import java.util.List;       
import java.util.ArrayList;

public class TreeMap implements Map {
  
    /// @variable root The root value in the tree. 
    /// @variable rebalance a constructor flag to check if the tree needs rebalancing. 
    private TreeNode root;
    private boolean rebalance;

    public TreeMap( boolean rebalance ) 
    {
        this.root = null;
        this.rebalance = rebalance;
    }

    ///*--------------SET METHODS--------------*\\\

    /// Allows the user to add a key-value pair (node) at its appropriate 
    /// location in the tree. 
    ///
    /// @param key the unique identifier for this node.  immutable
    /// @param value the value associated with the provided key. 
    /// @param profile profile integer array for analysis 
    /// @return void, but results in an updated binary tree if the key
    /// specified is not already in the tree. 
    /// If the key specified is already in the tree (a duplicate), return 
    /// and end without adding anything. 
    public void set(String key, String value, int[] profile)
    {
        //Create a new root if empty. 
        if(root == null)
        {
            profile[0]++;
            root = new TreeNode(key, value);
            return; 
        }
        //See if the key is already there:
        if(get(key, profile) != null)
        {
            profile[0]++;
            return;
        }
        //Otherwise, call setRecursive to figure out where the node needs to be added. 
        setRecursive(root, key, value, profile);
    }

    ///A recursive helper method for the set method. 
    ///Looks for the location where the new node should be placed using the compareTo method and the 
    ///string key data of the node. 
    ///
    /// @param node the current node we are evaluating during this recursive call. Passed in when the user calls 
    /// the set() method. 
    /// @param key the unique identifier for this node.  immutable
    /// @param value the value associated with the provided key. 
    /// @param profile profile integer array for analysis 
    public void setRecursive(TreeNode node, String key, String value, int [] profile)
    {
        //Base case:
        if(node == null)
        {
            return; 
        }
        //Comparisons:
        if((key.compareTo(node.getKey()) < 0))
        {
            profile[0]++;

            //Look left:
            if( node.left != null)
            {
                profile[0]++;

                setRecursive(node.left, key, value, profile);
            }
            else
            {
                node.left = new TreeNode(key, value);
            }
        
        }
        //Look right:
        else{
            if(node.right != null)
            {
                profile[0]++;

                setRecursive(node.right, key, value, profile);
            }
            else{
                node.right = new TreeNode(key, value);
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
        //If the tree has no elements, return a null value 
        if(root == null)
        {
            profile[0]++;
            return null;
        }

        //If the key given does not exist, return a null value 
        if(key == null)
        {
            profile[0]++;
            return null;
        }

        //If the first node we check (the root) matches our value (best case)
        if(root.getKey().equals(key))
        {
            profile[0]++;
            return root.getValue();
        }

        //Else: Call the recursive get method. 
        return getRecursive(root, key, profile);
    }

    ///Helper method for the get() method. Recursively searches for the value associated with the node's key
    ///provided by the user.
    ///
    /// @param key the unique identifier for this node.  immutable (passed in when user calls )
    /// @param value the value associated with the provided key. (passed in when user calls get())
    /// @param profile profile integer array for analysis 
    /// @return the String value associated with the KVP/node.
    public String getRecursive(TreeNode node, String key, int[] profile)
    {
        //Check base case:
        if(node.getKey() == null)
        {
            profile[0]++; 
            return null;
        }

        if((key.compareTo(node.getKey()) == 0))
        {
            profile[0]++;
            return node.getValue();
        }

        if((key.compareTo(node.getKey()) < 0))
        {
            profile[0]++;
            if(node.left != null)
            {
                profile[0]++;

                return getRecursive(node.left, key, profile);
            }
            else{
                return null;
            }
        }
        else
        {
            if(node.right != null)
            {
                profile[0]++;

                return getRecursive(node.right, key, profile);
            }
            else
            {
                return null;
            }
        }
    }


    ///Clears the tree by setting the root to null. 
    ///Java's garbage collector automatically deletes everything else. 
    public void clear()
    {
        this.root = null;
    }



  
    //----------------------------------------------------------------------
    // Utilities
    //----------------------------------------------------------------------
    /// The entry point for balancing this tree to maintain optimal insert 
    /// and search efficiency
    /// Note: This algorithm focuses on correctness and is not the most 
    /// efficient algorithm available. Please look up different algorithms 
    /// that solve the balancing problem.
    private void balance() {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        //Sorts tree from given root
        populate(root, nodes);
        //Return null if root has no children
        if(nodes.size() == 0) return;
  
        this.root = balance(nodes, 0, nodes.size() - 1);
    }
 
    /// Recursive helper in the balancing operation to support balance.
    /// @param nodes a list of nodes
    /// @param start the start index within the list
    /// @param end the end index within the list
    /// @return the local root after balancing is performed on the subtree
    private TreeNode balance(List<TreeNode> nodes, int start, int end) {
        int mid = (start + end) / 2;
        TreeNode node = nodes.get(mid);
        if(start == end){
            node.left = null;
            node.right = null;
            return node;
        }
        //Recursively balance tree on left and right children using
        //middle node as root
        if(!(mid - 1 < start)) {
            node.left = balance(nodes, start, mid - 1);
        } else {
            node.left = null;
        }
  
        if(!(mid + 1 > end)) {
            node.right = balance(nodes, mid + 1, end);
        } else {
            node.right = null;
        }
  
        return node;
    }
 
    /// Recursive helper in the balancing operation to put listitems into
    /// the tree
    /// @param the root of the subtree to balance
    /// @param the list of nodes to balance
    private void populate(TreeNode node, List<TreeNode> list) {
        if(node == null) return;
        populate(node.left, list);
        list.add(node);
        populate(node.right, list);
    }
}
