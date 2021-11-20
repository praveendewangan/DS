import java.util.*;

public class _11MaxChunksToMakeArraySorted2 {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        int n = arr.length;
        int[] rightMin = new int[n+1];
        rightMin[n] = Integer.MAX_VALUE;
        int chunks = 0;
        
        for(int i = n-1; i >= 0; i--){
            rightMin[i] = Math.min(rightMin[i+1],arr[i]);
        }
        
        int leftMax = Integer.MIN_VALUE;
        for(int i=0; i < n; i++) {
            leftMax = Math.max(leftMax,arr[i]);
            if(leftMax <= rightMin[i+1]) {
                chunks++;
            }
        }
        return chunks;
        
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}