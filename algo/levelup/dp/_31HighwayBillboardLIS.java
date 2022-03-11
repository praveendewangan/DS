import java.util.Scanner;
public class _31HighwayBillboardLIS {
    // O(n^2)
    public static int solution(int m , int[] x, int[] rev, int t) {
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[rev.length];
        dp[0] = rev[0];
        for(int i = 1; i < x.length; i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--) {
                if(x[i] - x[j] > t) {
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max + rev[i];
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}