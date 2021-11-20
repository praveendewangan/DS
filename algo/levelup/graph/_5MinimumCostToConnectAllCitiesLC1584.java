import java.io.*;
import java.util.*;

public class _5MinimumCostToConnectAllCitiesLC1584 {
  static class Edge implements Comparable<Edge> {
    int v;
    int wt;

    Edge(int nbr, int wt) {
      this.v = nbr;
      this.wt = wt;
    }

    @Override
    public int compareTo(Edge o) {
      return this.wt - o.wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < vtces; i++) {
      graph.add(new ArrayList<>());
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph.get(v1).add(new Edge(v2, wt));
      graph.get(v2).add(new Edge(v1, wt));
    }
    
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.add(new Edge(0,0));
    boolean[] v = new boolean[vtces];
    int ans = 0;
    while(pq.size() > 0) {
        Edge rm = pq.remove();
        if(v[rm.v]) continue;
        v[rm.v] = true;
        ans += rm.wt; 
        for(Edge e : graph.get(rm.v)){
            if(!v[e.v]) {
                pq.add(e);
            }
        }
    }
    System.out.println(ans);

  }

}
