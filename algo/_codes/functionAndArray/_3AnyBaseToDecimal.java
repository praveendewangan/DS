package _codes.functionAndArray;

public class _3AnyBaseToDecimal {
    public static void main(String[] args) {
        int n = 111001;
        int b = 2;
        System.out.println(getAnyBaseToDecimal(n,b));
    }

    private static int getAnyBaseToDecimal(int n, int b) {
        int ans = 0;
        int p = 1;
        while(n != 0) {
            int r = n % 10;
            n /= 10;
            ans += r * p;
            p = p * b;
        }
        return ans;
    }
    
}
