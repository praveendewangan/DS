package backtrackingwithrecursion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordKSelection2_Distinct_character {
    private static void generate(String str,int cs,int ts,int lc,String asf) {
        if(cs > ts) {
            System.out.println(asf);
            return;
        }
        for (int i = lc + 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            generate(str,cs+1,ts,i,asf + ch);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        String ustr = "";
        Set<Character> sets = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if(!sets.contains(ch)) {
                sets.add(ch);
                ustr += ch;
            }
        }
        generate(ustr,1,k,-1,"");
    }
}
