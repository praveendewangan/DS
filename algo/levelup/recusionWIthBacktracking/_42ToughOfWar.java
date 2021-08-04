import java.io.*;
import java.util.*;

public class _42ToughOfWar {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
		System.out.println(ans);
	}

	static int mindiff = Integer.MAX_VALUE;
	static String ans = "";

	public static void solve(int[] arr, int vidx, ArrayList<Integer> s1, ArrayList<Integer> s2, int sum1,int sum2) {
		if(vidx == arr.length){
		    int diff = Math.abs(sum1-sum2);
		    if(diff < mindiff){
		        mindiff = diff;
		        ans = "" + s1 + " " + s2;
		    }
		    return;    
		}
		
        int val = arr[vidx];
        // val in set1
        if(s1.size() < (arr.length+1) / 2) {
            s1.add(val);
            solve(arr,vidx+1,s1,s2,sum1+val,sum2);
            s1.remove(s1.size()-1);
        }
        
        // val in set2
        // if(s2.size() < (arr.length+1)/ 2) {
        if(s1.size() > 0 && s2.size() < (arr.length+1)/ 2) {
            s2.add(val);
            solve(arr,vidx+1,s1,s2,sum1,sum2+val);
            s2.remove(s2.size()-1);
        }
	}

}