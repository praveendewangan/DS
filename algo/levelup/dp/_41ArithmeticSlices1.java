import java.io.*;
import java.util.*;

public class _41ArithmeticSlices1 {

	public static int solution(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
               dp[i] = dp[i - 1] + 1;
               count += dp[i];
            }
        }
        return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}