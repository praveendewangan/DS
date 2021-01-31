package practice.arrays;

import java.util.HashSet;
import java.util.Set;

public class _21SubArraySumZero {
    public static void main(String[] args){
        System.out.println(solution(new int[]{4,2,-3,1,6},5));
    } 

    public static boolean solution(int[] a,int n) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : a){
            set.add(sum);
            sum += num;
            if(set.contains(sum)){
                return true;
            }
        }
        return false;
    }
}