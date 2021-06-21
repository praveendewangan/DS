import java.io.*;
import java.util.*;

public class _12IsGraphCyclic {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

    static class BFSPair {
        int vt;
        String psf;
        BFSPair(int vt,String psf){
            this.vt = vt;
            this.psf = psf;
        }
    }
    private static boolean isCyclicHelper(ArrayList<Edge>[] graph,int src,boolean[] v) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        while(q.size() > 0) {
            int rm = q.remove();
            if(v[rm]) {
                return true;
            } else {
                v[rm] = true;
                for(Edge e : graph[rm]) {
                    if(!v[e.nbr]) {
                        q.add(e.nbr);
                    } 
                }
            }
        }
        return false;
        
    }
    private static boolean isCyclic(ArrayList<Edge>[] graph) {
        
        boolean[] v = new boolean[graph.length];
        for(ArrayList<Edge> list : graph){
            for(Edge e : list) {
                if(!v[e.nbr]){
                    if(isCyclicHelper(graph,e.nbr,v)){
                       return true; 
                    }
                }
            }
        }
        return false;
    }
    
    // Using DFS
    private static boolean dfs(ArrayList<Edge>[] graph,int src,boolean[] v,int par) {
        v[src] = true;
        for(Edge e : graph[src]) {
            int nbr = e.nbr;
            if(v[nbr] && nbr != par) {
                return true;
            }
            if(!v[nbr]) {
                if(dfs(graph,nbr,v,src)) {
                    return true;
                }
            }
        }
        return false;
    }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }    
      System.out.println(isCyclic(graph));
   }
}