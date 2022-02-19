import java.util.Scanner;
 
 public class _22PerfectSquaresLC279 {
 
 	 public static void main(String[] args) {
 	 	 // TODO Auto-generated method stub
 	 	 Scanner scn=new Scanner(System.in);
 	 	 int n=scn.nextInt();
 	 	 
 	 	 int leastNoSquares=count(n);
 	 	 System.out.println(leastNoSquares);
 
 	 }
 	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as an integer
 	 // It should return the required output
 
 	 private static int count(int n) {
 	 	 int[] dp = new int[n + 1];
        dp[0] = 0; 
        for(int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int count = 1;
            while(i - (count * count) >= 0) {
                min = Math.min(min, dp[i - count * count]);
                count++;
            }
            dp[i] = min + 1;
        }
        return dp[n];
 	 }
 }