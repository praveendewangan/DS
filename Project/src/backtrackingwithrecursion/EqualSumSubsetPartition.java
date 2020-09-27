package backtrackingwithrecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EqualSumSubsetPartition {
    private static void solution(int[] arr,int vidx,int n,int k,int[] subsetsum,int nos,List<List<Integer>> list) {
        if(vidx > arr.length){
            if(nos == k) {
                boolean flag = true;
                for (int i = 0; i < subsetsum.length; i++) {
                    if (subsetsum[i] != subsetsum[i+1]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for (List<Integer> sets: list) {
                        System.out.print(sets + " ");
                    }
                    System.out.println("");
                }
            }
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).size() > 0) {
                list.get(i).add(vidx);
                subsetsum[i] += arr[vidx];
                solution(arr,vidx + 1,n,k,subsetsum,nos,list);
                subsetsum[i] -= arr[vidx];
                list.get(i).remove(list.size() - 1);
            } else {
                list.get(i).add(i);
                subsetsum[i] += arr[vidx];
                solution(arr,vidx + 1,n,k,subsetsum,nos + 1,list);
                subsetsum[i] -= arr[vidx];
                list.get(i).remove(list.get(i).size() - 1);
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int sum = scn.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList());
        }
        if(k == 1){
            for (int i = 0; i < n; i++) {
                System.out.println(i);
            }
            return;
        }
        if(k > n || sum % k != 0){
            System.out.println("-1");
            return;
        }
        int[] subset = new int[k];
        int[] arr = new int[k];
        solution(arr,0,n,k,subset,0,list);
    }
}
