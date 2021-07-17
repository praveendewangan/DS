import java.io.*;
import java.util.*;

public class _21TilingWith2X1Tiles {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solve(n));
    }
    
    private static int solve(int n) {
        int a = 0;
        int b = 1;
        if(n == 1) {
            return b;
        }
        for(int i = 1; i <= n ; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
