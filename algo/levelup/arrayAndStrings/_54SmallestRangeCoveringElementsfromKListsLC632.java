import java.util.*;

public class _54SmallestRangeCoveringElementsfromKListsLC632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = {-100000,100000};
        int k = nums.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[0]-b[0]));
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++){
            int val = nums.get(i).get(0);
            int[] arr = {val,0,i};
            // 0th - min element of the list
            // 1st - index of element from the list
            // 2nd - index of list in nums
            max = Math.max(max,val);
            pq.add(arr);
        }
        
        while(true) {
            int[] min = pq.remove();
            
            if(res[1] - res[0] > max - min[0]) {
                res[0] = min[0];
                res[1] = max;
            }
            min[1]++;
            List<Integer> cur = nums.get(min[2]);
            if(min[1] == cur.size()) {
                break;
            } else {
                min[0] = cur.get(min[1]);
                max = Math.max(max,cur.get(min[1]));
               pq.add(min);
            }
        }
       return res;
    }
}
