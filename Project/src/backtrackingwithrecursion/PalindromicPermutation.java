package backtrackingwithrecursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PalindromicPermutation {
    private static void generatePermutation(int cs,int ts,Map<Character,Integer> fmap,Character odd,String asf) {
        if (cs > ts) {
            String rev = "";
            for (int i = asf.length() - 1; i >= 0; i--) {
                rev += asf.charAt(i);
            }
            String res = asf;
            if (odd != null) {
                res += odd;
            }
            res += rev;
            System.out.println(res);
            return;
        }
        for (char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq > 0) {
                fmap.put(ch,freq - 1);
                generatePermutation(cs + 1,ts,fmap,odd,asf + ch);
                fmap.put(ch,freq);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        Map<Character,Integer> fmap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (fmap.containsKey(ch)) {
                int val = fmap.get(ch);
                fmap.put(ch,val + 1);
            } else {
                fmap.put(ch,1);
            }
        }
        Character odd = null;
        int odds = 0;
        int len = 0;
        for ( char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if(freq % 2 == 1) {
                odd = ch;
                odds++;
            }
            fmap.put(ch,freq / 2);
            len += freq / 2;
        }
        if (odds > 1) {
            System.out.println("-1");
            return;
        }
        generatePermutation(1,len,fmap,odd,"");
    }
}
