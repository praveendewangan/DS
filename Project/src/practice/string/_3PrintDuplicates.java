package practice.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3PrintDuplicates {
    
    // Set Approch;
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        Map<Character,Integer> hm = new HashMap<>();
        for(char chr : s.toCharArray()) {
            if(hm.containsKey(chr)) {
                hm.put(chr, hm.get(chr) + 1);
            } else {
                hm.put(chr,1);
            }
        }
        for(Map.Entry<Character,Integer> entry : hm.entrySet()) {
            if(hm.get(entry.getKey()) > 1) {
                System.out.println(entry.getKey() + " count = "+entry.getValue());
            }
        }
    }

    // Array Approch O(n),O(256)

    static final int NO_OF_CHARS = 256; 
  
    /* Fills count array with  
       frequency of characters */
    static void fillCharCounts(String str,  
                                   int[] count) 
    { 
        for (int i = 0; i < str.length(); i++) 
            count[str.charAt(i)]++; 
    } 
  
    /* Print duplicates present  
      in the passed string */
    static void printDups(String str) 
    { 
        // Create an array of size  
        // 256 and fill count of 
        // every character in it 
        int count[] = new int[NO_OF_CHARS]; 
        fillCharCounts(str, count); 
  
        for (int i = 0; i < NO_OF_CHARS; i++) 
            if (count[i] > 1) 
                System.out.println((char)(i) +  
                          ", count = " + count[i]); 
    } 
  
    // Driver Method 
    public static void main1(String[] args) 
    { 
        String str = "test string"; 
        printDups(str); 
    } 
}
