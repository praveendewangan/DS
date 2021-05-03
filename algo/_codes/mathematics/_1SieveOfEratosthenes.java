import java.util.Arrays;

public class _1SieveOfEratosthenes {
    public static void main(String[] args) {
        Arrays.toString(primeNumbers(10));
    }   

    private static int[] primeNumbers(int n) {
        int[] isPrime = new int[n + 1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i * i <= n; i++) {
            if(isPrime[i]) {
                for(int j = 2 * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
