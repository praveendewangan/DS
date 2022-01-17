import java.util.*;

public class _5LargestSubarrayWithZeroSumLC560 {
	
	public static int solution(int[] arr) {
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0,-1);
		int len = 0;
		int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
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
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
