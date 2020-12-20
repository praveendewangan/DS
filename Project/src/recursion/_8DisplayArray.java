package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _8DisplayArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        fun(a,0);
    }
    private static void fun(int[] a,int idx) {
        if(idx == a.length) return;
        System.out.println(a[idx]);
        fun(a,idx+1);
    }
}
