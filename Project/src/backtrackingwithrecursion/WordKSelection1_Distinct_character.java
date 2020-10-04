package backtrackingwithrecursion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordKSelection1_Distinct_character {
    private static void solution(int i,String str,int cs,int ts,String asf) {
        if(i == str.length()) {
            if(cs == ts) {
                System.out.println(asf);
            }
            return;
        }
        char ch = str.charAt(i);
        solution(i+1,str,cs+1,ts,asf+ch);
        solution(i+1,str,cs,ts,asf);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Set<Character> sets = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if(!sets.contains(ch)) {
                sets.add(ch);
                ustr += ch;
            }
        }
        solution(0,ustr,0,k,"");
    }
}
