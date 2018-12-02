import java.util.List;

public class Solution {
    public static void main(String[] args)
    {
        BT bt = new BT(10);
        bt.insert(15);
        bt.insert(7);
        bt.insert(4);
        bt.insert(2);
        bt.insert(3);

        // Serialize Binary Tree with delimiter '-1'
        Serialize s = new Serialize();
        List<Integer> withDelimiter = s.doSerializeWithDelimiter(bt);

        bt.inOrder();
        System.out.print("= ");
        s.doDeserializeWithDelimiter(withDelimiter).inOrder();
        System.out.println();

        withDelimiter = s.doSerializeWithDelimiterOptimal(bt);
        for(int i : withDelimiter)
        {
            System.out.print(i + " ");
        }

        System.out.println();
        bt.inOrder();
        System.out.print("= ");
        s.doDeserializeWithDelimiterOptimal(withDelimiter).inOrder();
        System.out.println();
    }

    public static void LCA(String[] args)
    {
        BT bt = new BT(10);
        bt.insert(15);
        bt.insert(7);
        bt.insert(4);
        bt.insert(2);
        bt.insert(3);

        LCA lca = new LCA(bt);
        System.out.println(lca.solve(4, 2) + " = 15");
        System.out.println(lca.solve(15, 7) + " = 10");
        System.out.println(lca.solve(3, 4) + " = 10");
    }

    public static void testTree()
    {
        BT bt = new BT(10);
        bt.insert(15);
        bt.insert(7);
        bt.insert(4);
        bt.insert(2);
        bt.insert(3);

        bt.inOrder();
        System.out.print(" = 4 15 2 10 3 7");
        System.out.println();

        bt.preOrder();
        System.out.print(" = 10 15 4 2 7 3");
        System.out.println();

        bt.postOrder();
        System.out.print(" = 4 2 15 3 7 10");
        System.out.println();

        System.out.println(bt.find(15) + " = true");
        System.out.println(bt.find(10) + " = true");
        System.out.println(bt.find(70) + " = false");
        bt = new BT(10);
        bt.insert(15);
        bt.insert(7);
        bt.insert(4);
        bt.insert(2);
        bt.insert(3);

        bt.delete(10);
        bt.inOrder();
        System.out.print(" = 15 2 4 3 7");
        System.out.println();
    }
}
