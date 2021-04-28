
import java.io.*;
import java.util.*;
public class _11ToggleClass {
// Q - pepCODinG
// A - PEPcodINg
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}
    public static String toggleCase(String str){
		if(str.length() == 0) return "";
		int n = str.length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
		    char ch = str.charAt(i);
		   if(ch >= 'a' && ch <= 'z') {
		        char c = (char) (ch - 'a' + 'A');
		        sb.append(c);
		    } else {
		        char c = (char) (ch - 'A' + 'a');
		        sb.append(c);
		    }
		}

		return sb.toString();
	}
	public static String toggleCase1(String str){
		if(str.length() == 0) return "";
		int n = str.length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
		    char ch = str.charAt(i);
		    int idx = (int)(ch - 'a');
		   if(idx >= 0 && idx <= 26) {
		        char c = (char) ('A' + idx);
		        sb.append(c);
		    } else {
		        idx = ch - 'A';
		        char c = (char) ('a' + idx);
		        sb.append(c);
		    }
		}

		return sb.toString();
	}

}
