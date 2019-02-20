import java.util.LinkedList;
import java.util.Queue;

public class BT {
    private Node root;

    public BT(int value)
    {
        root = new Node(value);
    }

    public void insert(int value)
    {
        Queue<Node> queue = new LinkedList<>();
        Node node = root;
        queue.add(node);

        while(!queue.isEmpty())
        {
            node = queue.remove();
            if(node.left() == null)
            {
                node.setLeft(new Node(value));
                return;
            }
            else if(node.right() == null)
            {
                node.setRight(new Node(value));
                return;
            }

            queue.add(node.left());
            queue.add(node.right());
        }
    }

    public boolean find(int value)
    {
        Queue<Node> queue = new LinkedList<>();
        Node node = root;
        queue.add(node);

        while(!queue.isEmpty())
        {
            node = queue.remove();
            if(node.value() == value)
            {
                return true;
            }

            if(node.left() != null)
            {
                queue.add(node.left());
            }
            if(node.right() != null)
            {
                queue.add(node.right());
            }
        }

        return false;
    }

    public void delete(int value)
    {
        recursiveDelete(root, value);
    }

    public Node getRoot()
    {
        return root;
    }

    private Node recursiveDelete(Node node, int value)
    {
        Node delete = null;
        if(node == null)
        {
            return null;
        }
        else if(node.value() == value)
        {
            if(node.left() == null && node.right() == null)
            {
                return null;
            }
            else if(node.left() == null)
            {
                return node.right();
            }
            else if(node.right() == null)
            {
                return node.left();
            }
            else
            {
                delete = findLeaf(node.left());
                node.setLeft(recursiveDelete(node.left(), delete.value()));
                node.setValue(delete.value());

                return node;
            }
        }
        if(node.left() != null)
        {
            node.setLeft(recursiveDelete(node.left(), value));
        }
        if(node.right() != null)
        {
            node.setRight(recursiveDelete(node.right(), value));
        }

            return node;
    }

    private Node findLeaf(Node node)
    {
        if(node.left() == null && node.right() == null)
        {
            return node;
        }
        else if(node.left() != null)
        {
            return findLeaf(node.left());
        }
        else
        {
            return findLeaf(node.right());
        }
    }

    private void inOrderRecursive(Node node)
    {
        if(node == null)
        {
            return;
        }

        inOrderRecursive(node.left());
        System.out.print(node.value() + " ");
        inOrderRecursive(node.right());
    }

    public void inOrder()
    {
        inOrderRecursive(root);
    }

    public void preOrder()
    {
        preOrderRecursive(root);
    }

    public void postOrder()
    {
        postOrderRecursive(root);
    }

    private void preOrderRecursive(Node node)
    {
        if(node == null)
        {
            return;
        }

        System.out.print(node.value() + " ");
        preOrderRecursive(node.left());
        preOrderRecursive(node.right());
    }

    private void postOrderRecursive(Node node)
    {
        if(node == null)
        {
            return;
        }

        postOrderRecursive(node.left());
        postOrderRecursive(node.right());
        System.out.print(node.value() + " ");
    }
}
