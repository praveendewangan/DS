public class _8CoinChangePermutation {
    
    public static void main(String[] args) {
        int[] coins = {2,3,5,6};
        int tar = 7;
        // System.out.println(permutation(coins,tar));
        // System.out.println(permutation(coins,tar,new int[tar+1]));
        System.out.println(permutationTab(coins,tar,new int[tar+1]));
    }
    private static int permutation(int[] coins,int tar,String psf) {
        if(tar == 0) {
            System.out.println(psf);
            return 1;
        }
        
        int count = 0;
        for (int coin : coins) {
            if(tar-coin >= 0) {
                count += permutation(coins,tar-coin,psf+coin+",");
            }
        }
        return count;
    }
// Using memoisation
    private static int permutation(int[] coins,int tar,int[] dp) {
        if(tar == 0) {
            return dp[tar] = 1;
        }
        if(dp[tar] != 0) {
            return dp[tar];
        }
        int count = 0;
        for (int coin : coins) {
            if(tar-coin >= 0) {
                count += permutation(coins,tar-coin,dp);
            }
        }
        return dp[tar] = count;
    }

// Using Tabulation
    private static int permutationTab(int[] coins,int tar,int[] dp) {
        dp[0]=1;
        for(int i=1; i <= tar; i++) {
            for(int coin : coins){
                if(i-coin >= 0) {
                    dp[i] += dp[i-coin]; 
                }
            }
        }
        return dp[tar];
    }
}
