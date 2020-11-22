package practice.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. Then following line contains 'n' integers forming the array.

        Output:
        Output the cyclically rotated array by one.

        Constraints:
        1<=T<=1000
        1<=N<=1000
        0<=a[i]<=1000

        Example:
        Input:
        2
        5
        1 2 3 4 5
        8
        9 8 7 6 4 2 1 3

        Output:
        5 1 2 3 4
        3 9 8 7 6 4 2 1*/
public class _7RotateArrayByOne {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            reverse(a,0,n-2);
            for (int i = n - 1; i >= 0; i--) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            T--;
        }
    }
    private static void reverse(int[] a,int start,int end){

        while ( start < end) {
            int temp = a[end];
            a[end] = a[start];
            a[start] = temp;
            start++;
            end--;
        }
    }
}
