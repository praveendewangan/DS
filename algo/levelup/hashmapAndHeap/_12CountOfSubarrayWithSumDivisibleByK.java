import java.util.*;

public class _12CountOfSubarrayWithSumDivisibleByK {

    public static int solution(int[] arr, int k) {
       int sum = 0;
       Map<Integer,Integer> map = new HashMap<>();
       map.put(0,1);
       int count = 0;
       for(int i = 0; i < arr.length; i++){
           int val = arr[i];
           sum += val;
           int rem = sum % k;
           if(rem  < 0) {
               rem += k;
           }
           if(map.containsKey(rem)) {
               count +=  map.get(rem);
           }
           map.put(rem,map.getOrDefault(rem,0)+1);
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
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
