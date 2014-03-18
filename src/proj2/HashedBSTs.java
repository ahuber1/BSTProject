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
public class HashedBSTs<E>
{
    private ArrayList<BinarySearchTree<String>> table = new ArrayList<BinarySearchTree<String>>();

    public HashedBSTs(int size)
    {
        String chars;
        char lower = 'a';
        char upper = 'A';
        chars = "" + upper + lower;

        for(int i = 0; i < size; i++)
        {
            BinarySearchTree<String> tree = new BinarySearchTree<String>(chars);
            table.add(i, tree);
            tree.insert(chars);
        }
    }

    public void  printHashCountResults()
    {

    }

    public void fileReader(String filename)
    {
        File file = new File(filename);
        String str = "";
        try
        {
            Scanner scan = new Scanner(file);
            scan.useDelimiter("[^\\w']|[0-9]");

            while (scan.hasNext())
            {
                str = scan.next();
                System.out.print(str + " ");
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
