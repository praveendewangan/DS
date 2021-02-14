package practice.string;

public class _41IsIsomorphic {
    public static boolean areIsomorphic(String str1,String str2)
    {
        int c1 = 0;
        int c2 = 0;
        // Map<Character,Integer> hm1 = new HashMap<>();
        // Map<Character,Integer> hm2 = new HashMap<>();
        int[] hm1 = new int[256];
        int[] hm2 = new int[256];
        for(char ch : str1.toCharArray()){
            if(hm1[ch - 'a'] > 0){
                hm1[ch - 'a']++;
            } else {
                hm1[ch - 'a'] = 1;
                c1++;
            }
        }
        for(char ch : str2.toCharArray()){
            if(hm2[ch - 'a'] > 0){
                hm2[ch - 'a']++;
            } else {
                hm2[ch - 'a'] = 1;
                c2++;
            }
        }
        if(c1 != c2 || str1.length() != str2.length()){
            return false;
        }
        for(int i=0;i<c1;i++) {
            if(hm1[str1.charAt(i)-'a'] != hm2[str2.charAt(i)-'a']){
                return false;
            }
        }
        return true;
        
    }
}
