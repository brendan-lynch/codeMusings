public class Solution {

    public static void main(String[] args)
    {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple") + " == true");
        System.out.println(t.search("app") + " == false");
        System.out.println(t.startsWith("apple") + " == true");
        t.insert("app");
        System.out.println(t.search("app") + " == true");
    }
}
