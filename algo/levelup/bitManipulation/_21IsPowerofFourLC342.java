public class _21IsPowerofFourLC342 {
    public boolean isPowerOfFour(int n) {
        // int bm = 0b1010_1010_1010_1010_1010_1010_1010_1010; // literals for binary to int
        int bm = 0xA_A_A_A_A_A_A_A; // literals for hexadecimal to int
        return n > 0 && ((n & (n - 1)) == 0) && (n & bm) == 0;
    }   
}
