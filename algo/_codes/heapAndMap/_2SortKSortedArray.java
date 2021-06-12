import java.io.*;
import java.util.*;

public class _2SortKSortedArray {
    private static void sort(int[] a,int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < a.length; i++) {
            if(pq.size() < k) {
                pq.add(a[i]);
            } else {
                pq.add(a[i]);
                System.out.println(pq.remove());
            }
        }
        while(pq.size()>0) {
                System.out.println(pq.remove());
        }
    }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      sort(arr,k);
   }

}
