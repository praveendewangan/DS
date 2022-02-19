import java.io.*;
import java.util.*;

public class _13Reducento1official {

    public static int solution(long n) {
         int count = 0;
        while(n != 1) {
            if((n & 1) == 0) {
                // n % 2 == 0
                // even
                n = n / 2;
            } else if(n == 3) {
                // special case
                n = n - 1;
            } else if((n & 3) == 1) {
                // n % 4 == 1
                // odd 1 type
                n = n - 1;
            } else if((n & 3) == 3) {
                // n % 4 == 3
                // odd 2 type
                n = n + 1;
            }
            count++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
        System.out.println(solution(n));
    }
	
	
}