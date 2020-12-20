package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13AllIndicesInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        find(a,0,x);
    }
    private static void find(int[] a,int idx,int x) {
        if(idx == a.length) return;
        if(a[idx] == x){
            System.out.println(idx);
        }
        find(a,idx+1,x);
    }
}
