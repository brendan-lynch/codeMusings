import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args)
    {
        Map<Integer, Integer> map = new HashMap<>();
        MyHashTable myMap = new MyHashTable();

        for(int i = 0; i < 100; i++)
        {
            map.put(i, i*10);
            myMap.put(i, i*10);
        }

        for(int i = 0; i < 100; i++)
        {
            if(map.get(i) != myMap.get(i))
            {
                System.out.println("Maps don't match");
            }
        }

        myMap.delete(10);
        map.remove(10);
        map.put(101, -1);
        myMap.put(101, -1);

        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet)
        {
            if(map.get(key) != myMap.get(key))
            {
                System.out.println("Maps don't match");
            }
        }
        System.out.println("Tests complete.");
    }
}
