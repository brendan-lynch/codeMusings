import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LCA {
    private BT root;
    private Queue<Node> aList;
    private Queue<Node> bList;

    public LCA(BT tree)
    {
        root = tree;
    }

    public int solve(int a, int b)
    {
        aList = findPath(root.getRoot(), a);
        bList = findPath(root.getRoot(), b);

        int good = aList.peek().value();
        int lastGood = good;
        while(aList.remove().value() == bList.remove().value())
        {
            lastGood = good;
            good = aList.peek().value();
        }

        return lastGood;
    }

    // Use DFS to practice it.
    private Queue<Node> findPath(Node node, int value)
    {
        LinkedList<Node> path = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap();
        Node current = node;
        path.add(current);
        visited.put(current, true);

        while(!path.isEmpty())
        {
            current = path.getLast();
            if(current.value() == value)
            {
                break;
            }
            else if(current.left() == null && current.right() == null)
            {
                path.removeLast();
                continue;
            }
            else if(current.left() != null && !visited.containsKey(current.left()))
            {
                path.add(current.left());
                visited.put(current.left(), true);
                continue;
            }
            else if(current.right() != null && !visited.containsKey(current.right()))
            {
                path.add(current.right());
                visited.put(current.right(), true);
                continue;
            }
            else
            {
                // Not a leaf node but we visited all the children and didn't find the value
                path.removeLast();
            }
        }

        return path;
    }
}
