public class ConnectedComponentsUndirected{
    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponentsUndirected(UndirectedGraph G){
        marked = new boolean[G.getV()];
        id = new int[G.getV()];
        count = 0;

        //Count Components
        for(int v = 0; v < G.getV(); v++){
            if(!marked[v]){
                dfs(G, v);
                count++;
            }
        }
        
    }

    //dfs
    public void dfs(UndirectedGraph G, int vertex) {
        marked[vertex] = true;
        id[vertex] = count;
        for (int v : G.adj(vertex)) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }
}