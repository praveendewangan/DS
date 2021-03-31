package practice.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class _28RottenOrranges {
    //  O(N*M),O(N) 
    class Pair {
        int i;
        int j;
        int p;
        Pair(int p,int i,int j){
            this.p = p;
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid)
    {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i < n;i++) {
            for(int j=0; j < m;j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(0,i,j));
                } 
            }
        }
        int ans = 0;
        while(q.size() != 0) {
            Pair rm = q.remove();
            ans = rm.p;
            if(rm.i-1 >= 0 && grid[rm.i-1][rm.j] == 1){
                q.add(new Pair(rm.p+1,rm.i-1,rm.j));
                grid[rm.i-1][rm.j] = 2;
            }
            
            if(rm.i+1 < n && grid[rm.i+1][rm.j] == 1){
                q.add(new Pair(rm.p+1,rm.i+1,rm.j));
                grid[rm.i+1][rm.j] = 2;
            }
                
            if(rm.j+1 < m && grid[rm.i][rm.j+1] == 1){
                q.add(new Pair(rm.p+1,rm.i,rm.j+1));
                grid[rm.i][rm.j+1] = 2;
            }
                
            if(rm.j-1 >= 0 && grid[rm.i][rm.j-1] == 1){
                q.add(new Pair(rm.p+1,rm.i,rm.j-1));
                grid[rm.i][rm.j-1] = 2;
            }
        }
        for(int i=0;i < n; i++){
            for(int j=0; j < m;j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
