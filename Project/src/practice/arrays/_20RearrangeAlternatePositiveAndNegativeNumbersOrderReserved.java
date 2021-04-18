package practice.arrays;

public class _20RearrangeAlternatePositiveAndNegativeNumbersOrderReserved {
    public static void main(String[] args) {
        int a[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        // ans {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
        print(a);
        int i = 0;
        int j = 0;
        while( i < a.length && j < a.length) {
            if(i % 2 == 0) {
                if(a[i] < 0) {
                    i++;
                    if(j < i) j++;
                } else {
                    if(a[j] < 0) {
                        swap(a,i,j);
                        rotate(a,i,j,1);
                        i++;
                        if(j < i) j++;
                    } else {
                        j++;
                    }
                }
            } else {
                if(a[i] >= 0) {
                    i++;
                    if(j < i) j++;
                } else {
                    if(a[j] >= 0) {
                        swap(a,i,j);
                        rotate(a,i,j,1);
                        i++;
                        if(j < i) j++;
                    } else {
                        j++;
                    }
                }
            }
        }
        print(a);
    }
    private static void swap(int[] a,int i,int j) {
        int val = a[i];
        a[i] = a[j];
        a[j] = val; 
    }
    private static void rotate(int[] a,int i,int j,int k) {
        reverse(a,i+k,j-k);
        reverse(a,i+k,j);
    }
    private static void reverse(int[] a,int i, int j) {
        while(i < j) {
            swap(a,i,j);
            i++;
            j--;
        }
    }
    private static void print(int[] a) {
        for(int val : a) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
