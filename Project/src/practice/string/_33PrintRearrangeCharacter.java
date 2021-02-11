package practice.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _33PrintRearrangeCharacter {
    // O(nlogn),O(n)
    public static void main (String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int t = scn.nextInt();
	    while(t != 0) {
	        String str = scn.next();
	        System.out.println(rearrange(str));
	        t--;
	    }
		
	}
	private static int rearrange(String str) {
	    
    		Map<Character,Integer> mp = new HashMap<>();
    		int max = 0;
	        for(char ch : str.toCharArray()){
	            mp.put(ch,mp.getOrDefault(ch,0)+1);
	            if(mp.get(ch) > max){
	                max = mp.get(ch);
	            }
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        PriorityQueue<Character> pq = new PriorityQueue<>
	        ((a,b)->mp.get(b)-mp.get(a));
	        pq.addAll(mp.keySet());
	        while(pq.size() > 1){
	            char a = pq.remove();
	            char b = pq.remove();
	            sb.append(a).append(b);
	            mp.put(a,mp.get(a)-1);
	            mp.put(b,mp.get(b)-1);
	            if(mp.get(a) > 0) {
	                pq.add(a);
	            }
	            if(mp.get(b) > 0) {
	                pq.add(b);
	            }
	        }
	        if(!pq.isEmpty()){
	            char last = pq.remove();
	            if(mp.get(last) > 1){
	               // return "";
	               return 0;
	            }
	            sb.append(last);
	        }
	       // return sb.toString();
	       return  1;
	}
}
