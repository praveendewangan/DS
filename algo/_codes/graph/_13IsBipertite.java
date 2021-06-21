import java.io.*;
import java.util.*;

public class _13IsBipertite {
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
   static class BPair {
       int vtx;
       int dt;
       BPair(int vtx,int dt) {
           this.vtx = vtx;
           this.dt = dt;
       }
   }
   private static boolean isBipertiteHelper(ArrayList<Edge>[] graph,int src,int[] vis) {
       Queue<BPair> q = new LinkedList<>();
       q.add(new BPair(src,0));
       
       while(q.size() > 0) {
           BPair rm = q.remove();
           
           if(vis[rm.vtx] != -1) {
               if(vis[rm.vtx] == rm.dt) {
                   continue;
               } else {
                   return false;
               }
           }
           vis[rm.vtx] = rm.dt;
           for(Edge e : graph[rm.vtx]) {
               int nbr = e.nbr;
               if(vis[nbr] == -1) {
                   q.add(new BPair(nbr,rm.dt+1));
               }
           }
       }
       return true;
   }
    private static boolean isBipertite(ArrayList<Edge>[] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        for(int v = 0; v < n; v++){
            if(vis[v] == -1) {
                if(!isBipertiteHelper(graph,v,vis)){
                    return false;
                }
            }
        }
        return true;
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
      System.out.println(isBipertite(graph));

      // write your code here
   }
}
