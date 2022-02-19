import java.io.*;
import java.util.*;

public class _15PepcoderAndBits {
        public static long ncr(long n, long r){
        if(n < r){
            return 0L;    
        }
        long res = 1L;
        for(long i = 0L; i < r; i++){
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
        
    public static int csb(long n){
        // kernighan's Algorithm
        int res = 0;
        while(n > 0){
            long rsb = n & -n;
            n -= rsb;
            res++;
        }
        
        return res;
    }
    
    // n -> number, srb -> required set bits, lbi -> leftmost bit index => 63
    private static long pepcoderAndBits_rec(long n, int rsb, int lbi) {
        if(rsb == 0) return 0L;
        long count = 0L;
        // check left most index bit
        long bm = (1L << lbi);
        if((n & bm) == 0) {
            // leftmost bit index's bit is OFF
            count = pepcoderAndBits_rec(n, rsb, lbi - 1);
        } else {
            // bit is ON
            // find count if lbi is considered as OFF
            count = ncr(lbi, rsb);
            // find count if lbi is ON
            count += pepcoderAndBits_rec(n, rsb - 1, lbi - 1);
        }
        return count;
    }

    public static long pepcoderAndBits(long n) {
        int rsb = csb(n);
        return pepcoderAndBits_rec(n, rsb, 63);
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        int k = csb(n);
        System.out.println(pepcoderAndBits(n));
    }
	
	
}