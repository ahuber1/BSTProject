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
    private ArrayList<BinarySearchTree<E>> table;

    public HashedBSTs(int size)
    {
        table = new ArrayList<BinarySearchTree<E>>(size);

        for(int i = 0; i < size; i++)
        {
            BinarySearchTree<E> tree = new BinarySearchTree<E>();
            table.add(i, tree);
        }
    }

    public void  printHashCountResults()
    {
        for (int i = 0; i < table.size(); i++)
        {
            table.get(i).printTree();
        }
    }

    public void fileReader(String filename)
    {
        File file = new File(filename);
        String str;
        int index;
        char letter;

        try
        {
            Scanner scan = new Scanner(file);
            scan.useDelimiter("[\\W]|[0-9]");

            while (scan.hasNext())
            {
                str = scan.next();

                if(str.length() > 0)
                {
                    //Checking strings by comparing their Unicode values to their alphabetical index.
                    //Also known as magic.
                    if(str.charAt(0) - 65 >= 0 && str.charAt(0) - 65 <= 25)
                    {
                        index = str.charAt(0) - 65;
                        table.get(index).insert((E)str);
                    }
                    if(str.charAt(0) - 97 >= 0 && str.charAt(0) - 97 <= 25)
                    {
                        index = str.charAt(0) - 97;
                        table.get(index).insert((E)str);
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
