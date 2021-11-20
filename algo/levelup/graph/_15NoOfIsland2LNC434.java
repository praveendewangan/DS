import java.util.*;
public class _15NoOfIsland2LNC434 {
    
}
class Point {
    int x;
    int y;
    
    Point() { x = 0; y = 0; }
    
    Point(int a, int b) { 
        x = a; y = b;
    }
}

public int find(int[] parent, int x) {
    if(parent[x] == x) {
        return x;
    }

    int temp = find(parent, parent[x]);
    parent[x] = temp;
    return temp;
}

public void union(int lx, int ly, int[] rank, int[] parent) {
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
public List<Integer> numIslands2(int n, int m, Point[] operators) {
    if(operators == null) {
        return new ArrayList<>();
    }
    int[] parent = new int[n * m];
    Arrays.fill(parent, -1);
    int[] rank = new int[n * m];

    List<Integer> res = new ArrayList<>();
    int count = 0;

    for(Point p : operators) {
        int row = p.x;
        int col = p.y;

        int boxNo = row * m + col;
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
