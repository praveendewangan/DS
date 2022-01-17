import java.util.*;

public class _14CountOfSubarrayWithEqualNumberOf0s1sAnd2s {

    public static int solution(int[] arr) {
        Map<String,Integer> map = new HashMap<>();
		map.put("0#0",1);
		int count = 0;
		int c0 = 0;
		int c1 = 0;
		int c2 = 0;
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if(val == 0){
                c0++;
            } else if(val == 1) {
                c1++;
            } else {
                c2++;
            }
            String key = (c1 - c0) + "#" + (c2- c1); 
            if(map.containsKey(key)) {
                count += map.get(key);
            }
            map.put(key,map.getOrDefault(key,0)+1);
        }
		return count;
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
