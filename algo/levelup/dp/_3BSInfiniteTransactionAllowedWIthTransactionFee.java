import java.util.*;
public class _3BSInfiniteTransactionAllowedWIthTransactionFee {
    private static void stockBuySell3(int[] price, int fees) {
        int pibt = -price[0]; // pibt -> profit if buy today
        int pist = 0; // initially 0, pist-> profit if sell today
        for(int i = 1; i < price.length; i++) {
            int new_pibt = Math.max(pibt, pist - price[i]);
            int new_pist = Math.max(pist, price[i] + pibt - fees);
            pibt = new_pibt;
            pist = new_pist;
        }
        System.out.println(pist);
    }
}
