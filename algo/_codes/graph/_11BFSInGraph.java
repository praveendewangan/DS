import java.io.*;
import java.util.*;

public class _11BFSInGraph {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
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

    private static void bfs(ArrayList<Edge>[] graph,int src) {
        Queue<BFSPair> q = new ArrayDeque<>();
        q.add(new BFSPair(src,src+""));
        boolean[] v = new boolean[graph.length];
        while(q.size() > 0) {
            BFSPair rm = q.remove();
            if(v[rm.vt]) {
                continue;
            } else {
                v[rm.vt] = true;
                System.out.println(rm.vt + "@" +rm.psf);
                for(Edge e : graph[rm.vt]) {
                    if(!v[e.nbr]) {
                        q.add(new BFSPair(e.nbr,rm.psf+e.nbr));
                    }
                }
            }
        }
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      bfs(graph,src);  
   }
}
