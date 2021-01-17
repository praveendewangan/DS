package dynamicprogramsLU;

import java.util.Arrays;
import java.util.Scanner;

public class _5RussianDollEnvelops {


    public static class Envelope implements Comparable < Envelope > {
        int w;
        int h;

        Envelope(int w, int h) {
            this.w = w;
            this.h = h;
        }
        public int compareTo(Envelope o) {
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int num = Integer.parseInt(scn.nextLine());
        Envelope[] ev = new Envelope[num];
        for (int i = 0; i < num; i++) {
            String line = scn.nextLine();
            String[] parts = line.split(" ");
            int w = Integer.parseInt(parts[0]);
            int h = Integer.parseInt(parts[1]);
            ev[i] = new Envelope(w, h);
        }
        Arrays.sort(ev);

        int[] dp = new int[num];
        int oamax = 0;
        for (int i = 0; i < num; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (ev[j].h < ev[i].h && ev[j].w < ev[i].w) {
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
