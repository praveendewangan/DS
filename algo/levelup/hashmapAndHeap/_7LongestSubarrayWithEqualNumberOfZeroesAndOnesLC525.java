import java.util.*;

public class _7LongestSubarrayWithEqualNumberOfZeroesAndOnesLC525 {

    public static int solution(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
		map.put(0,-1);
		int len = 0;
		int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if(val == 0) {
                val = -1;
            }
            sum += val;
            if(map.containsKey(sum)) {
                len = Math.max(len,i-map.get(sum));
            } else {
                map.put(sum,i);
            }
        }
		return len;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
