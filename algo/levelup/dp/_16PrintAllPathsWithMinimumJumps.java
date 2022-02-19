
import java.util.*;

public class _16PrintAllPathsWithMinimumJumps{
    private static class MJHelper {
        int indx;
        int jumps;
        int minJumps;
        String psf;
        public MJHelper(int indx, int jumps, int minJumps, String psf) {
            this.indx = indx;
            this.jumps = jumps;
            this.minJumps = minJumps;
            this.psf = psf;
        }
    }
    public static void Solution(int arr[]){
        int n = arr.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;
        
        for(int i = n - 2; i >= 0; i--) {
            int minJumps = Integer.MAX_VALUE;
            for(int jump = 1; jump <= arr[i] && i + jump < n; jump++) {
                minJumps = Math.min(minJumps, dp[i + jump]);
            }
            dp[i] = minJumps != Integer.MAX_VALUE? minJumps + 1: minJumps;
        }

        System.out.println(dp[0]);
        Queue<MJHelper> que = new LinkedList<>();
        que.add(new MJHelper(0, arr[0], dp[0], "0"));

        while(que.size() > 0) {
            MJHelper rem = que.remove();
            if(rem.indx == n - 1) {
                System.out.println(rem.psf + " .");
                continue;
            }
            for(int jump = 1; jump <= rem.jumps && jump + rem.indx < n; jump++) {
                if(dp[rem.indx + jump] == rem.minJumps - 1) {
                    int nindx = rem.indx + jump;
                    que.add(new MJHelper(nindx, arr[nindx], rem.minJumps - 1, rem.psf + " -> "+ nindx));
                }
            }
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
