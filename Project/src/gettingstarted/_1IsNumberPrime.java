package gettingstarted;
import java.util.*;
/*Sample Input
        5
        19
        21
        33
        37
        121
Sample Output
        prime
        not prime
        not prime
        prime
        not prime*/
public class _1IsNumberPrime {
    public static void main(String[] args) {
        int n = 5;
        int a[] = {19,21,33,37,121};
        for (int i = 0; i < 5; i++) {
            isPrime(a[i]);
        }
    }

    public static void isPrime(int num){
        for (int j = 2; j * j <= num; j++) {
            if(num % j == 0) {
                System.out.println("not prime");
                return;
            }
        }
        System.out.println("prime");
    }
}
