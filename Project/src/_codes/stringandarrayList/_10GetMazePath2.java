import java.io.*;
import java.util.*;


public class _10GetMazePath2 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int dr = scn.nextInt();
        int dc = scn.nextInt();
        System.out.println(getMazePaths(0,0,dr-1,dc-1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
        if(sr == dr && sc == dc){
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        } 
        ArrayList<String> res = new ArrayList<>();
        if(sc+1 <= dc) {
            ArrayList<String> hlist = getMazePaths(sr,sc+1,dr,dc);
            for(String s : hlist){
                res.add("h" + s);
            }
        }
        if(sr + 1 <= dr) {
            ArrayList<String> vlist = getMazePaths(sr+1,sc,dr,dc);
            for(String s : vlist){
                res.add("v" + s);
            }
        }
        return res;
    }
}
