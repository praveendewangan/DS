package _codes.patterns;
import java.util.Scanner;

public class _20Pattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = 3;
        for(int i=1; i <= n; i++) {
            for(int j=1; j <= n; j++) {
                if(    
                        (i <= n/2 && j <= n/2 && i > 1)
                    ||  (i > n/2+1 && j > 1 && j <= n/2)
                    ||  (i > n/2+1 && i < n && j > n/2+1)
                    ||  (i <= n/2 && j > n/2+1 && j < n)){
                    System.out.print("\t");
                } else {
                    System.out.print("+\t");
                }
            }
            System.out.println();
        }
    }
}
