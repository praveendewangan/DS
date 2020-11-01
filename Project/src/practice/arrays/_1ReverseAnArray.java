package practice.arrays;

public class _1ReverseAnArray {
    public static void main(String[] args) {
        int[] a = {4,5,1,2};
        for (int i = a.length - 1; i >= 0 ; i--) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
        int middle = a.length / 2;
        for (int i = 0; i < middle; i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i]);
        }

    }
}
