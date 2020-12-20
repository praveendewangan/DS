package gettingstarted;


/*Sample Input
        6
Sample Output
        1
        4*/
public class _10BenjaminBulbs {
    public static void main(String[] args) {
        int n = 6;
        for (int i = 1; i * i <= n; i++) {
            System.out.println(i * i);
        }
    }
}
