package proj2;

/**
 * @author theghv
 * @version 1.0
 *          Date: 3/16/14
 *          Time: 1:30 AM
 */
public class BinaryNode<E>
{
    private String word;
    private int frequency;

    public BinaryNode(String word) {
        super();
        this.word = word;
        this.frequency = 1;
    }

    public String getWord() { return word; }
    public void setWord(String word) { this.word = word; }
    public int getFrequency() { return frequency; }
    public void setFrequency(int frequency) { this.frequency = frequency; }
    public void incrementFrequency() { this.frequency++; }

    @Override
    public String toString() {
        return "Node [word=" + word + ", frequency=" + frequency + "]";
    }

    @Override
    /** This function ONLY worries about matching the STRING portion of this node
     *
     */
    public int compareTo(Object x) {

        Node that = (Node) x;
        return this.getWord().compareTo(that.getWord());
    }

    public boolean startsWith(Object x) {

        Node that = (Node) x;
        return that.getWord().startsWith(this.getWord());
    }
}
