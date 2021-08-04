import java.io.*;
import java.util.*;

public class _43PatternMatching {

	public static void solution(String str, String pattern, HashMap<Character,String> map, String asf,int idx){
		if(idx == pattern.length()) {
		    if(str.length() == 0) {
		        System.out.println(asf+".");
		    }
		    return;
		}
		
		char ch = pattern.charAt(idx);
		String mapping = map.get(ch);
		for(int i = 0; i < str.length(); i++) {
		    String s = str.substring(0,i+1);
		    String ros = str.substring(i+1);
		    map.put(ch,s);
		    if(mapping.length() > 0){
		        if(mapping.equals(s)) {
		            solution(ros,pattern,map,asf,idx+1);
		        }
		    } else {
		        solution(ros,pattern,map,asf+ch +" -> "+s+", ",idx+1);
		    }
		    map.put(ch,mapping);
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		for(int i = 0; i < pattern.length(); i++) {
		    char ch = pattern.charAt(i);
		    if(!map.containsKey(ch)) {
		        map.put(ch,"");
		    }
		}
		solution(str,pattern,map,"",0);
	}
}