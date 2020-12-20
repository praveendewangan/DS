package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePaths {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        List<String> list = getMazePaths(1,1,n,m);
        System.out.println(list);
        System.out.println(list.size());
    }

    private static List<String> getMazePaths(int sr,int sc,int dr,int dc) {
        if(sr == dr && sc == dc) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> paths = new ArrayList<>();
        List<String> hpaths = new ArrayList<>();
        List<String> vpaths = new ArrayList<>();
        List<String> dpaths = new ArrayList<>();
        if(sc < dc) {
            hpaths = getMazePaths(sr,sc+1,dr,dc);
        }
        if(sr < dr) {
            vpaths = getMazePaths(sr+1,sc,dr,dc);
        }
        for (String hpath : hpaths){
            paths.add("h"+hpath);
        }
        for (String vpath : vpaths){
            paths.add("v"+vpath);
        }
        return paths;
    }
}
