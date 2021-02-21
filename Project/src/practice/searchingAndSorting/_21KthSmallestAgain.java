package practice.searchingAndSorting;

import java.util.*;

public class _21KthSmallestAgain {
        // O(n*m),O(1);
    public static void main(String[] args) {
        int t = 1;
        while(t != 0) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> l1 = new ArrayList<>();
            l1.add(1);
            l1.add(3);
            List<Integer> l2 = new ArrayList<>();
            l2.add(1);
            l2.add(5);
            list.add(l1);
            list.add(l2);
            // sort if required

            // merge interval
            int idx = 0;
            for(int i=1;i<list.size();i++) {
                if(list.get(idx).get(1) >= list.get(i).get(0)){
                    list.get(idx).set(1,Math.max(list.get(idx).get(1),list.get(i).get(1)));
                } else {
                    idx++;
                    list.set(idx,list.get(i));        
                }
            }
            int[] q = new int[]{1,3,6};
            int qidx = 0;
            while(qidx < q.length) {
                int k = q[qidx];
                int ans = -1;
                for(int i=0;i <= idx;i++){
                    if(list.get(i).get(1) - list.get(i).get(0) + 1 >= k) {
                        ans = list.get(i).get(0) + k - 1;
                        break;
                    } else {
                        k = k - (list.get(i).get(1) - list.get(i).get(0) + 1);
                    }
                }
                System.out.println(ans);
                qidx++;
            }
            t--;
        }
    }
}
