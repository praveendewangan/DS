package practice.searchingAndSorting;

public class _23KthElementInTwoSortedArray {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(k <= 0) {
            return -1L;
        }
        int i = 0;
        int j = 0;
        int x = 0;
        while(i < n && j < m) {
            if(arr1[i] > arr2[j]){
                x++;
                if(x == k){
                    return arr2[j];
                }
                j++;
            } else {
                x++;
                if(x == k) {
                    return arr1[i];
                }
                i++;
            }
        }
        while(i < n) {
            x++;
            if(x == k) return arr1[i];
            i++;
        }
        while(j < m) {
            x++;
            if(x == k) return arr2[j];
            j++;
        }
        
        return -1L;
    }
}
