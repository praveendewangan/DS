package practice.searchingAndSorting;

public class _30PainterPartion {
    // O(k*n^2),O(kn)
    public static void main(String[] args) {
        int arr[] = { 10, 20, 60, 50, 30, 40 };
  
    // Calculate size of array.
        int n = arr.length;
    // No.of Painters
        int k = 3;
        System.out.println(findMax(arr, n, k));
    }

    private static int findMax(int[] arr,int n,int k) {
        int[] sum = new int[n];
        sum[0] = arr[0];
        for(int i=1;i<n;i++){
            sum[i] = sum[i-1]+arr[i];
        }
        int[][] dp = new int[k+1][n+1];
        for (int i = 1; i <= n; i++)
            dp[1][i] = sum[i-1];
  
        // n=1
        for (int i = 1; i <= k; i++)
            dp[i][1] = arr[0];

        for(int i=2;i<=k;i++){
            for(int j=2;j<=n;j++) {
                int best = Integer.MAX_VALUE;
                for(int p=1;p<=j;p++) {
                    best = Math.min(best, Math.max(dp[i-1][p], sum[j-1]-sum[p-1]));
                }
                dp[i][j] = best;
            }
        }
        return dp[k][n];
    }
}
