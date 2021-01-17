package backtrackingwithrecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _11KPartitionSubsets {
    private static int count = 0;
    private static void solution(int i,int n ,int k, int nos,List<List<Integer>> list) {
        if (i > n) {
            if (nos == k) {
                count++;
                System.out.print(count+".");
                for (List<Integer> sets : list) {
                    System.out.print(sets);
                }
                System.out.println("");
            }
            return;
        }
        for (int j = 0; j < list.size(); j++) {
            if(list.get(j).size() > 0) {
                list.get(j).add(i);
                solution(i+1,n,k,nos,list);
                list.get(j).remove(list.get(j).size() - 1);
            } else {
                list.get(j).add(i);
                solution(i+1,n,k,nos + 1,list);
                list.get(j).remove(list.get(j).size() - 1);
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }
        solution(1,n,k,0,list);
    }
}
