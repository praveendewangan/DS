import java.io.*;
import java.util.*;

public class _4MergeKSortedList {
    static class Pair implements Comparable<Pair>{
        int data;
        int slot;
        int idx;
        Pair(int data,int slot,int idx) {
            this.data = data;
            this.slot = slot;
            this.idx = idx;
        }
        public int compareTo(Pair p){
            return this.data - p.data;
        }
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
    
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i).size() > 0) {
              pq.add(new Pair(lists.get(i).get(0),i,0));
            }
        }
        while(pq.size() > 0){
            Pair rm = pq.remove();
            rv.add(rm.data);
            if(lists.get(rm.slot).size() > rm.idx+1){
                pq.add(new Pair(lists.get(rm.slot).get(rm.idx+1),rm.slot,rm.idx+1));
            }
        }
      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}