import java.io.*;
import java.util.*;

public class _6IsGraphConnected {
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
private static void getConnectedComp(ArrayList<Edge>[] graph,List<Integer> comp,int v,boolean[] visited){
    visited[v] = true;
    comp.add(v);
    for(Edge e : graph[v]) {
        if(!visited[e.nbr]) {
            getConnectedComp(graph,comp,e.nbr,visited);
        }
    }
}   
    private static boolean isGraphConnected(ArrayList<Edge>[] graph){
        int vtces = graph.length;
      List<List<Integer>> comps = new ArrayList<>();
      boolean[] visited = new boolean[vtces];
      int count = 0;
      for(int v = 0; v < vtces; v++){
          if(!visited[v]){
              count++;
              if(count > 1) return false;
              List<Integer> list = new ArrayList<>();
              getConnectedComp(graph,list,v,visited);
              comps.add(list);
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
        if(isGraphConnected(graph)) {
            System.out.println(true);
          } else {
              System.out.println(false);
          }
   }
}
