import java.util.*;

public class _25TwoSumTargetUniquePair {

  // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static List<List<Integer>> twoSum(int[] arr, int target) {
    // write your code here
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(arr);
    int i = 0;
    int j = arr.length-1;
    while(i < j) {
        if(i != 0 && arr[i] == arr[i-1]){
            i++;
            continue;
        }
        int sum = arr[i] + arr[j]; 
        if(sum == target) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[j]);
            res.add(list);
            i++;
            j--;
        } else if(sum < target) {
            i++;
        } else {
            j--;
        }
    }
    return res;
  }

  // ~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = twoSum(arr, target);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }
}