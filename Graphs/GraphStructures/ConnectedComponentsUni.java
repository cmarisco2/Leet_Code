import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedComponentsUni<Vertex>{
    private Set<Vertex> visited;
    private Map<Vertex, Integer> id;
    private int count;

    public ConnectedComponentsUni(UniGraph G){
        visited = new HashSet<>();
        id = new HashMap<>();
        count = 0;

        for(Vertex v : (List<Vertex>)G.vertices()){
            if(!visited.contains(v)){
                dfs(G, v);
                count++;
            }
        }
    }

    public int id(Vertex v){
        return id.get(v);
    }

    public boolean connected(Vertex v, Vertex w){
        return id(v) == id(w);
    }

    public int count(){
        return this.count;
    }

    public void dfs(UniGraph G, Vertex vertex) {
        visited.add(vertex);
        id.put(vertex, count);
        for (Vertex v : (Iterable<Vertex>) G.adj(vertex)) {
            if (!visited.contains(v)) {
                dfs(G, v);
            }
        }
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
    }
}