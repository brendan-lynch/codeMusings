// Does not handle resizing the storage layer or error checking storage out of bounds or empty.

public class Heap {
    private int size;
    private int[] storage;
    private int tail;

    public Heap(int size)
    {
        this.size = size;
        storage = new int[size];
        tail = 0;
    }

    public void insert(int value)
    {
        tail++;
        int i = tail - 1;
        storage[i] = value;

        while( i != 0 && storage[parent(i)] > storage[i])
        {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int getMin()
    {
        return storage[0];
    }

    public int extractMin()
    {
        int value = storage[0];

        storage[0] = storage[tail-1];
        tail--;
        heapify(0);

        return value;
    }

    private void heapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if(l < tail && storage[l] < storage[i])
        {
            smallest = l;
        }
        if(r < tail && storage[r] < storage[smallest])
        {
            smallest = r;
        }
        if(smallest != i)
        {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private int left(int i)
    {
        return (2 * i + 1);
    }

    private int right(int i)
    {
        return (2 * i + 2);
    }

    private int parent(int i)
    {
        return ((i - 1) / 2);
    }

    private void swap(int a, int b)
    {
        int swap = storage[a];
        storage[a] = storage[b];
        storage[b] = swap;
    }
}
