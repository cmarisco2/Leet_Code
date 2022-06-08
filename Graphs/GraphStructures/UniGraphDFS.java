import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniGraphDFS<Vertex>{
    private Set<Vertex> visited;
    private List<Vertex> vertices;

    public UniGraphDFS(UniGraph G, Vertex source){
        visited = new HashSet<>();
        vertices = G.vertices();
        dfs(G, source);
    }

    /*
     * Template for dfs
     * 1) Mark current vertex
     * 2) For all vertices adjacent to current vertex
     * -if not already marked
     * -Go to adjacent vertex
     */
    public void dfs(UniGraph G, Vertex vertex) {
        // * 1
        visited.add(vertex);
        // * 2
        for (Vertex v : (Iterable<Vertex>)G.adj(vertex)) {
            if (!visited.contains(v)) {
                dfs(G, v);
            }
        }
    }

    public boolean isCompletelyConnected() {
        for(Vertex v : vertices){
            if (!visited.contains(v)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        UniGraph<String> foodGraph = new UniGraph<>();
        foodGraph.addEdge("apple", "banana");
        foodGraph.addEdge("apple", "kiwi");
        foodGraph.addEdge("apple", "orange");
        foodGraph.addEdge("banana", "grapefruit");
        foodGraph.addEdge("banana", "grape");
        foodGraph.addEdge("grapefruit", "grape");
        foodGraph.addEdge("kiwi", "orange");
        System.out.println("\nNumber of Vertices: " + foodGraph.getV());
        System.out.println("Number of Edges: " + foodGraph.getE());
        System.out.println();
        foodGraph.printGraph();
        System.out.println();
        System.out.println("\nRun DFS on our Graph");
        UniGraphDFS<String> process = new UniGraphDFS<String>(foodGraph, "apple");
        System.out.println("\nIs our Graph Completely Connected: " + process.isCompletelyConnected());
    }
}