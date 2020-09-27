package backtrackingwithrecursion;

import java.util.*;

public class PatternMatching {
    private static void solution(String str, String pattern, Map<Character, String> map,String op) {
        if(pattern.length() == 0) {
            if (str.length() == 0) {
                Set<Character> alrprin = new HashSet<>();
                for (int i = 0; i < op.length(); i++) {
                    char ch = op.charAt(i);
                    if(alrprin.contains(ch) == false) {
                        System.out.print(ch + " -> "+map.get(ch) + ", ");
                        alrprin.add(ch);
                    }
                }
                System.out.println(",");
            }
            return;
        }
        char ch = pattern.charAt(0);
        String rop = pattern.substring(1);

        if(map.containsKey(ch)) {
            String prevmap = map.get(ch);
            if(str.length() >= prevmap.length()) {
                String left = str.substring(0,prevmap.length());
                String right = str.substring(prevmap.length());
                if (prevmap.equals(left)) {
                    solution(right,rop,map,op);
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                String left = str.substring(0,i+1);
                String right = str.substring(i+1);
                map.put(ch,left);
                solution(right,rop,map,op);
                map.remove(ch);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        Map<Character,String> map = new HashMap<>();
        solution(str,pattern,map,pattern);
    }

}
