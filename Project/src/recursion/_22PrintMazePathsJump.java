package recursion;

import java.util.ArrayList;
import java.util.List;

public class _22PrintMazePathsJump {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        getMazePaths(1,1,n,m,"");
    }

    private static void getMazePaths(int sr, int sc, int dr, int dc,String path) {
        if(sr == dr && sc == dc) {
            System.out.println(path);
        }
        List<String> paths = new ArrayList<>();
        for (int ms = 1;ms+sc<= dc;ms++) {
            getMazePaths(sr,sc+ms,dr,dc,path+"h"+ms);
        }
        for (int ms = 1;ms+sr<= dr;ms++) {
            getMazePaths(sr+ms,sc,dr,dc,path+"v"+ms);
        }
        for (int ms = 1;ms+sr<= dr && ms+sc <= dc;ms++) {
            getMazePaths(sr+ms,sc+ms,dr,dc,path+"d"+ms);
        }
    }
}
