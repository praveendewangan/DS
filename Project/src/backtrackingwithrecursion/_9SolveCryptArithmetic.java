package backtrackingwithrecursion;

import javax.print.DocFlavor;
import java.util.Map;

public class _9SolveCryptArithmetic {
    public static void main(String[] args) {

    }
    private static int getNum(String s,Map<Character,Integer> charIntMap) {
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            num += charIntMap.get(s.charAt(i));
        }
        return Integer.parseInt(num);
    }
    private static void solution(String unique, int idx, Map<Character,Integer> charIntMap,
                                 boolean[] usedNumbers, String s1, String s2,String s3) {
        if(idx == unique.length()) {
            int num1 = getNum(s1,charIntMap);
            int num2 = getNum(s2,charIntMap);
            int num3 = getNum(s3,charIntMap);
            if(num1 + num2 == num3) {
                for (int i = 0; i < 26; i++) {
                    char ch = (char)('a' + i);
                    if(charIntMap.containsKey(ch)) {
                        System.out.println(ch + "-" +charIntMap.get(ch) +" ");
                    }
                }
            }
            return;
        }
        char ch = unique.charAt(idx);
        for (int num  = 0; num <= 9; num++) {
            if(usedNumbers[num] == false) {
                charIntMap.put(ch,num);
                usedNumbers[num] = true;
                solution(unique,idx+1,charIntMap,usedNumbers,s1,s2,s3);
                charIntMap.put(ch,-1);
                usedNumbers[num] = false;
            }
        }
    }
}
