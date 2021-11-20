import java.util.*;
import java.io.*;

class _12CriticalConnectionLC1192 {
    static int[] parent;
    static int[] disc;
    static int[] low;
    static boolean[] vis;
    static int time;
  public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> Edges) {
    List<List<Integer>> list = new ArrayList<>();
    List<List<Integer>> graph = new ArrayList<>();
    for(int i = 0; i < n; i++){
        graph.add(new ArrayList<>());
    }
    
    for(List<Integer> edge : Edges){
        int v1 = edge.get(0);
        int v2 = edge.get(1);
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }
    
    parent = new int[n];
    disc = new int[n];
    low = new int[n];
    vis = new boolean[n];
    time = 0;
    // parent[0] = -1;
    dfsCriticalCon(graph,0,list);
    return list;
  }
  
  private static void dfsCriticalCon(List<List<Integer>> graph,int src,List<List<Integer>> list) {
      disc[src] = low[src] = time;
      time++;
      vis[src] = true;
      for(int nbr : graph.get(src)) {
          if(nbr == parent[src]) {
              continue;
          } else if(vis[nbr] && nbr != parent[src]) {
              low[src] = Math.min(low[src],disc[nbr]);
          } else {
              parent[nbr] = src;
              dfsCriticalCon(graph,nbr,list);
              low[src] = Math.min(low[src],low[nbr]);
              if(disc[src] < low[nbr]) {
                  List<Integer> points = new ArrayList<>();
                  points.add(src);
                  points.add(nbr);
                  list.add(points);
              }
          }
      }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);
    List<List<Integer>> edges = new ArrayList<>();


    for (int i = 0; i < e; i++) {
      edges.add(new ArrayList<>());
      st = br.readLine().split(" ");
      edges.get(i).add(Integer.parseInt(st[0]));
      edges.get(i).add(Integer.parseInt(st[1]));
    }

    System.out.println(criticalConnections(n, edges));

  }

}