import java.util.*;

public class _11RoufTop {

    public static int findMaxSteps(int[]arr) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1]){
                count++;
            } else {
                max = Math.max(max,count);
                count = 0;
            }
        }
         max = Math.max(max,count);
        return  max;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMaxSteps(arr);
        System.out.println(ans);
    }
}