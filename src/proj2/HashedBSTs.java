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
                    letter = str.charAt(0);
                    switch(letter)
                    {
                        case 'A':
                        case 'a':
                            table.get(0).insert((E)str);
                            break;
                        case 'B':
                        case 'b':
                            table.get(1).insert((E)str);
                            break;
                        case 'C':
                        case 'c':
                            table.get(2).insert((E)str);
                            break;
                        case 'D':
                        case 'd':
                            table.get(3).insert((E)str);
                            break;
                        case 'E':
                        case 'e':
                            table.get(4).insert((E)str);
                            break;
                        case 'F':
                        case 'f':
                            table.get(5).insert((E)str);
                            break;
                        case 'G':
                        case 'g':
                            table.get(6).insert((E)str);
                            break;
                        case 'H':
                        case 'h':
                            table.get(7).insert((E)str);
                            break;
                        case 'I':
                        case 'i':
                            table.get(8).insert((E)str);
                            break;
                        case 'J':
                        case 'j':
                            table.get(9).insert((E)str);
                            break;
                        case 'K':
                        case 'k':
                            table.get(10).insert((E)str);
                            break;
                        case 'L':
                        case 'l':
                            table.get(11).insert((E)str);
                            break;
                        case 'M':
                        case 'm':
                            table.get(12).insert((E)str);
                            break;
                        case 'N':
                        case 'n':
                            table.get(13).insert((E)str);
                            break;
                        case 'O':
                        case 'o':
                            table.get(14).insert((E)str);
                            break;
                        case 'P':
                        case 'p':
                            table.get(15).insert((E)str);
                            break;
                        case 'Q':
                        case 'q':
                            table.get(16).insert((E)str);
                            break;
                        case 'R':
                        case 'r':
                            table.get(17).insert((E)str);
                            break;
                        case 'S':
                        case 's':
                            table.get(18).insert((E)str);
                            break;
                        case 'T':
                        case 't':
                            table.get(19).insert((E)str);
                            break;
                        case 'U':
                        case 'u':
                            table.get(20).insert((E)str);
                            break;
                        case 'V':
                        case 'v':
                            table.get(21).insert((E)str);
                            break;
                        case 'W':
                        case 'w':
                            table.get(22).insert((E)str);
                            break;
                        case 'X':
                        case 'x':
                            table.get(23).insert((E)str);
                            break;
                        case 'Y':
                        case 'y':
                            table.get(24).insert((E)str);
                            break;
                        case 'Z':
                        case 'z':
                            table.get(25).insert((E)str);
                            break;
                    }
                }
                //System.out.print(str + " ");
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
