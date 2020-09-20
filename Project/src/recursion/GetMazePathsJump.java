package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePathsJump {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        List<String> list = getMazePaths(1,1,n,m);
        System.out.println(list);
        System.out.println(list.size());
    }
    
    private static List<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> paths = new ArrayList<>();
        for (int ms = 1;ms+sc<= dc;ms++) {
            List<String> hpaths = getMazePaths(sr,sc+ms,dr,dc);
            for (String path : hpaths) {
                paths.add("h"+ms+path);
            }
        }
        for (int ms = 1;ms+sr<= dr;ms++) {
            List<String> vpaths = getMazePaths(sr+ms,sc,dr,dc);
            for (String path : vpaths) {
                paths.add("v"+ms+path);
            }
        }
        for (int ms = 1;ms+sr<= dr && ms+sc <= dc;ms++) {
            List<String> dpaths = getMazePaths(sr+ms,sc+ms,dr,dc);
            for (String path : dpaths) {
                paths.add("d"+ms+path);
            }
        }
        return paths;
    }
}
