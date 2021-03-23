package practice.backtracking;

import java.util.List;

public class _10TugOfWar {
    static int min = Integer.MAX_VALUE;
    static String ans = "";
    private static void solve(int[] a,int vidx,List<Integer> set1,List<Integer> set2,int sum1,int sum2) {
        if(vidx == a.length) {
            int delta = Math.abs(sum1 - sum2);
            if(min > delta) {
                min = delta;
                ans = set1 + " " +set2;
            }
            return;
        }
        if(set1.size() < (a.length+1)/2) {
            set1.add(a[vidx]);
            solve(a, vidx+1, set1, set2, sum1+a[vidx], sum2);
            set1.remove(set1.size() - 1);
        }
        if(set2.size() < (a.length+1)/2) {
            set2.add(a[vidx]);
            solve(a, vidx+1, set1, set2, sum1, sum2+a[vidx]);
            set2.remove(set2.size() - 1);
        }
    }
}
