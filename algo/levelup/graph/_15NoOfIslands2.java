import java.util.*;
import java.io.*;

public class _15NoOfIslands2 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);
    int q = Integer.parseInt(st[2]);

    int[][] pos = new int[q][2];
    for (int i = 0; i < q; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    System.out.println(numIslands2(m, n, pos));
  }
    public static int find(int[] parent, int x) {
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
    static int[] xdir = {-1,0,1,0};
    static int[] ydir = {0,1,0,-1};
  public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[n * m];
        Arrays.fill(parent, -1);
        int[] rank = new int[n * m];
    
        List<Integer> res = new ArrayList<>();
        int count = 0;
    
        for(int i=0; i < positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
    
            int boxNo = row * m + col;
            // if same points come then check if parent is already processed or not . If processed i.e. 
            // parent[boxNo] != -1
            if(parent[boxNo] != -1) {
                res.add(count);
                continue;
            }
            parent[boxNo] = boxNo;
            rank[boxNo] = 1;
            count++;
    
            for(int d = 0; d < 4; d++) {
                int r = row + xdir[d];
                int c = col + ydir[d];
    
                if(r < 0 || r >= n || c < 0 || c >= m || parent[r * m + c] == -1)
                    continue;
                
                int bNo = r * m + c;
                // find set leader
                int lx = find(parent, bNo);
                int ly = find(parent, boxNo);
    
                // union them
                if(lx != ly) {
                    union(lx, ly, rank, parent);
                    count--;
                }
            }
            res.add(count);
        }
        return res;
  }
}