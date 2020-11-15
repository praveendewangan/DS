package hashmapandheap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _8MergeKSortedLists {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }
            lists.add(list);
        }
        List<Integer> mlist = mergeSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }

    }
    public static class Pair implements Comparable<Pair>{
        int li;
        int di;
        int val;
        Pair(int li,int di,int val) {
            this.li = li;
            this.di = di;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
    public static List<Integer> mergeSortedLists(List<List<Integer>> lists) {
        List<Integer> rv = new ArrayList<>();
        Queue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            Pair p = new Pair(i,0,lists.get(i).get(0));
            pq.add(p);
        }
        while (pq.size() > 0) {
            Pair p = pq.remove();
            rv.add(p.val);
            p.di++;

            if(p.di < lists.get(p.li).size()) {
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        return rv;
    }
}
