import java.io.*;
import java.util.*;

public class _15GetMazePathThreeDirection {
    private static List<String> solve(int sr,int sc,int dr, int dc){
        if(sr == dr && sc == dc) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> res = new ArrayList<>();
        if(sc + 1 <= dc) {
            List<String> list = solve(sr,sc+1,dr,dc);
            for(String s : list) {
                res.add("h" + s);
            }
        }
        
        if(sr + 1 <= dr) {
            List<String> list = solve(sr+1,sc,dr,dc);
            for(String s : list) {
                res.add("v" + s);
            }
        }
        
        if(sc + 1 <= dc && sr + 1 <= dr) {
            List<String> list = solve(sr+1,sc+1,dr,dc);
            for(String s : list) {
                res.add("d" + s);
            }
        }
        return res;
    }
    
}
