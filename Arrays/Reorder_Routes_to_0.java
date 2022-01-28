//? Problem Statement:
// There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

// Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

// This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

// Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

// It's guaranteed that each city can reach city 0 after reorder.

package Arrays;

//* Build Graph out of 2D array inputs for linear traversal

class Reorder_Routes_to_0 {
    public Node [] adj;
    public boolean [] visited;
    int count;
    int SOURCE;

    public Reorder_Routes_to_0(int size, int source){
        SOURCE = source;
        adj = new Node [size];
        visited = new boolean [size];
    }

    public void dfs(int source){
        visited[source] = true;
        if(adj(source).away && adj(source).vertex != SOURCE) count++;
        Node w = adj(source);
        for(int i = 0; w != null && i < w.size; i++, w = w.next){
            if(!visited[w.vertex]){
                dfs(w.vertex);
            }
        }
    }

    private class Node{
        int vertex;
        int size = 1;
        Boolean away;
        Node next;
    }

    // public int minReorder(int n, int[][] connections) {

    // }

    public void addEdge(int [] arr){
        Node from = new Node();
        Node to = new Node();

        from.vertex = arr[0];
        to.vertex = arr[1];

        from.away = false;
        to.away = true;

        to.next = adj[from.vertex];
        adj[from.vertex] = to;

        from.next = adj[to.vertex];
        adj[to.vertex] = from;
        from.size++;
        to.size++;

    }

    public Node adj(int vertex){
        return adj[vertex];
    }

    public static void demoCount(int theSize, int [][] connections, int source){
        int size = theSize;
        Reorder_Routes_to_0 nodes = new Reorder_Routes_to_0(size, source);
        for(int[] arr: connections)
            nodes.addEdge(arr);
        
        nodes.dfs(source);
        System.out.println("Number of edges to fix is: " + nodes.count);
    }

    public static void main(String[] args) {
        int source = 0;

        int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
        int size = 6;
        demoCount(size, connections, source); //expected output: 3
        
        int [][] edges = { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } };
        size = 5;
        demoCount(size, edges, source); //expected output: 2
        
        int [][] paths = { { 1, 0 }, { 2, 0} };
        size = 3;
        demoCount(size, paths, source); //expected output: 0
        
        int[][] tree = { { 0, 4 }, { 1, 0 }, { 1, 3 }, { 3, 5 }, { 5, 7 }, { 2, 4 }, { 2, 6 } };
        size = 8;
        demoCount(size, tree, source); //expected output: 5
    }
}