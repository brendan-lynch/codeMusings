import java.util.HashMap;
import java.util.Map;

class Trie {

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for(char c : word.toCharArray())
        {
            if(!cur.children.containsKey(c))
            {
                cur.children.put(c, new Node(c));
            }

            cur = cur.children.get(c);
        }

        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for(char c : word.toCharArray())
        {
            if(!cur.children.containsKey(c))
            {
                return false;
            }

            cur = cur.children.get(c);
        }

        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char c : prefix.toCharArray())
        {
            if(!cur.children.containsKey(c))
            {
                return false;
            }

            cur = cur.children.get(c);
        }

        return true;
    }

    private class Node
    {
        private char value;
        private boolean isWord;
        private Map<Character, Node> children;
        public Node(char c)
        {
            value = c;
            children = new HashMap<>();
        }

        public Node()
        {
            children = new HashMap<>();
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */