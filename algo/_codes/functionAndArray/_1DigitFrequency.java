package _codes.functionAndArray;

public class _1DigitFrequency {
    public static void main(String[] args) {
        int n = 12432422;
        int d = 2;
        System.out.println(getFrequency(n,d));
    }

    private static int getFrequency(int n,int d) {
        int c = 0;
        while(n != 0) {
            int r = n % 10;
            n /= 10;
            if(r == d) {
                c++;
            }
        }
        return c;
    }
}
