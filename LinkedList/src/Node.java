public class Node {
    private int value;
    private Node next;

    public Node(int value)
    {
        this.value = value;
    }

    public int value()
    {
        return value;
    }

    public Node next()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }
}
