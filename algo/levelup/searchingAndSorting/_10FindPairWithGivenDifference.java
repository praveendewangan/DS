import java.util.*;
import java.io.*;

public class _10FindPairWithGivenDifference {


    public static void findPair(int[]arr,int target) {
        Arrays.sort(arr);
        
        int lo = 0;
        int hi = 1;
        while(hi < arr.length) {
            int dif = arr[hi] - arr[lo];
            if(dif == target){
                System.out.println(arr[lo] + " " + arr[hi]);
                return;
            } else if(dif > target) {
                lo++;
            } else {
                hi++;
            }
        }
        System.out.println("-1");
    }

    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        findPair(arr,target);
    }
}