import java.util.*;

public class _27FourSumUniqueQuadruple {

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for(int i = 0; i < nums.length-3; i++){
        if(i != 0 && nums[i] == nums[i-1]){
            continue;
        }
        int left = i+1;
        int right = nums.length-1;
        int tar = target - nums[i];
        List<List<Integer>> list = threeSum(nums,left,tar);
        for(List<Integer> l : list){
            l.add(nums[i]);
            res.add(l);
        }
    }
    // System.out.println(res);
    return res;
  }
  
  public static List<List<Integer>> threeSum(int[] nums,int idx, int targ) {
    // write your code here
    List<List<Integer>> res = new ArrayList<>();
    for(int i = idx; i < nums.length-2; i++){
        if(i != idx && nums[i] == nums[i-1]){
            continue;
        }
        int left = i+1;
        int right = nums.length-1;
        int target = targ - nums[i];
        List<List<Integer>> list = twoSum(nums,left,right,target);
        for(List<Integer> l : list){
            l.add(nums[i]);
            res.add(l);
        }
    }
    // System.out.println(res);
    return res;
  }
  public static List<List<Integer>> twoSum(int[] arr,int i,int j, int target) {
    // write your code here
    int idx = i;
    List<List<Integer>> res = new ArrayList<>();
    while(i < j) {
        if(i != idx && arr[i] == arr[i-1]){
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

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = fourSum(arr, target);
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