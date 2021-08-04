import java.io.*;
import java.util.*;

public class _26CoinChangePermutation2 {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf) {
        if(amtsf == tamt) {
            System.out.println(asf+".");
            return;
        }
       for(int i = 0; i < coins.length; i++){
           if( coins[i] + amtsf <= tamt){
               coinChange(coins,coins[i] + amtsf,tamt,asf+coins[i]+"-");
           }
       }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(coins, 0, amt, "");
    }
}