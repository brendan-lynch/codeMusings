public class BST {
    private Node root;

    public BST(int value)
    {
        root = new Node(value);
    }

    public void insert(int value)
    {
        insertRecursive(root, value);
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

    public boolean find(int value)
    {
        return findRecursive(root, value);
    }

    public void delete(int value)
    {
        root = deleteRecursive(root, value);
    }

    public Node getRoot()
    {
        return root;
    }

    private Node deleteRecursive(Node node, int value)
    {
        if(node == null)
        {
            return null;
        }
        // This is the node to delete
        else if(value == node.value())
        {
            if(node.left() == null && node.right() == null)
            {
                return null;
            }
            else if(node.left() == null && node.right() != null)
            {
                return node.right();
            }
            else if(node.left() != null && node.right() == null)
            {
                return node.left();
            }
            else
            {
                // Delete the max node from the left tree and modify the existing node in place.
                int max = findMax(node.left());
                node.setValue(max);
                node.setLeft(deleteRecursive(node.left(), max));

                return node;
            }
        }
        else if(value < node.value())
        {
            node.setLeft(deleteRecursive(node.left(), value));

            return node;
        }
        else
        {
            node.setRight(deleteRecursive(node.right(), value));

            return node;
        }
    }

    private boolean findRecursive(Node node, int value)
    {
        if(node == null)
        {
            return false;
        }
        else if(node.value() == value)
        {
            return true;
        }
        else if(value < node.value())
        {
            return findRecursive(node.left(), value);
        }
        else
        {
            return findRecursive(node.right(), value);
        }
    }

    private int findMin(Node node)
    {
        if(node.left() == null)
        {
            return node.value();
        }
        else
        {
            return findMin(node.left());
        }
    }

    private int findMax(Node node)
    {
        if(node.right() == null)
        {
            return node.value();
        }
        else
        {
            return findMax(node.right());
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

    private void insertRecursive(Node root, int value)
    {
        if(value < root.value())
        {
            if(root.left() != null)
            {
                insertRecursive(root.left(), value);
            }
            else
            {
                root.setLeft(new Node(value));
            }
        }
        else
        {
            if(root.right() != null)
            {
                insertRecursive(root.right(), value);
            }
            else
            {
                root.setRight(new Node(value));
            }
        }
    }
}
