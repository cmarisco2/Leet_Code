import java.util.Stack;

public class DepthFirstPathsUndirected{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPathsUndirected(UndirectedGraph G, int source){
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        s = source;

        dfs(G, s);
    }

    public DepthFirstPathsUndirected(UndirectedGraph G) {
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        s = 0;

        dfs(G, s);
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public void dfs(UndirectedGraph G, int v){
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for(int i = v; i != this.s; i = edgeTo[i]) path.push(i);
        path.push(this.s);
        return path;
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

        DepthFirstPathsUndirected path = new DepthFirstPathsUndirected(G);
        int source = 4;
        System.out.println("\nPath from " + source + ":\n");
        for(int v : path.pathTo(source)){
            System.out.print(v + " ");
        }
    }
}