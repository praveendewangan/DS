import java.io.*;
import java.util.*;

public class _27BuyandSellMultipleTransactionAllowedWithFees {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int fees = scn.nextInt();
        System.out.println(profit(a,fees));
    }
    
    
    private static int profit(int[] price,int fees) {
        int pwb = -price[0];
        int pws = 0;
        
        for(int i = 1; i < price.length; i++)  {
            int npwb = Math.max(pwb,pws-price[i]);
            int npws = Math.max(pws,pwb+price[i]-fees);
            
            pws = npws;
            pwb = npwb;
        }
        return pws;
    }

}