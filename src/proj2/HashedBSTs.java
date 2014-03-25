package proj2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Stores and manipulates an ArrayList of Binary Search Trees. The BSTs store Nodes containing words taken from an input
 * file as well as their frequencies.
 *
 * @author Mark Judy <mjudy1@umbc.edu>
 * @version 1.0
 *          Date: 3/15/14
 *          Time: 5:44 PM
 */
public class HashedBSTs<E extends Comparable<? super E>>
{
    private ArrayList<BinarySearchTree<Node>> table;

    /**
     * Constructor for HashedBSTs class. Initializes an ArrayList of Binary Search Trees with length specified by size parameter.
     * @param size Sets the length of the ArrayList to be used by this object.
     */
    public HashedBSTs(int size)
    {
        table = new ArrayList<BinarySearchTree<Node>>(size);

        for(int i = 0; i < size; i++)
        {
            BinarySearchTree<Node> tree = new BinarySearchTree<Node>();
            table.add(i, tree);
        }
    }

    /**
     * Prints the root Node of each Binary Search Tree in the ArrayList and how many nodes are contained in each BST.
     */
    public void  printHashCountResults()
    {
        for (int i = 0; i < table.size(); i++)
        {
            if(table.get(i).isEmpty())
            {
                System.out.println("Empty Tree");
            }
            else
            {
                System.out.println("This tree starts with: " + table.get(i).getRoot() + " and has " + table.get(i).getCount() + " nodes.");
            }
        }
    }

    /**
     * Retrieves a Binary Seach Tree from a specified index in the ArrayList.
     * @param index The index of the Binary Search Tree in the ArrayList.
     * @return Returns a BinarySearchTree.
     */
    public BinarySearchTree retrieveHashedBSTat(int index)
    {
        return table.get(index);
    }

    /**
     * Reads input data from a specified file.
     * @param filename The filename from which to read the input data.
     */
    public void fileReader(String filename)
    {
        File file = new File(filename);
        String str;
        int index;

        try
        {
            Scanner scan = new Scanner(file);
            while (scan.hasNext())
            {
                str = scan.next();
                str = str.replaceAll("[\\W]|[0-9]", "");

                if(str.length() > 0)
                {
                    //Checking strings by comparing their Unicode values to their alphabetical index.
                    if(str.charAt(0) - 65 >= 0 && str.charAt(0) - 65 <= 25)
                    {
                        index = str.charAt(0) - 65;
                        table.get(index).insert(new Node(str));
                    }
                    if(str.charAt(0) - 97 >= 0 && str.charAt(0) - 97 <= 25)
                    {
                        index = str.charAt(0) - 97;
                        table.get(index).insert(new Node(str));
                    }
                }
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Finds all nodes in a retrieved Binary Search Tree that start with the String contained in sample Node.
     * @param retrieved The Binary Search Tree to search for Nodes in.
     * @param sample The sample node to compare with nodes in the Binary Search Tree.
     */
    public void findAll(BinarySearchTree<Node> retrieved, Node sample)
    {
        System.out.println("Printing the results of nodes that START WITH: " + sample.getWord());
        retrieved.findAll(sample);
    }
}
