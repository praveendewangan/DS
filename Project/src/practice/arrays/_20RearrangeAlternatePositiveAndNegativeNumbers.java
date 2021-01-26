package practice.arrays;

public class _20RearrangeAlternatePositiveAndNegativeNumbers {
    public static void main(String[] args) {
        int a[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        int i=0;
        int j = a.length - 1;
        while(i < j) {
            if(a[i] < 0 && a[j] >= 0){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            } else if(a[i] >= 0 && a[j] < 0) {
                i++;
                j--;
            } else if(a[j] < 0){
                j--;
            } else if(a[i] >= 0){
                i++;
            }
        }

        int k = 0;
        i += 1;
        while(k < a.length && i < a.length){
            int temp = a[i];
            a[i] = a[k];
            a[k] = temp;
            k += 2;
            i++;
        }
        for(int n : a) {
            System.out.print(n + " ");
        }
    }

}
