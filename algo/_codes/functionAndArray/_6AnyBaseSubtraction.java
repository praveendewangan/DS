package _codes.functionAndArray;

public class _6AnyBaseSubtraction {
    public static void main(String[] args) {
        int b = 8;
        int n1 = 62;
        int n2 = 773;

        System.out.println(getAnyBaseSubtraction(n1,n2,b));
    }

    private static int getAnyBaseSubtraction(int n1,int n2,int b) {
        int c = 0;
        int ans = 0;
        int p = 1;
        while(n1 != 0 || n2 != 0 || c != 0) {
            int r1 = n1 % 10;
            int r2 = n2 % 10;
            n1 /= 10;
            n2 /= 10;
            int dif = r2 - r1 - c;
            if(dif < 0) {
                c = 1;
                dif += b;
            } else {
                c = 0;
            }
            ans += dif * p;
            p = p * 10;
        }
        return ans;
    }
}
