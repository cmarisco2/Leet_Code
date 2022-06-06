import java.util.LinkedList;
import java.util.List;

/*
 * Mock up of typical implementation of an undirected graph (solely integer vertices)
 */

public class UndirectedGraph {
    private List<Integer> [] adj;
    private int edges;
    private int vertices;

    public UndirectedGraph(int v){
        this.vertices = v;
        this.edges = 0;

        adj = (List<Integer> [])new List[this.vertices];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        edges++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int getV(){ return this.vertices; }
    public int getE(){ return this.edges; }

    public void printGraph(){
        for(int v = 0; v < adj.length; v++){
            System.out.print(v + ": [");
            for(int w: adj(v)){
                System.out.print(w + " ");
            }
            System.out.println("]\n");
        }
    }

    public static void main(String[] args){
        //Create Graph G, with 6 vertices and 8 edges
        UndirectedGraph G = new UndirectedGraph(6);
        G.addEdge(0, 1);
        G.addEdge(0, 4);
        G.addEdge(0, 2);
        G.addEdge(1, 4);
        G.addEdge(4, 2);
        G.addEdge(4, 3);
        G.addEdge(2, 3);
        G.addEdge(2, 5);
        G.printGraph();
        System.out.println("\nNumber of Vertices: " + G.getV());
        System.out.println("\nNumber of Edges: " + G.getE());
    }
}