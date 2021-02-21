package practice.searchingAndSorting;

public class _34InversionCount {
    // O(nLogn),O(n)
    public static void main(String[] args) {
        int n = 5;
        int arr[] = new int[]{2, 4, 1, 3, 5};
        int temp[] = new int[n];
        System.out.println(findInversionCount(arr,temp,0,n-1));
    }

    private static int findInversionCount(int[] a,int[] temp,int lo,int hi) {
        int count = 0;
        int mid = 0;
        if(lo < hi) {
            mid = (lo + hi) / 2;
            count += findInversionCount(a, temp, lo, mid);
            count += findInversionCount(a, temp, mid+1, hi);
            count += mergeSortedArrays(a,temp,lo,mid+1,hi);
        }
        return count;
    }

    private static int mergeSortedArrays(int[] a,int[] temp,int lo,int mid,int hi) {
        int count = 0;
        int i = lo;
        int j = mid;
        int k = lo;

        while((i <= mid-1) && (j <= hi)) {
            if(a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else  {
                temp[k++] = a[j++];
                // Count number of left elem greater than right elem
                count += mid - i;
            }
        }

        while(i <= mid - 1) {
            temp[k++] = a[i++];
        }
        
        while(j <= hi) {
            temp[k++] = a[j++];
        }

        for(int x = lo;x<=hi;x++) {
            a[x] = temp[x];
        }
        return count;
    }
}
