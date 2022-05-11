import java.util.Arrays;

public class UnionFindConnectedComponents {
    int[] id;
    int[] sz;
    boolean[] visited;

    public int countComponents(int n, int[][] edges) {
        int connectedComponents = 0;
        visited = new boolean[n];
        // build UF array
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
        // build size array
        sz = new int[n];
        Arrays.fill(sz, 1);

        // Union Nodes
        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            union(v, w);
        }

        // Count ConnectedComponents
        for (int i = 0; i < n; i++) {
            int key = root(i);
            if (!visited[key]) {
                visited[key] = true;
                connectedComponents++;
            }
        }

        // Return Result
        return connectedComponents;
    }

    public int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}