import java.util.*;

public class _23MaximumConsecutiveOnes2LC1004 {

    public static int solution(int[] arr, int k){
        int ans = 0;
        int j = -1;
        int count0 = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) count0++;

            while(count0 > k) {
                // release
                j++;
                if(arr[j] == 0) count0--;
            }
            // count 0 must be less than equal to 1
            ans = Math.max(ans, i - j);
        }
        return ans;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr,k));
	}

}
