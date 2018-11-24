import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        List<Integer> list = new LinkedList<>();
        MyLL myList = new MyLL();

        for(int i = 0; i < 20; i++)
        {
            list.add(i);
            myList.insert(i);
        }

        for(int i = 0; i < 30; i++)
        {
            if(list.contains(i) != myList.contains(i))
            {
                System.out.println("Lists are not equal");
            }
        }

        int insert = 100;
        myList.insert(insert);
        list.add(insert);
        if(list.contains(insert) != myList.contains(insert))
        {
            System.out.println("Lists are not equal");
        }


        int delete = 10;
        myList.delete(delete);
        list.remove(delete);
        if(list.contains(delete) != myList.contains(delete))
        {
            System.out.println("Lists are not equal");
        }

        for(int i = 0; i < 30; i++)
        {
            if(list.contains(i) != myList.contains(i))
            {
                System.out.println("Lists are not equal");
            }
        }
        
        System.out.println("Tests passed.");
    }
}
