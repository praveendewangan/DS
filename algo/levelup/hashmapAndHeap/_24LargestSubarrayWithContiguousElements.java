import java.util.*;

public class _24LargestSubarrayWithContiguousElements {

	public static int solution(int[] arr) {
        int len = 0;
        for(int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int min = arr[i];
            HashSet<Integer> set = new HashSet<>();
            for(int j = i; j < arr.length; j++) {
                if(set.contains(arr[j]) == true) {
                    break;
                }
                set.add(arr[j]);

                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                if(max - min == j - i) {
                    len = Math.max(len, j - i + 1);
                }
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
