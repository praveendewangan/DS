package dynamicprograms;

import java.util.Scanner;

public class _19PaintFence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        long same = k * 1;
        long diff = k * (k - 1);
        long total = same + diff;

        for (int i = 3; i <= n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }
        System.out.println(total);
    }
}
