package gettingstarted;
import java.util.*;

/*Sample Input
        65784383
Sample Output
        6
        5
        7
        8
        4
        3
        8
        3*/
public class _4DigitsOfANumber {
    public static void main(String[] args) {
        int n = 65784383;
        int node = 0;
        int temp = n;
        while (temp != 0) {
            temp = temp / 10;
            node++;
        }
        int div = (int) Math.pow(10,node-1);
        while (div != 0) {
            int q = n / div;
            System.out.println(q);
            n = n % div;
            div = div / 10;
        }
    }
}
