import java.util.*;
public class _2BSInfiniteTransactionAllowed {
    private static void stockBuySell2(int[] price) {
        int bd = 0;
        int sd = 0;
        int profit = 0;

        for(int i = 1; i < price.length; i++) {
            if(price[i] > price[i - 1]) {
                sd = i;
            } else {
                profit += price[sd] - price[bd];
                // reset bd and sd
                bd = i;
                sd = i;
            }
        }
        // is peak is present in price int end of days
        profit += price[sd] - price[bd];
        System.out.println(profit);
    }
}
