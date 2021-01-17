package dynamicprogramsLU;

import java.util.Arrays;
import java.util.Scanner;

public class _4MaxNonOverlappingBridges {


    public static class Bridge implements Comparable < Bridge > {
        int n;
        int s;

        Bridge(int n, int s) {
            this.n = n;
            this.s = s;
        }
        public int compareTo(Bridge o) {
            if (this.n != o.n) {
                return this.n - o.n;
            } else {
                return this.s - o.s;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int num = Integer.parseInt(scn.nextLine());
        Bridge[] bdgs = new Bridge[num];
        for (int i = 0; i < num; i++) {
            String line = scn.nextLine();
            String[] parts = line.split(" ");
            int n = Integer.parseInt(parts[0]);
            int s = Integer.parseInt(parts[1]);
            bdgs[i] = new Bridge(n, s);
        }
        Arrays.sort(bdgs);

        int[] dp = new int[num];
        int oamax = 0;
        for (int i = 0; i < num; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (bdgs[j].s <= bdgs[i].s) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if (dp[i] > oamax) {
                oamax = dp[i];
            }
        }
        System.out.println(oamax);
    }


}
