import java.util.*;
public class _1BSOneTransactionAllowed {
    private static void stockBuySell1(int[] stocks) {
        int oprofit = 0; // overall profit
        int min = Integer.MAX_VALUE;
        for(int d = 0; d < stocks.length; d++) {
            int price = stocks[d];
            min = Math.min(min, price);
            oprofit = Math.max(oprofit, price - min);
        }
        System.out.println(oprofit);
    }
}
