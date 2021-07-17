import java.io.*;
import java.util.*;

public class _25BuyandSellOneTransactionAllowed {

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
        int minPrice = price[0];
        int profit = 0;
        
        for(int day = 1; day < price.length; day++)  {
            profit = Math.max(profit,price[day] - minPrice);
            minPrice = Math.min(minPrice,price[day]);
        }
        return profit;
    }

}
