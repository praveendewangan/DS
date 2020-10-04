package backtrackingwithrecursion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordKLength2_Distinct_character {
    private static void generate(int cs,int ts,String str,Set<Character> sets,String asf) {
        if(cs > ts) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!sets.contains(ch)) {
                sets.add(ch);
                generate(cs+1,ts,str,sets,asf+ch);
                sets.remove(ch);
            }
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
        generate(1,k,ustr,new HashSet<>(),"");
    }
}
