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

    //Check if to vertices are connected
    public boolean connected(int v, int w){
        return id(v) == id(w);
    }

    //Discloses the number of connected components
    public int count(){
        return this.count;
    }

    //return component id
    public int id(int v){
        return id[v];
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