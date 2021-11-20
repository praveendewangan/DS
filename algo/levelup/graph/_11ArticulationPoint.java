import java.util.*;
import java.io.*;

class _11ArticulationPoint {

  public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int v1 = scn.nextInt() - 1;
            int v2 = scn.nextInt() - 1;
            // add undirected edge 
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        int count = articulationPoint(graph);
        System.out.println(count);
  }
  
  static int time;
  static int[] parent;
  static int[] disc;
  static int[] low;
  static boolean[] vis;
  static boolean[] art;
  
  private static int articulationPoint(ArrayList<ArrayList<Integer>> graph) {
      time = 0;
      parent = new int[graph.size()];
      disc = new int[graph.size()];
      low = new int[graph.size()];
      vis = new boolean[graph.size()];
      art = new boolean[graph.size()];
      
      parent[0] = -1;
      int count = 0;
      dfsArticulation(graph,0); 
        for(int i = 0; i < art.length; i++) {
            if(art[i] == true) {
                // System.out.println(i + 1);
                count++;
            }
        }
        return count;
  }
  
  private static void dfsArticulation(ArrayList<ArrayList<Integer>> graph,int src) {
      disc[src] = low[src] = time;
      time++;
      vis[src] = true;
      int count = 0; // count for finding original source status about articulation
      
      for(int nbr : graph.get(src) ) {
          if(nbr == parent[src]) {
              continue;
          } else if(vis[nbr] && nbr != parent[src]) {
              low[src] = Math.min(low[src],disc[nbr]);
          } else {
              parent[nbr] = src;
              dfsArticulation(graph,nbr);
              low[src] = Math.min(low[src],low[nbr]);
              count++;
              if(parent[src] == -1) {
                  if(count > 1) {
                      art[src] = true;
                  }
              } else if(disc[src] <= low[nbr]){
                  art[src] = true;
              }
          }
      }
    
  }

}




