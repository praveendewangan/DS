import java.util.*;

public class _35ArithmeticSequenceLC1502 {

    public static boolean solution(int[] arr) {
		if(arr.length <= 1) return true; 
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE,sum = 0;
		Set<Integer> set = new HashSet<>();
		for(int val : arr){
			min = Math.min(min,val);
			max = Math.max(max,val);
			set.add(val);
		}

		int d = (max-min) / (arr.length - 1);
		sum = min;
		while(sum < max) {
			sum += d;
			if(!set.contains(sum)) return false;
		}
        
        return true;
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
