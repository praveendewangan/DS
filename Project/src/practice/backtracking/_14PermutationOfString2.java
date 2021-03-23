package practice.backtracking;

import java.util.*;

public class _14PermutationOfString2 {
    // O(n!*n),O(n)
    public List<String> find_permutation(String S) {
        List<String> list = new ArrayList<>();
        solve(S,0,S.length()-1,list);
        return list;
    }
    
    public void solve(String str,int l,int r,List<String> list) {
         if (l == r) 
            list.add(str); 
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = swap(str,l,i); 
                solve(str, l+1, r,list); 
                str = swap(str,l,i); 
            } 
        }
    }
    
    public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    }
}
