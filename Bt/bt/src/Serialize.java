import java.util.ArrayList;
import java.util.List;

public class Serialize {
    List<Integer> withDelimiter;

    public List<Integer> doSerializeWithDelimiter(BT tree) {
        withDelimiter = new ArrayList<>();
        delimiterRecursive(tree.getRoot());

        return withDelimiter;
    }

    public BT doDeserializeWithDelimiter(List<Integer> list) {
        BT bt = new BT(list.remove(0));
        delimiterRecursive(list, bt.getRoot());

        return bt;
    }

    public List<Integer> doSerializeWithDelimiterOptimal(BT tree) {
        withDelimiter = new ArrayList<>();
        delimiterRecursiveOptimal(tree.getRoot());

        return withDelimiter;
    }

    public BT doDeserializeWithDelimiterOptimal(List<Integer> list) {
        BT bt = new BT(list.remove(0));
        delimiterRecursiveOptimal(list, bt.getRoot());

        return bt;
    }

    private void delimiterRecursiveOptimal(Node current) {
        if (current == null) {
            withDelimiter.add(-1);
            return;
        }

        withDelimiter.add(current.value());
        if (current.left() != null || current.right() != null) {
            withDelimiter.add(-2);
            delimiterRecursiveOptimal(current.left());
            delimiterRecursiveOptimal(current.right());
        }
    }

    private void delimiterRecursiveOptimal(List<Integer> list, Node current)
    {
        if(list.isEmpty())
        {
            return;
        }

        int value;
        Node insert;
        if(list.get(0) == -2)
        {
            // pop the delimiter for internal node
            list.remove(0);
            value = list.remove(0);
            if(value != -1)
            {
                insert = new Node(value);
                current.setLeft(insert);
                delimiterRecursiveOptimal(list, insert);
            }

            value = list.remove(0);
            if(value != -1)
            {
                insert = new Node(value);
                current.setRight(insert);
                delimiterRecursiveOptimal(list, insert);
            }
        }
    }

    private void delimiterRecursive(Node current)
    {
        if(current == null)
        {
            withDelimiter.add(-1);
            return;
        }

        withDelimiter.add(current.value());
        delimiterRecursive(current.left());
        delimiterRecursive(current.right());
    }

    private void delimiterRecursive(List<Integer> list, Node current)
    {
        if(list.isEmpty())
        {
            return;
        }

        Integer value = list.remove(0);
        Node insert;
        if(value != -1)
        {
            insert = new Node(value);
            current.setLeft(insert);
            delimiterRecursive(list, insert);
        }

        value = list.remove(0);
        if(value != -1)
        {
            insert = new Node(value);
            current.setRight(insert);
            delimiterRecursive(list, insert);
        }
    }
}
