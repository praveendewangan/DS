package practice.backtracking;

public class _8PartitionEqualSUbset {
    // O(n2),O(n2)
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int val : arr) {
            sum += val;
        }
        if(sum % 2 != 0) {
            return 0;
        }
        int tar = sum/2;
        boolean[][] dp = new boolean[N+1][tar + 1];
        for(int i = 0;i < dp.length;i++){
            for(int j = 0; j < dp[0].length;j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if( i == 0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    dp[i][j] = true;
                } else {
                    if(dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else {
                        int val = arr[i-1];
                        if(j >= val) {
                            if(dp[i-1][j-val]) {
                                dp[i][j] = true;;
                            }
                        }
                    }
                }
            }
        }
        if(dp[N][tar]) {
            return 1;
        }
        return 0;
    }
}
