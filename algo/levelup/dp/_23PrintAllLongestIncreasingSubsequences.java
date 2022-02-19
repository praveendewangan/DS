import java.util.*;

public class _23PrintAllLongestIncreasingSubsequences{
    
   
    public static class LISHelper {
        int l;
        int i;
        int v;
        String psf;
        
        LISHelper(int l, int i, int v, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    public static void printAllLIS(int []arr){
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = 1;
        int maxIndx = 0;
        for(int i = 1; i < n; i++) {
            int maxLen = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    maxLen = Math.max(maxLen, dp[j]);
                }
            }
            dp[i] = maxLen + 1;
            if(dp[maxIndx] < dp[i]) {
                maxIndx = i;
            }
        }
        System.out.println(dp[maxIndx]);
        Queue<LISHelper> qu = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(dp[i] == dp[maxIndx]) {
                qu.add(new LISHelper(dp[maxIndx], i, arr[i], arr[i] + ""));
            }
        }

        while(qu.size() > 0) {
            LISHelper rem = qu.remove();
            if(rem.l == 1) {
                System.out.println(rem.psf);
                continue;
            }

            for(int j = rem.i - 1; j >= 0; j--) {
                if(dp[j] == rem.l - 1 && arr[j] < arr[rem.i]) {
                    qu.add(new LISHelper(dp[j], j, arr[j], arr[j] + " -> " + rem.psf));
                }
            }
        }
    }
    
    
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        printAllLIS(arr);

        scn.close();
    }
}