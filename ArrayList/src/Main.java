import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        MyArrayList myList = new MyArrayList();

        for(int i = 0; i < 15; i++)
        {
            list.add(i);
            myList.add(i);
        }

        for(int i = 0; i < 15; i++)
        {
            if(list.get(i) != myList.get(i))
            {
                System.out.println(list.get(i) + " does not equal " + myList.get(i) + " at index " + i);
            }
        }

        list.add(10, 100);
        myList.insertAt(10, 100);
        list.add(list.size(), 1000);
        myList.insertAt(myList.size(), 1000);

        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) != myList.get(i))
            {
                System.out.println(list.get(i) + " does not equal " + myList.get(i) + " at index " + i);
            }
        }

        System.out.println("Test passed.");
    }
}
