import java.util.*;
public class _12BoxStackingLC1691 {
    public int maxHeight(int[][] cuboids) {
        Box[] arr = new Box[cuboids.length];
        int j = 0;
        for(int[] box : cuboids) {
            Arrays.sort(box);
            arr[j++] = new Box(box[0], box[1], box[2]);
        }
        Arrays.sort(arr);
        int[] dp = new int[arr.length];
        dp[0] = arr[0].h;
        int maxHeight = dp[0];
        for(int i = 1; i < arr.length; i++) {
            int max = 0;
            for(int k = i - 1; k >= 0; k--) {
                if(arr[k].l >= arr[i].l && arr[k].b >= arr[i].b && arr[k].h >= arr[i].h) {
                    max = Math.max(max, dp[k]);
                }
            }
            dp[i] = max + arr[i].h;
            maxHeight = Math.max(maxHeight, dp[i]);
        }
        return maxHeight;
    }
    private static class Box implements Comparable<Box> {
        int l;
        int b;
        int h;
        int area;

        public Box(int l, int b, int h) {
            this.l = l;
            this.b = b;
            this.h = h;
            this.area = this.l * this.b;
        }

        public int compareTo(Box o) {
            if(o.area != this.area)
                return o.area - this.area;
            else
                return o.h - this.h;
        }
    }

    public static int maxHeight(int[] height, int[] width, int[] length, int n) {
        Box[] arr = new Box[3 * n];
        int j = 0;
        for(int i = 0; i < n; i++) {
            // LBH
            if(length[i] > width[i]) {
                arr[j++] = new Box(length[i], width[i], height[i]);
            } else {
                arr[j++] = new Box(width[i], length[i], height[i]);
            }
            // HBL
            if(height[i] > width[i]) {
                arr[j++] = new Box(height[i], width[i], length[i]);
            } else {
                arr[j++] = new Box(width[i], height[i], length[i]);
            }
            // LHB
            if(length[i] > height[i]) {
                arr[j++] = new Box(length[i], height[i], width[i]);
            } else {
                arr[j++] = new Box(height[i], length[i], width[i]);
            }
        }
        Arrays.sort(arr);
        int[] dp = new int[3 * n];
        dp[0] = arr[0].h;
        int maxHeight = dp[0];
        for(int i = 1; i < 3 * n; i++) {
            int max = 0;
            for(int k = i - 1; k >= 0; k--) {
                if(arr[k].l > arr[i].l && arr[k].b > arr[i].b) {
                    max = Math.max(max, dp[k]);
                }
            }
            dp[i] = max + arr[i].h;
            maxHeight = Math.max(maxHeight, dp[i]);
        }
        return maxHeight;
    }
}