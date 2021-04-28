package _codes.functionAndArray;

public class _7AnyBaseMultiplication {
    public static void main(String[] args) {
        int b = 5;
        int n1 = 1220;
        int n2 = 31;

        System.out.println(getAnyBaseMultiplication(n1,n2,b));
    }

    private static int getAnyBaseMultiplication(int n1,int n2,int b) {
        int ans = 0;
        int p = 1;
        while(n2 != 0) {
            int r = n2 % 10;
            n2 /= 10;

            int val = getProductVal(n1,r,b);
            val = val * p;
            ans = getAnyBaseAddition(b, ans, val);
            p = p * 10;
        }
        return ans;
    }

    private static int getProductVal(int n1,int n2,int b) {
        int ans = 0;
        int c = 0;
        int p = 1;
        while(n1 != 0 || c != 0) {
            int r = n1 % 10;
            n1 /= 10;

            int sum = r * n2 + c;
            c = sum / b;
            sum = sum % b;

            ans += sum * p;
            p = p * 10;
        }
        return ans;
    }
    private static int getAnyBaseAddition(int b,int n1,int n2) {
        int c = 0;
        int ans = 0;
        int p = 1;

        while(n1 != 0 || n2 != 0 || c != 0) {
            int r1 = n1 % 10;
            int r2 = n2 % 10;
            n1 /= 10;
            n2 /= 10;

            int sum = r1 + r2 + c;
            c = sum / b;
            sum %= b;
            ans += sum * p;
            p = p * 10;
        }
        return ans;
    }
}
