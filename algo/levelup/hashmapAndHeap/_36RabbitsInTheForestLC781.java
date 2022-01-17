import java.util.*;

public class _36RabbitsInTheForestLC781 {

    public static int solution(int[] arr) {
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int val : arr) {
            fmap.put(val, fmap.getOrDefault(val, 0) + 1);
        }
        int count = 0;
        for(int key : fmap.keySet()) {
            int val = fmap.get(key);
            count += (key + 1) * (int)Math.ceil(val * 1.0 / (key + 1));
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
		System.out.println(solution(arr));
	}

}
