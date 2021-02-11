package practice.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _29MinNumberOfSwapsForBracketBalance {
    // O(n),O(n)
    public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t != 0) {
		    int num = scn.nextInt();
		    String input = scn.next();
		    char[] s = input.toCharArray();
		    int count = 0;
		    int idx = 0;
		    int sum = 0;
		    List<Integer> list = new ArrayList<>();
		    for(int i=0;i<num;i++) {
		        if(s[i] == '[') {
		            list.add(i);
		        }
		    }
		    for(int i=0;i<num;i++){
		        if(s[i] == '['){
		            count++;
		            idx++;
		        } else {
		            count--;
		            
		            if(count < 0) {
		                sum += list.get(idx) - i;
		                char temp = s[i];
		                s[i] = s[list.get(idx)];
		                s[list.get(idx)] = temp;
		                count = 1;
		                idx++;
		            }
		        }
		    }
		    System.out.println(sum);
		    t--;
		}
	}
}
