import java.io.*;
import java.util.*;

public class _10ExclusiveTimeofFunctionsLC636 {
    static class Pair {
        int id;
        int st;
        int ct;
        Pair(int id,int st,int ct) {
            this.id = id;
            this.st = st;
            this.ct = ct;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());
        int[] timeF = new int[n];
        int len = Integer.parseInt(read.readLine());
        Stack<Pair> s = new Stack<>();
        for(int i=0; i < len; i++) {
            String[] log = read.readLine().split(":");
            if(log[1].equals("start")) {
                int id = Integer.parseInt(log[0]);
                int st = Integer.parseInt(log[2]);
                Pair p = new Pair(id,st,0);
                s.push(p);
            } else {
                Pair p = s.pop();
                int et = Integer.parseInt(log[2]);
                int interval = et - p.st + 1;
                int time = interval - p.ct;
                timeF[p.id] += time;
                if(s.size() > 0) {
                    s.peek().ct += interval;
                }
            }
        }
        for(int val : timeF) {
            System.out.println(val);
        }
    }
}
