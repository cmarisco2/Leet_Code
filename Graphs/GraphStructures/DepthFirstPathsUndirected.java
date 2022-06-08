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
}