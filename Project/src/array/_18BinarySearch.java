package array;

public class _18BinarySearch {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,0};
        int data = 31;
        int l = 0;
        int h = a.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if(data > a[m]) {
                l = m + 1;
            } else if(data < a[m]) {
                h = m - 1;
            } else {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}
