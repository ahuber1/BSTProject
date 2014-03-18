package proj2;

/**
 * @author theghv
 * @version 1.0
 *          Date: 3/15/14
 *          Time: 5:56 PM
 */
public class BinarySearchTree<E extends Comparable<? super E>>
{
    private BinaryNode<E> root;

    public BinarySearchTree()
    {
        root = null;
    }

    public  BinarySearchTree(String str)
    {
        root = new BinaryNode(str);
    }

    public void emptyTree()
    {
        root = null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void  insert(E x)
    {
        root = insert(x, root);
    }

    private BinaryNode<E> insert (E x, BinaryNode t)
    {
        if (t == null)
        {
            return new BinaryNode<E>(x, null, null);
        }

        int compareResult = x.compareTo((E) t.getElement());

        if (compareResult < 0)
        {
            insert(x, t.getLeft());
        }
        else if (compareResult > 0)
        {
            insert(x, t.getRight());
        }
        else
            ;
        return t;
    }

    public void printRoot()
    {
        System.out.println(root.getElement());
    }

    public void printTree()
    {
        if (isEmpty())
        {
            System.out.println("Empty Tree");
        }
        else
        {
            printTree(root);
        }
    }

    private void printTree(BinaryNode t)
    {
        if (t != null)
        {
            printTree(t.getLeft());
            System.out.println(t.getElement());
            printTree(t.getRight());
        }
    }

    private void printRoot(BinaryNode t)
    {

    }

    public void findCommonAncestor(E x, E y)
    {

    }

    /*public int compareTo(E x)
    {

        return 0;
    }*/
}
