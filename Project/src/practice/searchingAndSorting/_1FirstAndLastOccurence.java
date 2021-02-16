package practice.searchingAndSorting;

import java.io.*;

public class _1FirstAndLastOccurence {
    // O(n),O(1)
    public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0){
		    String[] inputs = br.readLine().split(" ");
		    String[] elements = br.readLine().split(" ");
		    int num = Integer.parseInt(inputs[0].trim());
		    int fnum = Integer.parseInt(inputs[1].trim());
		    int fidx = -1;
		    int lidx = -1;
		    for(int i=0;i<num;i++){
		        int ele = Integer.parseInt(elements[i].trim());
		        if(fnum == ele){
		            if(fidx == -1){
		                fidx = i;
		            }
		            lidx = i;
		        }
		    }
		    if(fidx == -1){
		        System.out.println(fidx);
		    } else {
		        System.out.println(fidx + " " + lidx);
		    }
		    t--;
		}
	}
}
