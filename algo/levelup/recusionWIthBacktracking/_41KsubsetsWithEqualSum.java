import java.io.*;
import java.util.*;

public class _41KsubsetsWithEqualSum {


	public static boolean isSumSame(int[] arr) {
        int val = arr[0];
        for(int ele : arr) {
            if(ele != val) return false;
        }
        return true;
    }

    public static void solution(int[] arr, int indx, int sum, int k, int[] subsetSum, int ssf, ArrayList<ArrayList<Integer>> ans) {
        if(indx == arr.length) {
            if(ssf == k) {
                if(isSumSame(subsetSum) == true) {
                    for(ArrayList<Integer> list : ans) {
                        System.out.print(list + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }
        int val = arr[indx];
        int i = 0;
        // merging with existing set
        while(i < ans.size() && ans.get(i).size() > 0) {
            if(subsetSum[i] + val <= (sum / k)) {
                // increase subset sum
                subsetSum[i] += val;
                // add in answer so far
                ans.get(i).add(val);
                solution(arr, indx + 1, sum, k, subsetSum, ssf, ans);
                // decrease subset sum
                subsetSum[i] -= val;
                // remove from asf
                ans.get(i).remove(ans.get(i).size() - 1);
            }
            i++;
        }
        if(i < k) {
            // single call with new set
            // increase subset sum
            subsetSum[i] += val;
            // add in answer so far
            ans.get(i).add(val);
            solution(arr, indx + 1, sum, k, subsetSum, ssf + 1, ans);
            // decrease subset sum
            subsetSum[i] -= val;
            // remove from asf
            ans.get(i).remove(ans.get(i).size() - 1);
        }
    }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k > n || sum % k != 0) {
			System.out.println("-1");
			return;
		}
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(arr,0,sum,k,subsetSum,0,ans);
	}
	
	

}