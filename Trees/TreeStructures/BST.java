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
        if(x == null) return 0;
        return x.size;
    }

    public void printPreOrderKeys(){
        printPreOrderKeys(this.root);
    }
    private void printPreOrderKeys(Node x){
        if(x == null) return;
        System.out.print(x.key + " ");
        printPreOrderKeys(x.left);
        printPreOrderKeys(x.right);
    }
    public void printPreOrderValues(){
        printPreOrderValues(this.root);
    }
    private void printPreOrderValues(Node x){
        if(x == null) return;
        System.out.print(x.val + " ");
        printPreOrderValues(x.left);
        printPreOrderValues(x.right);
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

        //Test PreOrder Traversal
        System.out.println();
        treeMap.printPreOrderKeys(); //fdcemhirov
        System.out.println();
        treeMap.printPreOrderValues(); //associated values of preorder keys
    }
}