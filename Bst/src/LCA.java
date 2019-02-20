public class LCA {
    private BST bst;

    public LCA(BST bst)
    {
        this.bst = bst;
    }

    /*
        Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common Ancestor (LCA).
        You may assume that both the values exist in the tree.
    */
    public int solve(int a, int b)
    {
        Node node = solveRecusive(bst.getRoot(), a, b);

        return node.value();
    }

    private Node solveRecusive(Node node, int a, int b)
    {
        if(node == null)
        {
            return null;
        }
        else if(a > node.value() && b > node.value())
        {
            return solveRecusive(node.right(), a, b);
        }
        else if(a < node.value() && b < node.value())
        {
            return solveRecusive(node.left(), a, b);
        }

        return node;
    }

}
