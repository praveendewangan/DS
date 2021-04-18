import java.io.*;
import java.util.*;
public class _16GetMazePathWithJump {
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
        
        if(sr == dr && sc == dc) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        ArrayList<String> res = new ArrayList<>();
        for(int jump = 1 ; sc + jump <= dc; jump++) {
            ArrayList<String> list = getMazePaths(sr,sc + jump,dr,dc);
            for(String s : list) {
                res.add("h" + jump + s);
            }
        }
        
        for(int jump = 1 ; sr + jump <= dr; jump++) {
            ArrayList<String> list = getMazePaths(sr + jump,sc,dr,dc);
            for(String s : list) {
                res.add("v" + jump + s);
            }
        }
        
        for(int jump = 1 ; sr + jump <= dr && sc + jump <= dc; jump++) {
            ArrayList<String> list = getMazePaths(sr + jump,sc + jump,dr,dc);
            for(String s : list) {
                res.add("d" + jump + s);
            }
        }
        return res;
    }

}
