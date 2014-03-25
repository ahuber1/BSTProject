package proj2;

/**
 * A generic Binary Search Tree class that defines BST operations with a BinaryNode inner class.
 *
 * @author Mark Judy <mjudy1@umbc.edu>
 * @version 1.0
 *          Date: 3/15/14
 *          Time: 5:56 PM
 */
public class BinarySearchTree<E extends Comparable<? super E>>
{
    private BinaryNode<E> root;
    private int count;

    /**
     * Constructs a Binary Search Tree with an empty root. Initializes a count of the tree's nodes to 0.
     */
    public BinarySearchTree()
    {
        root = null;
        count = 0;
    }

    /**
     * Checks to see if this is an empty tree.
     * @return Returns true if the tree is empty. Returns false if the tree is populated.
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * Calls a private insertion method to insert an object into the Binary Search Tree.
     * @param x The object to be inserted into the tree.
     */
    public void insert(E x)
    {
        root = insert(x, root);
    }

    /**
     * Bootstrapped method to insert a new Binary Node into this Binary Search Tree.
     * @param x The new Binary Node to be inserted into the tree.
     * @param t The Binary Node pointer location at which to insert the new Binary Node.
     * @return Returns the new Binary Node at its inserted location.
     */
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

    /**
     * Bootstrap method that determines whether or not the Binary Search Tree is empty before calling a method to print a
     * populated Binary Search Tree.
     */
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

    /**
     * Recursive bootstrapped method to print a Binary Search Tree using an inorder traversal
     * starting from a specified node in the tree.
     * @param t The node from which to start printing the Binary Search Tree.
     */
    private void printTree(BinaryNode<E> t)
    {
        if (t != null)
        {
            printTree(t.getLeft());
            System.out.println(t.getElement());
            printTree(t.getRight());
        }
    }

    /**
     * Gets the root of this Binary Search Tree.
     * @return The Binary Node stored at the root of this tree.
     */
    public E getRoot()
    {
        return root.getElement();
    }

    /**
     * Gets the number of nodes stored in this Binary Search Tree.
     * @return Returns the count of nodes stored in this tree.
     */
    public int getCount()
    {
        return count;
    }

    /**
     * Bootstrap method to find the lowest common ancestor of two specified nodes in this Binary Search Tree.
     * @param x A data object to search for when finding the lowest common ancestor.
     * @param y A data object to search for when finding the lowest common ancestor.
     */
    public void findCommonAncestor(E x, E y)
    {
        System.out.println("The common ancestor of \n" + find(x) + " and " + find(y) + "\n\tis: " + findCommonAncestor(root, x, y).getElement());
    }

    /**
     * Recursive bootstrapped method for finding the lowest common ancestor of two specified nodes in this Binary Search Tree.
     * @param t The root node to search for a lowest common ancestor from.
     * @param x A data object to search for when finding the lowest common ancestor.
     * @param y A data object to search for when finding the lowest common ancestor.
     * @return The lowest common ancestor of the specified nodes.
     */
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

    /**
     * Bootstrap method to find the stored data corresponding to a given object in the Binary Search Tree.
     * @param x Object to find corresponding data for.
     * @return Returns the stored data for the given object.
     */
    public E find (E x)
    {
        return find(root, x);
    }

    /**
     * Recursive bootstrapped method for finding the stored data corresponding to a given object in the Binary Search Tree.
     * @param t The Binary Node to search from.
     * @param x Object to find corresponding data for.
     * @return Returns the stored data for the given object.
     */
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

    /**
     * Bootstrap method for finding all nodes that contain data starting with the sample given.
     * @param x Sample data to search for.
     */
    public void findAll(E x)
    {
        findAll(root, x);
    }

    /**
     * Recursive bootstrapped method for finding all nodes that contain data starting with the given sample.
     * @param t Binary Node to search from.
     * @param x Sample data to search for.
     */
    private void findAll(BinaryNode<E> t, E x)
    {
        if (t == null)
        {
            System.out.print("");
        }
        else if (((Node)t.getElement()).startsWith(x))
        {
            System.out.println(t.getElement());
            if(t.right != null)
            {
                findAll(t.right, x);
            }
            if(t.left != null)
            {
                findAll(t.left, x);
            }
        }
        else
        {
            if (t.getElement().compareTo(x) > 0)
            {
                findAll(t.left, x);
            }
            else if (t.getElement().compareTo(x) < 0)
            {
                findAll(t.right, x);
            }
        }
    }

    /**
     * Custom method for determining whether or not the data in a given node starts with data contained in a sample node.
     * Used when troubleshooting problems with the given Node.java class.
     * @param t Existing Binary Node to compare with the given sample.
     * @param x Sample node used for searching.
     * @return Returns true if data in the existing node starts with data from the sample node. Returns false otherwise.
     */
    private boolean startsWith(BinaryNode<E> t, E x)
    {
        String localStr = ((Node)t.getElement()).getWord();
        String inputStr = ((Node)x).getWord();
        int result = 0;

        for(int i = 0; i < inputStr.length(); i++)
        {
            if (localStr.charAt(i) == inputStr.charAt(i))
            {
                result++;
            }
            else
            {
                result -= (inputStr.length() + 10);
            }
        }
        if(result > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Inner class defining the structure of nodes in this Binary Search Tree.
     * @param <E> Generic type to be stored in the Binary Node.
     */
    private class BinaryNode<E>
    {
        private E element;
        private BinaryNode<E> left;
        private BinaryNode<E> right;

        /**
         * Bootstrap constructor that creates a new Binary Node from a given object.
         * @param element The object to store in the Binary Node.
         */
        public BinaryNode(E element)
        {
            this(element, null, null);
        }

        /**
         * Bootstrapped constructor for creating Binary Nodes in a Binary Search Tree.
         * @param element The object to be stored in the Binary Node.
         * @param left Pointer to the left branch of this Binary Node.
         * @param right Pointer to the right branch of this Binary Node.
         */
        public BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right)
        {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        /**
         * Returns the object stored in this Binary Node.
         * @return the object stored in this Binary Node.
         */
        private E getElement()
        {
            return element;
        }

        /**
         * Sets the data stored in a Binary Node to new data.
         * @param element the object to store in this new Binary Node.
         */
        private void setElement(E element)
        {
            this.element = element;
        }

        /**
         * Returns the node to the left of the current node.
         * @return a reference to the left binary node.
         */
        private BinaryNode<E> getLeft()
        {
            return left;
        }

        /**
         * Returns the node to the right of the current node.
         * @return a reference to the right binary node.
         */
        private BinaryNode<E> getRight()
        {
            return right;
        }
    }
}
