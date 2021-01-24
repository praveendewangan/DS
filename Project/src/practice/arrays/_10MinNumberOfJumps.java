package practice.arrays;


import dynamicprogramsLU._15PrintAllPathsWithMinJumps;

import java.util.ArrayDeque;
import java.util.Scanner;

/*Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.

    Input:
        The first line contains an integer T, depicting total number of test cases.  Then following T lines contains a number n denoting the size of the array. Next line contains the sequence of integers a1, a2, ..., an.

    Output:
        For each testcase, in a new line, print the minimum number of jumps. If answer is not possible print -1.

        Constraints:
        1 ≤ T ≤ 100
        1 ≤ N ≤ 107
        0 <= ai <= 107

Example:
    Input:
        2
        11
        1 3 5 8 9 2 6 7 6 8 9
        6
        1 4 3 2 6 7
    Output:
        3
        2*/
public class _10MinNumberOfJumps {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int n = 11;
        System.out.println(minJump(a,n));
    }

    private static int minJump(int[] a ,int n) {
        int maxR = a[0];
        int step = a[0];
        int jump = 1;
        if(n == 1) {
            return 0;
        } else if(a[0] == 0) {
            return -1;
        } else {
            for (int i = 1; i < n; i++) {
                if(i == n-1) {
                    return jump;
                }
                maxR = Math.max(maxR,i+a[i]);
                step--;
                if(step == 0) {
                    jump++;
                    if(i >= maxR) {
                        return -1;
                    }
                    step = maxR-i;
                }
            }
        }
        return -1;
    }
    public static class Pair {
        int i;
        int s;
        int j;
        String psf;
        Pair(int i,int s,int j,String psf) {
            this.i = i;
            this.s = s;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void Solution(int arr[]) {
        Integer[] dp = new Integer[arr.length];
        dp[arr.length-1] = 0;

        for(int i=arr.length-2;i >= 0;i--){
            int min = Integer.MAX_VALUE;
            int steps = arr[i];
            for(int j=1;j<= steps && i+j < arr.length;j++){
                if(dp[i+j] != null && dp[i+j] < min){
                    min = dp[i+j];
                }
            }
            if(min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        System.out.println(dp[0]);
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,arr[0],dp[0],0+""));
        while(q.size() > 0){
            Pair r = q.removeFirst();
            if(r.j == 0) {
                System.out.println(r.psf+" .");
            }
            for(int j=1;j <= r.s && r.i + j < arr.length;j++){
                int ci = r.i+j;
                if(dp[ci] != null && dp[ci] == r.j-1){
                    q.add(new Pair(ci,arr[ci],dp[ci],r.psf+" -> "+ci));
                }
            }
        }
    }
    public static void main1(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }

}
