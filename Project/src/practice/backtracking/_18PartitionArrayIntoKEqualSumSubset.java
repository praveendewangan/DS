package practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _18PartitionArrayIntoKEqualSumSubset {
    boolean flag = false;
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	    int sum = 0;
	    for(int val : a) {
	        sum += val;
	    }
	    if(sum % k != 0){
	        return false;
	    }
	    if(k == 1) {
	        return true;
	    }
	    if(k > a.length) {
	        return false;
	    }
	    List<List<Integer>> list = new ArrayList<>();
	    for(int i=0;i<k;i++) {
	        list.add(new ArrayList<>());
	    }
	    int[] subsetSum = new int[k];
	    helper(a,0,n,k,list,subsetSum,0);
	    return flag;
    }
    
    public void helper(int[] a,int idx,int n,int k,List<List<Integer>> list
    ,int[] subsetSum ,int set) {
        if(idx == a.length) {
            if(set == k) {
                boolean res= true;
                for(int i=0;i<k-1;i++){
                    if(subsetSum[i] != subsetSum[i+1]) {
                        res = false;
                        break;
                    }
                }
                if(res) {
                    if(!flag){
                        flag = true;
                    }
                }
            }
            return;
        }
        for(int i=0;i<list.size();i++){
            if(flag) {
                return;
            }
            if(list.get(i).size() > 0) {
                list.get(i).add(a[idx]);
                subsetSum[i] += a[idx];
                helper(a,idx+1,n,k,list,subsetSum,set);
                subsetSum[i] -= a[idx];
                list.get(i).remove(list.get(i).size()-1);
            } else {
                list.get(i).add(a[idx]);
                subsetSum[i] += a[idx];
                helper(a,idx+1,n,k,list,subsetSum,set+1);
                subsetSum[i] -= a[idx];
                list.get(i).remove(list.get(i).size()-1);
                break;
            }
        }
    }
}
