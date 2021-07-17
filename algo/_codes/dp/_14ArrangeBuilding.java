
import java.io.*;
import java.util.*;

public class _14ArrangeBuilding{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // long res = solve(n,1);
        long res = solveTab(n);
        System.out.println(res*res);
     }
     
     private static long solve(int n,int lsn) {
         if(n == 0) {
             return 1L;
         }
         long count = 0;
         count += solve(n-1,1);
         if(lsn == 1) {
             count += solve(n-1,0);
         }
         return count;
     }

    //  Using better approch
    
    private static long solveTab(int n) {
        int a = 1;
        int b = 1;
        for(int i=2; i<= n; i++) {
            int c = a;
            a = b;
            b += c;
        }
        return a+b;
    }
}
