package backtrackingwithrecursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PermutationOfString {
    private static void generateWords(int cc,String str,Character[] spots,Map<Character,Integer> lasocc) {
        if(cc == str.length()) {
            for (int i = 0; i < spots.length; i++) {
                System.out.print(spots[i]);
            }
            System.out.println();
            return;
        }
        char ch = str.charAt(cc);
        int lo = lasocc.get(ch);
        for (int i = lo + 1; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                lasocc.put(ch,i);
                generateWords(cc+1,str,spots,lasocc);
                lasocc.put(ch,lo);
                spots[i] = null;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        Character[] spots = new Character[str.length()];
        Map<Character,Integer> lastOcc = new HashMap<>();
        for (char ch : str.toCharArray()) {
            lastOcc.put(ch,-1);
        }
        generateWords(0,str,spots,lastOcc);
    }
}
