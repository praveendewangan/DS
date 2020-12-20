package gettingstarted;
import java.util.*;
/*Sample Input
        10
Sample Output
        0
        1
        1
        2
        3
        5
        8
        13
        21
        34*/
public class _3PrintAllFibonacciNumTillN {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println(a);
            int c = a + b;
            a = b;
            b = c;
        }
    }
}
