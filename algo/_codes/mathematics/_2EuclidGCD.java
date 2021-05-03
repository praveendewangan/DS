public class _2EuclidGCD {
    
    // O(log(min(a,b)))
    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
