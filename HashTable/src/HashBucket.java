public class HashBucket {
    private int key;
    private int value;
    private HashBucket next;

    public HashBucket(int key, int value)
    {
        this.key = key;
        this.value = value;
        next = null;
    }

    public void setNext(HashBucket next)
    {
        this.next = next;
    }

    public HashBucket getNext()
    {
        return next;
    }

    public int getValue()
    {
        return value;
    }

    public int getKey()
    {
        return key;
    }
}
