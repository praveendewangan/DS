import java.util.*;

public class _20CycleInDirectedGraph2 {
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        boolean[] myPath = new boolean[V];
        for(int v = 0; v < V; v++){
            if(!visited[v] && dfs(adj,v,visited,myPath)) {
                return true;
            }
        }
        return false;
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> adj,int src,boolean[] visited,boolean[] myPath) {
        visited[src] = true;
        myPath[src] = true;
        for(int nbr : adj.get(src)) {
            if(myPath[nbr]) {
                return true;
            } else if(!visited[nbr] && dfs(adj,nbr,visited,myPath)){
                return true;
            }
        }
        myPath[src] = false;
        return false;
    }
}
