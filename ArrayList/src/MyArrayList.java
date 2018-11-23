import java.util.Arrays;
import java.util.List;

// Not a full implementation, just a data structure refresher for interviews.
public class MyArrayList {
    private int capacity;
    private int size;
    private int[] arr;

    public MyArrayList()
    {
        capacity = 10;
        size = 0;
        arr = new int[capacity];
    }

    public MyArrayList(int defaultLength)
    {
        capacity = defaultLength;
        size = 0;
        arr = new int[capacity];
    }

    public void add(int value)
    {
        checkAndResize();
        
        arr[size] = value;
        size++;
    }

    public void addAll(List<Integer> value)
    {
        checkAndResize(value.size());

        for(Integer i : value)
        {
            arr[size] = i;
            size++;
        }
    }

    public int get(int index) throws ArrayIndexOutOfBoundsException
    {
        if(index > size)
        {
            throw new ArrayIndexOutOfBoundsException();
        }

        return arr[index];
    }

    public int indexOf(int value)
    {
        for(int i = 0; i <= size; i++)
        {
            if(arr[i] == value)
            {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(int value)
    {
        if(indexOf(value) != -1)
        {
            return true;
        }

        return false;
    }

    public void insertAt(int index, int value) throws ArrayIndexOutOfBoundsException
    {
        checkAndResize();

        // size is the next position to be inserted, tail+1 so i should not be greater than that.
        if(index > size)
        {
            throw new ArrayIndexOutOfBoundsException();
        }

        size++;
        int temp;
        for(int i = index; i < size; i++)
        {
            temp = arr[i];
            arr[i] = value;
            value = temp;
        }
    }

    public int size()
    {
        return size;
    }

    private void checkAndResize()
    {
        checkAndResize(0);
    }

    private void checkAndResize(int extraLength)
    {
        if((size + extraLength) < capacity)
        {
            return;
        }

        capacity *= 2;
        arr = Arrays.copyOf(arr, capacity);
    }
}
