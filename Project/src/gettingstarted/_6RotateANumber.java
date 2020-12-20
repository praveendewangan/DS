package gettingstarted;

/*Input
    273516
    2
Output
    162735*/

public class _6RotateANumber {
    public static void main(String[] args) {
        int n = 273516;
        int k = 2;
        int temp = n;
        int nod = 0;
        while (temp > 0) {
            temp = temp / 10;
            nod++;
        }

        k = k % nod;
        if(k < 0) {
            k = k + nod;
        }
        int div = 1;
        int mul = 1;
        for (int i = 1; i <= nod; i++) {
            if(i <= k){
                div = div * 10;
            } else {
                mul = mul * 10;
            }
        }
        int q = n / div;
        int r = n % div;

        int rt = r * mul + q;
        System.out.println(rt);
    }
}
