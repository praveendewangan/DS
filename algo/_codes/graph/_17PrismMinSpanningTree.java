import java.io.*;
import java.util.*;

public class _17PrismMinSpanningTree {
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
    static class Pair implements Comparable<Pair>{
        int vtx;
        int parent;
        int wsf;
        Pair(int vtx,int parent,int wsf) {
            this.vtx = vtx;
            this.parent = parent;
            this.wsf = wsf;
        }
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }
    private static void prism(ArrayList<Edge>[] graph){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,-1,0));
        boolean[] v = new boolean[graph.length];
        int n = graph.length;
        // min spanning tree
        ArrayList<Edge>[] mst = new ArrayList[n];
        for(int i=0;i < n; i++){
            mst[i] = new ArrayList<>();
        }
        while(pq.size() > 0) {
            Pair rm = pq.remove();
            if(v[rm.vtx]) {
                continue;
            }
            v[rm.vtx] = true;
            if(rm.parent != -1) {
                System.out.println("["+rm.vtx + "-" + rm.parent + "@" + rm.wsf+"]");
                // addEdge(mst,rm.vtx,rm.parent,rm.wsf);
                
            }
            for(Edge e : graph[rm.vtx]) {
                if(!v[e.nbr]) {
                    pq.add(new Pair(e.nbr,rm.vtx,e.wt));
                }
            }
        }
    }
    private static void addEdge(ArrayList<Edge>[] graph,int v1,int v2,int wt) {
        for (int i = 0; i < graph.length; i++) {
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
        prism(graph);
      // write your code here
   }

}
