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
}