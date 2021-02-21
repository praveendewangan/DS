package practice.searchingAndSorting;

public class _22PivotElementInSortedArray {
    public static void main(String[] args) {
        int[] a = new int[]{3,4,5,1,2};
        int lo = 0;
        int hi = a.length-1;
        while(lo < hi) {
            int mid = (lo+hi)/2;
            if(a[mid] < a[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.print(a[hi]);
    }
}
