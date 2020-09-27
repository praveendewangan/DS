package backtrackingwithrecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumSubsetSumDifference {
    private static int minDiff = Integer.MAX_VALUE;
    private static String ans = "";
    private static void solution(int[] arr,int vidx,ArrayList<Integer> set1,ArrayList<Integer> set2,
                                 int sum1,int sum2){
        if (vidx == arr.length) {
            int delta = Math.abs(sum1-sum2);
            if(delta < minDiff) {
                minDiff = delta;
                ans = set1 + " " + set2;
            }
            return;
        }
        if(set1.size() < (arr.length + 1)/2) {
            set1.add(arr[vidx]);
            solution(arr,vidx+1,set1,set2,sum1 + arr[vidx],sum2);
            set1.remove(set1.size()-1);
        }
        if(set2.size() < (arr.length + 1)/2) {
            set2.add(arr[vidx]);
            solution(arr,vidx+1,set1,set2,sum1,sum2 + arr[vidx]);
            set2.remove(set2.size()-1);
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr,0,new ArrayList<>(),new ArrayList<>(),0,0);
        System.out.println(ans);
    }
}
