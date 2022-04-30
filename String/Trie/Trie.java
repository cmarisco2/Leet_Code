class Trie{
    private Node root;
    private static final int R = 26;

    private class Node {
        Character letter;
        boolean found;
        Node[] next;

        Node() {
            letter = null;
            found = false;
            next = new Node[R];
        }

        Node(char ch) {
            letter = ch;
            found = false;
            next = new Node[R];
        }
    }

    public Trie() {
        root = new Node();
    }

    private int toIndex(char ch) {
        return ch - 'a';
    }

    public void insert(String word) {
        char key = word.charAt(0);
        int index = toIndex(key);
        root.next[index] = insert(root.next[index], word, 0);
    }

    private Node insert(Node x, String word, int d) {
        char key = word.charAt(d); // 'a'
        int index = toIndex(key); // 0

        if (x == null) {
            x = new Node(key);
        }

        if (d == word.length() - 1) {
            x.found = true;
            return x;
        }

        key = word.charAt(d + 1); // 'p'
        index = toIndex(key); // 16

        x.next[index] = insert(x.next[index], word, d + 1);
        return x;

    }

    public boolean search(String word) {
        char ch = word.charAt(0);
        int index = toIndex(ch);

        Node x = search(root.next[index], word, 0);
        if (x == null)
            return false;
        return x.found;
    }

    private Node search(Node x, String word, int d) {
        if (x == null)
            return null;
        if (d == word.length() - 1)
            return x;
        char ch = word.charAt(d + 1);
        int index = toIndex(ch);
        return search(x.next[index], word, d + 1);
    }

    public boolean startsWith(String prefix) {
        return true;
    }
}