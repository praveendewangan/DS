package _codes.recursion;
import java.io.*;

public class _5PowerLinear {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int val = power(x,n);
        System.out.println(val);
    }

    public static int power(int x, int n){
        if(n == 0) {
            return 1;
        }
        return x * power(n-1);
    } 
}
