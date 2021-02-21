package practice.searchingAndSorting;

public class _35InPlaceMergeSort {
    public static void main(String[] args) {
        int n = 5;
        int arr[] = new int[]{2, 4, 1, 3, 5};
        findInversionCount(arr,0,n-1);
        for(int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    private static void findInversionCount(int[] a,int lo,int hi) {
        int mid = 0;
        if(lo < hi) {
            mid = (lo + hi) / 2;
            findInversionCount(a, lo, mid);
            findInversionCount(a, mid+1, hi);
            mergeSortedArrays(a, lo,mid+1,hi);
        }
    }

    private static void mergeSortedArrays(int[] a,int lo,int mid,int hi) {
        
        int i = lo;
        int j = mid;

        while((i <= mid-1) && (j <= hi)) {
            if(a[i] <= a[j]) {
                i++;
            } else  {
                int val = a[j];
                int idx = j;
                while(idx != i) {
                    a[idx] = a[idx-1];
                    idx--;
                }
                a[i] = val;
                i++;
                mid++;
                j++;

            }
        }
    }
}
