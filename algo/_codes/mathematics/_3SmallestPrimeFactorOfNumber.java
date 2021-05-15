public class _3SmallestPrimeFactorOfNumber {
    public static void main(String[] args) {
        smallestPrimeFactor(42);
    }


    private static void smallestPrimeFactor(int n) {
        int[] spf = new int[n+1];
        for(int i =2; i <= n; i++) {
            spf[i] = i;
        }
        for(int i = 2; i <= n; i++){
            if(spf[i] == i) {
                for(int j = i*i; j <= n; j += i) {
                    if(spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        while(n != 1) {
            System.out.println(spf[n]);
            n /= spf[n];
        }
    }
}
