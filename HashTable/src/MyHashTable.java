public class MyHashTable {
    private int size;
    private int bucketCount;
    private HashBucket[] buckets;

    public MyHashTable()
    {
        size = 0;
        bucketCount = 10;
        buckets = new HashBucket[bucketCount];
    }

    public void put(int key, int value)
    {
        size++;
        HashBucket insert = new HashBucket(key, value);
        int hashKey = hashFunction(key);
        if(buckets[hashKey] == null)
        {
            buckets[hashKey] = insert;
        }
        else
        {
            HashBucket runner = buckets[hashKey];
            while(runner.getNext() != null)
            {
                runner = runner.getNext();
            }

            runner.setNext(insert);
        }
    }

    public int get(int key) throws IndexOutOfBoundsException
    {
        int hashKey = hashFunction(key);
        if(buckets[hashKey] == null)
        {
            throw new IndexOutOfBoundsException();
        }

        HashBucket runner = buckets[hashKey];
        while(runner != null)
        {
            if(runner.getKey() == key)
            {
                return runner.getValue();
            }

            runner = runner.getNext();
        }

        throw new IndexOutOfBoundsException();
    }

    public int delete(int key) throws IndexOutOfBoundsException
    {
        int hashKey = hashFunction(key);
        if(buckets[hashKey] == null)
        {
            throw new IndexOutOfBoundsException();
        }

        HashBucket runner = new HashBucket(0, 0);
        runner.setNext(buckets[hashKey]);
        while(runner.getNext() != null)
        {
            if(runner.getNext().getKey() == key)
            {
                int ret = runner.getNext().getValue();
                runner.setNext(runner.getNext().getNext());

                return ret;
            }

            runner = runner.getNext();
        }

        throw new IndexOutOfBoundsException();
    }

    private int hashFunction(int key)
    {
        if((size * 2 ) > bucketCount)
        {
            rehash();
        }

        return (key * 2) % bucketCount;
    }

    private void rehash()
    {
        size = 0;
        int currentCount = bucketCount;
        bucketCount *= 3;
        HashBucket[] oldBuckets = buckets;
        buckets = new HashBucket[bucketCount];
        HashBucket runner;
        for(int i = 0; i < currentCount; i++)
        {
            if(oldBuckets[i] != null)
            {
                runner = oldBuckets[i];
                while(runner != null)
                {
                    this.put(runner.getKey(), runner.getValue());
                    runner = runner.getNext();
                }
            }
        }
    }
}
