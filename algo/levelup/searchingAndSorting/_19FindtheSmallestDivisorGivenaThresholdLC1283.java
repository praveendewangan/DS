import java.util.*;
import java.io.*;

public class _19FindtheSmallestDivisorGivenaThresholdLC1283 {
    private static boolean isPossible(int[]nums,int threshold,int div) {
        int time = 0;
        for(int i = 0; i < nums.length; i++) {
            time += (int)Math.ceil(nums[i] * 1.0 / div);
        }
        return time <= threshold;
    }
    
    public static int findSmallestDivisor(int[]nums,int threshold) {
        int max = Integer.MIN_VALUE;
        for(int val : nums){
            max = Math.max(val,max);
        }
        if(threshold == nums.length) return max;
        
        int lo = 1; // min divisor will be one
        int hi = max;
        int ans = Integer.MAX_VALUE;
        while(lo <= hi) {
            int div = lo + (hi-lo) / 2;
            
            if(isPossible(nums,threshold,div)) {
                ans = div;
                hi = div-1;
            } else {
                lo = div+1;
            }
        } 
        return ans;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]nums = new int[n];

        for(int i=0 ; i < n ; i++) {
            nums[i] = scn.nextInt();
        }

        int th = scn.nextInt();

        int speed = findSmallestDivisor(nums,th);
        System.out.println(speed);
    }
}