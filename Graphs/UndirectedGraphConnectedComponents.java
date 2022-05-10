import java.util.LinkedList;
import java.util.List;

public class UndirectedGraphConnectedComponents {
    List<Integer>[] adj;
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        // Number of Connected Components
        int connectedComponents = 0;

        // Visited Set
        visited = new boolean[n];

        // Build Graph Adjacency List
        adj = (LinkedList<Integer>[]) new LinkedList[n];
        for (int i = 0; i < adj.length; i++)
            adj[i] = new LinkedList<>();

        // Add All Edges to the Adjacency List
        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            adj[v].add(w);
            adj[w].add(v);
        }

        // Peform A Depth First Search on all unvisited nodes
        // increment each time dfs needs to be performed
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                connectedComponents++;
            }
        }
        // Return # of connected components
        return connectedComponents;

    }

    // dfs and mark all connected nodes as visited
    public void dfs(int source) {
        visited[source] = true;
        List<Integer> li = adj[source];
        for (int v : li) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
}