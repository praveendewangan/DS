import java.io.*;
import java.util.*;

public class _39AllPalindromicPermutation {

	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
		if(cs == ts) {
		    if(oddc == null){
		        System.out.println(asf + reverse(asf));
		    } else {
		        System.out.println(asf + oddc + reverse(asf));
		    }
		    return;
		}
		
		for(char ch : fmap.keySet()){
		    int f = fmap.get(ch);
		    if(f > 0) {
		        fmap.put(ch,f-1);
		        generatepw(cs+1,ts,fmap,oddc,asf+ch);
		        fmap.put(ch,f);
		    }
		}
	}
    private static String reverse(String s) {
        String str = "";
        for(int i = s.length()-1; i >= 0; i--) {
            str += s.charAt(i);
        } 
        return str;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		
		int singleFeqCharCount = 0;
		Character oddChar = null; 
		for(char ch : fmap.keySet()) {
		    if(fmap.get(ch) % 2 == 1) {
		        singleFeqCharCount++; 
		        oddChar = ch; 
		    } 
		  //  if(fmap.get(ch) == 1) {
		  //      oddChar = ch;   
		  //  } 
		}
		int ts = 0;
		for(char ch : fmap.keySet()){
		    ts += fmap.get(ch) / 2;
		    fmap.put(ch,fmap.get(ch) / 2);
		}
		if(singleFeqCharCount > 1) {
		    System.out.println(-1);
		} else {
		    generatepw(0,ts,fmap,oddChar,"");
		}
	}
	
}