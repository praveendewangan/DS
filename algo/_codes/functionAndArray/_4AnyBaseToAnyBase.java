package _codes.functionAndArray;

public class _4AnyBaseToAnyBase {
    public static void main(String[] args) {
        int n = 111001;
        int s = 2;
        int d = 3;
        int decimal = getAnyBaseToDecimal(n, s);
        System.out.println(getDecimalToAnyBase(decimal, d));
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
