import java.util.*;
import java.io.*;

public class _6FIndKClosestElements2LC658 {

    /*find 'k' closest element to 'x' and return answer list*/
    /*elements in answer list should be in ascending order*/
    public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
        int lo = 0;
        int hi = arr.length-1;
        int m = 0;
        while(lo <= hi) {
            m = (lo+hi) / 2;
            
            if(arr[m] == x) {
                break;
            } else if(arr[m] < x) {
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }
        int l = 0;
        int r = 0;
        
        if(m >= 1) {
            l = m -1;
            r = m;
        } else {
            l = m;
            r = m + 1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        while(l >= 0 && r < arr.length && list.size() < k) {
            if(Math.abs(arr[l]-x) <= Math.abs(arr[r]-x)) {
                list.add(arr[l]);
                l--;
            } else {
                list.add(arr[r]);
                r++;
            }
        }
        
        while(l >= 0 && list.size() < k) {
            list.add(arr[l]);
            l--;
        }
        
        while(r < arr.length && list.size() < k) {
            list.add(arr[r]);
            r++;
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int x = scn.nextInt();

        ArrayList<Integer>ans = findClosest(arr,k,x);

        for(int val : ans) {
            System.out.print(val + " ");
        }

    }
}