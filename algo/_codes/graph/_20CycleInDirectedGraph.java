import java.util.*;
public class _20CycleInDirectedGraph {
        //Function to detect cycle in a directed graph.
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
        {
            boolean[] visited = new boolean[V];
            for(int v = 0; v < V; v++){
                if(dfs(adj,v,visited)) {
                    return true;
                }
            }
            return false;
        }
        private boolean dfs(ArrayList<ArrayList<Integer>> adj,int src,boolean[] visited) {
            visited[src] = true;
            for(int nbr : adj.get(src)) {
                if(visited[nbr]) {
                    return true;
                } else if(dfs(adj,nbr,visited)){
                    return true;
                }
            }
            visited[src] = false;
            return false;
        }
}
