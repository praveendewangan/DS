package practice.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _33RearrangeCharacter {
	// O(n),O(n)
    public static void main (String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int t = scn.nextInt();
	    while(t != 0) {
	        String str = scn.next();
    		Map<Character,Integer> mp = new HashMap<>();
    		int max = 0;
	        for(char ch : str.toCharArray()){
	            mp.put(ch,mp.getOrDefault(ch,0)+1);
	            if(mp.get(ch) > max){
	                max = mp.get(ch);
	            }
	        }
	        
	        if(max <= str.length()-max+1){
	            System.out.println(1);
	        } else {
	            System.out.println(0);
	        }
	        t--;
	    }
		
	}
}
