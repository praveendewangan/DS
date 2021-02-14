package practice.string;

import java.util.HashMap;

public class _41IsIsomorphic2 {
    public static boolean areIsomorphic(String str1,String str2)
    {
        if(str1.length() != str2.length()) return false;

        Map<Character,Character> hm1 = new HashMap<>();
        Map<Character,Boolean> hm2 = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if(hm1.containsKey(ch1)){
                if(hm1.get(ch1) != ch2){
                    return false;
                }
            } else {
                if(hm2.containsKey(ch2)) {
                    return false;
                } else {
                    hm1.put(ch1,ch2);
                    hm2.put(ch2,true);
                }
            }
        }
        return true;
        
    }
}
