import java.io.*;
import java.util.*;

public class _14SpreadInfection {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
    static class BPair {
        int vtx;
        int level;
        BPair(int vtx,int level) {
            this.vtx = vtx;
            this.level = level;
        }
    }
    private static int spreadCount(ArrayList<Edge>[] graph,int src,int t) {
        Queue<BPair> q = new LinkedList<>();
        q.add(new BPair(src,1));
        boolean[] v = new boolean[graph.length];
        int count = 0;
        while(q.size() > 0) {
            BPair rm = q.remove();
            if(rm.level > t) {
                break;
            }
            if(v[rm.vtx]) {
                continue;
            } else {
                count++;
                v[rm.vtx] = true;
                for(Edge e : graph[rm.vtx]) {
                    if(!v[e.nbr]) {
                        q.add(new BPair(e.nbr,rm.level+1));
                    }
                }
            }
            
        }
        // for(boolean val : v) {
        //     if(val) count++;
        // }
        return count;
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
      int t = Integer.parseInt(br.readLine());
      
      System.out.println(spreadCount(graph,src,t));
   }

}
