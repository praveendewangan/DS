import java.util.*;
public class _9CoinChangeCombinatation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];
        
        for(int i = 0; i < n; i++) {
            coins[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        // System.out.println(combinationRec(coins,tar,0));
        System.out.println(combinationTab(coins,tar));
    }

    // Using recursion 
    private static int combinationRec(int[] coins,int tar,int idx) {
        if(tar == 0) return 1;

        if(idx == coins.length) {
            return 0;
        }

        int count = 0;
        if(tar - coins[idx] >= 0) {
            count += combinationRec(coins,tar-coins[idx],idx);
        }
        count += combinationRec(coins,tar,idx+1);
        return count;
    }

    // Using tabulation
    private static int combinationTab(int[] coins,int tar) {
        int[] dp = new int[tar+1];
        dp[0]=1;


        int count = 0;
        for(int coin : coins) {
            for(int i = coin; i <= tar; i++) {
                if(i-coin >= 0) {
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[tar];
    }
}
