import java.util.*;

public class _10CountOfSubarraysHavingSumEqualsToK {

	public static int solution(int[] arr, int k){
        Map<Integer,Integer> map = new HashMap<>();
		map.put(0,1);
		int count = 0;
		int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            sum += val;
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
       
            map.put(sum,map.getOrDefault(sum,0)+1);
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
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}

}