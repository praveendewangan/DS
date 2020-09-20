package recursion;

import java.util.Arrays;

public class PrintIndexs {
    static int count = 0;
    public static void main(String[] args) {
        int[] a = {2,3,2,4,5,6,8,4};
        int n = 4;
        int[] arr = index(a,0,n,0);
        for (int d: arr) {
            System.out.println(d);
        }
        //System.out.println(count);
    }
    private static int[] index(int[] a,int n,int f,int c) {
        if(n == a.length) return new int[c];
        if(a[n] == f) {
            int[] arr = index(a,n+1,f,c+1);
            arr[c] = n;
            return arr;
        } else {
            return index(a,n+1,f,c);
        }

    }
}
