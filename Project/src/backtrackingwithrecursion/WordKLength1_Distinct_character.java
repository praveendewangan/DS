package backtrackingwithrecursion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordKLength1_Distinct_character {
    private static void generate(int cc,String str,int ssf,int ts,Character[] spots) {
        if (cc == str.length()) {
            if(ssf == ts) {
                for (int i = 0; i < spots.length; i++) {

                    System.out.print(spots[i]);
                }
                System.out.println();
            }
            return;
        }
        char ch = str.charAt(cc);
        for (int i = 0; i < spots.length; i++) {
            if(spots[i] == null) {
                spots[i] = ch;
                generate(cc+1,str,ssf+1,ts,spots);
                spots[i] = null;
            }
        }
        generate(cc+1,str,ssf,ts,spots);
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
        Character[] spots = new Character[k];
        generate(0,ustr,0,k,spots);
    }
}
