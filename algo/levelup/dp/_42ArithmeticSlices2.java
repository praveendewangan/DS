import java.io.*;
import java.util.*;

public class _42ArithmeticSlices2 {

	public static int solution(int[] arr) {
        int n = arr.length;
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for(int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int count = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                long cd = (long)arr[i] - (long)arr[j];

                int countInI = dp[i].getOrDefault(cd, 0);
                int countInJ = dp[j].getOrDefault(cd, 0);
                
                count += countInJ;
                dp[i].put(cd, countInI + countInJ + 1);
            }
        }
        return count;
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