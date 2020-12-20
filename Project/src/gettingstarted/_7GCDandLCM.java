package gettingstarted;

/*Sample Input
        36
        24
Sample Output
        12
        72*/
public class _7GCDandLCM {
    public static void main(String[] args) {
        int n1 = 36;
        int n2 = 24;
        int o1 = n1;
        int o2 = n2;
        while (n1 % n2 != 0) {
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        int gcd = n2;
        int lcm = (o1 * o2) / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
