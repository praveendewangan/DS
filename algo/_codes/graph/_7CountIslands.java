import java.io.*;
import java.util.*;

public class _7CountIslands {
    // Approch 1
    private static void getIsland(int[][] a,int i,int j) {
        if(i >= 0 && i < a.length && j >= 0 && j < a[0].length && a[i][j] == 0){
            a[i][j] = 1;
            getIsland(a,i+1,j);
            getIsland(a,i-1,j);
            getIsland(a,i,j+1);
            getIsland(a,i,j-1);
        }
    }
    // Approch 2
    static int[] xdir = {-1,0,1,0};
    static int[] ydir = {0,-1,0,1};
    private static void getIsland2(int[][] a,int i,int j) {
        for(int d = 0; d < xdir.length; d++) {
            int r = i + xdir[d];
            int c = j + ydir[d];
            if(r >= 0 && r < a.length && c >= 0 && c < a[0].length && a[r][c] == 0){
                a[r][c] = 1;
                getIsland2(a,r,c);
            }
        }
    }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }
        int count = 0;
      for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++) {
              if(arr[i][j] != 1){
                  count++;
                  getIsland(arr,i,j);
              }
          }
      }
      System.out.println(count);
   }

}
