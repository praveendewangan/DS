import java.io.*;
import java.util.*;

public class _32TempleOfferings {
	
	public static int totaloffering(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        // left to right
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            if(height[i] > height[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        int sum = 0;
        // right to left
        int count = 1;
        dp[n - 1] = Math.max(count, dp[n - 1]);
        sum = dp[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            if(height[i] > height[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            sum += Math.max(count, dp[i]);
        }
        return sum;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int height[] = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = scn.nextInt();
		}
		System.out.println(totaloffering(height));
	}

}