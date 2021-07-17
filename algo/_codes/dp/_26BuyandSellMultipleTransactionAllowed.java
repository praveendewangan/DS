import java.io.*;
import java.util.*;

public class _26BuyandSellMultipleTransactionAllowed {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        System.out.println(profit(a));
    }

    private static int profit(int[] price) {
        int profit = 0;
        int bd = 0;
        int sd = 0;
        
        for(int i = 1; i < price.length; i++)  {
            if(price[i-1] > price[i]) {
                profit += price[sd] - price[bd];
                bd = sd = i;
            } else {
                sd = i;
            }
        }
        // if(bd < sd)
            profit += price[sd] - price[bd];
        return profit;
    }
}