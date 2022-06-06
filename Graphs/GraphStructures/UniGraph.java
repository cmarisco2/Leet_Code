import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UniGraph<Vertex>{
    private Map<Vertex, List<Vertex>> adj;
    private int V;
    private int E;

    public UniGraph(){
        adj = new HashMap<>();
        V = 0;
        E = 0;
    }

    public void addEdge(Vertex v1, Vertex v2){
        if(!adj.containsKey(v1)){
            adj.put(v1, new LinkedList<>());
            V++;
        }
        if(!adj.containsKey(v2)){
            adj.put(v2, new LinkedList<>());
            V++;
        }
        adj.get(v1).add(v2);
        adj.get(v2).add(v1);
        E++;
    }

    public Iterable<Vertex> adj(Vertex v){
        return adj.get(v);
    }

    public int getV() { return this.V; }
    public int getE() { return this.E; }
}