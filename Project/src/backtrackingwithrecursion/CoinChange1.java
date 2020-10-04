package backtrackingwithrecursion;

import java.util.Scanner;

public class CoinChange1 {
    private static void coinChange(int i,int[] coins,int amsf,int amt,String asf){
        if (i == coins.length){
            if(amsf == amt) {
                System.out.println(asf);
            }
            return;
        }
        coinChange(i+1,coins,amsf+coins[i],amt,asf+coins[i]+"-");
        coinChange(i+1,coins,amsf,amt,asf);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scn.nextInt();
        }
        int amt = scn.nextInt();
        coinChange(0,coins,0,amt,"");
    }
}
