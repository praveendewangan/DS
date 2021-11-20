import java.util.*;

public class _45IntervalListIntersectionsLC986 {
  public static int[][] intersection(int intervalList1[][], int intervalList2[][]) {
      ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < intervalList1.length && j < intervalList2.length) {
            int st = Math.max(intervalList1[i][0], intervalList2[j][0]);
            int end = Math.min(intervalList1[i][1], intervalList2[j][1]);
            if(st <= end) {
                // it is valid interval
                int[] sublist = {st, end};
                list.add(sublist);
            }
            if(intervalList1[i][1] < intervalList2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    // Input format
    int n = scn.nextInt();
    int list1[][] = new int[n][2];
    for (int i = 0 ; i < n ; i++) {
      list1[i][0] = scn.nextInt();
      list1[i][1] = scn.nextInt();
    }

    int m = scn.nextInt();
    int list2[][] = new int[m][2];
    for (int i = 0 ; i < m ; i++) {
      list2[i][0] = scn.nextInt();
      list2[i][1] = scn.nextInt();
    }

    // output
    int ans[][] = intersection(list1, list2);
    System.out.print("[");
    for (int interval[] : ans) {
      System.out.print(Arrays.toString(interval));
    }
    System.out.println("]");
  }
}
