import java.util.*;

public class _28KSumTargetUniquePair {
    public static List<List<Integer>> twoSum(int[] arr,int si,int ei, int target) {
    // write your code here
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(arr);
    int i = si;
    int j = ei;
    while(i < j) {
        if(i != si && arr[i] == arr[i-1]){
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
    private static List<List<Integer>> kSum_(int[] arr, int target, int si, int k) {
        if(k == 2) {
            // base case
            return twoSum(arr, si, arr.length - 1, target);
        }

        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i = si; i < n - (k - 1); i++) {
            if(i != si && arr[i] == arr[i - 1]) 
                continue;

            int val1 = arr[i];
            int targ = target - val1;
            List<List<Integer>> subres = kSum_(arr, targ, i + 1, k - 1);

            for(List<Integer> list : subres) {
                list.add(val1);
                res.add(list);
            }
        }
        return res;
    }

  public static List<List<Integer>> kSum(int[] arr, int target, int k) {
    
    // main function -> main function will call to recursive function
    Arrays.sort(arr);
    List<List<Integer>> res = kSum_(arr, target, 0, k);
    return res;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    int k = scn.nextInt();
    List<List<Integer>> res = kSum(arr, target, k);
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