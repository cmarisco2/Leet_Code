public class ConnectedComponentsUndirected{
    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponentsUndirected(UndirectedGraph G){
        marked = new boolean[G.getV()];
        id = new int[G.getV()];
        count = 0;

        //Count Components
        for(int v = 0; v < G.getV(); v++){
            if(!marked[v]){
                dfs(G, v);
                count++;
            }
        }
        
    }

    //Check if to vertices are connected
    public boolean connected(int v, int w){
        return id(v) == id(w);
    }

    //Discloses the number of connected components
    public int count(){
        return this.count;
    }

    //return component id
    public int id(int v){
        return id[v];
    }

    //dfs
    public void dfs(UndirectedGraph G, int vertex) {
        marked[vertex] = true;
        id[vertex] = count;
        for (int v : G.adj(vertex)) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    public static void main(String[] args) {
        // Create Graph G, with 6 vertices and 8 edges
        UndirectedGraph G = new UndirectedGraph(6);
        G.addEdge(0, 5);
        G.addEdge(0, 3);
        G.addEdge(3, 5);
        G.addEdge(5, 4);
        G.addEdge(1, 2);
        G.printGraph();
        System.out.println("\nNumber of Vertices: " + G.getV());
        System.out.println("\nNumber of Edges: " + G.getE());

        ConnectedComponentsUndirected cc = new ConnectedComponentsUndirected(G);
        System.out.println("Number of Connected Components: " + cc.count());
        int v = 3, w = 5, z = 2;
        System.out.println("Component " + v + " is connected to " + w + "?:\n");
        System.out.println(cc.connected(v, w));
        System.out.println();
        System.out.println("id of " + v + " is: " + cc.id(v));
        System.out.println("id of " + w + " is: " + cc.id(w));
        System.out.println();
        System.out.println("Component " + v + " is connected to " + z + "?:\n");
        System.out.println(cc.connected(v, z));
        System.out.println();
        System.out.println("id of " + v + " is: " + cc.id(v));
        System.out.println("id of " + z + " is: " + cc.id(z));

    }
}