import java.io.*;
import java.util.*;

public class _28MinimumNumberofSwapsRequiredtoSortanArrayOfficial {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    String[] st = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st[i]);
    }

    System.out.println(minSwaps(arr));
  }

  public static int minSwaps(int[] arr) {
      int n = arr.length;
    Pair[] pairs = new Pair[n];
    for(int i = 0; i < n; i++) {
        pairs[i] = new Pair(arr[i],i);
    }
    Arrays.sort(pairs);
    boolean[] vis = new boolean[n];
    int ans = 0;
    for(int i=0; i < n; i++) {
        if(vis[i] || pairs[i].idx == i) {
            continue;
        }
        int clen = 0;
        int j = i;
        while(!vis[j]) {
            vis[j] = true;
            j = pairs[j].idx;
            clen++;
        }
        ans += clen-1;
    }
    return ans;
  }

  private static class Pair implements Comparable<Pair> {
    int val;
    int idx;

    Pair(int val, int idx) {
      this.val = val;
      this.idx = idx;
    }

    @Override
    public int compareTo(Pair o) {
      return this.val - o.val;
    }
  }
}
