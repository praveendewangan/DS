package hashmapandheap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _2GetCommonElements2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            a1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = scn.nextInt();
        }

        Map<Integer,Integer> mp = new HashMap<>();

        for (int a : a1) {
            if(mp.containsKey(a)) {
                mp.put(a,mp.get(a) + 1);
            } else {
                mp.put(a,1);
            }
        }

        for (int a : a2) {
            if(mp.containsKey(a) && mp.get(a) > 0) {
                System.out.println(a);
                int count = mp.get(a);
                mp.put(a,count - 1);
            }
        }

    }
}
