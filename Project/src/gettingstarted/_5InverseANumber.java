package gettingstarted;

public class _5InverseANumber {
    public static void main(String[] args) {
        int n = 426135;
        int inv = 0;
        int op = 1;
        while (n != 0) {
            int od = n % 10;
            int id = op;
            int ip = od;

            inv = inv + id * (int)Math.pow(10,ip-1);
            n= n / 10;
            op++;
        }
        System.out.println(inv);
    }
}
