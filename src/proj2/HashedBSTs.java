package proj2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author theghv
 * @version 1.0
 *          Date: 3/15/14
 *          Time: 5:44 PM
 */
public class HashedBSTs<E extends Comparable<? super E>>
{
    private ArrayList<BinarySearchTree<Node>> table;

    public HashedBSTs(int size)
    {
        table = new ArrayList<BinarySearchTree<Node>>(size);

        for(int i = 0; i < size; i++)
        {
            BinarySearchTree<Node> tree = new BinarySearchTree<Node>();
            table.add(i, tree);
        }
    }

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

    public BinarySearchTree retrieveHashedBSTat(int index)
    {
        return table.get(index);
    }

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

    public void findAll(BinarySearchTree<Node> retrieved, Node sample)
    {

    }
}
