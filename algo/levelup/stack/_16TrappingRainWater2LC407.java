import java.util.*;

public class _16TrappingRainWater2LC407 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[][] arr = new int[n][m];
    for(int i=0; i < n; i++) {
        for(int j=0; j < m; j++) {
            arr[i][j] = scn.nextInt();
        }
    }
    System.out.println(trapRainWater(arr));
  }
  
  
    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        int ht;
        Pair(int r,int c,int ht) {
            this.x = r;
            this.y = c;
            this.ht = ht;
        }
        
        public int compareTo(Pair p) {
            return this.ht-p.ht;
        }
    }
    static int[] xdir = {-1,0,1,0};
    static int[] ydir = {0,-1,0,1};
    public static int trapRainWater(int[][] hts) {
        boolean[][] vis = new boolean[hts.length][hts[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        // add boundry in queue
        addBundrTRW(pq,hts,vis);
        int water = 0;
        while(pq.size() > 0) {
            Pair rm = pq.remove();
            for(int d=0; d < 4; d++) {
                int r = rm.x + xdir[d];
                int c = rm.y + ydir[d];
                
                if(r >= 0 && r < hts.length && c >= 0 && c < hts[0].length && !vis[r][c]) {
                    vis[r][c] = true;
                    if(hts[r][c] < rm.ht) {
                        water += rm.ht - hts[r][c];
                        pq.add(new Pair(r,c,rm.ht));
                    } else {
                        pq.add(new Pair(r,c,hts[r][c]));
                    }
                }
            }
        }
        return water;
    }
    
    public static void addBundrTRW(PriorityQueue<Pair> pq,int[][] hts, boolean[][] vis) {
        // top wall
        for(int c = 0; c < hts[0].length; c++) {
            if(!vis[0][c]) {
                pq.add(new Pair(0,c,hts[0][c]));
                vis[0][c] = true;
            }
        }
        
        // left wall
        for(int r = 0; r < hts.length; r++) {
            if(!vis[r][0]) {
                pq.add(new Pair(r,0,hts[r][0]));
                vis[r][0] = true;
            }
        }
        
        // down wall
        for(int c = 0; c < hts[0].length; c++) {
            if(!vis[hts.length-1][c]) {
                pq.add(new Pair(hts.length-1,c,hts[hts.length-1][c]));
                vis[hts.length-1][c] = true;
            }
        }
        
        // right wall
        for(int r = 0; r < hts.length; r++) {
            if(!vis[r][hts[0].length-1]) {
                pq.add(new Pair(r,hts[0].length-1,hts[r][hts[0].length-1]));
                vis[r][hts[0].length-1] = true;
            }
        }
    }
    

}
