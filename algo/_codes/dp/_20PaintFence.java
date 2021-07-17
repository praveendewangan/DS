import java.io.*;
import java.util.*;

public class _20PaintFence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        System.out.println(solve(n,k));
    }
    
    private static long solve(int n, int k) {
        long same = 0;
        long distinct = k;
        
        for(int i = 1; i < n; i++) {
            long nSame = distinct;
            long nDistinct = (same + distinct) * (k-1);
            
            same = nSame;
            distinct = nDistinct;
        }
        return same + distinct;
        
    }
}