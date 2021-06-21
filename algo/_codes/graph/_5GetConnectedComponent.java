import java.io.*;
import java.util.*;

public class _5GetConnectedComponent {
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

    private static void getConnectedComp(ArrayList<Edge>[] graph,ArrayList<Integer> comp,int idx,boolean[] v){
        v[idx] = true;
        comp.add(idx);
        for(Edge e : graph[idx]){
            if(!v[e.nbr]) {
                getConnectedComp(graph,comp,e.nbr,v);
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean[] visited = new boolean[vtces];
      for(int v = 0; v < vtces; v++){
          if(!visited[v]) {
              ArrayList<Integer> list = new ArrayList<>();
              getConnectedComp(graph,list,v,visited);
              comps.add(list);
          }
      }

      System.out.println(comps);
   }
}
