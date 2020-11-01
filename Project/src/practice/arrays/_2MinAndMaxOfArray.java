package practice.arrays;

public class _2MinAndMaxOfArray {
    public static void main(String[] args) {
        int[] a = {4,1,5,2};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if(a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("MIN :: "+min);
        System.out.println("MAX :: "+max);
    }
}
