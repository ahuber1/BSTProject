package proj2;

/**
 * @author theghv
 * @version 1.0
 *          Date: 3/16/14
 *          Time: 1:30 AM
 */
public class BinaryNode<E extends Comparable<? super E>>
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
