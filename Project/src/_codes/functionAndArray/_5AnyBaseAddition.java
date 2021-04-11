package _codes.functionAndArray;

public class _5AnyBaseAddition {
    public static void main(String[] args) {
        int b = 8;
        int n1 = 773;
        int n2 = 62;

        System.out.println(getAnyBaseAddition(b,n1,n2));
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
