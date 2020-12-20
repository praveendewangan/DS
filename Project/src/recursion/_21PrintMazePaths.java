package recursion;

import java.util.ArrayList;
import java.util.List;

public class _21PrintMazePaths {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        getMazePaths(1,1,n,m,"");
    }

    private static void getMazePaths(int sr,int sc,int dr,int dc,String ans) {
        if(sr > dr || sc > dc) {
            return;
        } else if(sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }
        getMazePaths(sr,sc+1,dr,dc,"h"+ans);
        getMazePaths(sr+1,sc,dr,dc,"v"+ans);
    }
}
