package backtrackingwithrecursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PermutationWIthDuplicateWords {
    private static void solution(int cs,int ts,Map<Character,Integer> fmp,String asf) {
        if(cs > ts){
            System.out.println(asf);
            return;
        }
        for (char ch:fmp.keySet()) {
            if(fmp.get(ch) > 0) {
                fmp.put(ch,fmp.get(ch) - 1);
                solution(cs + 1,ts,fmp,asf + ch);
                fmp.put(ch,fmp.get(ch) + 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        Map<Character,Integer> mp = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(mp.containsKey(ch)){
                int count = mp.get(ch);
                mp.put(ch,count + 1);
            } else {
                mp.put(ch,1);
            }
        }
        solution(1,str.length(),mp,"");
    }
}
