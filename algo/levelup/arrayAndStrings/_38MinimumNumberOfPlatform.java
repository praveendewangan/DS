import java.util.*;

public class _38MinimumNumberOfPlatform {

  public static int findPlatform(int[] arr, int[] dep) {
    Arrays.sort(arr);
    Arrays.sort(dep);
    int c = 0;
    int max = 0;
    int n = arr.length;
    int m = dep.length;
    int i = 0;
    int j = 0;
    while(i < n && j < m) {
        if(arr[i] <= dep[j]) {
            c++;
            i++;
        } else {
            c--;
            j++;
        }
        max = Math.max(max,c);
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int[] dep = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    for (int i = 0; i < n; i++) {
      dep[i] = scn.nextInt();
    }

    int plateforms = findPlatform(arr, dep);
    System.out.println(plateforms);
  }
}