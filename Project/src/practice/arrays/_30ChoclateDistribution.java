package practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _30ChoclateDistribution {
    public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int T = Integer.parseInt(br.readLine());
        int T = 1;
		while(T != 0) {
            // int n = Integer.parseInt(br.readLine());
            int n = 8;
		    int[] a = new int[]{3,4,1,9,56,7,9,12};
		    // String[] s = br.readLine().trim().split(" ");
		  //  System.out.println(s.length);
		  //  System.out.println(a.length);
		//     for(int i=0;i<n;i++) {
		//   //  System.out.println(i);
		//         a[i] = Integer.parseInt(s[i]);
		//     }
		    int[] l = new int[n];
		    int[] r = new int[n];
		    Arrays.fill(l,1);
		    Arrays.fill(r,1);
		    for(int i=1;i<n;i++){
		        if(a[i] > a[i-1]){
		            l[i] = l[i-1]+1;
		        }
		    }
		    for(int i=n-2;i>=0;i--){
		        if(a[i] > a[i+1]){
		            r[i] = r[i+1]+1;
		        }
            }
            for(int num : l){
                System.out.print(num + " ");
            }
            System.out.println();
            for(int num : r){
                System.out.print(num + " ");
            }
            System.out.println();
		    int sum = 0;
		    for(int i=0;i<n;i++){
		        sum += Math.min(l[i],r[i]);
		    }
            System.out.println(sum);
            T--;
		}
	}
}
