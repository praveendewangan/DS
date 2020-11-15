package hashmapandheap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _3LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        Map<Integer,Boolean> mp = new HashMap<>();
        for (int num : a) {
            mp.put(num,true);
        }
        for (int num : a) {
            if(mp.containsKey(num - 1)) {
                mp.put(num,false);
            }
        }
        int msp = 0;
        int m1 = 0;
        for (int num : a) {
            if(mp.get(num)) {
                int tsp = num;
                int t1 = 1;
                while (mp.containsKey( tsp + t1)) {
                    t1++;
                }
                if(t1 > m1) {
                    msp = tsp;
                    m1 = t1;
                }
            }
        }
        for (int i = 0; i < m1; i++) {
            System.out.println(msp + i);
        }
    }

}
