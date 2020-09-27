package backtrackingwithrecursion;

import java.util.Scanner;

public class MaximumNumAfterKSwaps {
    private static String max;
    private static void findMax(String str,int k) {
        if(Integer.parseInt(str) > Integer.parseInt(max)) {
            max = str;
        }
        if(k==0) {
            return;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i+1; j < str.length(); j++) {
                if(str.charAt(j) > str.charAt(i)) {
//                    WITHOUT BACKTRACKING
//                    String swapped = swap(str,i,j);
//                    findMax(swapped,k-1);
//                    WITH BACKTRACKING
                    str = swap(str,i,j);
                    findMax(str,k-1);
                    str = swap(str,i,j);
                }
            }
        }
    }
    private static String swap(String str,int i,int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);
        String left = str.substring(0,i);
        String middle = str.substring(i+1,j);
        String right = str.substring(j+1);
        return left + jth + middle + ith + right;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        max = str;
        findMax(str,k);
        System.out.println(max);
    }
}
