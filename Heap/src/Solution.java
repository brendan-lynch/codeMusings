public class Solution {
    public static void main(String[] args)
    {
        Heap h = new Heap(100);
        h.insert(10);
        h.insert(5);
        h.insert(15);
        h.insert(20);
        h.insert(11);
        h.insert(1);

        System.out.println(h.getMin() + " == 1");
        System.out.println(h.extractMin() + " == 1");
        System.out.println(h.extractMin() + " == 5");
        System.out.println(h.extractMin() + " == 10");
        System.out.println(h.extractMin() + " == 11");
        System.out.println(h.extractMin() + " == 15");
        System.out.println(h.extractMin() + " == 20");
    }
}
