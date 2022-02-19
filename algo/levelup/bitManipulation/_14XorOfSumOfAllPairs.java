import java.io.*;
import java.util.*;

public class _14XorOfSumOfAllPairs {

    public static int solution(int[] arr){
       int res = 0;
        for(int val : arr) {
            res = (res ^ val);
        }
        return 2 * res;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
    
    
}