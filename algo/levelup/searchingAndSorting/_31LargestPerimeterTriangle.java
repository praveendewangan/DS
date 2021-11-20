import java.util.*;
import java.io.*;

public class _31LargestPerimeterTriangle {
  public static int largestPerimeter(int[]nums) {
    Arrays.sort(nums);
    int n = nums.length;
    if(n < 3) {
        return -1;
    }
    for(int i=n-1; i>=2; i--) {
        if(nums[i-1] + nums[i-2] > nums[i]) {
            return nums[i-1] + nums[i-2] + nums[i];
        }
    }
    return 0;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]nums = new int[n];

    for (int i = 0; i < n; i++) {
      nums[i] = scn.nextInt();
    }

    System.out.println(largestPerimeter(nums));
  }
}