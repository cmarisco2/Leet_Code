import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class UniGraphBFS<Vertex>{
    private Set<Vertex> visited;
    private List<Vertex> vertices;



    public UniGraphBFS(UniGraph<Vertex> G, Vertex source){
        visited = new HashSet<>();
        vertices = G.vertices();
        bfs(G, source);
    }

    public void bfs(UniGraph<Vertex> G, Vertex v){
        Queue<Vertex> q = new LinkedList<>();
        visited.add(v);
        q.add(v);
        while(!q.isEmpty()){
            Vertex w = q.remove();
            for(Vertex x : (Iterable<Vertex>)G.adj(w)){
                if(!visited.contains(x)){
                    visited.add(x);
                    q.add(x);
                }
            }
        }
    }

    public boolean isCompletelyConnected(){
        for(Vertex v : this.vertices){
            if(!visited.contains(v)) return false;
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

        System.out.println("\nRun BFS on our Graph");
        UniGraphBFS<String> process = new UniGraphBFS<>(foodGraph, "apple");
        System.out.println("\nIs our Graph Completely Connected: " + process.isCompletelyConnected());
    }
}