import java.util.*;

public class _4CheckIfAnArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByKLC1497 {
	
	public static boolean solution(int[] arr, int k){
		Map<Integer,Integer> map = new HashMap<>();
        
        for(int val : arr){
            int rem = val % k;
            // for negative numbers
            if(rem < 0) rem += k;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        
        for(int val : arr){
            int rem = val % k;
            // for negative numbers
            if(rem < 0) rem += k;
            if(rem == 0) {
                if(map.get(rem) % 2 == 1) {
                    return false;
                }
            } else if(2* rem == k) {
                /// for k = 10 and  rem = 5
                if(map.get(rem) % 2 == 1) {
                    return false;
                }
            } else {
                int fq = map.get(rem);
                int ofq = map.getOrDefault(k-rem,0);
                if(fq != ofq) {
                    return false;
                }
            }
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
		int k = scn.nextInt();
		System.out.println(solution(arr,k));
	}

}
