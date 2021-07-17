import java.io.*;
import java.util.*;

public class _28BuyandSellMultipleTransactionAllowedWithCoolDown {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        
        System.out.println(profit(a));
    }
    
    private static int profit(int[] cost) {
        int pwb = -cost[0];
        int pws = 0;
        int cd = 0;
        
        for(int i = 1; i < cost.length; i++) {
            int npwb = Math.max(pwb,cd - cost[i]);
            int npws = Math.max(pws,cost[i] + pwb);
            int ncd = Math.max(cd,pws);
            
            pwb = npwb;
            pws = npws;
            cd = ncd;
        }
        
        return pws;
        
    }

}
