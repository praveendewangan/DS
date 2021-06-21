

import java.io.*;
import java.util.*;

public class _8PerfectFriends {
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

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      int vtces = n;
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = k;
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = -1;
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
      //   O(N^2)
    //   int sum = 0;
    //   for (int i = 0; i < comps.size(); i++) {
    //         for (int j = i + 1; j < comps.size(); j++) {
    //             int count = comps.get(i).size() * comps.get(j).size();
    //             sum += count;
    //         }
    //     }
    // System.out.println(sum);

    // O(N)

    int sum = comps.get(comps.size()-1).size();
    int count = 0;
    for(int i = comps.size()-2; i >= 0; i--) {
        int s = comps.get(i).size();
        count += sum*s;
        sum += s;

    }
      System.out.println(count);

   }

}