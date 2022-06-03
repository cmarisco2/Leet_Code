package TreeStructures;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackBST<Key extends Comparable<Key>, Value>{
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int size;
        boolean color;

        public Node(Key key, Value val, int size, boolean color) {
            this.key = key;
            this.val = val;
            this.size = size;
            this.color = color;
        }
    }

    //*  RED BLACK VERSION put Key & Value */
    public void put(Key key, Value val) {
        this.root = put(this.root, key, val);
        root.color = BLACK;
    }
    
    //! Need to update w/ ROTATIONS
    private Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        //* Code to maintain balance */
        if(isRed(x.right) && !isRed(x.left)) x = leftRotate(x);
        if(isRed(x.left) && isRed(x.left.left)) x = rightRotate(x);
        if(isRed(x.left) && isRed(x.right)) flipColors(x);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    // * get Value */
    public Value get(Key key) {
        return get(this.root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }
    //* Left Rotation */
    private Node leftRotate(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }
    //* Right Rotation */
    private Node rightRotate(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    //* Flip Colors */
    private void flipColors(Node x){
        x.left.color = BLACK;
        x.right.color = BLACK;
        x.color = RED;
    }

    //* isRed */
    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }

    // * Node size */
    public int size() {
        return this.root.size;
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        return x.size;
    }

    // * Key Min */
    public Key min() {
        return min(this.root).key;
    }

    private Node min(Node x) {
        // 2 Base Cases
        if (x == null)
            return null;
        if (x.left == null)
            return x;
        // STOP & RETURN when found
        return min(x.left);
    }

    // * Key Max */
    public Key max() {
        return max(this.root).key;
    }

    private Node max(Node x) {
        if (x == null)
            return null;
        if (x.right == null)
            return x;
        return max(x.right);
    }

    // * floor() */
    public Key floor(Key key) {
        Node x = floor(this.root, key);
        if (x == null)
            return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return floor(x.left, key);
        if (cmp == 0)
            return x;
        // * returns x, if the right path doesn't have a larger floor.
        // * utilizes separate Node ref, local to this method
        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    // * ceiling() */
    public Key ceiling(Key key) {
        Node x = ceiling(this.root, key);
        if (x == null)
            return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0)
            return ceiling(x.right, key);
        if (cmp == 0)
            return x;
        Node t = ceiling(x.left, key);
        if (t != null)
            return t;
        else
            return x;
    }
    
    // ? Key Ranges
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new LinkedList<>();
        keys(root, lo, hi, q);
        return q;
    }

    private void keys(Node x, Key lo, Key hi, Queue<Key> q) {
        if (x == null)
            return;
        int loLimit = lo.compareTo(x.key);
        int hiLimit = hi.compareTo(x.key);
        // * In order traversal & add keys in range */
        if (loLimit < 0)
            keys(x.left, lo, hi, q);
        if (loLimit <= 0 && hiLimit >= 0)
            q.add(x.key);
        if (hiLimit > 0)
            keys(x.right, lo, hi, q);
    }
}