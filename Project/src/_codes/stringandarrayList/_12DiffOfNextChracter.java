import java.io.*;
import java.util.*;
public class _12DiffOfNextChracter {
    // Q - pepCODinG
    // A - p-11e11p-45C12O-11D37i5n-39G
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}
    public static String solution(String str){
		if(str.length() == 0) return "";
		int n = str.length();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < n-1) {
		    char a = str.charAt(i);
		    char b = str.charAt(i+1);
		    int idx = b - a;
	        sb.append(a).append(idx);
	        i++;
		}
		if( i < n) {
		    sb.append(str.charAt(i));
		}

		return sb.toString();
	}
	

}
