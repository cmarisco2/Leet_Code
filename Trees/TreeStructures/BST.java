package TreeStructures;

public class BST<Key extends Comparable<Key>, Value>{
    private Node root;

    private class Node{
        Key key;
        Value val;
        Node left, right;
        int size;

        public Node(Key key, Value val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public void put(Key key, Value val){
        this.root = put(this.root, key, val);
    }

    private Node put(Node x, Key key, Value val){
        if(x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.size = size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key){
        return get(this.root, key);
    }

    private Value get(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public int size(Node x){
        return x.size;
    }

    public static void main(String[] args){
        
    }
}