import java.util.*;
import java.io.*;

public class _18KokoEatingBananasLC875 {
    private static boolean isPossible(int[]piles,int h,int speed) {
        int time = 0;
        for(int i = 0; i < piles.length; i++) {
            time += (int)Math.ceil(piles[i] * 1.0 / speed);
        }
        return time <= h;
    }
    public static int minEatingSpeed(int[]piles,int h) {
        int max = Integer.MIN_VALUE;
        for(int val : piles){
            max = Math.max(val,max);
        }
        if(h == piles.length) return max;
        
        int lo = 1; // min 1 banana can be eatable
        int hi = max;
        int speed = Integer.MAX_VALUE;
        while(lo <= hi) {
            int sp = lo + (hi-lo) / 2;
            
            if(isPossible(piles,h,sp)) {
                speed = sp;
                hi = sp-1;
            } else {
                lo = sp+1;
            }
        } 
        return speed;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]piles = new int[n];

        for(int i=0 ; i < n ; i++) {
            piles[i] = scn.nextInt();
        }

        int h = scn.nextInt();

        int speed = minEatingSpeed(piles,h);
        System.out.println(speed);
    }
}