package practice.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class _12CombinationSum {
    // O(2^tk),O(kx)
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        Set<ArrayList<Integer>> set = new HashSet<>();
        helper(A,B,0,set,new ArrayList<>());
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(set);
        return res;
    }
    
    static void helper(ArrayList<Integer> a,int tar,
            int idx,Set<ArrayList<Integer>> set,ArrayList<Integer> list) {
        
        if(idx == a.size()){
            if(tar == 0) {
                
                set.add(new ArrayList<>(list));
            }
            return;
        }
        if(a.get(idx) <= tar){
            list.add(a.get(idx));
            helper(a,tar-a.get(idx),idx,set,list);
            list.remove(list.size()-1);
        }
        helper(a,tar,idx+1,set,list);
    }
}
