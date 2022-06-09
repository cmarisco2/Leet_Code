import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphBFS {
    private boolean[] marked;
    private int s;

    public UndirectedGraphBFS(UndirectedGraph G, int source){
        marked = new boolean[G.getV()];
        s = source;

        bfs(G, s);
    }

    private void bfs(UndirectedGraph G, int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;
        while(!q.isEmpty()){
            int v = q.remove();
            for(int w : G.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
    }

    public boolean isCompletelyConnected() {
        for (int i = 0; i < marked.length; i++) {
            if (!marked[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Create Graph G, with 6 vertices and 8 edges
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

        System.out.println("\nRun BFS on our Graph");
        UndirectedGraphBFS process = new UndirectedGraphBFS(G, 0);
        System.out.println("\nIs our Graph Completely Connected: " + process.isCompletelyConnected());

    }
}