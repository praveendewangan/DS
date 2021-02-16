package practice.searchingAndSorting;

import java.util.ArrayList;
import java.util.Arrays;

public class _11FindAllFourSumNumbers {
    // O(n^3),O(1)
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(arr == null || arr.length == 0) {
            return res;
        }
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int target = k - arr[j] - arr[i];
                int left = j+1;
                int right = n-1;
                while(left < right){
                    int twoSum = arr[left]+arr[right];
                    if(twoSum < target){
                        left++;
                    } else if(twoSum > target) {
                        right--;
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[left]);
                        list.add(arr[right]);
                        res.add(list);
                        
                        while(left < right && arr[left] == list.get(2)) {
                            left++;
                        }
                        while(left < right && arr[right] == list.get(3)) {
                            right--;
                        }
                    }
                }
                while(j+1 < n && arr[j+1] == arr[j]) j++;
                
            }
                while(i+1 < n && arr[i+1] == arr[i]) i++;
        }   
        return res;
    }
      
}
