import java.io.*;
import java.util.*;

public class _9HamiltonionPath {
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
    private static void hamiltonion(ArrayList<Edge>[] graph,int start,int src,boolean[] visited,int c,int tar,String psf) {
        if(c == tar) {
            boolean flag = false;
            for(Edge e : graph[start]) {
                if(e.nbr == src) {
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println(psf+"*");
            } else {
                System.out.println(psf+".");
            }
            return;
        }
        visited[src] = true;
        for(Edge e : graph[src]) {
            if(!visited[e.nbr]) {
                hamiltonion(graph,start,e.nbr,visited,c+1,tar,psf+e.nbr);   
            }
        }
        visited[src] = false;
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

      int src = Integer.parseInt(br.readLine());
     boolean[] visited = new boolean[vtces];
     hamiltonion(graph,src,src,visited,1,vtces,src+"");
      
   }


}
