package TreeStructures;

import java.util.LinkedList;
import java.util.Queue;

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
    //* put Key */
    public void put(Key key, Value val){
        this.root = put(this.root, key, val);
    }

    private Node put(Node x, Key key, Value val){
        if(x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    //* get Value */
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
    //* Key Min */
    public Key min(){
        return min(this.root).key;
    }
    private Node min(Node x){
        // 2 Base Cases
        if(x == null) return null;
        if(x.left == null) return x;
        //STOP & RETURN when found 
        return min(x.left); 
    }
     //* Key Max */
    public Key max(){
        return max(this.root).key;
    }

    private Node max(Node x){
        if(x == null) return null;
        if(x.right == null) return x;
        return max(x.right);
    }
    //* Node size */
    public int size(){
        return this.root.size;
    }
    private int size(Node x){
        if(x == null) return 0;
        return x.size;
    }

    //* floor() */
    public Key floor(Key key){
        Node x = floor(this.root, key);
        if(x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return floor(x.left, key);
        if(cmp == 0) return x;
        //* returns x, if the right path doesn't have a larger floor.
        //* utilizes separate Node ref, local to this method
        Node t = floor(x.right, key);
        if(t != null) return t;
        else return x;
    }
    //* ceiling() */
    public Key ceiling(Key key){
        Node x = ceiling(this.root, key);
        if(x == null) return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0) return ceiling(x.right, key);
        if(cmp == 0) return x;
        Node t = ceiling(x.left, key);
        if(t != null) return t;
        else return x;
    }

    //* deleteMin() */
    public void deleteMin(){
        root = deleteMin(root);
    }

    //improved deleteMin to delete the min of a subtree not from root
    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    //* deleteMax() */
    public void deleteMax(){
        root = deleteMax(root);
    }
    private Node deleteMax(Node x){
        // if(x == null) return null;
        // Node t = max(this.root);
        // if(t == x.right) x.right = t.left;
        // x.right = deleteMax(x.right);
        if(x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    //* delete any node via Hibbard deletion */
    public void delete(Key key){
        root = delete(this.root, key);
    }

    private Node delete(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left, key);
        else if(cmp > 0) x.right = delete(x.right, key);
        else {
            if(x.left == null) return x.right;
            if(x.right == null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
            return x;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    //? Key Traversals
    //* PreOrder Key Traversal */
    public void printPreOrderKeys(){
        printPreOrderKeys(this.root);
    }
    private void printPreOrderKeys(Node x){
        if(x == null) return;
        System.out.print(x.key + " ");
        printPreOrderKeys(x.left);
        printPreOrderKeys(x.right);
    }
    //* InOrder Key Traversal */
    public void printInOrderKeys(){
        printInOrderKeys(this.root);
    }
    private void printInOrderKeys(Node x){
        if(x == null) return;
        printInOrderKeys(x.left);
        System.out.print(x.key + " ");
        printInOrderKeys(x.right);
    }
    //* PostOrder Key Traversal */
    public void printPostOrderKeys(){
        printPostOrderKeys(this.root);
    }
    private void printPostOrderKeys(Node x){
        if(x == null) return;
        printPostOrderKeys(x.left);
        printPostOrderKeys(x.right);
        System.out.print(x.key + " ");
    }
    //? Value Traversals
    //* PreOrder Value Traversal */
    public void printPreOrderValues(){
        printPreOrderValues(this.root);
    }
    private void printPreOrderValues(Node x){
        if(x == null) return;
        System.out.print(x.val + " ");
        printPreOrderValues(x.left);
        printPreOrderValues(x.right);
    }
    //* InOrder Value Traversal */
    public void printInOrderValues(){
        printInOrderValues(this.root);
    }
    private void printInOrderValues(Node x){
        if(x == null) return;
        printInOrderValues(x.left);
        System.out.print(x.val + " ");
        printInOrderValues(x.right);
    }
    //* PostOrder Value Traversal */
    public void printPostOrderValues(){
        printPostOrderValues(this.root);
    }
    private void printPostOrderValues(Node x){
        if(x == null) return;
        printPostOrderValues(x.left);
        printPostOrderValues(x.right);
        System.out.print(x.val + " ");
    }

    //? Key Ranges
    public Iterable<Key> keys(){
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> q = new LinkedList<>();
        keys(root, lo, hi, q);
        return q;
    }
    private void keys(Node x,  Key lo, Key hi, Queue<Key> q){
        if(x == null) return;
        int loLimit = lo.compareTo(x.key);
        int hiLimit = hi.compareTo(x.key);
        //* In order traversal & add keys in range */
        if(loLimit < 0) keys(x.left, lo, hi, q);
        if(loLimit <= 0 && hiLimit >= 0) q.add(x.key);
        if(hiLimit > 0) keys(x.right, lo, hi, q);
    }

    public static void main(String[] args){
        //Construct a new BST
        BST<Character, String> treeMap = new BST<>();

        //Test putting keys in tree map
        treeMap.put('f', "FaceTime");
        treeMap.put('m', "Melody");
        treeMap.put('h', "Hello");
        treeMap.put('i', "Intelligence");
        treeMap.put('r', "Rags");
        treeMap.put('v', "Volume");
        treeMap.put('o', "Organize");
        treeMap.put('d', "Dangerous");
        treeMap.put('c', "Christopher");
        treeMap.put('e', "Equality");

        //Test retrieval API for the keys
        System.out.println("\nWord at key e is: " + treeMap.get('e'));
        System.out.println("\nWord at key v is: " +  treeMap.get('v'));
        System.out.println("\nWord at key f is: " +  treeMap.get('f'));
        System.out.println("\nNumber of Tree Elements: " + treeMap.size());
        System.out.println("\nMinimum Char entered: " + treeMap.min());
        System.out.println("\nMaximum Char entered: " + treeMap.max());
        
        //Test PreOrder Traversal
        System.out.println();
        treeMap.printPreOrderKeys(); //fdcemhirov
        System.out.println();
        treeMap.printPreOrderValues(); //associated values of preorder keys
        //Test InOrder Traversal
        System.out.println();
        treeMap.printInOrderKeys(); //cdefhimorv
        System.out.println();
        treeMap.printInOrderValues(); //associated values of inorder keys
        //Test PostOrder Traversal
        System.out.println();
        treeMap.printPostOrderKeys(); // cedihovrmf
        System.out.println();
        treeMap.printPostOrderValues(); //associated values of postorder keys
        
        // Floors
        System.out.println("\n\nFloor of key: 'b' is: " + treeMap.floor('b'));
        System.out.println("\nFloor of key: 'c' is: " + treeMap.floor('c'));
        System.out.println("\nFloor of key: 'g' is: " + treeMap.floor('g'));
        
        // Ceilings
        System.out.println("\n\nCeiling of key: 'b' is: " + treeMap.ceiling('b'));
        System.out.println("\nCeiling of key: 'c' is: " + treeMap.ceiling('c'));
        System.out.println("\nCeiling of key: 'g' is: " + treeMap.ceiling('g'));
        
        // //Delete min and print
        // System.out.println("\nDeleted min key char: " + treeMap.min());
        // treeMap.deleteMin();
        // System.out.println("\nNew min key char: " + treeMap.min());
        // System.out.println("\nDeleted min key char: " + treeMap.min());
        // treeMap.deleteMin();
        // System.out.println("\nNew min key char: " + treeMap.min());
        
        // //Delete max and print
        // System.out.println("\nDeleted max key char: " + treeMap.max());
        // treeMap.deleteMax();
        // System.out.println("\nNew max key char: " + treeMap.max());
        // System.out.println("\nDeleted max key char: " + treeMap.max());
        // treeMap.deleteMax();
        // System.out.println("\nNew max key char: " + treeMap.max());
        // // check tree size counts -> 6
        // System.out.println("\nNumber of Tree Elements: " + treeMap.size());

        // System.out.println("\n\nDelete element d: ");
        // treeMap.delete('d');
        // System.out.println("\nIn order traversal without d: ");
        // treeMap.printInOrderKeys();

        //Print out keys with iterable:
        System.out.println();
        for(char k : treeMap.keys('d', 'i')){
            System.out.print(k + " ");
        }
    }
}