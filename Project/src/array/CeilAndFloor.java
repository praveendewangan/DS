package array;

public class CeilAndFloor {
    public static void main(String[] args) {
        int[] a = {10,20,30,40,50};
        int num = 40;
        int l = 0;
        int h = a.length-1;
        int c = 0;
        int f = 0;

        while (l <= h) {
            int m = (h+l)/2;
            if(num < a[m]) {
                h = m - 1;
                c = a[m];
            } else if(num > a[m]){
                l = m + 1;
                f = a[m];
            } else {
                c = a[m];
                f = c;
                break;
            }
        }
        System.out.println("ceil :: "+c+" and Floor ::"+f);
    }
}
