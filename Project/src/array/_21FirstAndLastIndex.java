package array;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        int[] a = {10,20,20,20,30,50,50,60};
        int h1 = a.length-1;
        int h2 = a.length-1;
        int l1 = 0;
        int l2 = 0;
        int num = 50;
        int fi = -1;
        int li = -1;
        while (l1 <= h1) {
            int m = (h1+l1)/2;
            if(num < a[m]){
                h1 = m - 1;
            } else if(num > a[m]) {
                l1 = m + 1;
            } else {
                fi = m;
                h1 = m - 1;
            }
        }
        while (l2 <= h2) {
            int m = (h2+l2)/2;
            if(num < a[m]){
                h2 = m - 1;
            } else if(num > a[m]) {
                l2 = m + 1;
            } else {
                li = m;
                l2 = m + 1;
            }
        }
        System.out.println("First index :: "+fi+" and Last index :: "+li);
    }
}
