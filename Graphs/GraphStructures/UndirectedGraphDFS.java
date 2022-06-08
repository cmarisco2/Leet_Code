public class UndirectedGraphDFS{
    private boolean[] marked;


    public UndirectedGraphDFS(UndirectedGraph G) {
        marked = new boolean[G.getV()];
    }

}