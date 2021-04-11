package _codes.functionAndArray;

public class _2DecimalToAnyBase {
    public static void main(String[] args) {
        int n = 57;
        int b = 2;
        System.out.println(getDecimalToAnyBase(n,b));
    }

    private static int getDecimalToAnyBase(int n,int b) {
        int ans = 0;
        int p = 1;
        while(n != 0) {
            int r = n % b;
            n /= b;
            ans += r * p;
            p = p * 10;
        }
        return ans;
    }
}
