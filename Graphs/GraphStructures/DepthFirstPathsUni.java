import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DepthFirstPathsUni<Vertex>{
    private Set<Vertex> visited;
    private Map<Vertex, Vertex> edgeTo;
    private Vertex source;

    public DepthFirstPathsUni(UniGraph G, Vertex s){
        visited = new HashSet<>();
        edgeTo = new HashMap<>();
        for(Vertex v :(List<Vertex>) G.vertices()){
            edgeTo.put(v, null);
        }
        source = s;

        dfs(G, source);
    }

    public void dfs(UniGraph G, Vertex v){
        visited.add(v);
        for(Vertex w: (Iterable<Vertex>)G.adj(v)){
            if(!visited.contains(w)){
                edgeTo.put(w, v);
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(Vertex v){
        return visited.contains(v);
    }

    public Iterable<Vertex> pathTo(Vertex given){
        LinkedList<Vertex> result = new LinkedList<>();
        while(given != null){
            result.addFirst(given);
            given = edgeTo.get(given);
        }
        return result;
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
        String source = "orange";
        String destination = "grape";
        DepthFirstPathsUni<String> path = new DepthFirstPathsUni<String>(foodGraph, source);
        System.out.println("\nPath from " + source + " to " + destination + ":\n");
        for(String s : path.pathTo(destination)){
            System.out.print(s + " ");
        }
    }
}