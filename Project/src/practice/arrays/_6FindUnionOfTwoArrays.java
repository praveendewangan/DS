package practice.arrays;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*Given two arrays A and B of size N and M respectively. The task is to find union between these two arrays.
        Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in union.

        Input:
        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consist of three lines. The first line of each test case contains two space separated integers N and M, where N is the size of array A and M is the size of array B. The second line of each test case contains N space separated integers denoting elements of array A. The third line of each test case contains M space separated integers denoting elements of array B.

        Output:
        Correspoding to each test case, print the count of union elements of the two arrays.

        Expected Time Complexity: O(N + M).
        Expected Auxiliary Space: O(N + M).

        Constraints:
        1 ≤ T ≤ 100
        1 ≤ N, M ≤ 105
        1 ≤ A[i], B[i] < 105

        Example:
        Input:
        2
        5 3
        1 2 3 4 5
        1 2 3
        6 2
        85 25 1 32 54 6
        85 2
        Output:
        5
        7*/
public class _6FindUnionOfTwoArrays {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
// 		String s = br.readLine();
// 		System.exit(0);
        while(T > 0) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            str = br.readLine().split(" ");
            Set<Integer> hs = new HashSet();
            int[] a1 = new int[n];
            for(int i = 0 ; i < n; i++) {
                a1[i] = Integer.parseInt(str[i].trim());
                hs.add(a1[i]);
            }
            str = br.readLine().split(" ");
            int[] a2 = new int[m];
            for(int i = 0 ; i< m; i++) {
                a2[i] = Integer.parseInt(str[i].trim());
                hs.add(a2[i]);
            }
            System.out.println(hs.size());
            T--;
        }
    }
}
