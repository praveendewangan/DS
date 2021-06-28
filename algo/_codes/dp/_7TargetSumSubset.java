import java.io.*;
import java.util.*;

public class _7TargetSumSubset {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        System.out.println(tss(a,0,tar));
    }
    // Approch 1 using recursion
    private static boolean tss(int[] a,int idx,int tar) {
        if(tar == 0) return true;
        
        if(idx == a.length) return false;
        
        boolean flag = false;
        if(tar - a[idx] >= 0) {
            flag = tss(a,idx+1,tar-a[idx]);
        }
        flag = flag || tss(a,idx+1,tar);
        return flag;
    }
    // Approch 2 using recursion
    public static boolean printTargetSumSubsets(int[] arr, int idx, int sos, int tar) {
        if(sos > tar) {
            return false;
        }
        if(idx == arr.length){
            if(tar == sos){
                return true;
            }
            return false;
        }
        boolean res = printTargetSumSubsets(arr,idx+1,sos + arr[idx],tar);
        return res || printTargetSumSubsets(arr,idx+1,sos,tar);
    }

    // Using memoisation
    public static boolean targetSumSubset_memo(int[] arr, int indx, int target, Boolean[][] dp) {
        if(target == 0) return dp[indx][target] = true; 
        if(indx == arr.length) {
            return dp[indx][target] = false;
        }

        if(dp[indx][target] != null) {
            return dp[indx][target];
        }

        boolean res = false;
        // yes call
        if(target - arr[indx] >= 0) {
            res = targetSumSubset_memo(arr, indx + 1, target - arr[indx],dp);
        }
        // no call
        res = res || targetSumSubset_memo(arr, indx + 1, target,dp);
        return dp[indx][target] = res;
    }

    // public static boolean printTargetSumSubsets(int[] arr, int idx,int sos, int tar,Boolean[][] dp) {
    //     if(sos > tar) {
    //         return false;
    //     }
    //     if(idx == arr.length) {
    //         return dp[idx][tar] = false;
    //     }
    //     if(dp[idx][tar] != null) {
    //         return dp[idx][tar];
    //     }
    //     if(idx == arr.length){
    //         if(tar == sos){
    //             return dp[idx][tar] = true;
    //         }
    //         return dp[idx][tar] = false;
    //     }
    //     boolean res = printTargetSumSubsets(arr,idx+1,sos + arr[idx],tar,dp);
    //     res = res || printTargetSumSubsets(arr,idx+1,sos,tar,dp);
    //     return dp[idx][tar] = res;
    // }

    // Using tabulation
    public static boolean targetSumSubset_tab1(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        for(int indx = arr.length; indx >= 0; indx--) {
            for(int targ = 0; targ <= target; targ++) {
                if(targ == 0) {
                    dp[indx][targ] = true; 
                    continue;
                }
                    
                if(indx == arr.length) {
                    dp[indx][targ] = false;
                    continue;
                }

                boolean res = false;
                // yes call
                if(targ - arr[indx] >= 0) {
                    res = dp[indx + 1][targ - arr[indx]];
                }
                // no call
                res = res || dp[indx + 1][targ];
                dp[indx][targ] = res;
            }
        }
        return dp[0][target];
    }


    public static boolean targetSumSubset_tab2(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    dp[i][j] = true;
                } else {
                    if(dp[i-1][j]){
                        dp[i][j] = true;
                    } else {
                        int val = arr[i-1];
                        if(j >= val) {
                            if(dp[i-1][j-val]){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
