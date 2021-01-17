package dynamicprogramsLU;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
public class _14PrintAllLongestIncreasingSubsequence {


    public static class Pair {
        int l;
        int i;
        int v;
        String psf;

        Pair(int l, int i, int v, String psf) {
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    public static void solution(int[] arr) {
        int[] dp = new int[arr.length];
        int oamax = 0;
        int omi = 0;
        for(int i=0; i < dp.length;i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(arr[j] <= arr[i]) {
                    if(dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if(dp[i] > oamax) {
                oamax=dp[i];
                omi = i;
            }
        }
        ArrayDeque<Pair> q = new ArrayDeque<>();
        for(int i=0; i < dp.length;i++){
            if(dp[i] == oamax) {
                q.add(new Pair(oamax,i,arr[i],arr[i]+""));
            }
        }

        System.out.println(oamax);
        while(q.size() > 0) {
            Pair rm = q.remove();
            if(rm.l == 1){
                System.out.println(rm.psf);
            }
            for(int j =rm.i-1;j >= 0;j--) {
                if(dp[j] == rm.l - 1 && arr[j] <= rm.v){
                    q.add(new Pair(dp[j],j,arr[j],arr[j]+" -> "+rm.psf));
                }
            }
        }
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }

}
