import java.util.*;
import java.io.*;

public class _21KruskalAlgorithm {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int v = Integer.parseInt(br.readLine());
    int e = Integer.parseInt(br.readLine());

    int[][] edges = new int[e][3];
    for (int i = 0; i < e; i++) {
      String[] st = br.readLine().split(" ");
      edges[i][0] = Integer.parseInt(st[0]);
      edges[i][1] = Integer.parseInt(st[1]);
      edges[i][2] = Integer.parseInt(st[2]);
    }

    System.out.println(minCostToSupplyWater(v, edges));
  }

  static int[] parent;
  static int[] rank;

  public static class Pair implements Comparable<Pair> {
    int u;
    int v;
    int wt;

    Pair(int u, int v, int wt) {
      this.u = u;
      this.v = v;
      this.wt = wt;
    }

    @Override
    public int compareTo(Pair o) {
      return this.wt - o.wt;
    }
  }
private static int find(int[] parent, int x) {
        if(parent[x] == x) {
            return x;
        }

        int temp = find(parent, parent[x]);
        parent[x] = temp;
        return temp;
  }
  public static void union(int lx, int ly, int[] rank, int[] parent) {
        if(rank[lx] > rank[ly]) {
            parent[ly] = lx;
        } else if(rank[lx] < rank[ly]) {
            parent[lx] = ly;
        } else {
            parent[ly] = lx;
            rank[lx]++;
        }
    }

  public static int minCostToSupplyWater(int n, int[][] pipes) {
    
        // kruskal Algo, sort all the edges 
        Arrays.sort(pipes, (val1, val2) -> Integer.compare(val1[2], val2[2]));

        int[] parent = new int[pipes.length];
        int[] rank = new int[pipes.length];

        for(int i = 0; i < pipes.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int cost = 0;
        for(int i = 0; i < pipes.length; i++) {
            int u = pipes[i][0];
            int v = pipes[i][1];
            int wt = pipes[i][2];

            int lu = find(parent, u);
            int lv = find(parent, v);

            if(lu == lv)
                continue;
            
            union(lu, lv, rank, parent);
            // add edge
            cost += wt;
        }
        return cost;

  }
}
