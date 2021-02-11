package practice.string;

import java.util.HashMap;
import java.util.Map;

public class _25RomanNumberToInteger {
    // O(n),O(1)
    public int romanToDecimal(String str) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int i = 0;
        int j = str.length();
        int total = 0;
        int num = 0;
        while(i < j){
            total += map.get(str.charAt(i));
            if(i != 0 && map.get(str.charAt(i)) > num) {
                total -= 2*num;
            } 
                num = map.get(str.charAt(i));
            i++;
        }
        return total;
    }
}
