package practice.backtracking;

import java.util.*;

public class _13LargestNumberAfterKswaps {
    static String max; 
    static Map<String,String> mp = new HashMap<>();
    public static String findMaximumNum(String str, int k) {
        max = "0";
        findMax(str,k);
        return max;
    }
    
    public static void findMax(String str,int k) {
        if(Long.parseLong(max) < Long.parseLong(str)) {
            max = str;
            mp.put(str,str);
        } 
        if(k == 0) {
            return;
        }
        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j < str.length();j++){
                if(str.charAt(i) < str.charAt(j)) {
                    
                    String swapped = swap(str,i,j);
                    findMax(swapped,k-1);
                }
            }
        }
    }
    public static String swap(String str,int i,int j) {
        if(mp.containsKey(str+i+j)) {
            return mp.get(str+i+j);
        }
        char ith = str.charAt(i);
        char jth = str.charAt(j);
        String left = str.substring(0,i);
        String middle = str.substring(i+1,j);
        String right = str.substring(j+1);
        String s = left + jth + middle + ith + right;
        mp.put(str+i+j,s);
        return s;
    }
}
