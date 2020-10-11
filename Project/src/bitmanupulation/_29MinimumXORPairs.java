package bitmanupulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _29MinimumXORPairs {
    private static void solution(int[] a) {
        Arrays.sort(a);
        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            int xor = a[i] ^ a[i + 1];
            if(xor < min) {
                min = xor;
                list = new ArrayList<>();
                list.add(a[i] + ", "+a[i + 1]);
            } else {
                list.add(a[i] + ", "+a[i + 1]);
            }
        }
        for (String val : list) {
            System.out.println(val);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        solution(a);
    }
}
