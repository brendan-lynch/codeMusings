public class Solution {

    public static void main(String[] args)
    {
        BST bst = new BST(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(5);
        bst.insert(8);
        bst.insert(6);
        bst.insert(13);

        System.out.println("Sanity check");
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();

        System.out.println("Delete 13");
        bst.delete(13);
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();

        System.out.println("Delete 7");
        bst.delete(7);
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();

        System.out.println("insert 13, delete 12");
        bst.insert(13);
        bst.delete(12);
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();

        System.out.println("insert 4, delete 5");
        bst.insert(4);
        bst.delete(5);
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();

        System.out.println("delete root, 10");
        bst.delete(10);
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();

        System.out.println("Find 4: " + bst.find(4));
        System.out.println("Find 13: " + bst.find(13));
        System.out.println("Find 8: " + bst.find(8));
        System.out.println("Find 100: " + bst.find(100));
    }
}
