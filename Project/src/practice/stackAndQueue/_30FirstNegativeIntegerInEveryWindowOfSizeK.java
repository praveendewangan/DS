package practice.stackAndQueue;
import java.util.Scanner;

public class _30FirstNegativeIntegerInEveryWindowOfSizeK {
    // O(n*k),O(1)
    public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t != 0) {
		    int n =  scn.nextInt();
		    int[] a = new int[n];
		    for(int i = 0; i < n; i++) {
		        a[i] = scn.nextInt();
		    }
		    int k = scn.nextInt();
		    
		    for(int i=0; i + k <= n;i++){
		        boolean flag = false;
		        for(int j=i;j < i+k;j++){
		            if(a[j] < 0){
		                System.out.print(a[j] + " ");
		                flag = true;
		                break;
		            }
		        }
		        if(!flag){
	                System.out.print("0 ");
	            }
		    }
		    System.out.println();
		    t--;
		}
	}
}
