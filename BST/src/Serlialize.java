import java.util.ArrayList;
import java.util.List;

public class Serlialize {


    public List<Integer> doSerialize(BST tree)
    {
        List<Integer> list = new ArrayList<>();
        doSerializeRecursive(tree.getRoot(), list);

        return list;
    }

    public BST doDeserialize(List<Integer> list)
    {
        BST bst = new BST(list.remove(0));

        while(!list.isEmpty())
        {
            bst.insert(list.remove(0));
        }

        return bst;
    }

    public void doSerializeRecursive(Node current, List<Integer> list)
    {
        if(current == null)
        {
            return;
        }

        list.add(current.value());
        doSerializeRecursive(current.left(), list);
        doSerializeRecursive(current.right(), list);
    }
}
