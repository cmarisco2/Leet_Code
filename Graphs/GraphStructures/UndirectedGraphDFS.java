public class UndirectedGraphDFS{
    private boolean[] marked;
    int source;


    public UndirectedGraphDFS(UndirectedGraph G, int source) {
        marked = new boolean[G.getV()];
        this.source = source;

        dfs(G, source);
    }

    /*
     * Template for dfs
     * 1) Mark current vertex 
     * 2) For all vertices adjacent to current vertex
     *      -if not already marked
     *      -Go to adjacent vertex
     */
    public void dfs(UndirectedGraph G, int vertex){
        //* 1
        marked[vertex] = true;
        //* 2
        for(int v : G.adj(vertex)){
            if(!marked[v]){
                dfs(G, v);
            }
        }
    }

    public boolean isCompletelyConnected(){
        for(int i = 0; i < marked.length; i++){
            if(!marked[i]) return false;
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

        System.out.println("\nRun DFS on our Graph");
        UndirectedGraphDFS process = new UndirectedGraphDFS(G, 0);
        System.out.println("\nIs our Graph Completely Connected: " + process.isCompletelyConnected());

    }

}