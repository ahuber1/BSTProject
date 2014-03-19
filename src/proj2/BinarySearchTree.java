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
            t.left = insert(x, t.getLeft());
        }
        else if (compareResult > 0)
        {
            t.right = insert(x, t.getRight());
        }
        else
            ; //TODO deal with duplicates
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

    public E getRoot()
    {
        return root.getElement();
    }

    public void findCommonAncestor(E x, E y)
    {

    }

    private class BinaryNode<E extends Comparable<? super E>>
    {
        private E element;
        private BinaryNode<E> left;
        private BinaryNode<E> right;
        private int frequency;

        public BinaryNode(E element)
        {
            this(element, null, null);
        }

        public BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right)
        {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public E getElement()
        {
            return element;
        }

        public void setElement(E element)
        {
            this.element = element;
        }

        public BinaryNode<E> getLeft()
        {
            return left;
        }

        public BinaryNode<E> getRight()
        {
            return right;
        }

        public void setLeft(E element)
        {
            left.element = element;
        }

        public void setRight(E element)
        {
            right.element = element;
        }
    }
}
