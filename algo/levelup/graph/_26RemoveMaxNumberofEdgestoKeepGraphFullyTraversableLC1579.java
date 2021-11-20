import java.io.*;
import java.util.*;

public class _26RemoveMaxNumberofEdgestoKeepGraphFullyTraversableLC1579 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] edges = new int[m][3];
    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      edges[i][0] = Integer.parseInt(st[0]);
      edges[i][1] = Integer.parseInt(st[1]);
      edges[i][2] = Integer.parseInt(st[2]);
    }
    Main obj = new Main();
    System.out.println(obj.maxNumEdgesToRemove(n, edges));
  }

    private int find4Edge(int x, int[] parent) {
        if(parent[x] == x) {
            return x;
        }
        int temp = find4Edge(parent[x], parent);
        parent[x] = temp;
        return temp;
    }

    private boolean unionEdge(int x, int y, int[] parent, int[] rank) {
        int lx = find4Edge(x, parent);
        int ly = find4Edge(y, parent);

        if(lx == ly) {
            return false;
        } else {
            if(rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else if(rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else {
                parent[ly] = lx;
                rank[lx]++;
            }
        }
        return true;
    }
  public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> {
            return -Integer.compare(a[0], b[0]);
        });

        int mergea = 1;
        int mergeb = 1;
        int removeEdge = 0;

        int[] parenta = new int[n + 1];
        int[] parentb = new int[n + 1];
        int[] ranka = new int[n + 1];
        int[] rankb = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            parenta[i] = i;
            parentb[i] = i;
            ranka[i] = 1;
            rankb[i] = 1;
        }

        for(int[] edge : edges) {
            if(edge[0] == 3) {
                boolean tempa = unionEdge(edge[1], edge[2], parenta, ranka);
                boolean tempb = unionEdge(edge[1], edge[2], parentb, rankb);
                if(tempa == true) {
                    mergea++;
                }
                if(tempb == true) {
                    mergeb++;
                }
                if(tempa == false && tempb == false) {
                    removeEdge++;
                }
            } else if(edge[0] == 1) {
                boolean tempa = unionEdge(edge[1], edge[2], parenta, ranka);
                if(tempa == true) {
                    mergea++;
                } else {
                    removeEdge++;
                }
            } else {
                boolean tempb = unionEdge(edge[1], edge[2], parentb, rankb);
                if(tempb == true) {
                    mergeb++;
                } else {
                    removeEdge++;
                }
            }
        }
        if(mergea == n && mergeb == n) {
            return removeEdge;
        } else {
            return -1;
        }
  }


}