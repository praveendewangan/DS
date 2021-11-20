import java.util.*;

public class _3CountDistinctElementsInEveryWindowOfSizeK {

	public static ArrayList<Integer> solution(int[] arr, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0; i < k-1; i++){
		    int val = arr[i];
		    map.put(val,map.getOrDefault(val,0)+1);
		}

        for(int j=0, i=k-1; i < arr.length; i++,j++) {
		    map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            int count = map.keySet().size();
            ans.add(count);
            int freq = map.get(arr[j]);
            if(freq == 1) {
                map.remove(arr[j]);
            } else {
                map.put(arr[j],freq-1);
            }
        }
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}


}
