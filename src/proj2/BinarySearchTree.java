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
    private int count;

    public BinarySearchTree()
    {
        root = null;
        count = 0;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void insert(E x)
    {
        root = insert(x, root);
    }

    private BinaryNode<E> insert (E x, BinaryNode<E> t)
    {
        if (t == null)
        {
            count++;
            return new BinaryNode<E>(x, null, null);
        }

        int compareResult = x.compareTo(t.getElement());

        if (compareResult < 0)
        {
            t.left = insert(x, t.getLeft());
        }
        else if (compareResult > 0)
        {
            t.right = insert(x, t.getRight());
        }
        else
        {
            Node n = (Node)t.getElement();
            n.incrementFrequency();
            t.setElement((E)n);
        }
        return t;
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

    private void printTree(BinaryNode<E> t)
    {
        if (t != null)
        {
            printTree(t.getLeft());
            System.out.println(t.getElement());
            printTree(t.getRight());
        }
    }

    public E getRoot()
    {
        return root.getElement();
    }

    public int getCount()
    {
        return count;
    }

    public void findCommonAncestor(E x, E y)
    {
        System.out.println("The common ancestor of \n" + find(x) + " and " + find(y) + "\n\tis: " + findCommonAncestor(root, x, y).getElement());
    }

    private BinaryNode<E> findCommonAncestor(BinaryNode<E> t, E x, E y)
    {
        if (t == null)
        {
            return null;
        }
        if(t.getElement().compareTo(x) > 0 && t.getElement().compareTo(y) > 0)
        {
            return findCommonAncestor(t.left, x, y);
        }
        else if(t.getElement().compareTo(x) < 0 && t.getElement().compareTo(y) < 0)
        {
            return findCommonAncestor(t.right, x, y);
        }
        else
        {
            return t;
        }
    }

    public E find (E x)
    {
        return find(root, x);
    }

    private E find(BinaryNode<E> t, E x)
    {
        if (t == null)
        {
            return null;
        }
        if(t.getElement().compareTo(x) > 0)
        {
            return find(t.left, x);
        }
        else if(t.getElement().compareTo(x) < 0)
        {
            return find(t.right, x);
        }
        else
        {
            return t.getElement();
        }
    }

    private class BinaryNode<E>
    {
        private E element;
        private BinaryNode<E> left;
        private BinaryNode<E> right;

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

        private E getElement()
        {
            return element;
        }

        private void setElement(E element)
        {
            this.element = element;
        }

        private BinaryNode<E> getLeft()
        {
            return left;
        }

        private BinaryNode<E> getRight()
        {
            return right;
        }

        private void setLeft(E element)
        {
            left.element = element;
        }

        private void setRight(E element)
        {
            right.element = element;
        }
    }
}
